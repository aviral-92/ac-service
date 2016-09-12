package com.customer.management.tool.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.cache.CacheManager;
import com.customer.management.tool.constants.CMTOrderStatusCode;
import com.customer.management.tool.dao.CMTJobDao;
import com.customer.management.tool.extractor.CMTCategoryExtractor;
import com.customer.management.tool.extractor.CustomerJobDetailExtractor;
import com.customer.management.tool.extractor.GetLastInsertedIDExtractor;
import com.customer.management.tool.pojo.CMTCategory;
import com.customer.management.tool.pojo.CustomerJobDetail;

@Component
public class CMTJobDaoImpl implements CMTJobDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addCategory(CMTCategory category) {

		String response = null;
		if (!isCategoryExist(category)) {
			String query = "INSERT INTO CATEGORY (category_name) values (?)";
			String maxRow = "SELECT max(categoryId) AS categoryId FROM customer_mgmt_tool.category";
			if (!StringUtils.isEmpty(category) && !StringUtils.isEmpty(category.getCategory_name())) {
				Object[] args = { category.getCategory_name().toLowerCase() };
				int executed = jdbcTemplate.update(query, args);
				if (executed > 0) {
					Integer lastInsertedId = jdbcTemplate.query(maxRow, new GetLastInsertedIDExtractor());
					if (lastInsertedId > 0) {
						CacheManager.categoryMap.put(lastInsertedId, category.getCategory_name());
					}
					response = "Category Successfully Added";
				}
			}
		} else {
			response = category.getCategory_name() + " already exist ";
		}
		return response;
	}

	private boolean isCategoryExist(CMTCategory category) {

		boolean exist = false;
		if (!StringUtils.isEmpty(category.getCategory_name())
				&& CacheManager.categoryMap.containsValue(category.getCategory_name().toLowerCase())) {
			exist = true;
		}
		return exist;
	}

	@Override
	public List<CMTCategory> getCategories() {

		String query = "SELECT * FROM customer_mgmt_tool.category ";
		List<CMTCategory> categories = jdbcTemplate.query(query, new CMTCategoryExtractor());
		return categories;
	}

	@Override
	public String addCustomerJob(CustomerJobDetail customerJobDetail) {

		String response = null;
		String queryForCustomerJobDetail = "INSERT INTO customer_mgmt_tool.customer_job_detail(customer_id,category_id,unique_id,actual_amount,"
				+ "paid_amount,description,warranty,reason,due_date,customer_job_status) VALUES (?,?,?,?,?,?,?,?,STR_TO_DATE(?,'%Y,%m,%d'),?) ";
		String queryForCustomerJobDetailNow = "INSERT INTO customer_mgmt_tool.customer_job_detail(customer_id,category_id,unique_id,actual_amount,"
				+ "paid_amount,description,warranty,reason,due_date, customer_job_status) VALUES (?,?,?,?,?,?,?,?,NOW(),?) ";

		int executed = 0;
		List<Object> args = new ArrayList<Object>();
		args.add(customerJobDetail.getCustomerId());
		args.add(customerJobDetail.getCategory_id());
		args.add(customerJobDetail.getUnique_Id());
		args.add(customerJobDetail.getActualAmount());
		args.add(customerJobDetail.getPaidAmount());
		args.add(customerJobDetail.getDescription());
		args.add(customerJobDetail.getWarranty());
		args.add(customerJobDetail.getReason());
		if (StringUtils.isEmpty(customerJobDetail.getDueDate())) {
			args.add(CMTOrderStatusCode.COMPLETED.getPrperty());
			executed = jdbcTemplate.update(queryForCustomerJobDetailNow, args.toArray());
		} else {
			args.add(customerJobDetail.getDueDate());
			args.add(CMTOrderStatusCode.PENDING.getPrperty());
			executed = jdbcTemplate.update(queryForCustomerJobDetail, args.toArray());
		}
		if (executed > 0) {
			int custID = getLastInsertedOrderID();
			response = "Customer Job details Successfully Added, Job ID is " + custID;
		}
		return response;
	}

	@Override
	public int getLastInsertedOrderID() {

		String query = "SELECT max(job_id) as jobId FROM customer_mgmt_tool.customer_job_detail";
		int id = jdbcTemplate.query(query, new GetLastInsertedIDExtractor());
		return id;
	}

	// TODO Remove Order Details
	@Override
	public List<CustomerJobDetail> searchJobOfCustomer(CustomerJobDetail customerJobDetail) {

		String sql = "select * from customer_mgmt_tool.customer_job_detail AS CJD INNER JOIN customer_mgmt_tool.customer AS CUST ON CJD.customer_id=CUST.customerId "
				+ "INNER JOIN customer_mgmt_tool.category AS CAT ON CAT.categoryId = CJD.category_id "
				/*+ " INNER JOIN customer_mgmt_tool.category AS CAT ON CAT.categoryId = CJD.category_id INNER JOIN customer_mgmt_tool.order_mgmt AS OMGMT "
				+ "ON OMGMT.orderId = CJD.order_id INNER JOIN customer_mgmt_tool.customer_order_status AS OS ON OS.order_status =  OMGMT.order_status"
				+ " INNER JOIN customer_mgmt_tool.customer_order_status AS COS ON OMGMT.order_status = COS.order_status"*/
				+ " WHERE CUST.customerStatus = 'A' AND CAT.category_status = 'A' ";
		StringBuilder query = new StringBuilder(sql);
		List<Object> args = new ArrayList<>();
		if (customerJobDetail.getJobId() > 0) {
			query.append(" AND CJD.job_id = ?");
			args.add(customerJobDetail.getJobId());
		}  else if (!StringUtils.isEmpty(customerJobDetail.getUnique_Id())) {
			query.append(" AND CJD.unique_id LIKE ?");
			args.add("%" + customerJobDetail.getUnique_Id() + "%");
		} else if (customerJobDetail.getCustomerId() > 0) {
			query.append(" AND CJD.customer_id = ?");
			args.add(customerJobDetail.getCustomerId());
		} else if (!StringUtils.isEmpty(customerJobDetail.getEmail())) {
			query.append(" AND CUST.email = ?");
			args.add(customerJobDetail.getEmail());
		} else if (!StringUtils.isEmpty(customerJobDetail.getMobile())) {
			query.append(" AND CUST.mobile = ?");
			args.add(customerJobDetail.getMobile());
		}
		List<CustomerJobDetail> jobDetails = jdbcTemplate.query(query.toString(), new CustomerJobDetailExtractor(),
				args.toArray());

		return jobDetails;
	}

	public List<CustomerJobDetail> jobByDate(Date startDate, Date endDate, String pending) {

		List<CustomerJobDetail> customerJobDetails = new ArrayList<>();
		String query = "select * from customer_mgmt_tool.customer_job_detail AS CJD INNER JOIN customer_mgmt_tool.order_mgmt AS "
				+ " OM ON CJD.order_id = OM.orderId INNER JOIN customer_mgmt_tool.customer_order_status AS "
				+ " OS ON OM.order_status = OS.order_status where CJD.due_date >= ? AND CJD.due_date <= ?  ";
		StringBuilder stringBuilder = new StringBuilder(query);
		if (!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {
			if (!StringUtils.isEmpty(pending) && pending.equalsIgnoreCase("pending")) {
				stringBuilder.append(" AND OS.order_status = 'P'");
			} else if (!StringUtils.isEmpty(pending) && pending.equalsIgnoreCase("underprocess")) {
				stringBuilder.append(" AND OS.order_status = 'UP'");
			} else {
				stringBuilder.append(" AND OS.order_status = 'C'");
			}
			Object[] args = { startDate, endDate };
			customerJobDetails = jdbcTemplate.query(stringBuilder.toString(), new CustomerJobDetailExtractor(), args);
		}
		return customerJobDetails;
	}

	public String orderStatusChange(CustomerJobDetail customerJobDetail) {
		// Job Id -- customer_job_detail -- cust_id --

		return "";
	}

	private Date stringToDate(String date) throws ParseException {

		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		Date stringTodate = formatter.parse(date);
		return stringTodate;
	}
}

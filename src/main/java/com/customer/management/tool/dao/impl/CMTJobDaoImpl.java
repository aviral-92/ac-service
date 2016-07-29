package com.customer.management.tool.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.constants.CMTOrderStatusCode;
import com.customer.management.tool.dao.CMTJobDao;
import com.customer.management.tool.extractor.CMTCategoryExtractor;
import com.customer.management.tool.extractor.GetLastInsertedIDExtractor;
import com.customer.management.tool.pojo.CMTCategory;
import com.customer.management.tool.pojo.CMTOrderManagement;
import com.customer.management.tool.pojo.CustomerJobDetail;

@Component
public class CMTJobDaoImpl implements CMTJobDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String addCategory(CMTCategory category) {

		String response = null;
		String query = "INSERT INTO CATEGORY (category_name) values (?)";
		if (!StringUtils.isEmpty(category)
				&& !StringUtils.isEmpty(category.getCategory_name())) {
			Object[] args = { category.getCategory_name() };
			int executed = jdbcTemplate.update(query, args);
			if (executed > 0) {
				response = "Category Successfully inserted";
			}
		}
		return response;
	}

	@Override
	public List<CMTCategory> getCategories() {

		String query = "SELECT * FROM CATEGORY ";
		List<CMTCategory> categories = jdbcTemplate.query(query,
				new CMTCategoryExtractor());
		return categories;
	}

	@Override
	public CMTOrderManagement checkOrderStatus(String customerId) {

		CMTOrderManagement cmtOrderManagement = null;
		/*
		 * String query =
		 * "SELECT * FROM customer_mgmt_tool.order_mgmt WHERE customer_id = ? "
		 * +
		 * "AND order_status != ? AND order_status != ? AND order_status != ? ";
		 * if (!StringUtils.isEmpty(customerId)) { Object[] args = { customerId,
		 * CMTOrderStatusCode.PENDING.getPrperty(),
		 * CMTOrderStatusCode.REOPEN.getPrperty(),
		 * CMTOrderStatusCode.SUBMITTED.getPrperty() }; cmtOrderManagement =
		 * jdbcTemplate.query(query, new CMTOrderManagementExtractor(), args); }
		 */
		return cmtOrderManagement;
	}

	@Override
	public String addCustomerJob(CustomerJobDetail customerJobDetail) {

		String query = "INSERT INTO customer_mgmt_tool.order_mgmt (customer_id, order_description, order_status, order_completion"
				+ "order_date) VALUES (?,?,?,STR_TO_DATE(?,'%d,%m,%Y'),now()) ";
		List<Object> args = new ArrayList<Object>();
		args.add(customerJobDetail.getCustomerId());
		args.add(customerJobDetail.getDescription());
		if (!StringUtils.isEmpty(customerJobDetail.getDueDate())) {
			args.add(CMTOrderStatusCode.COMPLETED.getPrperty());
			args.add(customerJobDetail.getDueDate());
		} else {
			args.add(CMTOrderStatusCode.PENDING.getPrperty());
			args.add(new Date());
		}

		int execute = jdbcTemplate.update(query, args.toArray());
		if (execute > 0) {
			System.out.println("Hurrreeeeyyyyyy");
			getLastInsertedID();
		}
		return null;
	}

	@Override
	public String getLastInsertedID() {

		String query = "SELECT LAST_INSERT_ID() AS ID ";
		String id = jdbcTemplate.query(query, new GetLastInsertedIDExtractor());
		return id;
	}

}

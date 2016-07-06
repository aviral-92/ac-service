/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.dao.CMTDao;
import com.customer.management.tool.extractor.CMTTypesExtractor;
import com.customer.management.tool.extractor.CMTExtractor;
import com.customer.management.tool.extractor.CustomerRepairingDetailExtractor;
import com.customer.management.tool.pojo.CMTTypes;
import com.customer.management.tool.pojo.Customer;
import com.customer.management.tool.pojo.CustomerReparingDetail;
import com.customer.management.tool.query.CMTQueryConstant;

/**
 *
 * @author amittal
 */
@Component
@Scope("prototype")
public class CMTDaoImpl implements CMTDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CMTTypes> getAcTypes() {
		return jdbcTemplate.query(CMTQueryConstant.AC_SERVICE,
				new CMTTypesExtractor());
	}

	@Override
	public String addCustomer(Customer customer) throws Exception {

		String response = null;
		if (!isExist(customer)) {
			List<String> args = new ArrayList<>();
			args.add(customer.getName());
			args.add(customer.getEmail());
			args.add(customer.getAddress());
			args.add(customer.getMobile());
			int result = jdbcTemplate.update(CMTQueryConstant.ADDCUSTOMER,
					args.toArray());
			if (result > 0) {
				response = "Customer " + customer.getName()
						+ " successfully added";
			}
		} else {
			throw new Exception("Email or Password already Exist");
		}
		return response;
	}

	@Override
	public boolean isExist(Customer customer) {

		boolean isExist = false;
		List<String> args = new ArrayList<>();
		args.add(customer.getEmail());
		args.add(customer.getMobile());
		List<Customer> response = jdbcTemplate.query(CMTQueryConstant.ISEXIST,
				new CMTExtractor(), args.toArray());
		if (!StringUtils.isEmpty(response) && response.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public List<Customer> getCustomer(Customer customer) {

		boolean isEmail = false, isMobile = false, isAddress = false;
		StringBuilder query = new StringBuilder(CMTQueryConstant.GETCUSTOMER);
		List<String> args = new ArrayList<>();
		if (!StringUtils.isEmpty(customer.getEmail())) {
			query.append(" WHERE email = ? ");
			args.add(customer.getEmail());
			isEmail = true;
		}
		if (isEmail) {
			if (!StringUtils.isEmpty(customer.getMobile())) {
				query.append(" OR mobile = ? ");
				args.add(customer.getMobile());
				isMobile = true;
			}
		} else if (!StringUtils.isEmpty(customer.getMobile())) {
			query.append(" WHERE mobile = ? ");
			args.add(customer.getMobile());
		}
		if (isMobile || isEmail) {
			if (!StringUtils.isEmpty(customer.getAddress())) {
				query.append(" OR address LIKE ? ");
				args.add("%" + customer.getAddress() + "%");
			}
		} else if (!StringUtils.isEmpty(customer.getAddress())) {
			query.append(" WHERE address LIKE ? ");
			args.add("%" + customer.getAddress() + "%");
			isAddress = true;
		}
		if (isMobile || isEmail || isAddress) {
			if (!StringUtils.isEmpty(customer.getCustomerId())
					&& customer.getCustomerId() != -1) {
				query.append(" OR customerId = ? ");
				args.add(String.valueOf(customer.getCustomerId()));
			}
		} else if (!StringUtils.isEmpty(customer.getCustomerId())
				&& customer.getCustomerId() != -1) {
			query.append(" WHERE customerId = ? ");
			args.add(String.valueOf(customer.getCustomerId()));
		}

		List<Customer> response = jdbcTemplate.query(query.toString(),
				new CMTExtractor(), args.toArray());

		return response;
	}

	@Override
	public String addCustomerRepairDetails(
			CustomerReparingDetail customerReparingDetail) {

		String response = null;
		if (!StringUtils.isEmpty(customerReparingDetail)) {
			String query = "insert into customer_repairing_detail (repairId, ac_Id, customer_Id, description,"
					+ "actual_amount, paid_amount, model_vehicle_no, updated_date, warranty) "
					+ "values (0,?,?,?,?,?,?,?,?)";
			List<Object> args = new ArrayList<>();
			args.add(String.valueOf(customerReparingDetail.getAcTypesid()));
			args.add(String.valueOf(customerReparingDetail.getCustomerId()));
			args.add(customerReparingDetail.getDescription());
			args.add(customerReparingDetail.getActualAmount());
			args.add(customerReparingDetail.getPaidAmount());
			args.add(customerReparingDetail.getModel_Vehicle());
			args.add(customerReparingDetail.getUpdateDate());
			args.add(customerReparingDetail.getWarranty());

			int success = jdbcTemplate.update(query, args.toArray());
			if (success > 0) {
				response = "success";
			}
		}
		return response;
	}

	public Customer getCustomerId(Customer customer) {

		if (!StringUtils.isEmpty(customer)
				&& !StringUtils.isEmpty(customer.getEmail())) {
			String query = "SELECT * FROM customer WHERE email = ? ";
			List<String> args = new ArrayList<>();
			args.add(customer.getEmail());
			List<Customer> customerList = jdbcTemplate.query(query,
					new CMTExtractor(), args.toArray());
			if (!StringUtils.isEmpty(customerList) && customerList.size() > 0) {
				customer.setCustomerId(customerList.get(0).getCustomerId());
			}
		}
		return customer;
	}

	@Override
	public List<CustomerReparingDetail> findRepairDetailsByCustomerId(
			CustomerReparingDetail reparingDetail) {

		String query = "select * from ( ( select * from ac_service.CUSTOMER_REPAIRING_DETAIL where customer_Id=? ) a , (select * from ac_service.CUSTOMER  where CUSTOMERID =?) b ) where a.customer_Id = b.CUSTOMERID";
		List<String> args = new ArrayList<>();
		if (!StringUtils.isEmpty(reparingDetail)
				&& !StringUtils.isEmpty(reparingDetail.getCustomerId())) {
			args.add(String.valueOf(reparingDetail.getCustomerId()));
			args.add(String.valueOf(reparingDetail.getCustomerId()));
			System.out.println(System.currentTimeMillis());
			List<CustomerReparingDetail> reparingDetailList = jdbcTemplate
					.query(query, new CustomerRepairingDetailExtractor(),
							args.toArray());
			System.out.println(System.currentTimeMillis());
			if (!StringUtils.isEmpty(reparingDetailList)
					&& reparingDetailList.size() > 0) {
				return reparingDetailList;
			}
		}
		return null;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.impl;

import ac.service.dao.impl.CustomerDaoImpl;
import ac.service.pojo.AcTypes;
import ac.service.pojo.Customer;
import ac.service.pojo.CustomerReparingDetail;
import ac.service.validator.ValidateCustomer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author amittal
 */
@Component
@Scope("prototype")
public class AcServiceCustomerImpl {

	@Autowired
	private CustomerDaoImpl customerDaoImpl;
	@Autowired
	private ValidateCustomer validateCustomer;

	public List<AcTypes> getAcType() {

		return customerDaoImpl.getAcTypes();
	}

	public String addCustomer(Customer customer) throws Exception {

		return customerDaoImpl.addCustomer(customer);
	}

	public List<Customer> getCustomerInfo(Customer customer) {

		return customerDaoImpl.getCustomer(customer);
	}

	public String addRepairDetail(CustomerReparingDetail customerReparingDetail) throws Exception {

		validateCustomer.isRepairDetails(customerReparingDetail);
		return customerDaoImpl.addCustomerRepairDetails(customerReparingDetail);
	}

	public Customer getCustomerID(Customer customer) {

		return customerDaoImpl.getCustomerId(customer);
	}

	public List<CustomerReparingDetail> getRepairDetailByCustomerId(CustomerReparingDetail reparingDetail) {

		List<CustomerReparingDetail> customerReparingDetails = new ArrayList<>();

		List<CustomerReparingDetail> reparingDetails = customerDaoImpl.findRepairDetailsByCustomerId(reparingDetail);

		if (!StringUtils.isEmpty(reparingDetails) && reparingDetails.size() > 0) {
			Date date = new Date();
			for (CustomerReparingDetail customerReparingDetail : reparingDetails) {
				reparingDetail = customerReparingDetail;
				if (date.compareTo(customerReparingDetail.getWarranty()) == 0) {
					System.out.println("Today is your last day of Warrenty");
					reparingDetail.setIsWarrantyExpired("NO");
				} else if (reparingDetail.getWarranty().compareTo(date) == 1) {
					customerReparingDetail.setIsWarrantyExpired("NO");
				} else {
					customerReparingDetail.setIsWarrantyExpired("YES");
				}
				customerReparingDetails.add(reparingDetail);
			}
		} else {
			reparingDetail = new CustomerReparingDetail();
		}
		return customerReparingDetails;
	}
}

package com.customer.management.tool.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.tool.impl.CMTImpl;
import com.customer.management.tool.pojo.Customer;

@RestController
@RequestMapping("/CMT")
@Api(description = "Customer management API")
public class CustomerController {

	@Autowired
	private CMTImpl cmtImpl;

	@RequestMapping(value = "/addcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addCustomer(Customer customer) {

		String response = null;
		try {
			response = cmtImpl.addCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/getcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomer(Customer customer) {

		List<Customer> response = null;
		try {
			response = cmtImpl.getCustomerInfo(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/updatecustomer",produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateCustomer(Customer customer) {

		String response = cmtImpl.updateCustomerWithId(customer);
		return response;
	}
}

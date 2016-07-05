/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.dao;

import java.util.List;

import com.customer.management.tool.pojo.CMTTypes;
import com.customer.management.tool.pojo.Customer;
import com.customer.management.tool.pojo.CustomerReparingDetail;

/**
 *
 * @author amittal
 */
public interface CMTDao {

	public List<CMTTypes> getAcTypes();

	public String addCustomer(Customer customer) throws Exception;

	public boolean isExist(Customer customer);

	public List<Customer> getCustomer(Customer customer);

	public String addCustomerRepairDetails(CustomerReparingDetail customerReparingDetail);

	public List<CustomerReparingDetail> findRepairDetailsByCustomerId(CustomerReparingDetail reparingDetail);
}

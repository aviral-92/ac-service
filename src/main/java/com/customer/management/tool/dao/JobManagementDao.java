package com.customer.management.tool.dao;

import java.util.List;

import com.customer.management.tool.pojo.Category;
import com.customer.management.tool.pojo.CustomerJobDetail;

public interface JobManagementDao {

	// Why u have added into Job 
	public String addCategory(Category category);
	
	public List<Category> getCategories();
	
	public String addCustomerJob(CustomerJobDetail customerJobDetail);
	
	public int getLastInsertedOrderID();
	
	public List<CustomerJobDetail> searchJobOfCustomer(CustomerJobDetail customerJobDetail);

}

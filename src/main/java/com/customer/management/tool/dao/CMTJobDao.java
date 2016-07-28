package com.customer.management.tool.dao;

import java.util.List;

import com.customer.management.tool.pojo.CMTCategory;

public interface CMTJobDao {

	public String addCategory(CMTCategory category);
	
	public List<CMTCategory> getCategories();
}

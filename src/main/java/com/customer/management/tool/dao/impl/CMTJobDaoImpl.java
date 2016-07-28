package com.customer.management.tool.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.dao.CMTJobDao;
import com.customer.management.tool.extractor.CMTCategoryExtractor;
import com.customer.management.tool.pojo.CMTCategory;

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
		List<CMTCategory> categories = jdbcTemplate.query(query, new CMTCategoryExtractor());
		return categories;
	}

}

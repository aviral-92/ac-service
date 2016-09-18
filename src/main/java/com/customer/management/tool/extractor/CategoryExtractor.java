package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.Category;

public class CategoryExtractor implements
		ResultSetExtractor<List<Category>> {

	@Override
	public List<Category> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<Category> categories = new ArrayList<Category>();
		Category category = new Category();
		while (rs.next()) {
			category = new Category();
			category.setCategory_id(rs.getInt("categoryId"));
			category.setCategory_name(rs.getString("category_name"));
			category.setStatus(rs.getString("category_status"));
			categories.add(category);
		}
		return categories;
	}

}

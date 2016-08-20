package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.Product;

public class CMTProductExtractor implements
		ResultSetExtractor<List<Product>> {

	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Product> cmtProducts = new ArrayList<Product>();
		Product cmtProduct = null;
		while (rs.next()) {
			cmtProduct = new Product();
			cmtProduct.setId(rs.getInt("productId"));
			cmtProduct.setName(rs.getString("product_name"));
			cmtProduct.setDescription(rs.getString("product_description"));
			cmtProduct.setStatus(rs.getString("status"));
			cmtProducts.add(cmtProduct);
		}
		return cmtProducts;
	}

}

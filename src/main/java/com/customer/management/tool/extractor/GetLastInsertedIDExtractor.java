package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class GetLastInsertedIDExtractor implements ResultSetExtractor<Integer> {

	@Override
	public Integer extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		int lastId = 0;
		if (rs.next()) {
			lastId = rs.getInt("orderId");
		}
		return lastId;
	}

}

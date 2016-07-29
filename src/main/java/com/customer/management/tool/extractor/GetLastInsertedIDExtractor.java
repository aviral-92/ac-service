package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class GetLastInsertedIDExtractor implements ResultSetExtractor<String> {

	@Override
	public String extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		String lastId = null;
		if (rs.next()) {
			lastId = rs.getString("ID");
		}
		return lastId;
	}

}

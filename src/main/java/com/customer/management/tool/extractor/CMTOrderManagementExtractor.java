package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.CMTOrderManagement;

public class CMTOrderManagementExtractor implements ResultSetExtractor<CMTOrderManagement> {

	@Override
	public CMTOrderManagement extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		CMTOrderManagement cmtOrderManagement = null;
		if(rs.next()){
			cmtOrderManagement = new CMTOrderManagement();
			cmtOrderManagement.setCustomer_id(rs.getInt("customer_id"));
			cmtOrderManagement.setOrderId(rs.getInt("orderId"));
			cmtOrderManagement.setOrder_status(rs.getString("order_status"));
			cmtOrderManagement.setDescription(rs.getString("order_description"));
			cmtOrderManagement.setOrder_date(rs.getTimestamp("order_date").toString());
			cmtOrderManagement.setCompletion_date(rs.getTimestamp("order_completion").toString());
			cmtOrderManagement.setStatus(rs.getString("status"));
		}
		return cmtOrderManagement;
	}

}

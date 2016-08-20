package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.OrderManagement;
import com.customer.management.tool.pojo.OrderStatus;

public class CMTOrderManagementExtractor implements ResultSetExtractor<OrderManagement> {

	@Override
	public OrderManagement extractData(ResultSet rs) throws SQLException, DataAccessException {
		OrderManagement cmtOrderManagement = null;
		if (rs.next()) {
			cmtOrderManagement = new OrderManagement();
			cmtOrderManagement.setCustomerId(rs.getInt("customer_id"));
			cmtOrderManagement.setOrderId(rs.getInt("orderId"));
			// cmtOrderManagement.setOrder_status(rs.getString("order_status"));
			cmtOrderManagement.setDescription(rs.getString("order_description"));
			cmtOrderManagement.setOrderDate(rs.getTimestamp("order_date").toString());
			cmtOrderManagement.setCompletionDate(rs.getTimestamp("order_completion").toString());
			cmtOrderManagement.setStatus(rs.getString("status"));
			OrderStatus cmtOrderStatus = new OrderStatus();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();
			for (int x = 1; x <= columns; x++) {
				if ("order_status".equals(rsmd.getColumnName(x))) {
					cmtOrderStatus.setOrderStatus(rs.getString("order_status"));
				} else if ("order_value".equals(rsmd.getColumnName(x))) {
					cmtOrderStatus.setOrderValue(rs.getString("order_value"));
				}
			}
			cmtOrderManagement.setOrderStatus(cmtOrderStatus);
		}
		return cmtOrderManagement;
	}

}

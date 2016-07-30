package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.CustomerJobDetail;

public class CustomerJobDetailExtractor implements
		ResultSetExtractor<List<CustomerJobDetail>> {

	@Override
	public List<CustomerJobDetail> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<CustomerJobDetail> customerJobDetails = new ArrayList<CustomerJobDetail>();
		CustomerJobDetail customerJobDetail = null;
		if (rs.next()) {
			customerJobDetail = new CustomerJobDetail();
			customerJobDetail.setJobId(rs.getInt("job_id"));
			customerJobDetail.setCustomerId(rs.getInt("customer_id"));
			customerJobDetail.setCategory_id(rs.getInt("category_id"));
			customerJobDetail.setOrder_id(rs.getInt("order_id"));
			customerJobDetail.setUnique_Id(rs.getString("unique_id"));
			customerJobDetail.setActualAmount(rs.getString("actual_amount"));
			customerJobDetail.setPaidAmount(rs.getString("paid_amount"));
			customerJobDetail.setDescription(rs.getString("description"));
			customerJobDetail.setUpdateDate(rs.getTimestamp("due_date").toString());
			customerJobDetail.setWarranty(rs.getDate("warranty").toString());
			customerJobDetail.setStatus(rs.getString("status"));
			customerJobDetail.setReason(rs.getString("reason"));
			ResultSetMetaData rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();
			for (int x = 1; x <= columns; x++) {
				if ("customerId".equals(rsmd.getColumnName(x))) {
					customerJobDetail.setCategory_id(rs.getInt("customerId"));
				}
			}
			customerJobDetails.add(customerJobDetail);
		}
		return customerJobDetails;
	}
}

package com.customer.management.tool.extractor;

import java.sql.ResultSet;
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
			customerJobDetail.setUnique_Id(rs.getInt("unique_id"));
			customerJobDetail.setProductId(rs.getInt("product_id"));
			customerJobDetail.setActualAmount(rs.getString("actual_amount"));
			customerJobDetail.setPaidAmount(rs.getString("paid_amount"));
			customerJobDetail.setDescription(rs.getString("description"));
			customerJobDetail.setUpdateDate(rs.getTimestamp("updated_date"));
			customerJobDetail.setWarranty(rs.getDate("warranty"));
			customerJobDetail.setStatus(rs.getString("status"));
			customerJobDetails.add(customerJobDetail);
		}
		return customerJobDetails;
	}
}

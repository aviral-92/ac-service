package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.CustomerReparingDetail;

import java.sql.ResultSetMetaData;

public class RepairingDetailExtractor implements
		ResultSetExtractor<List<CustomerReparingDetail>> {

	@Override
	public List<CustomerReparingDetail> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<CustomerReparingDetail> reparingDetailList = new ArrayList<>();
		CustomerReparingDetail reparingDetail = null;
		while (rs.next()) {
			reparingDetail = new CustomerReparingDetail();

			reparingDetailList.add(reparingDetail);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columns = rsmd.getColumnCount();
			for (int x = 1; x <= columns; x++) {
				// System.out.println(rsmd.getColumnName(x));
				if ("customer_Id".equals(rsmd.getColumnName(x))) {
					reparingDetail.setCustomerId(rs.getInt("customer_Id"));
				} else if ("ac_type".equals(rsmd.getColumnName(x))) {
					reparingDetail.setAcType(rs.getString("ac_type"));
				} else if ("repairId".equals(rsmd.getColumnName(x))) {
					reparingDetail.setRepairId(rs.getInt("repairId"));
				} else if ("ac_Id".equals(rsmd.getColumnName(x))) {
					reparingDetail.setAcTypesid(rs.getInt("ac_Id"));
				} else if ("description".equals(rsmd.getColumnName(x))) {
					reparingDetail.setDescription(rs.getString("description"));
				} else if ("actual_amount".equals(rsmd.getColumnName(x))) {
					reparingDetail.setActualAmount(rs
							.getString("actual_amount"));
				} else if ("paid_amount".equals(rsmd.getColumnName(x))) {
					reparingDetail.setPaidAmount(rs.getString("paid_amount"));
				} else if ("updated_date".equals(rsmd.getColumnName(x))) {
					reparingDetail.setUpdateDate(rs.getDate("updated_date"));
				} else if ("status".equals(rsmd.getColumnName(x))) {
					reparingDetail.setStatus(rs.getString("status"));
				} else if ("warranty".equals(rsmd.getColumnName(x))) {
					reparingDetail.setWarranty(rs.getDate("warranty"));
				} else if ("model_vehicle_no".equals(rsmd.getColumnName(x))) {
					reparingDetail.setModel_Vehicle(rs
							.getString("model_vehicle_no"));
				} else if ("address".equals(rsmd.getColumnName(x))) {
					reparingDetail.setAddress(rs.getString("address"));
				} else if ("email".equals(rsmd.getColumnName(x))) {
					reparingDetail.setEmail(rs.getString("email"));
				} else if ("mobile".equals(rsmd.getColumnName(x))) {
					reparingDetail.setMobile(rs.getString("mobile"));
				} else if ("name".equals(rsmd.getColumnName(x))) {
					reparingDetail.setName(rs.getString("name"));
				} else if ("updatedDate".equals(rsmd.getColumnName(x))) {
					reparingDetail.setUpdatedDateRetun(rs.getString("updatedDate"));
				}else if ("amount".equals(rsmd.getColumnName(x))) {
					reparingDetail.setFinalAmount(rs.getString("amount"));
				}
			}
		}
		return reparingDetailList;
	}

}

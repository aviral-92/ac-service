package ac.service.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ac.service.pojo.CustomerReparingDetail;

public class RepairingDetailExtractor implements ResultSetExtractor<List<CustomerReparingDetail>> {

	@Override
	public List<CustomerReparingDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<CustomerReparingDetail> reparingDetailList = new ArrayList<>();
		CustomerReparingDetail reparingDetail = null;
		while (rs.next()) {
			reparingDetail = new CustomerReparingDetail();
			reparingDetail.setCustomerId(rs.getInt("customer_Id"));
			reparingDetail.setRepairId(rs.getInt("repairId"));
			reparingDetail.setAcTypesid(rs.getInt("ac_Id"));
			reparingDetail.setDescription(rs.getString("description"));
			reparingDetail.setActualAmount(rs.getString("actual_amount"));
			reparingDetail.setPaidAmount(rs.getString("paid_amount"));
			reparingDetail.setUpdateDate(rs.getDate("updated_date"));
			reparingDetail.setStatus(rs.getString("status"));
			reparingDetail.setWarranty(rs.getDate("warranty"));
			reparingDetail.setModel_Vehicle(rs.getString("model_vehicle_no"));
			reparingDetailList.add(reparingDetail);
			try {
				if (rs.getString("ac_type") != null) {
					reparingDetail.setAcType(rs.getString("ac_type"));
				}
			} catch (SQLException ex) {
				System.err.println("SQL Exception in Repairing Detail Extractor ac_type does not Exist");
			}
			try {
				if (rs.getString("address") != null) {
					reparingDetail.setAddress(rs.getString("address"));
				}
			} catch (SQLException ex) {
				System.err.println("SQL Exception in Repairing Detail Extractor address does not exist");
			}
			try {
				if (rs.getString("email") != null) {
					reparingDetail.setEmail(rs.getString("email"));
				}
			} catch (SQLException ex) {
				System.err.println("SQL Exception in Repairing Detail Extractor email does not exist");
			}
			try {
				if (rs.getString("mobile") != null) {
					reparingDetail.setMobile(rs.getString("mobile"));
				}
			} catch (SQLException ex) {
				System.err.println("SQL Exception in Repairing Detail Extractor mobile does not exist");
			}
			try {
				if (rs.getString("name") != null) {
					reparingDetail.setName(rs.getString("name"));
				}
			} catch (SQLException ex) {
				System.err.println("SQL Exception in Repairing Detail Extractor name does not exist");
			}
		}

		return reparingDetailList;
	}

}

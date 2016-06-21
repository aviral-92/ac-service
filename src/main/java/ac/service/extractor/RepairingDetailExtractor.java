package ac.service.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import ac.service.pojo.CustomerReparingDetail;
import java.sql.ResultSetMetaData;

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
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            for (int x = 1; x <= columns; x++) {
                //System.out.println(rsmd.getColumnName(x));
                if ("ac_type".equals(rsmd.getColumnName(x))) {
                    reparingDetail.setAcType(rs.getString("ac_type"));
                } else if ("address".equals(rsmd.getColumnName(x))) {
                    reparingDetail.setAddress(rs.getString("address"));
                } else if ("email".equals(rsmd.getColumnName(x))) {
                    reparingDetail.setEmail(rs.getString("email"));
                } else if ("mobile".equals(rsmd.getColumnName(x))) {
                    reparingDetail.setMobile(rs.getString("mobile"));
                } else if ("name".equals(rsmd.getColumnName(x))) {
                    reparingDetail.setName(rs.getString("name"));
                }
            }
        }
        return reparingDetailList;
    }

}

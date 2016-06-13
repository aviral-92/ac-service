/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.extractor;

import ac.service.pojo.AcTypes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author amittal
 */
public class AcTypesExtractor implements ResultSetExtractor<List<AcTypes>> {

    @Override
    public List<AcTypes> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<AcTypes> acTypesList = new ArrayList<>();
        AcTypes acTypes;
        while (rs.next()) {
            acTypes = new AcTypes();
            acTypes.setAcTypesid(rs.getInt(1));
            acTypes.setAcType(rs.getString(2));
            acTypesList.add(acTypes);
        }
        return acTypesList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.CMTTypes;

/**
 *
 * @author amittal
 */
public class CMTTypesExtractor implements ResultSetExtractor<List<CMTTypes>> {

    @Override
    public List<CMTTypes> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<CMTTypes> acTypesList = new ArrayList<>();
        CMTTypes acTypes;
        while (rs.next()) {
            acTypes = new CMTTypes();
            acTypes.setAcTypesid(rs.getInt(1));
            acTypes.setAcType(rs.getString(2));
            acTypesList.add(acTypes);
        }
        return acTypesList;
    }

}

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

import com.customer.management.tool.pojo.UserDetail;

/**
 *
 * @author amittal
 */
public class UserManagementExtractor implements ResultSetExtractor<List<UserDetail>> {

    @Override
    public List<UserDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {
        UserDetail userDetails;
        List<UserDetail> detailList = new ArrayList<>();
        while (rs.next()) {
            userDetails = new UserDetail();
            userDetails.setUserId(rs.getInt("userId"));
            userDetails.setUsername(rs.getString("username"));
            userDetails.setName(rs.getString("name"));
            userDetails.setEmail(rs.getString("email"));
            userDetails.setMobile(rs.getString("mobile"));
            detailList.add(userDetails);
        }
        return detailList;
    }
}

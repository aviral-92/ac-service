/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.customer.management.tool.pojo.Login;

/**
 *
 * @author amittal
 */
public class LoginExtractor implements ResultSetExtractor<Login> {

    @Override
    public Login extractData(ResultSet rs) throws SQLException, DataAccessException {
        Login login =null ;
        if (rs.next()) {
            login = new Login(rs.getString("username"),rs.getString("password"),rs.getString("role"));
        }
        return login;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.dao.UserManagementDao;
import com.customer.management.tool.extractor.CMTLoginExtractor;
import com.customer.management.tool.extractor.UserManagementExtractor;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetail;
import com.customer.management.tool.validator.ValidateUser;

/**
 *
 * @author Aviral
 */
@Component
@Scope("prototype")
public class UserManagementDaoImpl implements UserManagementDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*@Autowired
    private ValidateUser validation;*/

    @Override
    public boolean authenticateUser(CMTLogin login) {
        boolean loginSuccess = false;
        String sql = "SELECT * FROM LOGIN WHERE username = ? AND password = ? AND role = ?";

        List<String> args = new ArrayList<>();
        args.add(login.getUsername());
        args.add(login.getPassword());
        args.add(login.getRole());
        CMTLogin loginDetail = jdbcTemplate.query(sql, new CMTLoginExtractor(), args.toArray());
        if (!StringUtils.isEmpty(loginDetail)) {
            loginSuccess = true;
        }
        return loginSuccess;
    }

    @Override
    public String addUser(UserDetail userDetail, CMTLogin login) throws Exception {

//        validation.validateLogin(login);
        String response = null;
        
            String userValidate = null;
//            validation.validateUser(userDetail);
            String insertLogin = " INSERT INTO login VALUES (?,?,?)";
			String sql = "INSERT INTO userdetail (userId,name,email,mobile,username) values (0,?,?,?,?)";
			if (!isUserExist(userDetail)) {
			    List<String> args = null;
			    args = new ArrayList<>();
			    args.add(login.getUsername());
			    args.add(login.getPassword());
			    args.add(login.getRole());
			    int success = jdbcTemplate.update(insertLogin, args.toArray());
			    if (success > 0) {
			        args = new ArrayList<>();
			        args.add(userDetail.getName());
			        args.add(userDetail.getEmail());
			        args.add(userDetail.getMobile());
			        args.add(userDetail.getUsername());
			        int temp = jdbcTemplate.update(sql, args.toArray());
			        if (temp > 0) {
			            response = "Successfully added.";
			        } else {
			            response = "Unable to insert User";
			        }
			    } else {
			        response = "Unable to insert in CMTLogin";
			    }
			} else {
			    response = "User already Exist";
			}
        
        return response;
    }

    @Override
    public boolean isUserExist(UserDetail detail) {

        boolean isExist = false, isUsername = false, isEmail = false;
        List<String> args = new ArrayList<>();
        StringBuilder query = new StringBuilder(" SELECT * FROM userdetail ");

        if (!StringUtils.isEmpty(detail.getUsername())) {
            query.append(" WHERE username = ? ");
            args.add(detail.getUsername());
            isUsername = true;
        }
        if (isUsername) {
            if (!StringUtils.isEmpty(detail.getEmail())) {
                query.append(" AND email = ? ");
                args.add(detail.getEmail());
            }
        } else if (!StringUtils.isEmpty(detail.getEmail())) {
            query.append(" WHERE email = ? ");
            args.add(detail.getEmail());
            isEmail = true;
        }
        if (isUsername || isEmail) {
            if (!StringUtils.isEmpty(detail.getMobile())) {
                query.append(" AND mobile = ? ");
                args.add(detail.getMobile());
            }
        } else if (!StringUtils.isEmpty(detail.getMobile())) {
            query.append(" WHERE mobile = ? ");
            args.add(detail.getMobile());
        }
        CMTLogin login = jdbcTemplate.query(query.toString(), new CMTLoginExtractor(), args.toArray());
        if (!StringUtils.isEmpty(login.getUsername())) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public List<UserDetail> getUserList(UserDetail detail) {

        boolean isUsername = false, isEmail = false;
        StringBuilder query = new StringBuilder("SELECT * FROM userdetail ");
        List<String> args = new ArrayList<>();
        if (!StringUtils.isEmpty(detail)) {
            if (!StringUtils.isEmpty(detail.getUsername())) {
                query.append(" WHERE username = ? ");
                args.add(detail.getUsername());
                isUsername = true;
            }
            if (isUsername) {
                if (!StringUtils.isEmpty(detail.getEmail())) {
                    query.append(" AND email = ? ");
                    args.add(detail.getEmail());
                }
            } else if (!StringUtils.isEmpty(detail.getEmail())) {
                query.append(" WHERE email = ? ");
                args.add(detail.getEmail());
                isEmail = true;
            }
            if (isUsername || isEmail) {
                if (!StringUtils.isEmpty(detail.getMobile())) {
                    query.append(" AND mobile = ? ");
                    args.add(detail.getMobile());
                }
            } else if (!StringUtils.isEmpty(detail.getMobile())) {
                query.append(" WHERE mobile = ? ");
                args.add(detail.getMobile());
            }
        }
        List<UserDetail> userDetailList = jdbcTemplate.query(query.toString(), new UserManagementExtractor(), args.toArray());
        return userDetailList;
    }

    @Override
    public String updateUser(UserDetail detail) {

        String updated = null;
        if (!isUserExist(detail)) {
            String query = " UPDATE userdetail SET name = ?, email = ?, mobile = ? where userid = ?";
            List<String> args = new ArrayList<>();
            args.add(detail.getName());
            args.add(detail.getEmail());
            args.add(detail.getMobile());
            args.add(String.valueOf(detail.getUserId()));
            int update = jdbcTemplate.update(query, args.toArray());
            if (update > 0) {
                updated = "Updated Successfully";
            }
        } else {
            updated = "Email or Mobile already Exist, please provide other.";
        }
        return updated;
    }

    @Override
    public String deleteUser(UserDetail detail) {

        String delete = null;
        StringBuilder query = new StringBuilder("DELETE FROM userdetail ");
        List<String> args = new ArrayList<>();
        if (!StringUtils.isEmpty(detail)) {
            if (!StringUtils.isEmpty(detail.getUsername())) {
                query.append(" WHERE username = ? ");
                args.add(detail.getUsername());
            } else if (!StringUtils.isEmpty(detail.getEmail())) {
                query.append(" WHERE email = ? ");
                args.add(detail.getEmail());
            } else if (!StringUtils.isEmpty(detail.getMobile())) {
                query.append(" WHERE mobile = ? ");
                args.add(detail.getMobile());
            } else {
                delete = "Please provide atleast one field.";
            }
        }
        if (StringUtils.isEmpty(delete)) {
            int response = jdbcTemplate.update(query.toString(), args.toArray());
            if (response > 0) {
                delete = "Successfully Deleted";
            }
        }
        return delete;
    }

}

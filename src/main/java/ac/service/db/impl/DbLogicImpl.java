/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.db.impl;

import ac.service.db.DbLogic;
import ac.service.extractor.LoginExtractor;
import ac.service.extractor.UserExtractor;
import ac.service.pojo.Login;
import ac.service.pojo.UserDetail;
import ac.service.validator.Validation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author Aviral
 */
@Component
public class DbLogicImpl implements DbLogic {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private Validation validation;

    @Override
    public boolean loginCheck(Login login) {
        boolean loginSuccess = false;
        String sql = "SELECT * FROM LOGIN WHERE username = ? AND password = ? AND role = ?";

        List<String> args = new ArrayList<>();
        args.add(login.getUsername());
        args.add(login.getPassword());
        args.add(login.getRole());
        Login loginDetail = jdbcTemplate.query(sql, new LoginExtractor(), args.toArray());
        if (!StringUtils.isEmpty(loginDetail)) {
            loginSuccess = true;
        }
        return loginSuccess;
    }

    @Override
    public String addUser(UserDetail userDetail, Login login) {

        String loginValidate = validation.validateLogin(login);
        String response = null;
        if (loginValidate == null) {
            String userValidate = null;
            userValidate = validation.validateUser(userDetail);
            if (userValidate == null) {
                String insertLogin = " INSERT INTO login VALUES (?,?,?)";
                String sql = "INSERT INTO userdetail (userId,name,email,mobile,username) values (0,?,?,?,?)";
                if (!isExist(userDetail)) {
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
                        response = "Unable to insert in Login";
                    }
                } else {
                    response = "User already Exist";
                }
            } else {
                response = userValidate;
            }
        } else {
            response = loginValidate;
        }
        return response;
    }

    @Override
    public boolean isExist(UserDetail detail) {

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
        Login login = jdbcTemplate.query(query.toString(), new LoginExtractor(), args.toArray());
        if (!StringUtils.isEmpty(login.getUsername())) {
            isExist = true;
        }
        return isExist;
    }

    @Override
    public List<UserDetail> userDetailList(UserDetail detail) {

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
        List<UserDetail> userDetailList = jdbcTemplate.query(query.toString(), new UserExtractor(), args.toArray());
        return userDetailList;
    }

    @Override
    public String updateUser(UserDetail detail) {

        String updated = null;
        if (!isExist(detail)) {
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

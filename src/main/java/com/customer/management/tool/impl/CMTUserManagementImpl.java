/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.impl;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.CMTDevelopmentTool;
import com.customer.management.tool.dao.impl.UserManagementDaoImpl;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetail;
import com.customer.management.tool.ui.admin.Welcome;
import com.customer.management.tool.validator.ValidateUser;

/**
 *
 * @author amittal
 */
@Component
@Scope("prototype")
public class CMTUserManagementImpl {

    @Autowired
    private UserManagementDaoImpl userDaoImpl;
    @Autowired
    private ValidateUser validation;
    /*@Autowired
    private Welcome welcomeForm;*/
    
    /*@Autowired
    private LoginForm loginForm;*/

    public String login(CMTLogin login) throws Exception {

        String response = null;
        if (!CMTDevelopmentTool.isDevelopmentMode) {
            validation.validateLogin(login);
            if (StringUtils.isEmpty(response)) {
                if (userDaoImpl.authenticateUser(login)) {
                    response = "Successfully Logged in";
                    JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.INFORMATION_MESSAGE);
//                    loginForm.dispose();
//                    welcomeForm.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.ERROR_MESSAGE);
            }
        } else {
//            loginForm.dispose();
//            welcomeForm.setVisible(true);
        }
        return response;
    }

    public String validateField(String field) {

        String data = null;
        String response = validation.textFieldValidation(field);
        if (response != null) {
            JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.ERROR_MESSAGE);
            data = "Success";
        }
        return data;
    }

    public String addUser(CMTLogin login, UserDetail userDetail) throws Exception {

    	validation.validateLogin(login);
    	validation.validateUser(userDetail);
        return userDaoImpl.addUser(userDetail, login);
    }

    public UserDetail getUserData(UserDetail detail) throws Exception {

        validation.validateGeteUser(detail);
        if (!userDaoImpl.getUserList(detail).isEmpty()) {
            return userDaoImpl.getUserList(detail).get(0);
        } else {
            return null;
        }
    }

    public String updateUserData(UserDetail detail) throws Exception {

        validation.validateUpdate_DeleteUser(detail);
        return userDaoImpl.updateUser(detail);
    }

    public String deleteUserData(UserDetail detail) throws Exception {

        validation.validateUpdate_DeleteUser(detail);
        return userDaoImpl.deleteUser(detail);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.impl;

import ac.service.dao.impl.UserDaoImpl;
import ac.service.pojo.Login;
import ac.service.pojo.UserDetail;
import ac.service.ui.LoginForm;
import ac.service.ui.admin.WelcomeForm;
import ac.service.validator.ValidateUser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author amittal
 */
@Component
public class AcServiceUserImpl {

    @Autowired
    private UserDaoImpl userDaoImpl;
    @Autowired
    private ValidateUser validation;
    @Autowired
    private WelcomeForm welcomeForm;
    @Autowired
    private LoginForm loginForm;

    public String login(Login login) throws Exception {

        String response = null;
        validation.validateLogin(login);
        if (StringUtils.isEmpty(response)) {
            if (userDaoImpl.authenticateUser(login)) {
                response = "Successfully Logged in";
                JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.INFORMATION_MESSAGE);
                loginForm.dispose();
                welcomeForm.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.ERROR_MESSAGE);
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

    public String addUser(Login login, UserDetail userDetail) throws Exception {

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

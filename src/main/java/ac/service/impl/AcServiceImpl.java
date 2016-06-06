/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.impl;

import ac.service.db.DbLogic;
import ac.service.pojo.Login;
import ac.service.ui.LoginForm;
import ac.service.ui.admin.WelcomeForm;
import ac.service.validator.Validation;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author amittal
 */
@Component
public class AcServiceImpl {

    @Autowired
    private DbLogic dbLogic;
    @Autowired
    private Validation validation;
    @Autowired
    private WelcomeForm welcomeForm;
    @Autowired
    private LoginForm loginForm;

    public String login(Login login) {

        String check = null;
        String response = validation.validateLogin(login);
        if (response == null) {
            if (dbLogic.loginCheck(login)) {
                check = "Successfully Logged in";
                JOptionPane.showMessageDialog(new JFrame(), check, check, JOptionPane.INFORMATION_MESSAGE);
                loginForm.dispose();
                welcomeForm.setTitle("Welcome");
                welcomeForm.setVisible(true);
            }
        } else {
            check = response;
            JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.ERROR_MESSAGE);
        }
        return check;
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
}

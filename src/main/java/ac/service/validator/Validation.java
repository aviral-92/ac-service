/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.validator;

import ac.service.pojo.Login;
import ac.service.pojo.UserDetail;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author amittal
 */
@Component
public class Validation {

    public String validateLogin(Login login) {

        String response = null;
        if ((StringUtils.isEmpty(login.getPassword())) || (StringUtils.isEmpty(login.getUsername()))) {
            response = "Username or Password field is empty";
        }
        if (login.getRole().equals("select")) {
            response = "Please select role";
        }
        return response;
    }

    public String validateUser(UserDetail userDetail) {

        String response = null;
        if (userDetail != null) {
            if (StringUtils.isEmpty(userDetail.getEmail())) {
                response = "Emial field is empty";
            } else if (StringUtils.isEmpty(userDetail.getMobile())) {
                response = "Mobile field is empty";
            } else if (StringUtils.isEmpty(userDetail.getName())) {
                response = "Name field is empty";
            } else if (StringUtils.isEmpty(userDetail.getUsername())) {
                response = "Username field is empty";
            }
        } else {
            response = "Fields are Empty";
        }
        return response;
    }

    public String textFieldValidation(String textField) {

        String validate = null;
        if (StringUtils.isEmpty(textField) || StringUtils.containsWhitespace(textField)) {
            validate = " field is empty or it contains white Spaces";
        }
        return validate;
    }
}

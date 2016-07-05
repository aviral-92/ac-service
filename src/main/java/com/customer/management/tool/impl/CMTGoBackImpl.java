/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.customer.management.tool.ui.admin.AddUser;
import com.customer.management.tool.ui.admin.GetUser;
import com.customer.management.tool.ui.admin.GetUsers;
import com.customer.management.tool.ui.admin.ModifyUser;
import com.customer.management.tool.ui.admin.Welcome;
import com.customer.management.tool.ui.customer.AddCustomer;
import com.customer.management.tool.ui.customer.AddCustomerRepairDetail;
import com.customer.management.tool.ui.customer.GetCustomer;
import com.customer.management.tool.ui.customer.CustomerHistory;
import com.customer.management.tool.ui.customer.CustomerDetail;

/**
 *
 * @author amittal
 */
@Component
public class CMTGoBackImpl {

    @Autowired
    private Welcome welcomeForm;

    public void backButtonCode(Object back) {

        if (back instanceof GetUsers) {
            goBack();
        } else if (back instanceof GetUser) {
            goBack();
        } else if (back instanceof AddUser) {
            goBack();
        } else if (back instanceof ModifyUser) {
            goBack();
        } else if (back instanceof CustomerDetail) {
            goBack();
        }else if(back instanceof AddCustomer){
            goBack();
        }else if(back instanceof AddCustomerRepairDetail){
            goBack();
        }else if(back instanceof GetCustomer){
            goBack();
        }else if(back instanceof CustomerHistory){
            goBack();
        }
    }

    private void goBack() {
        welcomeForm.setTitle("Welcome");
        welcomeForm.setVisible(true);
    }
}

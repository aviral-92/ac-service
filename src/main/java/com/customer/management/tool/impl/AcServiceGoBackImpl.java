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
import com.customer.management.tool.ui.admin.GetUserTable;
import com.customer.management.tool.ui.admin.UserModifyForm;
import com.customer.management.tool.ui.admin.WelcomeForm;
import com.customer.management.tool.ui.customer.AddCustomer;
import com.customer.management.tool.ui.customer.AddRepairDetails;
import com.customer.management.tool.ui.customer.GetCustomer;
import com.customer.management.tool.ui.customer.GetCustomerPreviousRecords;
import com.customer.management.tool.ui.customer.GetCustomerTable;

/**
 *
 * @author amittal
 */
@Component
public class AcServiceGoBackImpl {

    @Autowired
    private WelcomeForm welcomeForm;

    public void backButtonCode(Object back) {

        if (back instanceof GetUserTable) {
            goBack();
        } else if (back instanceof GetUser) {
            goBack();
        } else if (back instanceof AddUser) {
            goBack();
        } else if (back instanceof UserModifyForm) {
            goBack();
        } else if (back instanceof GetCustomerTable) {
            goBack();
        }else if(back instanceof AddCustomer){
            goBack();
        }else if(back instanceof AddRepairDetails){
            goBack();
        }else if(back instanceof GetCustomer){
            goBack();
        }else if(back instanceof GetCustomerPreviousRecords){
            goBack();
        }
    }

    private void goBack() {
        welcomeForm.setTitle("Welcome");
        welcomeForm.setVisible(true);
    }
}

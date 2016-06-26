/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.impl;

import ac.service.ui.admin.AddUser;
import ac.service.ui.admin.GetUser;
import ac.service.ui.admin.GetUserTable;
import ac.service.ui.admin.UserModifyForm;
import ac.service.ui.admin.WelcomeForm;
import ac.service.ui.customer.AddCustomer;
import ac.service.ui.customer.AddRepairDetails;
import ac.service.ui.customer.GetCustomer;
import ac.service.ui.customer.GetCustomerPreviousRecords;
import ac.service.ui.customer.GetCustomerTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.impl;

import ac.service.dao.impl.CustomerDaoImpl;
import ac.service.pojo.AcTypes;
import ac.service.pojo.Customer;
import ac.service.pojo.CustomerReparingDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author amittal
 */
@Component
public class AcServiceCustomerImpl {

    @Autowired
    private CustomerDaoImpl customerDaoImpl;

    public List<AcTypes> getAcType() {

        return customerDaoImpl.getAcTypes();
    }

    public String addCustomer(Customer customer) throws Exception {

        return customerDaoImpl.addCustomer(customer);
    }

    public List<Customer> getCustomerInfo(Customer customer) {

        return customerDaoImpl.getCustomer(customer);
    }

    public String addRepairDetail(CustomerReparingDetail customerReparingDetail) {

        return customerDaoImpl.addCustomerRepairDetails(customerReparingDetail);
    }

    public Customer getCustomerID(Customer customer) {

        return customerDaoImpl.getCustomerId(customer);
    }
}

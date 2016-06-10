/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.impl;

import ac.service.dao.impl.CustomerDaoImpl;
import ac.service.pojo.AcTypes;
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
}

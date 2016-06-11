/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.dao;

import ac.service.pojo.AcTypes;
import ac.service.pojo.Customer;
import java.util.List;

/**
 *
 * @author amittal
 */
public interface CustomerDao {

    public List<AcTypes> getAcTypes();
    
    public String addCustomer(Customer customer);
}

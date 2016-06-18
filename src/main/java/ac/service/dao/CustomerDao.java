/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.dao;

import ac.service.pojo.AcTypes;
import ac.service.pojo.Customer;
import ac.service.pojo.CustomerReparingDetail;
import java.util.List;

/**
 *
 * @author amittal
 */
public interface CustomerDao {

	public List<AcTypes> getAcTypes();

	public String addCustomer(Customer customer) throws Exception;

	public boolean isExist(Customer customer);

	public List<Customer> getCustomer(Customer customer);

	public String addCustomerRepairDetails(CustomerReparingDetail customerReparingDetail);

	public List<CustomerReparingDetail> findRepairDetailsByCustomerId(CustomerReparingDetail reparingDetail);
}

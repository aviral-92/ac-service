/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.extractor;

import ac.service.pojo.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Aviral
 */
public class CustomerExtractor implements ResultSetExtractor<List<Customer>> {

	List<Customer> customerList = new ArrayList<>();

	@Override
	public List<Customer> extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		Customer customer;
		while (rs.next()) {
			customer = new Customer();
			customer.setCustomerId(rs.getInt("customerId"));
			customer.setName(rs.getString("name"));
			customer.setEmail(rs.getString("email"));
			customer.setAddress(rs.getString("address"));
			customer.setMobile(rs.getString("mobile"));
			customerList.add(customer);
		}
		return customerList;
	}

}

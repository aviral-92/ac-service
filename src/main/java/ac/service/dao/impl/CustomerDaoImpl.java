/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.dao.impl;

import ac.service.dao.CustomerDao;
import ac.service.extractor.AcTypesExtractor;
import ac.service.extractor.CustomerExtractor;
import ac.service.pojo.AcTypes;
import ac.service.pojo.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author amittal
 */
@Component
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<AcTypes> getAcTypes() {
        return jdbcTemplate.query("SELECT * FROM ac_type", new AcTypesExtractor());
    }

    @Override
    public String addCustomer(Customer customer) throws Exception {

        String response = null;
        if (!isExist(customer)) {
            String query = "INSERT INTO customer VALUES (0,?,?,?,?,?,?,?,?)";
            List<String> args = new ArrayList<>();
            args.add(String.valueOf(customer.getAcId()));
            args.add(customer.getName());
            args.add(customer.getEmail());
            args.add(customer.getAddress());
            args.add(customer.getMobile());
            args.add(customer.getDescription());
            args.add(String.valueOf(customer.getAmount()));
            args.add(customer.getModel_Vehicle());
            int result = jdbcTemplate.update(query, args.toArray());
            if (result > 0) {
                response = "Customer " + customer.getName() + " successfully added";
            }
        } else {
            throw new Exception("Email or Password already Exist");
        }
        return response;
    }

    @Override
    public boolean isExist(Customer customer) {

        boolean isExist = false;
        String query = "SELECT * FROM customer WHERE email = ? OR mobile = ?";
        List<String> args = new ArrayList<>();
        args.add(customer.getEmail());
        args.add(customer.getMobile());
        List<Customer> response = jdbcTemplate.query(query, new CustomerExtractor(), args.toArray());
        if (!StringUtils.isEmpty(response) && response.size() > 0) {
            isExist = true;
        }
        return isExist;
    }
}

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
            String query = "INSERT INTO customer (customerId,acId,name,email,address,mobile,"
                    + "description,amount,model_vehicle_no) VALUES (0,?,?,?,?,?,?,?,?)";
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

    @Override
    public List<Customer> getCustomer(Customer customer) {

        boolean isEmail = false, isMobile = false, isAddress = false, isCustomerId = false;
        StringBuilder query = new StringBuilder("SELECT * FROM customer ");
        List<String> args = new ArrayList<>();
        if (!StringUtils.isEmpty(customer.getEmail())) {
            query.append(" WHERE email = ? ");
            args.add(customer.getEmail());
            isEmail = true;
        }
        if (isEmail) {
            if (!StringUtils.isEmpty(customer.getMobile())) {
                query.append(" OR mobile = ? ");
                args.add(customer.getMobile());
                isMobile = true;
            }
        } else if (!StringUtils.isEmpty(customer.getMobile())) {
            query.append(" WHERE mobile = ? ");
            args.add(customer.getMobile());
        }
        if (isMobile || isEmail) {
            if (!StringUtils.isEmpty(customer.getAddress())) {
                query.append(" OR address LIKE ? ");
                args.add("%" + customer.getAddress() + "%");
            }
        } else if (!StringUtils.isEmpty(customer.getAddress())) {
            query.append(" WHERE address LIKE ? ");
            args.add("%" + customer.getAddress() + "%");
            isAddress = true;
        }
        if (isMobile || isEmail || isAddress) {
            if (!StringUtils.isEmpty(customer.getCustomerId()) && customer.getCustomerId() != -1) {
                query.append(" OR customerId = ? ");
                args.add(String.valueOf(customer.getCustomerId()));
            }
        } else if (!StringUtils.isEmpty(customer.getCustomerId()) && customer.getCustomerId() != -1) {
            query.append(" WHERE customerId = ? ");
            args.add(String.valueOf(customer.getCustomerId()));
            isCustomerId = true;
        }
        if (isMobile || isEmail || isAddress || isCustomerId) {
            if (!StringUtils.isEmpty(customer.getModel_Vehicle())) {
                query.append(" OR model_vehicle_no = ? ");
                args.add(customer.getModel_Vehicle());
            }
        } else if (!StringUtils.isEmpty(customer.getModel_Vehicle())) {
            query.append(" WHERE model_vehicle_no = ? ");
            args.add(customer.getModel_Vehicle());
        }

        List<Customer> response = jdbcTemplate.query(query.toString(), new CustomerExtractor(), args.toArray());

        return response;
    }
}

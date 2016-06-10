/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.dao.impl;

import ac.service.dao.CustomerDao;
import ac.service.extractor.AcTypesExtractor;
import ac.service.pojo.AcTypes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.extractor;

import ac.service.pojo.Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author amittal
 */
public class LoginExtractor implements ResultSetExtractor<Login> {

    @Override
    public Login extractData(ResultSet rs) throws SQLException, DataAccessException {
        Login loginDetails = new Login();
        if (rs.next()) {
            loginDetails.setUsername(rs.getString("username"));
            loginDetails.setPassword(rs.getString("password"));
            loginDetails.setRole(rs.getString("role"));
        }
        return loginDetails;
    }
}

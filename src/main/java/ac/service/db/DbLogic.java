/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.db;

import ac.service.pojo.Login;
import ac.service.pojo.UserDetail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Aviral
 */

@Component
public class DbLogic {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private ResultSet rs;
    private Connection con;
    private PreparedStatement ps;

    public boolean loginCheck(Login login) {
        boolean loginSuccess = false;
        if (con == null) {
            con = connection();
        }
        String sql = "SELECT * FROM LOGIN WHERE username = ? AND password = ? AND role = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getUsername());
            ps.setString(2, login.getPassword());
            ps.setString(3, login.getRole());
            rs = ps.executeQuery();
            if (rs.next()) {
                loginSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loginSuccess;
    }

    public String addUser(String name, String username, String email, String mobile, String password, String role) {

        String response = null;
        if (con == null) {
            con = connection();
        }
        if (!isExist(mobile, email, username)) {
            String insertLogin = " INSERT INTO login VALUES (?,?,?)";
            String sql = "INSERT INTO userdetail (userId,name,email,mobile,username) values (0,?,?,?,?)";
            try {
                ps = con.prepareStatement(insertLogin);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, role);
                int stmtExecute = ps.executeUpdate();
                if (stmtExecute > 0) {
                    System.out.println("Inserted into Login Table....");
                    response = "Inserted into Login Table....";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setString(3, mobile);
                    ps.setString(4, username);
                    int insert = ps.executeUpdate();
                    if (insert > 0) {
                        System.out.println("Inserted into User Detail Table....");
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            response = "Username - " + username + " or Mobile - " + mobile + " or Email - " + email + " already Exist";
        }
        return response;

    }

    private boolean isExist(String mobile, String email, String username) {

        String query = "SELECT * FROM userdetail WHERE username = ? OR email = ? OR mobile = ? ";
        if (con == null) {
            con = connection();
        }
        boolean isExist = false;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, mobile);
            rs = ps.executeQuery();
            if (rs.next()) {
                isExist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            isExist = false;
        }
        return isExist;
    }

    public List<UserDetail> userDetailList(UserDetail detail) {

        if (con == null) {
            con = connection();
        }
        UserDetail userDetail = null;
        List<UserDetail> userDetails = new ArrayList<>();
        try {
            if (detail != null && (!detail.getUsername().equals("") || !detail.getEmail().equals("") || !detail.getMobile().equals(""))) {
                String sql = "SELECT * FROM userdetail WHERE username = ? OR email = ? OR mobile = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, detail.getUsername());
                ps.setString(2, detail.getEmail());
                ps.setString(3, detail.getMobile());
                rs = ps.executeQuery();
                if (rs.next()) {
                    userDetail = new UserDetail();
                    userDetail.setUserId(rs.getInt("userId"));
                    userDetail.setName(rs.getString("name"));
                    userDetail.setEmail(rs.getString("email"));
                    userDetail.setUsername(rs.getString("username"));
                    userDetail.setMobile(rs.getString("mobile"));
                    userDetails.add(userDetail);
                }

            } else {
                String sql = "SELECT * FROM userdetail";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    userDetail = new UserDetail();
                    userDetail.setUserId(rs.getInt("userId"));
                    userDetail.setName(rs.getString("name"));
                    userDetail.setEmail(rs.getString("email"));
                    userDetail.setUsername(rs.getString("username"));
                    userDetail.setMobile(rs.getString("mobile"));
                    userDetails.add(userDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userDetails;
    }

    private Connection connection() {

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://10.1.249.41:3306/ac_service", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

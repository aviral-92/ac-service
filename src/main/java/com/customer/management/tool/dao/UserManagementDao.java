/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.dao;

import java.util.List;

import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetail;

/**
 *
 * @author amittal
 */
public interface UserManagementDao {

    public boolean authenticateUser(CMTLogin login);

    public String addUser(UserDetail userDetail, CMTLogin login) throws Exception;

    public boolean isUserExist(UserDetail detail);

    public List<UserDetail> getUserList(UserDetail detail);

    public String updateUser(UserDetail detail);
    
     public String deleteUser(UserDetail detail);

}

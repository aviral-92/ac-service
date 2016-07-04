/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.query;

/**
 *
 * @author amittal
 */
public class QueryConstant {

    public static String AC_SERVICE = "SELECT * FROM ac_type";

    public static String ADDCUSTOMER = "INSERT INTO customer (customerId,name,email,address,mobile,RegisteredDate) "
    		+ "VALUES (0,?,?,?,?,NOW())";

    public static String ISEXIST = "SELECT * FROM customer WHERE email = ? OR mobile = ?";
    
    public static String GETCUSTOMER = "SELECT * FROM customer ";
}

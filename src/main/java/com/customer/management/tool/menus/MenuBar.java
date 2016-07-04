/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.menus;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.customer.management.tool.ui.admin.AddUser;
import com.customer.management.tool.ui.admin.GetUser;
import com.customer.management.tool.ui.customer.AddCustomer;
import com.customer.management.tool.ui.customer.GetCustomer;

/**
 *
 * @author amittal
 */
//@Component
//@Scope("prototype")
public class MenuBar {
   
	/*
    @Autowired
    private AddUser user;
    @Autowired
    private GetUser getUserValue;
    @Autowired
    private AddCustomer customerAdd;
    @Autowired
    private GetCustomer getCustomerInfo;

    private javax.swing.JMenu Customer;
    private javax.swing.JMenu User;
    private javax.swing.JMenuItem addCustomer;
    private javax.swing.JMenuItem addUser;
    private javax.swing.JMenuItem deleteCustomer;
    private javax.swing.JMenuItem deleteUser;
    private javax.swing.JMenuItem getCustomer;
    private javax.swing.JMenuItem getUser;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem updateCustomer;
    private javax.swing.JMenuItem updateUser;

    public JMenuBar menu() {

        jMenuBar1 = new javax.swing.JMenuBar();
        User = new javax.swing.JMenu();
        addUser = new javax.swing.JMenuItem();
        getUser = new javax.swing.JMenuItem();
        updateUser = new javax.swing.JMenuItem();
        deleteUser = new javax.swing.JMenuItem();
        Customer = new javax.swing.JMenu();
        addCustomer = new javax.swing.JMenuItem();
        getCustomer = new javax.swing.JMenuItem();
        updateCustomer = new javax.swing.JMenuItem();
        deleteCustomer = new javax.swing.JMenuItem();

        User.setText("USER");
        addUser.setText("Add User");
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Clicked(evt);
            }
        });
        User.add(addUser);

        getUser.setText("Get User");
        getUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getUserMousePressed(evt);
            }
        });
        User.add(getUser);

        updateUser.setText("Update User");
        updateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateUserMousePressed(evt);
            }
        });
        User.add(updateUser);

        deleteUser.setText("Delete User");
        deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteUserMousePressed(evt);
            }
        });
        User.add(deleteUser);

        jMenuBar1.add(User);

        Customer.setText("CUSTOMER");

        addCustomer.setText("Add Customer");
        addCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addCustomerMousePressed(evt);
            }
        });
        Customer.add(addCustomer);

        getCustomer.setText("Get Customer");
        getCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                getCustomerMousePressed(evt);
            }
        });
        getCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getCustomerActionPerformed(evt);
            }
        });
        Customer.add(getCustomer);

        updateCustomer.setText("Update Customer");
        Customer.add(updateCustomer);

        deleteCustomer.setText("Delete Customer");
        Customer.add(deleteCustomer);

        jMenuBar1.add(Customer);
        return jMenuBar1;
    }

    /*private void Clicked(java.awt.event.MouseEvent evt) {
        //frame.dispose();
        user.setTitle("Add User");
        user.setVisible(true);
        System.out.println("Hello");
    }

    private void getCustomerActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void getUserMousePressed(java.awt.event.MouseEvent evt) {
      //  frame.dispose();
        getUserValue.setTitle("Get User Details");
        getUserValue.setVisible(true);
    }

    private void updateUserMousePressed(java.awt.event.MouseEvent evt) {
      //  frame.dispose();
        getUserValue.setTitle("Update User Details");
        getUserValue.setVisible(true);
    }

    private void deleteUserMousePressed(java.awt.event.MouseEvent evt) {
       // frame.dispose();
        getUserValue.setTitle("Delete User Details");
        getUserValue.setVisible(true);
    }

    private void addCustomerMousePressed(java.awt.event.MouseEvent evt) {
       // frame.dispose();
        customerAdd.setTitle("CUSTOMER ADD");
        customerAdd.setVisible(true);
    }

    private void getCustomerMousePressed(java.awt.event.MouseEvent evt) {
       // frame.dispose();
        getCustomerInfo.setTitle("Get Customer Info");
        getCustomerInfo.setVisible(true);
    }*/

    /**
     * @return the frame
     */
//    public JFrame getFrame() {
//        return frame;
//    }
//
//    /**
//     * @param frame the frame to set
//     */
//    public void setFrame(JFrame frame) {
//        this.frame = frame;
//    }
}

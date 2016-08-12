/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.ui.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.customer.management.tool.ui.customer.AddCustomer;
import com.customer.management.tool.ui.customer.CustomerAllDetails;
import com.customer.management.tool.ui.customer.job.AddNewCategory;
import com.customer.management.tool.ui.customer.job.AddCustomerJob;
import com.customer.management.tool.ui.customer.job.SearchCustomerJob;
import com.customer.management.tool.ui.customer.GetCustomer;
import com.customer.management.tool.ui.customer.job.JobListByDate;
import com.customer.management.tool.ui.report.CMTReport;

/**
 *
 * @author Aviral
 */
@Component
public class WelcomeForm extends javax.swing.JFrame {

	static Logger LOG = Logger.getLogger(WelcomeForm.class);
	private static final long serialVersionUID = 1L;
	@Autowired
	private AddUser addUserDetail;
	@Autowired
	private GetUser getUserDetail;
	@Autowired
	private AddCustomer addCustomerDetail;
	@Autowired
	private GetCustomer getCustomerDetail;
	@Autowired
	private CMTReport CMTReport;
	@Autowired
	private UserManagement userMgmt;
	@Autowired
	private AddCustomerJob customerJob;
	@Autowired
	private AddNewCategory addNewCategory;
	@Autowired
	private SearchCustomerJob searchCustomerJob;
	@Autowired
	private JobListByDate jobListByDate;
	@Autowired
	private CustomerAllDetails customerAllDetails;

	/**
	 * Creates new form WelcomeForm
	 */

	public WelcomeForm(ResourceBundleMessageSource messageSource) {
		initComponents();
		super.setTitle("WelcomeForm");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jMenuItem2 = new javax.swing.JMenuItem();
		jPopupMenu1 = new javax.swing.JPopupMenu();
		jMenuBar2 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		user = new javax.swing.JMenu();
		addUser = new javax.swing.JMenuItem();
		getUser = new javax.swing.JMenuItem();
		updateUser = new javax.swing.JMenuItem();
		deleteUser = new javax.swing.JMenuItem();
		customer = new javax.swing.JMenu();
		addCustomer = new javax.swing.JMenuItem();
		getCustomer = new javax.swing.JMenuItem();
		updateCustomer = new javax.swing.JMenuItem();
		deleteCustomer = new javax.swing.JMenuItem();
		report = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		userManagement = new javax.swing.JMenu();
		activateUser = new javax.swing.JMenuItem();
		deactivateUser = new javax.swing.JMenuItem();
		userDelete = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();
		byDate = new javax.swing.JMenuItem();
		addCustomerJob = new javax.swing.JMenuItem();
		searchJob = new javax.swing.JMenuItem();

		jMenuItem2.setText("jMenuItem2");

		jMenu1.setText("File");
		jMenuBar2.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar2.add(jMenu2);

		jMenuItem3.setText("jMenuItem3");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(450, 150, 0, 0));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"WELCOME ADMIN",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 14))); // NOI18N

		jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
		jLabel1.setText("Welcome Admin");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addGap(92, 92, 92)
						.addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 154,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(113, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addGap(102, 102, 102)
						.addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 29,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(128, Short.MAX_VALUE)));

		user.setText("USER");

		addUser.setText("Add User");
		addUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				Clicked(evt);
			}
		});
		user.add(addUser);

		getUser.setText("Get User");
		getUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				getUserMousePressed(evt);
			}
		});
		user.add(getUser);

		updateUser.setText("Update User");
		updateUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				updateUserMousePressed(evt);
			}
		});
		user.add(updateUser);

		deleteUser.setText("Delete User");
		deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				deleteUserMousePressed(evt);
			}
		});
		user.add(deleteUser);

		jMenuBar1.add(user);

		customer.setText("CUSTOMER");

		addCustomer.setText("Add Customer");
		addCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				addCustomerMousePressed(evt);
			}
		});
		customer.add(addCustomer);

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
		customer.add(getCustomer);

		updateCustomer.setText("Update Customer");
		customer.add(updateCustomer);

		deleteCustomer.setText("Delete Customer");
		customer.add(deleteCustomer);

		jMenuBar1.add(customer);

		report.setText("REPORT");

		jMenuItem1.setText("Monthly Report");
		jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				jMenuItem1MousePressed(evt);
			}
		});
		report.add(jMenuItem1);

		jMenuBar1.add(report);

		userManagement.setText("USER MANAGEMENT");

		activateUser.setText("Activate User");
		activateUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				activateUserMousePressed(evt);
			}
		});
		userManagement.add(activateUser);

		deactivateUser.setText("Deactivate User");
		deactivateUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				deactivateUserMousePressed(evt);
			}
		});
		userManagement.add(deactivateUser);

		userDelete.setText("Delete User");
		userDelete.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				userDeleteMousePressed(evt);
			}
		});
		userManagement.add(userDelete);

		jMenuBar1.add(userManagement);

		jMenu3.setText("CUSTOMER MANAGEMENT");

		byDate.setText("Search By Date");
		byDate.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				byDateMousePressed(evt);
			}
		});
		jMenu3.add(byDate);

		addCustomerJob.setText("Add Customer Job");
		addCustomerJob.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				addCustomerJobMousePressed(evt);
			}
		});
		jMenu3.add(addCustomerJob);

		searchJob.setText("Search Job");
		searchJob.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				searchJobMousePressed(evt);
			}
		});
		jMenu3.add(searchJob);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addGap(23, 23, 23)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void byDateMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_byDateMousePressed
		// TODO add your handling code here:
		dispose();
		jobListByDate.setVisible(true);
	}// GEN-LAST:event_byDateMousePressed

	private void addCustomerJobMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_addCustomerJobMousePressed
		// TODO add your handling code here:
		dispose();
		customerJob.setVisible(true);
		customerJob.setTitle("Add Customer Job");
	}// GEN-LAST:event_addCustomerJobMousePressed

	private void searchJobMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_searchJobMousePressed
		// TODO add your handling code here:
		dispose();
		searchCustomerJob.setVisible(true);
		searchCustomerJob.setTitle("Search Customer Job");
	}// GEN-LAST:event_searchJobMousePressed

	private void activateUserMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_activateUserMousePressed

		dispose();
		userMgmt.setVisible(true);
		userMgmt.setTitle("User Management");

	}// GEN-LAST:event_activateUserMousePressed

	private void deactivateUserMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deactivateUserMousePressed

		dispose();
		userMgmt.setVisible(true);
		userMgmt.setTitle("User Management");
	}// GEN-LAST:event_deactivateUserMousePressed

	private void userDeleteMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_userDeleteMousePressed

		dispose();
		userMgmt.setVisible(true);
		userMgmt.setTitle("User Management");
	}// GEN-LAST:event_userDeleteMousePressed

	private void getCustomerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_getCustomerActionPerformed

	}// GEN-LAST:event_getCustomerActionPerformed

	private void Clicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Clicked

		dispose();
		addUserDetail.setTitle("Add User");
		addUserDetail.setVisible(true);
	}// GEN-LAST:event_Clicked

	private void getUserMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_getUserMousePressed

		dispose();
		/*
		 * getUserDetail.setTitle("Get User Details");
		 * getUserDetail.setVisible(true);
		 */
		userMgmt.getContent();
	}// GEN-LAST:event_getUserMousePressed

	private void updateUserMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_updateUserMousePressed

		dispose();
		/*
		 * getUserDetail.setTitle("Update User Details");
		 * getUserDetail.setVisible(true);
		 */
		userMgmt.updateContent();
	}// GEN-LAST:event_updateUserMousePressed

	private void deleteUserMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_deleteUserMousePressed

		dispose();
		getUserDetail.setTitle("Delete User Details");
		getUserDetail.setVisible(true);
	}// GEN-LAST:event_deleteUserMousePressed

	private void addCustomerMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_customerAddMousePressed

		dispose();
		customerAllDetails.setVisible(true);
		// addCustomerDetail.setTitle("CUSTOMER ADD");
		// addCustomerDetail.setVisible(true);
	}// GEN-LAST:event_customerAddMousePressed

	private void getCustomerMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_getCustomerMousePressed

		dispose();
		getCustomerDetail.setTitle("Get Customer Info");
		getCustomerDetail.setVisible(true);
	}// GEN-LAST:event_getCustomerMousePressed

	private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMenuItem1MousePressed

		this.dispose();
		CMTReport.setVisible(true);
	}// GEN-LAST:event_jMenuItem1MousePressed

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem activateUser;
	private javax.swing.JMenuItem addCustomer;
	private javax.swing.JMenuItem addCustomerJob;
	private javax.swing.JMenuItem addUser;
	private javax.swing.JMenuItem byDate;
	private javax.swing.JMenu customer;
	private javax.swing.JMenuItem deactivateUser;
	private javax.swing.JMenuItem deleteCustomer;
	private javax.swing.JMenuItem deleteUser;
	private javax.swing.JMenuItem getCustomer;
	private javax.swing.JMenuItem getUser;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuBar jMenuBar2;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JMenu report;
	private javax.swing.JMenuItem searchJob;
	private javax.swing.JMenuItem updateCustomer;
	private javax.swing.JMenuItem updateUser;
	private javax.swing.JMenu user;
	private javax.swing.JMenuItem userDelete;
	private javax.swing.JMenu userManagement;
	// End of variables declaration//GEN-END:variables
}

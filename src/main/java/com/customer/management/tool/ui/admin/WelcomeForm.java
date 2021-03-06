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

import com.customer.management.tool.ui.customer.CustomerAllDetails;
import com.customer.management.tool.ui.customer.job.AddCustomerJob;
import com.customer.management.tool.ui.customer.job.CMTCustomerMgmt;
import com.customer.management.tool.ui.customer.job.JobListByDate;
import com.customer.management.tool.ui.customer.job.SearchCustomerJob;
import com.customer.management.tool.ui.report.CMTReport;
import com.customer.management.tool.ui.unused.GetCustomer;
import com.customer.management.tool.ui.user.UserOperation;

/**
 *
 * @author Aviral
 */
@Component
public class WelcomeForm extends javax.swing.JFrame {

	static Logger LOG = Logger.getLogger(WelcomeForm.class);
	private static final long serialVersionUID = 1L;
	// @Autowired
	// private AddUser addUserDetail;
	// @Autowired
	// private GetUser getUserDetail;
	// @Autowired
	// private AddCustomer addCustomerDetail;
	@Autowired
	private GetCustomer getCustomerDetail;
	@Autowired
	private CMTReport CMTReport;
	@Autowired
	private UserManagement userMgmt;
	@Autowired
	private AddCustomerJob customerJob;
	// @Autowired
	// private AddNewCategory addNewCategory;
	@Autowired
	private SearchCustomerJob searchCustomerJob;
	@Autowired
	private JobListByDate jobListByDate;
	@Autowired
	private CustomerAllDetails customerAllDetails;
	@Autowired
	private CMTCustomerMgmt cMTCustomerMgmt;
	@Autowired
	private UserOperation userOperation;

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
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
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
		customer = new javax.swing.JMenu();
		customerOperation = new javax.swing.JMenuItem();
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
		cmtCustomerMgmt = new javax.swing.JMenuItem();

		jMenuItem2.setText("jMenuItem2");

		jMenu1.setText("File");
		jMenuBar2.add(jMenu1);

		jMenu2.setText("Edit");
		jMenuBar2.add(jMenu2);

		jMenuItem3.setText("jMenuItem3");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(450, 150, 0, 0));

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "WELCOME ADMIN",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 14))); // NOI18N

		jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
		jLabel1.setText("Welcome Admin");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout
						.createSequentialGroup().addGap(92, 92, 92).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(113, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout
						.createSequentialGroup().addGap(102, 102, 102).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(128, Short.MAX_VALUE)));

		user.setText("USER");

		addUser.setText("User Operations");
		addUser.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				Clicked(evt);
			}
		});
		user.add(addUser);

		jMenuBar1.add(user);

		customer.setText("CUSTOMER");

		customerOperation.setText("Customer Operations");
		customerOperation.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				customerOperationMousePressed(evt);
			}
		});
		customer.add(customerOperation);

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

		cmtCustomerMgmt.setText("Customer Management");
		cmtCustomerMgmt.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				cmtCustomerMgmtMousePressed(evt);
			}
		});
		jMenu3.add(cmtCustomerMgmt);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(23, 23, 23)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void cmtCustomerMgmtMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_cmtCustomerMgmtMousePressed
		// TODO add your handling code here:
		dispose();
		cMTCustomerMgmt.setTitle("CMT TOOL Customer");
		cMTCustomerMgmt.setVisible(true);
	}// GEN-LAST:event_cmtCustomerMgmtMousePressed

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

	private void Clicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_Clicked

		dispose();
		// addUserDetail.setTitle("Add User");
		// addUserDetail.setVisible(true);
		userOperation.setTitle("Add User");
		userOperation.setVisible(true);
	}// GEN-LAST:event_Clicked

	private void customerOperationMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_customerAddMousePressed

		dispose();
		customerAllDetails.setVisible(true);
	}// GEN-LAST:event_customerAddMousePressed

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
	private javax.swing.JMenuItem addCustomerJob;
	private javax.swing.JMenuItem addUser;
	private javax.swing.JMenuItem byDate;
	private javax.swing.JMenuItem cmtCustomerMgmt;
	private javax.swing.JMenu customer;
	private javax.swing.JMenuItem customerOperation;
	private javax.swing.JMenuItem deactivateUser;
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
	private javax.swing.JMenu user;
	private javax.swing.JMenuItem userDelete;
	private javax.swing.JMenu userManagement;
	// End of variables declaration//GEN-END:variables
}

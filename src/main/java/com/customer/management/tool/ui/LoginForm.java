/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.ui;

import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.customer.management.tool.CMTDevelopmentTool;
import com.customer.management.tool.constants.CMTMessageCode;
import com.customer.management.tool.impl.CMTServiceImpl;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.ui.admin.WelcomeForm;

/**
 *
 * @author Aviral
 */
@Component
@Scope("prototype")
public class LoginForm extends CMTServiceImpl {

	static Logger LOG = Logger.getLogger(LoginForm.class);

	private String loginForm;

	public String getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(String loginForm) {
		this.loginForm = loginForm;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * @Autowired private CMTUserManagementImpl acServiceUserImpl;
	 */
	@Autowired
	private WelcomeForm welcomeForm;

	/*
	 * public LoginForm(){ initComponents(); setTitle("CMTLogin"); }
	 */

	public LoginForm(ResourceBundleMessageSource messageSource) {
		initComponents(messageSource);
		LOG.info("============="
				+ messageSource.getMessage("loginForm", null,
						Locale.getDefault()));
		setTitle(messageSource.getMessage(CMTMessageCode.TITLE.getValue(),
				null, Locale.getDefault()));
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents(ResourceBundleMessageSource messageSource) {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		username = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		role = new javax.swing.JComboBox();
		passwrd = new javax.swing.JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(450, 150, 0, 0));

		jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
		jLabel1.setText(messageSource.getMessage(
				CMTMessageCode.TITLE.getValue(), null, Locale.getDefault()));

		jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel2.setText(messageSource.getMessage(
				CMTMessageCode.USERNAME.getValue(), null, Locale.getDefault()));

		jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel3.setText(messageSource.getMessage(
				CMTMessageCode.PASSWORD.getValue(), null, Locale.getDefault()));

		username.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusLost(java.awt.event.FocusEvent evt) {
				usernameFocusLost(evt);
			}
		});

		jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jButton1.setText(messageSource.getMessage(
				CMTMessageCode.SUBMIT.getValue(), null, Locale.getDefault()));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel4.setText(messageSource.getMessage(
				CMTMessageCode.ROLE.getValue(), null, Locale.getDefault()));

		role.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"select", "admin", "user" }));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(101, 101, 101)
										.addComponent(jButton1)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(20,
																				20,
																				20)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								69,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								78,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel4))
																		.addGap(32,
																				32,
																				32)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								username)
																						.addComponent(
																								role,
																								0,
																								166,
																								Short.MAX_VALUE)
																						.addComponent(
																								passwrd)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												24,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(33, 33, 33)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel2)
														.addComponent(
																username,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(26, 26, 26)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel3)
														.addComponent(
																passwrd,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(
																role,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18)
										.addComponent(jButton1)
										.addContainerGap(30, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup()
						.addContainerGap(52, Short.MAX_VALUE)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(42, 42, 42)));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(34, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

		try {

			String response = acServiceUserImpl.login(new CMTLogin(username
					.getText(), passwrd.getText(), role.getSelectedItem()
					.toString()));
			if (!CMTDevelopmentTool.isDevelopmentMode) {
				if (StringUtils.isEmpty(response)) {
					JOptionPane.showMessageDialog(new JFrame(),
							"Username Or Password is incorrect", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					dispose();
					welcomeForm.setVisible(true);
					welcomeForm.setResizable(false);
				}
			} else {
				dispose();
				welcomeForm.setVisible(true);
				welcomeForm.setResizable(false);
				
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}// GEN-LAST:event_jButton1ActionPerformed
		// TODO NEED TO CHECK

	private void usernameFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_usernameFocusLost

		if (!CMTDevelopmentTool.isDevelopmentMode) {
			String response = acServiceUserImpl.validateField(username
					.getText());
			if (response != null) {
				username.setText("");
				username.requestFocus(true);
			}
		}
	}// GEN-LAST:event_usernameFocusLost

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPasswordField passwrd;
	private javax.swing.JComboBox role;
	private javax.swing.JTextField username;
	// End of variables declaration//GEN-END:variables
}

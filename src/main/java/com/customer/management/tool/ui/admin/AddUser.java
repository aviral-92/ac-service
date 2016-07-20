/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.ui.admin;

import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.customer.management.tool.constants.CMTMessageCode;
import com.customer.management.tool.impl.CMTGoBackImpl;
import com.customer.management.tool.impl.CMTServiceImpl;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetailHistory;

/**
 *
 * @author Aviral
 */
@Component
@Scope("prototype")
public class AddUser extends CMTServiceImpl {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form AddUser
	 */

	@Autowired
	private CMTGoBackImpl CMTgoBackImpl;

	public AddUser(ResourceBundleMessageSource resourceBundleMessageSource) {

		initComponents(resourceBundleMessageSource);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * @param resourceBundleMessageSource 
	 */
	public void initComponents(ResourceBundleMessageSource messageSource) {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		username = new javax.swing.JTextField();
		email = new javax.swing.JTextField();
		mobile = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		password = new javax.swing.JPasswordField();
		cnfPassword = new javax.swing.JPasswordField();
		submit = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		choice = new javax.swing.JComboBox();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(450, 150, 0, 0));
		jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
		jLabel1.setText(messageSource.getMessage(
				CMTMessageCode.ADD_USER.getValue(), null, Locale.getDefault()));

		jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel6.setText(messageSource.getMessage(
				CMTMessageCode.NAME.getValue(), null, Locale.getDefault()));

		jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel7.setText(messageSource.getMessage(
				CMTMessageCode.USERNAME.getValue(), null, Locale.getDefault()));

		jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel8.setText(messageSource.getMessage(
				CMTMessageCode.EMAIL.getValue(), null, Locale.getDefault()));

		jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel9.setText(messageSource.getMessage(
				CMTMessageCode.MOBILE.getValue(), null, Locale.getDefault()));

		jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel2.setText(messageSource.getMessage(
				CMTMessageCode.PASSWORD.getValue(), null, Locale.getDefault()));

		jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel3.setText(messageSource.getMessage(
				CMTMessageCode.CONFIRM_PASSWRD.getValue(), null, Locale.getDefault()));

		submit.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
		submit.setText(messageSource.getMessage(
				CMTMessageCode.SUBMIT.getValue(), null, Locale.getDefault()));
		submit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				submitActionPerformed(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
		jLabel4.setText(messageSource.getMessage(
				CMTMessageCode.ROLE.getValue(), null, Locale.getDefault()));

		choice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "user", "admin" }));

		jButton2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
		jButton2.setText(messageSource.getMessage(
				CMTMessageCode.BACK.getValue(), null, Locale.getDefault()));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(
				jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout
						.createSequentialGroup().addGap(30, 30,
								30)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(93, 93, 93)
										.addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(username).addComponent(name)))
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(jLabel8)
														.addComponent(jLabel9,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jLabel3,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel2,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addComponent(jLabel4)
												.addGroup(jPanel4Layout.createSequentialGroup().addGap(17, 17, 17)
														.addComponent(jButton2)))
												.addGap(43, 43, 43)
												.addGroup(jPanel4Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(submit)
														.addGroup(jPanel4Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(password,
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(mobile,
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(email).addComponent(cnfPassword)
																.addComponent(choice, 0, 130, Short.MAX_VALUE)))))
						.addGap(36, 36, 36)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6).addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel7).addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel8).addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(cnfPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(submit).addComponent(jButton2))
						.addContainerGap(20, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(33, 33, 33)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(36, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jLabel1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(132, 132, 132)));
		jPanel1Layout
				.setVerticalGroup(
						jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(23, 23, 23)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(22, 22, 22)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void submitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_submitActionPerformed

		try {
			if (password.getText().equals(cnfPassword.getText())) {
				CMTLogin login = new CMTLogin(username.getText(), password.getText(),
						choice.getSelectedItem().toString());
				UserDetailHistory userDetail = new UserDetailHistory(0, username.getText(), name.getText(),
						email.getText(), mobile.getText(), new Date().toString(), new Date().toString(), "add", "a");
				String response = acServiceUserImpl.addUser(login, userDetail);
				JOptionPane.showMessageDialog(new JFrame(), response, response, JOptionPane.INFORMATION_MESSAGE);

				if (userDetail.getStatus().equalsIgnoreCase("d")) {
					userDetail.setStatus("a");
					if (response.toLowerCase().contains("exist")) {
						int yesNo = JOptionPane.showConfirmDialog(new JFrame(), "Do you wish to active USER Account",
								"Message", JOptionPane.YES_NO_OPTION);
						if (yesNo == JOptionPane.YES_OPTION) {
							userDetail.setDescription("active");
							String activeDeactive = acServiceUserImpl.activateUser(userDetail);
							JOptionPane.showMessageDialog(new JFrame(), activeDeactive, "Message",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(new JFrame(), "Password and Confirm Password do no match", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_submitActionPerformed

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed

		dispose();
		CMTgoBackImpl.backButtonCode(this);
	}// GEN-LAST:event_jButton2ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox choice;
	private javax.swing.JPasswordField cnfPassword;
	private javax.swing.JTextField email;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JTextField mobile;
	private javax.swing.JTextField name;
	private javax.swing.JPasswordField password;
	private javax.swing.JButton submit;
	private javax.swing.JTextField username;
	// End of variables declaration//GEN-END:variables
}

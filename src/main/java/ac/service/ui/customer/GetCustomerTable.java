/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.ui.customer;

import ac.service.impl.AcServiceBackImpl;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ac.service.impl.AcServiceImpl;
import ac.service.pojo.Customer;

/**
 *
 * @author amittal
 */
@Component
@Scope("prototype")
public class GetCustomerTable extends AcServiceImpl {

    /*@Autowired
	private WelcomeForm welcomeForm;*/
    @Autowired
    private AddRepairDetails addRepairDetails;
    @Autowired
    private AcServiceBackImpl acServiceBackImpl;

    /**
     * Creates new form GetCustomerTable
     */
    public GetCustomerTable() {
        initComponents();
    }

    public void displayRecords(List<Customer> customers) {

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"CustomerID", "Name",
            "Email", "Mobile", "Address"});
        for (Customer customer : customers) {
            model.addRow(new Object[]{customer.getCustomerId(),
                customer.getName(), customer.getEmail(),
                customer.getMobile(), customer.getAddress()});
        }
        /*table.setModel(null);*/
        if (table.getModel().getRowCount() > 0) {
            initComponents();
        }
        table.setModel(model);
        table.setEnabled(true);
        table.setRowSelectionAllowed(true);

        table.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // System.out.println(table.getValueAt(table.getSelectedRow(),
                // 2).toString());
                Customer customer = new Customer();
                customer.setCustomerId(Integer.parseInt(table
                        .getValueAt(table.getSelectedRow(), 0)
                        .toString()));
                customer.setName(table.getValueAt(
                        table.getSelectedRow(), 1).toString());
                dispose();
                addRepairDetails.setCustomerID(customer);
                addRepairDetails.setVisible(true);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBounds(new java.awt.Rectangle(450, 150, 0, 0));

		table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,
				0, 0), 1, true));
		table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {

		}));
		table.setCellSelectionEnabled(true);
		table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		table.setEditingRow(0);
		table.setFillsViewportHeight(true);
		jScrollPane1.setViewportView(table);

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("Back");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup().addContainerGap()
								.addComponent(jScrollPane1).addContainerGap())
				.addGroup(
						layout.createSequentialGroup().addGap(422, 422, 422)
								.addComponent(jButton1)
								.addContainerGap(329, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										279,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										9, Short.MAX_VALUE)
								.addComponent(jButton1).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
        acServiceBackImpl.backButtonCode(this);
        /*	welcomeForm.setTitle("Welcome");
		welcomeForm.setVisible(true);*/
    }// GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable table;
	// End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.ui.report;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import ac.service.impl.AcServiceImpl;
import ac.service.pojo.CustomerReparingDetail;
import ac.service.pojo.ReportGenerator;

/**
 *
 * @author amittal
 */

@Component
public class ReportForm extends AcServiceImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form ReportForm
	 */
	public ReportForm() {
		initComponents();
	}

	public void displayMonthlyRecords(List<CustomerReparingDetail> customersList) {

		double sum = 0;
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Customer ID",
				"Customer Name", "Visit Date", "Amount" });
		for (CustomerReparingDetail reparingDetail : customersList) {
			model.addRow(new Object[] { reparingDetail.getCustomerId(),
					reparingDetail.getName(), reparingDetail.getUpdateDate(),
					reparingDetail.getActualAmount() });
			sum += Double.parseDouble(reparingDetail.getActualAmount());
		}
		model.addRow(new Object[] { "TOTAL", "", "", String.valueOf(sum) });
		model.fireTableDataChanged();
		jTable1.setModel(model);

	}

	public void displayMonThRecord(List<CustomerReparingDetail> customersList) {

		double sum = 0;
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Month", "Amount" });
		for (CustomerReparingDetail reparingDetail : customersList) {
			model.addRow(new Object[] { reparingDetail.getUpdatedDateRetun(),
					reparingDetail.getFinalAmount() });
			sum += Double.parseDouble(reparingDetail.getFinalAmount());
		}
		model.addRow(new Object[] { "TOTAL", String.valueOf(sum) });
		model.fireTableDataChanged();
		jTable1.setModel(model);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		endDate = new com.toedter.calendar.JDateChooser();
		startDate = new com.toedter.calendar.JDateChooser();
		dateWise = new javax.swing.JButton();
		yearChooser = new com.toedter.calendar.JYearChooser();
		jLabel4 = new javax.swing.JLabel();
		monthlyReport = new javax.swing.JButton();
		yearlyReport = new javax.swing.JButton();
		excel = new javax.swing.JButton();
		pdf = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] {

				}));
		jScrollPane1.setViewportView(jTable1);

		jLabel2.setText("End Date");

		jLabel1.setText("Start Date");

		dateWise.setText("Generate");
		dateWise.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dateWiseActionPerformed(evt);
			}
		});

		jLabel4.setText("Choose Year for Monthly Report");

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																179,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addGap(29,
																				29,
																				29)
																		.addComponent(
																				startDate,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				137,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(35, 35, 35)
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2)
																		.addGap(31,
																				31,
																				31)
																		.addComponent(
																				endDate,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				136,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(35,
																				35,
																				35)
																		.addComponent(
																				dateWise))
														.addComponent(
																yearChooser,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(17,
																				17,
																				17)
																		.addComponent(
																				jLabel1)
																		.addGap(3,
																				3,
																				3))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				jPanel2Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanel2Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel2Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																jLabel2)
																														.addComponent(
																																startDate,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(3,
																												3,
																												3))
																						.addComponent(
																								endDate,
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								dateWise,
																								javax.swing.GroupLayout.Alignment.TRAILING))))
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(17,
																				17,
																				17)
																		.addComponent(
																				jLabel4))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				yearChooser,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(14, Short.MAX_VALUE)));

		monthlyReport.setText("Monthly Report");
		monthlyReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				monthlyReportActionPerformed(evt);
			}
		});

		yearlyReport.setText("Yearly Report");
		yearlyReport.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				yearlyReportActionPerformed(evt);
			}
		});

		excel.setText("Export Excel");
		excel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				excelActionPerformed(evt);
			}
		});

		pdf.setText("Export PDF");
		pdf.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				pdfActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout.createSequentialGroup()
										.addGap(64, 64, 64)
										.addComponent(monthlyReport)
										.addGap(43, 43, 43)
										.addComponent(yearlyReport)
										.addGap(51, 51, 51).addComponent(excel)
										.addGap(49, 49, 49).addComponent(pdf)
										.addGap(0, 0, Short.MAX_VALUE))
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(
																jScrollPane1,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																680,
																Short.MAX_VALUE)
														.addComponent(
																jPanel2,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jPanel2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												394,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																monthlyReport,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																yearlyReport,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																pdf,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																excel,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));

		jLabel3.setText("Report Generator");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(30, 30, 30)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap())
				.addGroup(
						layout.createSequentialGroup()
								.addGap(346, 346, 346)
								.addComponent(jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										155,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(239, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void excelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_excelActionPerformed

		if (jTable1.getRowCount() > 0) {
			boolean isExcelExported = acReportGeneratorImpl
					.generateExcelReport(jTable1);
			if (isExcelExported) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Excel Successfully Exported", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Fill the table",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_excelActionPerformed

	private void pdfActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pdfActionPerformed

		if (jTable1.getRowCount() > 0) {
			boolean isPdfExported = acReportGeneratorImpl
					.generatePdfReport(jTable1);
			if (isPdfExported) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Pdf Successfully Exported", "Success",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Fill the table",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}// GEN-LAST:event_pdfActionPerformed

	private void monthlyReportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_monthlyReportActionPerformed

		ReportGenerator reportGenerator = new ReportGenerator(null, null, null,
				null, null, null, String.valueOf(yearChooser.getYear()));
		List<CustomerReparingDetail> reparingDetails = acReportGeneratorImpl
				.MonthlyReports(reportGenerator);
		if (reparingDetails != null && reparingDetails.size() > 0) {
			displayMonThRecord(reparingDetails);
		} else {
			System.err.println("No Data");
		}

	}// GEN-LAST:event_monthlyReportActionPerformed

	private void yearlyReportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_yearlyReportActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_yearlyReportActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed

	}// GEN-LAST:event_jButton1ActionPerformed

	private void dateWiseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dateWiseActionPerformed

		java.text.SimpleDateFormat fmt = new java.text.SimpleDateFormat(
				"dd-MM-yyyy");
		ReportGenerator reportGenerator = new ReportGenerator(null,
				fmt.format(startDate.getDate()), fmt.format(endDate.getDate()),
				null, null, null, null);
		List<CustomerReparingDetail> response = acReportGeneratorImpl
				.startToEndDateRecords(reportGenerator);
		// this.dispose();
		// this.initComponents();
		this.displayMonthlyRecords(response);

	}// GEN-LAST:event_dateWiseActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton dateWise;
	private com.toedter.calendar.JDateChooser endDate;
	private javax.swing.JButton excel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JButton monthlyReport;
	private javax.swing.JButton pdf;
	private com.toedter.calendar.JDateChooser startDate;
	private com.toedter.calendar.JYearChooser yearChooser;
	private javax.swing.JButton yearlyReport;
	// End of variables declaration//GEN-END:variables
}

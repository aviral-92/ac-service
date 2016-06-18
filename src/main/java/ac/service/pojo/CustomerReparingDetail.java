/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.pojo;

import java.util.Date;

/**
 *
 * @author amittal
 */
public class CustomerReparingDetail extends Customer {

	private int repairId;
	// private int customerId;
	private String description;
	private String actualAmount;
	private String paidAmount;
	private Date updateDate;
	private String status;
	private Date warranty;
	private String model_Vehicle;
	private String isWarrantyExpired;

	/**
	 * @return the repairId
	 */
	public int getRepairId() {
		return repairId;
	}

	/**
	 * @param repairId
	 *            the repairId to set
	 */
	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the actualAmount
	 */
	public String getActualAmount() {
		return actualAmount;
	}

	/**
	 * @param actualAmount
	 *            the actualAmount to set
	 */
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}

	/**
	 * @return the paidAmount
	 */
	public String getPaidAmount() {
		return paidAmount;
	}

	/**
	 * @param paidAmount
	 *            the paidAmount to set
	 */
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the warranty
	 */
	public Date getWarranty() {
		return warranty;
	}

	/**
	 * @param warranty
	 *            the warranty to set
	 */
	public void setWarranty(Date warranty) {
		this.warranty = warranty;
	}

	/**
	 * @return the model_Vehicle
	 */
	public String getModel_Vehicle() {
		return model_Vehicle;
	}

	/**
	 * @param model_Vehicle
	 *            the model_Vehicle to set
	 */
	public void setModel_Vehicle(String model_Vehicle) {
		this.model_Vehicle = model_Vehicle;
	}

	public String getIsWarrantyExpired() {
		return isWarrantyExpired;
	}

	public void setIsWarrantyExpired(String isWarrantyExpired) {
		this.isWarrantyExpired = isWarrantyExpired;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool.pojo;

/**
 *
 * @author amittal
 */
public class UniqueDetail{

	private int uniqueId;
	private String uniqueDescription;
	private String uniqueStatus;

	/**
	 * @return the unique_Id
	 */
	public int getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param unique_Id
	 *            the unique_Id to set
	 */
	public void setUniqueId(int unique_Id) {
		this.uniqueId = unique_Id;
	}

	/**
	 * @return the unique_description
	 */
	public String getUniqueDescription() {
		return uniqueDescription;
	}

	/**
	 * @param unique_description
	 *            the unique_description to set
	 */
	public void setUniqueDescription(String unique_description) {
		this.uniqueDescription = unique_description;
	}

	/**
	 * @return the unique_Status
	 */
	public String getUniqueStatus() {
		return uniqueStatus;
	}

	/**
	 * @param unique_Status
	 *            the unique_Status to set
	 */
	public void setUniqueStatus(String unique_Status) {
		this.uniqueStatus = unique_Status;
	}
}

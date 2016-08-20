package com.customer.management.tool.pojo;

public class Category {

	private int id;
	private String name;
	private String status;

	/**
	 * @return the category_id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param category_id
	 *            the category_id to set
	 */
	public void setId(int category_id) {
		this.id = category_id;
	}

	/**
	 * @return the category_name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param category_name
	 *            the category_name to set
	 */
	public void setName(String category_name) {
		this.name = category_name;
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

}

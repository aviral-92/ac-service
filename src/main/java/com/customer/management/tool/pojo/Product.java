package com.customer.management.tool.pojo;

public class Product {

	private int id;
	private String name;
	private String description;
	private String status;

	public Product() {

	}

	public Product(int productId, String productName,
			String productDescription, String status) {
		super();
		this.id = productId;
		this.name = productName;
		this.description = productDescription;
		this.status = status;
	}

	/**
	 * @return the productId
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setId(int productId) {
		this.id = productId;
	}

	/**
	 * @return the productName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setName(String productName) {
		this.name = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param productDescription
	 *            the productDescription to set
	 */
	public void setDescription(String productDescription) {
		this.description = productDescription;
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

package com.customer.management.tool.pojo;

public class OrderManagement {

	private int orderId;
	private int customerId;
	private OrderStatus orderStatus;
	private String description;
	private String orderDate;
	private String completionDate;
	private String status;

	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId
	 *            the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the customer_id
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customer_id
	 *            the customer_id to set
	 */
	public void setCustomerId(int customer_id) {
		this.customerId = customer_id;
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
	 * @return the order_date
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param order_date
	 *            the order_date to set
	 */
	public void setOrderDate(String order_date) {
		this.orderDate = order_date;
	}

	/**
	 * @return the completion_date
	 */
	public String getCompletionDate() {
		return completionDate;
	}

	/**
	 * @param completion_date
	 *            the completion_date to set
	 */
	public void setCompletionDate(String completion_date) {
		this.completionDate = completion_date;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus cmtOrderStatus) {
		this.orderStatus = cmtOrderStatus;
	}

}

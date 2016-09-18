package com.customer.management.tool.constants;

public enum UserStatusType {

	ACTIVATE("A"), DEACTIVATE("D"), DELETE("DE");

	private String prperty = null;

	public String getPrperty() {
		return prperty;
	}

	private UserStatusType(String prperty) {
		this.prperty = prperty;
	}

	public static UserStatusType fromValue(String value) {
		return valueOf(value);
	}

}

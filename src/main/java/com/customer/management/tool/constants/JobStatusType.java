package com.customer.management.tool.constants;

public enum JobStatusType {

	PENDING("P"), COMPLETED("C"), REOPEN("R");

	private String prperty = null;

	public String getPrperty() {
		return prperty;
	}

	private JobStatusType(String prperty) {
		this.prperty = prperty;
	}

	public static JobStatusType fromValue(String value) {
		return valueOf(value);
	}
}

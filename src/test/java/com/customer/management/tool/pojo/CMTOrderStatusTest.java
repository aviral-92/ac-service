package com.customer.management.tool.pojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CMTOrderStatusTest extends TestCase{

	public CMTOrderStatusTest(String testName){
		super(testName);
	}

	public static Test Suite(){
		return new TestSuite(CMTOrderStatusTest.class);
	}

	public void testAccessors(){
		CMTOrderStatus orderStatus = new CMTOrderStatus();
		orderStatus.setOrder_status("A");
		orderStatus.setOrder_value("B");
		assertEquals("A", orderStatus.getOrder_status());
		assertEquals("B", orderStatus.getOrder_value());
	}

}

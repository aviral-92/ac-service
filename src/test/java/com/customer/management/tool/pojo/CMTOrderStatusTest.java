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
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setOrderStatus("A");
		orderStatus.setOrderValue("B");
		assertEquals("A", orderStatus.getOrderStatus());
		assertEquals("B", orderStatus.getOrderValue());
	}

}

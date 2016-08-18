package com.customer.management.tool.pojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CMTProductTest extends TestCase{

	public CMTProductTest(String testName){
		super(testName);
	}

	public static Test Suite(){
		return new TestSuite(CMTProductTest.class);
	}

	public void testAccessors(){
		CMTProduct product = new CMTProduct(1, "box", "big", "available");
		assertEquals(1, product.getProductId());
		assertEquals("box", product.getProductName());
		assertEquals("big", product.getProductDescription());
		assertEquals("available", product.getStatus());
		product.setProductId(2);
		product.setProductName("box2");
		product.setProductDescription("small");
		product.setStatus("unavailable");
		assertEquals(2, product.getProductId());
		assertEquals("box2", product.getProductName());
		assertEquals("small", product.getProductDescription());
		assertEquals("unavailable", product.getStatus());
	}

}

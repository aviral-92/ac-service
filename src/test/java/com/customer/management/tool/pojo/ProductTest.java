package com.customer.management.tool.pojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ProductTest extends TestCase{

	public ProductTest(String testName){
		super(testName);
	}

	public static Test Suite(){
		return new TestSuite(ProductTest.class);
	}

	public void testAccessors(){
		Product product = new Product(1, "box", "big", "available");
		assertEquals(1, product.getId());
		assertEquals("box", product.getName());
		assertEquals("big", product.getDescription());
		assertEquals("available", product.getStatus());
		product.setId(2);
		product.setName("box2");
		product.setDescription("small");
		product.setStatus("unavailable");
		assertEquals(2, product.getId());
		assertEquals("box2", product.getName());
		assertEquals("small", product.getDescription());
		assertEquals("unavailable", product.getStatus());
	}

}

package com.customer.management.tool.pojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CMTCategoryTest extends TestCase{

	public CMTCategoryTest(String testName){
		super(testName);
	}

	public static Test Suite(){
		return new TestSuite(CMTCategoryTest.class);
	}

	public void testAccessors(){
		Category category = new Category();
		category.setId(1);
		category.setName("A");
		category.setStatus("valid");
		assertEquals(1, category.getId());
		assertEquals("A", category.getName());
		assertEquals("valid", category.getStatus());
	}

}

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
		CMTCategory category = new CMTCategory();
		category.setCategory_id(1);
		category.setCategory_name("A");
		category.setStatus("valid");
		assertEquals(1, category.getCategory_id());
		assertEquals("A", category.getCategory_name());
		assertEquals("valid", category.getStatus());
	}

}

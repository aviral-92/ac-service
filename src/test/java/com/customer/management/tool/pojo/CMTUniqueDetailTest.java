package com.customer.management.tool.pojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CMTUniqueDetailTest extends TestCase{

	public CMTUniqueDetailTest(String testName){
		super(testName);
	}

	public static Test Suite(){
		return new TestSuite(CMTUniqueDetailTest.class);
	}

	public void testAccessors(){
		CMTUniqueDetail uniqueDetail = new CMTUniqueDetail();
		uniqueDetail.setUnique_Id(1);
		uniqueDetail.setUnique_description("sample description");
		uniqueDetail.setUnique_Status("sample status");
		assertEquals(1, uniqueDetail.getUnique_Id());
		assertEquals("sample description", uniqueDetail.getUnique_description());
		assertEquals("sample status", uniqueDetail.getUnique_Status());
	}

}

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
		UniqueDetail uniqueDetail = new UniqueDetail();
		uniqueDetail.setUniqueId(1);
		uniqueDetail.setUniqueDescription("sample description");
		uniqueDetail.setUniqueStatus("sample status");
		assertEquals(1, uniqueDetail.getUniqueId());
		assertEquals("sample description", uniqueDetail.getUniqueDescription());
		assertEquals("sample status", uniqueDetail.getUniqueStatus());
	}

}

package com.customer.management.tool.pojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LoginTest extends TestCase{

	public LoginTest(String testName){
		super(testName);
	}

	public static Test Suite(){
		return new TestSuite(LoginTest.class);
	}

	public void testAccessors(){
		Login login = new Login("john", "abc", "user");
		assertEquals("john", login.getUsername());
		assertEquals("abc", login.getPassword());
		assertEquals("user", login.getRole());
		login.setUsername("mark");
		login.setPassword("def");
		login.setRole("admin");
		assertEquals("mark", login.getUsername());
		assertEquals("def", login.getPassword());
		assertEquals("admin", login.getRole());
	}

}

package com.customer.management.tool.controller;

import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.tool.impl.CMTUserManagementImpl;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetailHistory;

@RestController
@RequestMapping("/CMT")
@Api(description = "Users management API")
public class UserController {

	@Autowired
	private CMTUserManagementImpl CMTUserManagementImpl;

	@RequestMapping("/")
	public String test() {

		return "Successfully calling rest Service";
	}

	@RequestMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addUser(@RequestBody CMTLogin login, @RequestBody UserDetailHistory userDetail) {

		try {
			return CMTUserManagementImpl.addUser(login, userDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	@RequestMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<UserDetailHistory> getUser(String name, String mobile, String email, String username,
			@RequestParam String status) {

		UserDetailHistory detailHistory = new UserDetailHistory();
		detailHistory.setName(name);
		detailHistory.setEmail(email);
		detailHistory.setUsername(username);
		detailHistory.setMobile(mobile);
		detailHistory.setStatus(status);
		List<UserDetailHistory> response = CMTUserManagementImpl.getUser(detailHistory);
		return response;
	}

	public String updateUser(UserDetailHistory detailHistory) {

		String response = null;
		try {
			response = CMTUserManagementImpl.updateUserData(detailHistory);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
}

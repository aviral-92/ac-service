package com.customer.management.tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.tool.impl.CMTUserManagementImpl;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetailHistory;

@RestController
public class CMTUserController {

	@Autowired
	private CMTUserManagementImpl CMTUserManagementImpl;

	@RequestMapping("/")
	public String test() {

		return "Successfully calling rest Service";
	}

	@RequestMapping(value = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addUser(CMTLogin login, UserDetailHistory userDetail) {

		try {
			return CMTUserManagementImpl.addUser(login, userDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/getUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDetailHistory> getUser(@RequestParam String name) {

		UserDetailHistory detailHistory = new UserDetailHistory();
		detailHistory.setName(name);
		detailHistory.setStatus("A");
		List<UserDetailHistory> response = CMTUserManagementImpl.getUser(detailHistory);
		return response;
	}
}

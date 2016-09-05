package com.customer.management.tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.management.tool.impl.CMTUserManagementImpl;
import com.customer.management.tool.pojo.CMTLogin;
import com.customer.management.tool.pojo.UserDetailHistory;

@RestController
public class CMTUserController {

	@Autowired
	private CMTUserManagementImpl CMTUserManagementImpl;

	@RequestMapping("/addUser")
	public String addUser(CMTLogin login, UserDetailHistory userDetail) {

		try {
			return CMTUserManagementImpl.addUser(login, userDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/getUser")
	public List<UserDetailHistory> getUser(UserDetailHistory detailHistory) {

		return CMTUserManagementImpl.getUser(detailHistory);
	}

}

package com.customer.management.tool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CMTUserController {

	@RequestMapping("/index")
	public ModelAndView firstPage() {

		return new ModelAndView("index");
	}

	@RequestMapping("/addUser")
	public void addUser() {

		System.out.println("Hello Successfully called Controller");
	}

	@RequestMapping("/getUser")
	public void getUser() {

	}
}

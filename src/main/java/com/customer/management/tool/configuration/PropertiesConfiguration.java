package com.customer.management.tool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.customer.management.tool.dao.impl.UserManagementDaoImpl;
import com.customer.management.tool.ui.LoginForm;
import com.customer.management.tool.ui.unused.AddUser;
import com.customer.management.tool.ui.unused.GetUser;
import com.customer.management.tool.ui.unused.GetUsers;
import com.customer.management.tool.ui.unused.ModifyUser;
import com.customer.management.tool.ui.admin.WelcomeForm;

@Configuration
public class PropertiesConfiguration {

	@Bean(name = "MessageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource obj = new ResourceBundleMessageSource();
		obj.setBasenames("bundles/Messages");
		return obj;
	}

	@Bean
	public LoginForm loginForm() {
		return new LoginForm(messageSource());
	}

	@Bean
	public WelcomeForm welcomeForm() {
		return new WelcomeForm(messageSource());
	}
	
	@Bean
	public AddUser addUser(){
		return new AddUser(messageSource());
	}
	
	@Bean
	public GetUser getUser(){
		return new GetUser(messageSource());
	}
	
	@Bean
	public GetUsers getUsers(){
		return new GetUsers(messageSource());
	}
	
	@Bean
	public ModifyUser modifyUser(){
		return new ModifyUser(messageSource());
	}
	
	@Bean
	public UserManagementDaoImpl userMgmtDaoImpl(){
		return new UserManagementDaoImpl(messageSource());
	}
}

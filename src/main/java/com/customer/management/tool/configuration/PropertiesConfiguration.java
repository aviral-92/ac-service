package com.customer.management.tool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.customer.management.tool.ui.LoginForm;
import com.customer.management.tool.ui.customer.AddCustomer;

@Configuration
public class PropertiesConfiguration {

	
	@Bean(name = "MessageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource obj = new ResourceBundleMessageSource();
		obj.setBasenames("bundles/Messages");
		return obj;
	}
	
	
	@Bean(name = "loginForm")
	public LoginForm loginForm() {
		return new LoginForm(messageSource());
	}
	
	@Bean(name = "addCustomer")
	public AddCustomer addCustomer() {
		return new AddCustomer(messageSource());
	}
}

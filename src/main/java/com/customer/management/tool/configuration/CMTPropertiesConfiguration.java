package com.customer.management.tool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.customer.management.tool.ui.LoginForm;
import com.customer.management.tool.ui.admin.WelcomeForm;

@Configuration
public class CMTPropertiesConfiguration {

	
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
}

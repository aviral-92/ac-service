package com.customer.management.tool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.customer.management.tool.ui.admin.Welcome;

@Configuration
public class CMTPropertiesConfiguration {

	
	@Bean(name = "MessageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource obj = new ResourceBundleMessageSource();
		obj.setBasenames("bundles/Messages");
		return obj;
	}
	
	
	
	
	@Bean
	public Welcome welcome() {
		return new Welcome(messageSource());
	}
}

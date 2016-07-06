/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customer.management.tool;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.customer.management.tool.ui.LoginForm;

/**
 *
 * @author Aviral
 */

@SpringBootApplication
public class CMTStarter {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(CMTStarter.class).headless(false).run(args);
		context.getBean(LoginForm.class).setVisible(true);
		context.getBean(LoginForm.class).setResizable(false);
		
	}
}

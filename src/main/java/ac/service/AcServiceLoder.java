/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import ac.service.ui.LoginForm;

/**
 *
 * @author Aviral
 */
@Configuration
@PropertySource("classpath:Message-en.properties")
public class AcServiceLoder {

    private static ApplicationContext applicationContext;

    static {
        setApplicationContext(new AnnotationConfigApplicationContext("ac.service"));
    }
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    private static void setApplicationContext(ApplicationContext aApplicationContext) {
        applicationContext = aApplicationContext;
    }

    public static void main(String[] args) {
        getApplicationContext().getBean(LoginForm.class).setVisible(true);
    }
}

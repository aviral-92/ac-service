/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.service.swings;

import ac.service.ui.LoginForm;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Aviral
 */
@Configuration
public class AcServiceSwings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginForm loginForm = getContext().getBean(LoginForm.class);
        loginForm.setTitle("Login");
        loginForm.setVisible(true);
    }

    public static ApplicationContext getContext() {
        ApplicationContext ctx
                = new AnnotationConfigApplicationContext("ac.service");
        return ctx;
    }
}

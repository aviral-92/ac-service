package ac.service.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Properties {

	@Autowired
	private Environment env;
	
	private String loginForm;

	public String getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(String loginForm) {
		this.loginForm = loginForm;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

}

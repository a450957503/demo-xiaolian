package cn.edu.fjnu.towide.security;

import org.springframework.security.provisioning.JdbcUserDetailsManager;

public class JdbcManagerDetailsManager extends JdbcUserDetailsManager {

	@Override
	public String getUsersByUsernameQuery() {
		// TODO Auto-generated method stub
		return super.getUsersByUsernameQuery();
	}

}

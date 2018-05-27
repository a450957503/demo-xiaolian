package cn.edu.fjnu.towide.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;

//@Component
public class RestAuthenticationRememberMeService implements RememberMeServices {

	public Authentication autoLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/*
		 * Object userName="13850138018"; Object password="111111";
		 * UsernamePasswordAuthenticationToken authRequest = new
		 * UsernamePasswordAuthenticationToken(userName, password);
		 * 
		 * System.out.println(authRequest); return authRequest;
		 */
		System.out.println("autoLogin");
		return null;

	}

	public void loginFail(HttpServletRequest arg0, HttpServletResponse arg1) {
		System.out.println("loginFail");
	}

	public void loginSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.out.println("loginSuccess");
	}

}

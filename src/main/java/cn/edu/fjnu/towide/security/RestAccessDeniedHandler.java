package cn.edu.fjnu.towide.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

	public void handle(HttpServletRequest arg0, HttpServletResponse arg1, AccessDeniedException arg2)
			throws IOException, ServletException {
		System.out.println("access deny");
	}

}

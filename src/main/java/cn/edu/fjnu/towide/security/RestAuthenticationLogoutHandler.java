package cn.edu.fjnu.towide.security;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Component
public class RestAuthenticationLogoutHandler implements LogoutHandler {

	
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// TODO Auto-generated method stub
		System.out.println("我logout啦啦啦");
/*		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
*/
		PrintWriter out;
		try {
			out = response.getWriter();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("logou", "json");
			out.println(jsonObject.toJSONString());
/*			out.flush();
			out.close();
*/
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
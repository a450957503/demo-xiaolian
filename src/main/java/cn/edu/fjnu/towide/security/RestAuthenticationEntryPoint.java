package cn.edu.fjnu.towide.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;
import cn.edu.fjnu.towide.utils.HttpServletRequestUtil;
import cn.edu.fjnu.towide.utils.ResponseHeadUtil;

//import cn.edu.fjnu.towide.dao.CustomerDao;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
/*	@Autowired
	CustomerDao customerDao;
*/	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
	System.out.println("我是入口点");
/*		System.out.println("我的入口点");
//		System.out.println(customerDao.toString());
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().println("你还未登录！");
*/
	PrintWriter out;
	try {
		
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
			
		ResponseHead responseHead=ResponseHeadUtil.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_NEED_LOGIN_ERROR);
		String functionNo=HttpServletRequestUtil.getFunctionNo(request);
		responseHead.setFunctionNo(functionNo);
		out = response.getWriter();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("head", responseHead);
		out.println(jsonObject.toJSONString());
		out.flush();
		out.close();

		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
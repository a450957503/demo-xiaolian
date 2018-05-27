package cn.edu.fjnu.towide.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;
import cn.edu.fjnu.towide.utils.HttpServletRequestUtil;
import cn.edu.fjnu.towide.utils.JsonUtils;
import cn.edu.fjnu.towide.wrapper.BufferedServletRequestWrapper;
import cn.edu.fjnu.towide.wrapper.BufferedServletResponseWrapper;

/**
 * Servlet Filter implementation class RequestAndResponseWrappterFilter
 */
//@WebFilter("/*")

/**
 * 此filter主要实现对request和response的封装，使得request的内容可以反复读取，response的内容可以根据需要修改
 * 
 * @author lenovo
 *
 */
public class RequestAndResponseWrappterFilter implements Filter {
	static Logger logger = LoggerFactory.getLogger(RequestAndResponseWrappterFilter.class);

	/**
	 * Default constructor.
	 */
	public RequestAndResponseWrappterFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		logger.debug("filter begin");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// 要在封装为BufferedServletResponseWrapper之前，先设定，否则会无效
		response.setCharacterEncoding("utf-8");
		// 将request封装成可以反复读取
		BufferedServletRequestWrapper requestWrapper = new BufferedServletRequestWrapper(httpServletRequest);
		// 将response封装成内容可以修改
		BufferedServletResponseWrapper responseWrapper = new BufferedServletResponseWrapper(httpServletResponse);

		// 对客户端发送的数据进行校验，是否为有效的json格式，如果无效，向客户端返回提示信息
		if (!JsonUtils.verifyJsonFromRequest(requestWrapper)) {

			//向客户端发送json格式错误的提示信息
			responseForWrongJsonFormatError(httpServletResponse);
			return;
		}
		chain.doFilter(requestWrapper, responseWrapper);
		/**
		 * 以下代码，实现将新生成的token加入到返回的json数据中 新生成的token是暂存在response对象的header中
		 */

		String result = new String(responseWrapper.getResponseData(),"utf-8");
		JSONObject responseData=null;
		
		try{
			responseData = (JSONObject) JSONObject.parse(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (responseData != null) {
			//如果有令牌，添加令牌
			JSONObject head = responseData.getJSONObject("head");
			//如果head非空，才执行相应操作
			if(head!=null){
				String token = responseWrapper.getHeader("remember-me");
				head.put("token", token);
				//如果有功能号，添加功能号
				String functionNo=HttpServletRequestUtil.getFunctionNo(requestWrapper);
				head.put("functionNo", functionNo);
			}
			//这步一定要做，将封装在包装类中的数据，真正写入响应对象
			result = responseData.toJSONString();
//			response.flushBuffer();
		}
		response.getWriter().print(result);
		response.flushBuffer();
		logger.debug("filter end");
	}

	private void responseForWrongJsonFormatError(HttpServletResponse httpServletResponse) throws IOException {
		// String
		// result=ResponseHeadConstants.RESPONSEHEAD_WRONG_JSON_FORMAT_ERROR.toString();
		ResponseHead responseHead = new ResponseHead();
		ResponseHeadEnums responseHeadWrongJsonFormatError = ResponseHeadEnums.RESPONSEHEAD_WRONG_JSON_FORMAT_ERROR;
		responseHead.setCode(responseHeadWrongJsonFormatError.getCode());
		responseHead.setMsg(responseHeadWrongJsonFormatError.getMsg());
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("head", responseHead);
		String result = jsonObject.toJSONString();
		// logger.debug(result);
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("application/json; charset=utf-8");
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");

		httpServletResponse.getWriter().println(result);
		httpServletResponse.flushBuffer();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter init");
	}

}

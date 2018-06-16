package cn.edu.fjnu.towide.exceptionhandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;
import cn.edu.fjnu.towide.utils.HttpServletRequestUtil;
import cn.edu.fjnu.towide.utils.ResponseHeadUtil;

@ControllerAdvice
class GlobalExceptionHandler {
	static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	//处理因客户端传递的格式有误引起的异常
//	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ExceptionHandler(value = Exception.class)
	public void defaultExceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		logger.debug(e.getMessage());
		logger.debug("参数传递有误啊啊啊啊啊啊啊");
		PrintWriter out;
		String exceptionName=e.getClass().getSimpleName();
		try {
			ResponseHead responseHead;
			String functionNo;
			JSONObject jsonObject;
			switch (exceptionName) {
			case "AccessDeniedException":
				
/*				response.setCharacterEncoding("UTF-8");  
				response.setContentType("application/json; charset=utf-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
*/					
				responseHead=ResponseHeadUtil.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_NEED_LOGIN_ERROR);
				functionNo=HttpServletRequestUtil.getFunctionNo(request);
				responseHead.setFunctionNo(functionNo);
				out = response.getWriter();
				jsonObject=new JSONObject();
				jsonObject.put("head", responseHead);
				out.println(jsonObject.toJSONString());
				out.flush();
				out.close();
			break;

			default:

				responseHead=ResponseHeadUtil.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_NOT_MEET_REQUIREMENTS_OF_INTERFACE);
				functionNo=HttpServletRequestUtil.getFunctionNo(request);
				responseHead.setFunctionNo(functionNo);
				out = response.getWriter();
				jsonObject=new JSONObject();
				jsonObject.put("head", responseHead);
				logger.debug(jsonObject.toJSONString());
				logger.debug(response.getCharacterEncoding());
				out.println(jsonObject.toJSONString());
				out.flush();
				out.close();
				break;
			}
/*			response.setCharacterEncoding("UTF-8");  
			response.setContentType("application/json; charset=utf-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
*/			

/*			ResponseHead responseHead=ResponseHeadUtil.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_NOT_MEET_REQUIREMENTS_OF_INTERFACE);
			String functionNo=HttpServletRequestUtil.getFunctionNo(request);
			responseHead.setFunctionNo(functionNo);
			out = response.getWriter();
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("head", responseHead);
			logger.debug(jsonObject.toJSONString());
			logger.debug(response.getCharacterEncoding());
			out.println(jsonObject.toJSONString());
			out.flush();
			out.close();
*/
			} catch (IOException ee) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

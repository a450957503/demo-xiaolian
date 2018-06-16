package cn.edu.fjnu.towide.xjw.questionmanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.exception.RequestFailureException;
import cn.edu.fjnu.towide.xjw.questionmanagement.service.QuestionManagementDataCenterService;

@CrossOrigin
@RestController
public class QuestionManagementController {
	@Autowired
	QuestionManagementAppVerNoDispatcher questionManagementAppVerNoDispatcher;
	@Autowired
	QuestionManagementDataCenterService questionManagementDataCenterService;
	
	@RequestMapping("/questionManagement" )
	public Object home(@RequestBody Map<String, Object>requestMap){
		ResponseData responseData=new ResponseData();
		questionManagementAppVerNoDispatcher.dispatchByAppVerNo(requestMap,responseData);
		return responseData;
	}
	   
	@ExceptionHandler(RequestFailureException.class)
	public Object handleException(RequestFailureException requestFailureException){
		
		ResponseData responseData=requestFailureException.getResponseData();
		return responseData;
		
	}
}

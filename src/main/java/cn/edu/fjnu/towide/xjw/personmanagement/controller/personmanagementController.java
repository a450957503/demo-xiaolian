package cn.edu.fjnu.towide.xjw.personmanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.fjnu.towide.czx.personnelmanagement.service.PersonnelManagementDataCenterService;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.exception.RequestFailureException;
import cn.edu.fjnu.towide.xjw.personmanagement.service.personmanagementDataCenterService;

@CrossOrigin
@RestController
public class personmanagementController {
	@Autowired
	personmanagementAppVerNoDispatcher personmanagementAppVerNoDispatcher;
	@Autowired
	personmanagementDataCenterService personmanagementDataCenterService;
	
	@RequestMapping("/personnelManagement" )
	public Object home(@RequestBody Map<String, Object>requestMap){
		ResponseData responseData=new ResponseData();
		personmanagementAppVerNoDispatcher.dispatchByAppVerNo(requestMap,responseData);
		return responseData;
	}
	   
	@ExceptionHandler(RequestFailureException.class)
	public Object handleException(RequestFailureException requestFailureException){
		
		ResponseData responseData=requestFailureException.getResponseData();
		return responseData;
		
	}
}

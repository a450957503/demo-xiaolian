package cn.edu.fjnu.towide.czx.personnelmanagement.controller;

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

@CrossOrigin
@RestController
public class PersonnelManagementController {
	@Autowired
	PersonnelManagementAppVerNoDispatcher personnelManagementAppVerNoDispatcher;
	@Autowired
	PersonnelManagementDataCenterService personnelManagementDataCenterService;
	
	@RequestMapping("/personnelManagement" )
	public Object home(@RequestBody Map<String, Object>requestMap){
		ResponseData responseData=new ResponseData();
		personnelManagementAppVerNoDispatcher.dispatchByAppVerNo(requestMap,responseData);
		return responseData;
	}
	   
	@ExceptionHandler(RequestFailureException.class)
	public Object handleException(RequestFailureException requestFailureException){
		
		ResponseData responseData=requestFailureException.getResponseData();
		return responseData;
		
	}
}

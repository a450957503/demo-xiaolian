package cn.edu.fjnu.towide.czx.departmentmanagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.fjnu.towide.czx.departmentmanagement.service.DepartmentManagementDataCenterService;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.exception.RequestFailureException;

@CrossOrigin
@RestController
public class DepartmentManagementController {
	@Autowired
	DepartmentManagementAppVerNoDispatcher departmentManagementAppVerNoDispatcher;
	@Autowired
	DepartmentManagementDataCenterService departmentManagementDataCenterService;
	
	@RequestMapping("/departmentManagement" )
	public Object home(@RequestBody Map<String, Object>requestMap){
		ResponseData responseData=new ResponseData();
		departmentManagementAppVerNoDispatcher.dispatchByAppVerNo(requestMap,responseData);
		return responseData;
	}
	   
	@ExceptionHandler(RequestFailureException.class)
	public Object handleException(RequestFailureException requestFailureException){
		
		ResponseData responseData=requestFailureException.getResponseData();
		return responseData;
		
	}
}

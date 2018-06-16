package cn.edu.fjnu.towide.usercenter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.fjnu.towide.entity.ResponseData;

@CrossOrigin
@RestController
public class UserCenterController {
	@Autowired
	UserCenterAppVerNoDispatcher loginAppVerNoDispatcher;

	@RequestMapping("/usercenter")
	public Object home(@RequestBody Map<String, Object>requestMap){
		ResponseData responseData=new ResponseData();
		loginAppVerNoDispatcher.dispatchByAppVerNo(requestMap,responseData);
		return responseData;
	}
	   
}

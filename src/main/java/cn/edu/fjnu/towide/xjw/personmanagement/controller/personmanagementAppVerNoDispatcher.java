package cn.edu.fjnu.towide.xjw.personmanagement.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.fjnu.towide.entity.ResponseData;
@Component
public class personmanagementAppVerNoDispatcher {
	@Autowired
	personmanagementFunctionNoDispatcher personmanagementFunctionNoDispatcher;
	public Object dispatchByAppVerNo(Map<String, Object> requestMap,ResponseData responseData) {
		// TODO Auto-generated method stub
		@SuppressWarnings({ "unchecked", "rawtypes" })
		LinkedHashMap<String,String> head=(LinkedHashMap) requestMap.get("head");
		String appVerNo=head.get("appVerNo");
		String functionNo=head.get("functionNo");
		
		switch (appVerNo) {
		case "1.0.0":
			personmanagementFunctionNoDispatcher.dispatchByFunctionNo(functionNo,requestMap,responseData);
			break;

		default:
			break;
		}
		return null;
	}

}

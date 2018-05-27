package cn.edu.fjnu.towide.usercenter.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.usercenter.constant.UserCenterFunctionNoConstants;
import cn.edu.fjnu.towide.usercenter.service.UserCenterService;

@Component
public class UserCenterFunctionNoDispatcher {
	@Autowired
	UserCenterService userCenterService;
	@Autowired
	CommonService commonService;
	static Logger logger = LoggerFactory.getLogger(UserCenterFunctionNoDispatcher.class);

	public void dispatchByFunctionNo(String functionNo, Map<String, Object> requestMap, ResponseData responseData) {
		switch (functionNo) {
		
		
		case UserCenterFunctionNoConstants.GET_PHONE_VERIFICATION_CODE:
			userCenterService.getPhoneVerificationCodeRequestProcess(requestMap, responseData);
			break;
			
		case UserCenterFunctionNoConstants.GET_LOGIN_VERIFICATION_CODE:
			userCenterService.getLoginVerificationCodeRequestProcess(requestMap, responseData);
			break;
			
			
			
		default:
			String reasonOfFailure="功能号输入有误，没有匹配的功能号！";
			commonService.setResponseDataWithFailureInfo(responseData, reasonOfFailure);
			break;
		}
	}

}

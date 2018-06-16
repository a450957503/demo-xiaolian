package cn.edu.fjnu.towide.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.dao.UserDao;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;
import cn.edu.fjnu.towide.exception.RequestFailureException;
import cn.edu.fjnu.towide.utils.ResponseHeadUtil;
@Service
public class CommonService {
	@Autowired
	UserDao usersDao;
	public void setResponseDataWithFailureInfo(ResponseData responseData, String reasonOfFailure) {
		setHeadForResponseDataWithResponseHeadOfFailure(responseData);
		setDataForResponseData(responseData, reasonOfFailure);
	}
	public void setHeadForResponseDataWithResponseHeadOfFailure(ResponseData responseData) {
		ResponseHead responseHead = ResponseHeadUtil
				.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_OPERATION_FAILURE);
		responseData.setHead(responseHead);
	}
	public void setDataForResponseData(ResponseData responseData, String reasonOfFailure) {
		JSONObject data=new JSONObject();
		data.put("reasonOfFailure", reasonOfFailure);
		responseData.setData(data);
	}
	public User getCurrentLoginUser() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		User user=usersDao.getUserByUserName(userName);
		return user;

	}
	@SuppressWarnings("unchecked")
	public <T> T getElementFromParam(Map<String, Object> requestMap, String elmentName) {
		Map<String, Object> param = (Map<String, Object>) requestMap.get("param");
		T elementValue= (T) param.get(elmentName);
		return elementValue;
	}
	public void setHeadForResponseDataWithResponseHeadOfSuccess(ResponseData responseData) {
		ResponseHead responseHead = ResponseHeadUtil
				.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_OPERATION_SUCCESS);
		responseData.setHead(responseHead);
	}
	public void setResponseDataWithFailureInfo(ResponseData responseData, String reasonDescriptionOfFailure,
			String reasonCodeOfFailure) {
		setHeadForResponseDataWithResponseHeadOfFailure(responseData);
		JSONObject data=new JSONObject();
		data.put("reasonCodeOfFailure", reasonCodeOfFailure);
		data.put("reasonDescriptionOfFailure", reasonDescriptionOfFailure);
		responseData.setData(data);
		
		
	}
	public void throwRequestFailureException(ResponseData responseData, String reasonDescriptionOfFailure,
			String reasonCodeOfFailure) {
		setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
		RequestFailureException requestFailureException=new RequestFailureException();
		requestFailureException.setResponseData(responseData);
		throw requestFailureException;
	}
	public void setHeadForResponseDataWithResponseHeadOfSuccessAndData(ResponseData responseData,JSONObject data) {
		ResponseHead responseHead = ResponseHeadUtil
				.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_OPERATION_SUCCESS);
		responseData.setHead(responseHead);
		responseData.setData(data);
	}


}

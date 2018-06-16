package cn.edu.fjnu.towide.xjw.questionmanagement.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.dao.DepartmentDao;
import cn.edu.fjnu.towide.dao.QuestionsDao;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.exception.RequestFailureException;

@Service
public class QuestionManagementCheckService {
	@Autowired
	CommonService commonService;
	@Autowired
	QuestionManagementDataCenterService questionManagementDataCenterService;
 
	@Autowired
	QuestionsDao questionsDao;

	/**
	 * @Description: 获取部门列表请求检测
	 */
	public void getDepartmentListRequestCheck() {
	
	}


	private void checkEmptyStringVariable(String string) {

		if (string == null || string == "") {
			throwRequestFailureException();
			return;
		}
	}

	public void throwRequestFailureException() {
		ResponseData responseData =  questionManagementDataCenterService.getResponseData();
		commonService.setHeadForResponseDataWithResponseHeadOfFailure(responseData);
		RequestFailureException requestFailureException = new RequestFailureException();
		requestFailureException.setResponseData(responseData);
		throw requestFailureException;
	}

	private void throwRequestFailureException(ResponseData responseData, String reasonCodeOfFailure,
			String reasonDescriptionOfFailure) {
		commonService.setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
		RequestFailureException requestFailureException = new RequestFailureException();
		requestFailureException.setResponseData(responseData);
		throw requestFailureException;
	}


	public void getQuestionListRequestCheck() {
		// TODO Auto-generated method stub
		
	}


	public void addQuestionRequestCheck() {
		// TODO Auto-generated method stub
		Map<String, Object> requestMap =  questionManagementDataCenterService.getRequestMap();
		String departmentId=commonService.getElementFromParam(requestMap, "departmentId");
		String title=commonService.getElementFromParam(requestMap, "title");
		System.out.println(departmentId);
		System.out.println(title);
		questionManagementDataCenterService.setData("departmentId", departmentId);
		questionManagementDataCenterService.setData("title", title);
	}


//	/**  
//	 * @Description: 添加部门检测
//	 */  
//	public void addDepartmentListRequestCheck() {
//		Map<String, Object> requestMap = departmentManagementDataCenterService.getRequestMap();
//		String departmentName=commonService.getElementFromParam(requestMap, "departmentName");
//		String introduction=commonService.getElementFromParam(requestMap, "introduction");
//		
//		checkEmptyStringVariable(departmentName);
//		
//		departmentManagementDataCenterService.setData("departmentName", departmentName);
//		departmentManagementDataCenterService.setData("introduction", introduction);
//	}


	 


	 

}

package cn.edu.fjnu.towide.xjw.questionmanagement.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.constant.ReasonOfFailureConstant;
import cn.edu.fjnu.towide.czx.departmentmanagement.constant.DepartmentManagementFunctionNoConstants;
import cn.edu.fjnu.towide.czx.departmentmanagement.service.DepartmentManagementDataCenterService;
import cn.edu.fjnu.towide.czx.departmentmanagement.service.DepartmentManagementService;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.xjw.questionmanagement.constant.QuestionManagementFunctionNoConstants;
import cn.edu.fjnu.towide.xjw.questionmanagement.service.QuestionManagementDataCenterService;
import cn.edu.fjnu.towide.xjw.questionmanagement.service.QuestionManagementService;

@Component
public class QuestionManagementFunctionNoDispatcher {
	@Autowired
	CommonService commonService;
	@Autowired
	QuestionManagementService questionManagementService;
	@Autowired
	QuestionManagementDataCenterService questionManagementDataCenterService;
	
	static Logger logger = LoggerFactory.getLogger(QuestionManagementFunctionNoDispatcher.class);
	public void dispatchByFunctionNo(String functionNo, Map<String, Object> requestMap, ResponseData responseData) {
		questionManagementDataCenterService.init(requestMap, responseData);
		switch (functionNo) {
			//按功能号得到问题列表
		case QuestionManagementFunctionNoConstants.GET_QUESTION_LIST:
			questionManagementService.getQuestionListRequestProcess(requestMap, responseData);
			questionManagementDataCenterService.destory();
			break;
		
		case QuestionManagementFunctionNoConstants.ADD_QUESTION:
 
			questionManagementService.addQuestionRequestProcess(requestMap, responseData);
			questionManagementDataCenterService.destory();
			break;	
			
			//按功能号添加部门
		
		default:
			
			String reasonCodeOfFailure=ReasonOfFailureConstant.THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_CODE;
			String reasonDescriptionOfFailure=ReasonOfFailureConstant.THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_DESCRIPTION;
			commonService.setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
			break;
		}
	}

}

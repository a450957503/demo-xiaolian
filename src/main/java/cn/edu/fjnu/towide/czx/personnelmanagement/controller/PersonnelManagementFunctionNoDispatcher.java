package cn.edu.fjnu.towide.czx.personnelmanagement.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.constant.ReasonOfFailureConstant;
import cn.edu.fjnu.towide.czx.personnelmanagement.constant.PersonnelManagementFunctionNoConstants;
import cn.edu.fjnu.towide.czx.personnelmanagement.service.PersonnelManagementDataCenterService;
import cn.edu.fjnu.towide.czx.personnelmanagement.service.PersonnelManagementService;
import cn.edu.fjnu.towide.entity.ResponseData;

@Component
public class PersonnelManagementFunctionNoDispatcher {
	@Autowired
	CommonService commonService;
	@Autowired
	PersonnelManagementService personnelManagementService;
	@Autowired
	PersonnelManagementDataCenterService personnelManagementDataCenterService;
	
	static Logger logger = LoggerFactory.getLogger(PersonnelManagementFunctionNoDispatcher.class);
	public void dispatchByFunctionNo(String functionNo, Map<String, Object> requestMap, ResponseData responseData) {
		personnelManagementDataCenterService.init(requestMap, responseData);
		switch (functionNo) {
			//按功能号得到部门列表
//		case DepartmentManagementFunctionNoConstants.GET_DEPARTMENT_LIST:
//			personnelManagementService.getDepartmentListRequestProcess(requestMap, responseData);
//			personnelManagementDataCenterService.destory();
//			break;
		case PersonnelManagementFunctionNoConstants.GET_PERSONNEL_LIST:
			personnelManagementService.getPersonnelListRequestProcess(requestMap, responseData);
			personnelManagementDataCenterService.destory();
			break;
		
		default:
			
			String reasonCodeOfFailure=ReasonOfFailureConstant.THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_CODE;
			String reasonDescriptionOfFailure=ReasonOfFailureConstant.THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_DESCRIPTION;
			commonService.setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
			break;
		}
	}

}

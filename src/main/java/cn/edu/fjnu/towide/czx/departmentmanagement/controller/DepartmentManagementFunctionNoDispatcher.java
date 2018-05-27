package cn.edu.fjnu.towide.czx.departmentmanagement.controller;

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

@Component
public class DepartmentManagementFunctionNoDispatcher {
	@Autowired
	CommonService commonService;
	@Autowired
	DepartmentManagementService departmentManagementService;
	@Autowired
	DepartmentManagementDataCenterService departmentManagementDataCenterService;
	
	static Logger logger = LoggerFactory.getLogger(DepartmentManagementFunctionNoDispatcher.class);
	public void dispatchByFunctionNo(String functionNo, Map<String, Object> requestMap, ResponseData responseData) {
		departmentManagementDataCenterService.init(requestMap, responseData);
		switch (functionNo) {
			//按功能号得到部门列表
		case DepartmentManagementFunctionNoConstants.GET_DEPARTMENT_LIST:
			departmentManagementService.getDepartmentListRequestProcess(requestMap, responseData);
			departmentManagementDataCenterService.destory();
			break;
			//按功能号添加部门
		case DepartmentManagementFunctionNoConstants.ADD_DEPARTMENT:
			departmentManagementService.addDepartmentListRequestProcess(requestMap, responseData);
			departmentManagementDataCenterService.destory();
			break;
		default:
			
			String reasonCodeOfFailure=ReasonOfFailureConstant.THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_CODE;
			String reasonDescriptionOfFailure=ReasonOfFailureConstant.THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_DESCRIPTION;
			commonService.setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
			break;
		}
	}

}

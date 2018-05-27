package cn.edu.fjnu.towide.czx.departmentmanagement.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.dao.DepartmentDao;
import cn.edu.fjnu.towide.dao.QuestionsDao;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.exception.RequestFailureException;

@Service
public class DepartmentManagementCheckService {
	@Autowired
	CommonService commonService;
	@Autowired
	DepartmentManagementDataCenterService departmentManagementDataCenterService;
	@Autowired
	DepartmentDao departmentDao;
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
		ResponseData responseData = departmentManagementDataCenterService.getResponseData();
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


	/**  
	 * @Description: 添加部门检测456
	 */  
	public void addDepartmentListRequestCheck() { 
		Map<String, Object> requestMap = departmentManagementDataCenterService.getRequestMap();
		String departmentName=commonService.getElementFromParam(requestMap, "departmentName");
		String introduction=commonService.getElementFromParam(requestMap, "introduction");
		System.out.println("455");
		checkEmptyStringVariable(departmentName);
		
		departmentManagementDataCenterService.setData("departmentName", departmentName);
		departmentManagementDataCenterService.setData("introduction", introduction);
	}

}

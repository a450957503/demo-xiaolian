package cn.edu.fjnu.towide.czx.personnelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.dao.DepartmentDao;
import cn.edu.fjnu.towide.dao.QuestionsDao;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.exception.RequestFailureException;

@Service
public class PersonnelManagementCheckService {
	@Autowired
	CommonService commonService;
	@Autowired
	PersonnelManagementDataCenterService personnelManagementDataCenterService;




	private void checkEmptyStringVariable(String string) {

		if (string == null || string == "") {
			throwRequestFailureException();
			return;
		}
	}

	public void throwRequestFailureException() {
		ResponseData responseData = personnelManagementDataCenterService.getResponseData();
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
	 * @Description: 
	 */  
	public void getPersonnelListRequestCheck() {
		
	}

}

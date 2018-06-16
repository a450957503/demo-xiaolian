package cn.edu.fjnu.towide.czx.personnelmanagement.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.entity.ResponseData;

@Service
public class PersonnelManagementService {

	@Autowired
	PersonnelManagementDataCenterService personnelManagementDataCenterService;
	@Autowired
	PersonnelManagementCheckService personnelManagementCheckService;
	@Autowired
	PersonnelManagementBusinessService personnelManagementBusinessService;
	/**  
//	 * @Description: 获取人员列表
	 */  
	public void getPersonnelListRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
		personnelManagementCheckService.getPersonnelListRequestCheck();
		personnelManagementBusinessService.getPersonnelListRequestProcess();		
	}

//	/**
//	 *@Description: 获取部门列表
//	 */
//	public void getDepartmentListRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
//		personnelManagementCheckService.getDepartmentListRequestCheck();
//		personnelManagementBusinessService.getDepartmentListRequestProcess();
//
//	}

}

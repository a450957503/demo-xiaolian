package cn.edu.fjnu.towide.xjw.personmanagement.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.entity.ResponseData;

@Service
public class personmanagementService {

	@Autowired
	personmanagementDataCenterService personnelManagementDataCenterService;
	@Autowired
	personmanagementCheckService personnelManagementCheckService;
	@Autowired
	personmanagementBusinessService personnelManagementBusinessService;
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

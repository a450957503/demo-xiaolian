package cn.edu.fjnu.towide.czx.departmentmanagement.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.entity.ResponseData;

@Service
public class DepartmentManagementService {

	@Autowired
	DepartmentManagementDataCenterService departmentManagementDataCenterService;
	@Autowired
	DepartmentManagementCheckService departmentManagementCheckService;
	@Autowired
	DepartmentManagementBusinessService departmentManagementBusinessService;

	/**
	 *@Description: 获取部门列表
	 */
	public void getDepartmentListRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
		departmentManagementCheckService.getDepartmentListRequestCheck();
		departmentManagementBusinessService.getDepartmentListRequestProcess();

	}

	/**  
	 * @Description: 添加部门
	 */  
	public void addDepartmentListRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
		departmentManagementCheckService.addDepartmentListRequestCheck();
		departmentManagementBusinessService.addDepartmentListRequestProcess();

	}

}

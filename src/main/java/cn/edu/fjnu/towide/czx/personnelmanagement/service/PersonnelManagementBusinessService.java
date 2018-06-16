package cn.edu.fjnu.towide.czx.personnelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.dao.DepartmentDao;
import cn.edu.fjnu.towide.dao.SequenceDao;
import cn.edu.fjnu.towide.dao.UserDao;
import cn.edu.fjnu.towide.entity.Department;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.exception.RequestFailureException;

@Service
public class PersonnelManagementBusinessService {
	@Autowired
	CommonService commonService;
	@Autowired
	PersonnelManagementCheckService personnelManagementCheckService;

	@Autowired
	PersonnelManagementDataCenterService personnelManagementDataCenterService;

	@Autowired
	UserDao userDao;

	private void throwRequestFailureException(ResponseData responseData, String reasonCodeOfFailure,
			String reasonDescriptionOfFailure) {
		commonService.setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
		RequestFailureException requestFailureException = new RequestFailureException();
		requestFailureException.setResponseData(responseData);
		throw requestFailureException;
	}


	/**  
	 * @Description: 获取人员列表
	 */  
	public void getPersonnelListRequestProcess() {
		List<User> personnelList=userDao.getPersonnelList();
		
		JSONObject data =new JSONObject();
		data.put("personnelList", personnelList);
		
		ResponseData responseData=personnelManagementDataCenterService.getResponseData();
		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);
		responseData.setData(data);
	}

//	/**
//	 * @Description:获取部门列表处理过程
//	 */
//	public void getDepartmentListRequestProcess() {
//
//		List<Department> departmentList = departmentDao.getDepartmentList();
//		
//		JSONObject data = new JSONObject();
//		data.put("departmentList", departmentList);
//
//		ResponseData responseData = personnelManagementDataCenterService.getResponseData();
//		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);
//		responseData.setData(data);
//	}

//	/**
//	 * @Description: 添加部门请求处理过程
//	 */
//	@Transactional
//	public void addDepartmentRequestProcess() {
//		Map<String, Object> requestMap = departmentManagementDataCenterService.getRequestMap();
//		String departmentName = commonService.getElementFromParam(requestMap, "departmentName");
//		String introduction = commonService.getElementFromParam(requestMap, "introduction");
//		
//		String departmentId = IdGenerator.getId();
//
//		String id = SequenceIdConstant.DEPARTMENT;// sequence的id
//		int number = 0;
//		// 如果多人同时添加冲突，会重复添加
//		while (true) {
//			number = sequenceDao.getNumber(id);
//			boolean result = sequenceDao.numberAddOne(id, number);
//			if (result) {
//				break;
//			}
//		}
//
//		Date createDateTime = new Date();
//		Date lastUpdateTime = createDateTime;
//
//		Department department = new Department();
//		department.setId(departmentId);
//		department.setIntroduction(introduction);
//		department.setName(departmentName);
//		department.setSequenceNumber(number);
//		department.setCreateDateTime(createDateTime);
//		department.setLastUpdateTime(lastUpdateTime);
//
//		boolean result = departmentDao.addDepartment(department);
//		ResponseData responseData = departmentManagementDataCenterService.getResponseData();
//
//		if (!result) {
//			commonService.setHeadForResponseDataWithResponseHeadOfFailure(responseData);
//			return;
//		}
//		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);
//	}


}

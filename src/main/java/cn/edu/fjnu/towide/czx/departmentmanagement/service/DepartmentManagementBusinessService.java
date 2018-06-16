package cn.edu.fjnu.towide.czx.departmentmanagement.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.czx.departmentmanagement.constant.SequenceIdConstant;
import cn.edu.fjnu.towide.czx.personnelmanagement.service.PersonnelManagementDataCenterService;
import cn.edu.fjnu.towide.dao.DepartmentDao;
import cn.edu.fjnu.towide.dao.SequenceDao;
import cn.edu.fjnu.towide.entity.Department;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.exception.RequestFailureException;
import cn.edu.fjnu.towide.utils.IdGenerator;

@Service
public class DepartmentManagementBusinessService {
	@Autowired
	CommonService commonService;
	@Autowired
	DepartmentManagementCheckService departmentManagementCheckService;
	@Autowired
	DepartmentDao departmentDao;
	@Autowired
	DepartmentManagementDataCenterService departmentManagementDataCenterService;
	@Autowired
	SequenceDao sequenceDao;

	@SuppressWarnings("unused")
	private void throwRequestFailureException(ResponseData responseData, String reasonCodeOfFailure,
			String reasonDescriptionOfFailure) {
		commonService.setResponseDataWithFailureInfo(responseData, reasonDescriptionOfFailure, reasonCodeOfFailure);
		RequestFailureException requestFailureException = new RequestFailureException();
		requestFailureException.setResponseData(responseData);
		throw requestFailureException;
	}

	/**
	 * @Description:获取部门列表处理过程
	 */
	public void getDepartmentListRequestProcess() {

		List<Department> departmentList = departmentDao.getDepartmentList();

		JSONObject data = new JSONObject();
		data.put("departmentList", departmentList);

		ResponseData responseData = departmentManagementDataCenterService.getResponseData();
		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);
		responseData.setData(data);
	}

	/**
	 * @Description: TODO
	 */
	public void addDepartmentListRequestProcess() {
		String departmentName = departmentManagementDataCenterService.getData("departmentName");
		String introduction = departmentManagementDataCenterService.getData("introduction");

		User user=departmentManagementDataCenterService.getCurrentLoginUser();
		System.out.println(user.toString());
		
		String departmentId = IdGenerator.getId();
		String id = SequenceIdConstant.DEPARTMENT;
		int number = sequenceDao.getNumber(id);

		Date date = new Date();

		Department department = new Department();
		department.setName(departmentName);
		department.setId(departmentId);
		department.setIntroduction(introduction);
		department.setSequenceNumber(number);
		department.setCreateDateTime(date);
		department.setLastUpdateTime(date);
      
		boolean result = departmentDao.addDepartment(department);

		ResponseData responseData = departmentManagementDataCenterService.getResponseData();
		if (!result) {
			commonService.setHeadForResponseDataWithResponseHeadOfFailure(responseData);
			return;
		}
		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);

	}

	/**
	 * @Description: 添加部门请求处理过程
	 */
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

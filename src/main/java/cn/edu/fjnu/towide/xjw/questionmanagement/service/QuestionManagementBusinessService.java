package cn.edu.fjnu.towide.xjw.questionmanagement.service;

import java.util.Date;
import java.util.List;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.common.service.CommonService;
 
import cn.edu.fjnu.towide.dao.DepartmentDao;
import cn.edu.fjnu.towide.dao.QuestionsDao;
import cn.edu.fjnu.towide.dao.SequenceDao;
import cn.edu.fjnu.towide.entity.Department;
import cn.edu.fjnu.towide.entity.Questions;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.exception.RequestFailureException;
import cn.edu.fjnu.towide.utils.IdGenerator;
import cn.edu.fjnu.towide.xjw.questionmanagement.constant.SequenceIdConstant;

@Service
public class QuestionManagementBusinessService {
	@Autowired
	CommonService commonService;
	@Autowired
	QuestionManagementCheckService questionManagementCheckService;
	@Autowired
	QuestionsDao questionDao;
	@Autowired
	QuestionManagementDataCenterService  questionManagementDataCenterService;
	@Autowired
	SequenceDao sequenceDao;
    @Autowired
    QuestionsDao questionsDao;
	
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

	
	}

	/**
	 * @Description: TODO
	 */
	public void addDepartmentListRequestProcess() {
//		String departmentName = departmentManagementDataCenterService.getData("departmentName");
//		String introduction = departmentManagementDataCenterService.getData("introduction");
//
//		User user=departmentManagementDataCenterService.getCurrentLoginUser();
//		System.out.println(user.toString());
//		
//		String departmentId = IdGenerator.getId();
//		String id = SequenceIdConstant.DEPARTMENT;
//		int number = sequenceDao.getNumber(id);
//
//		Date date = new Date();
//
//		Department department = new Department();
//		department.setName(departmentName);
//		department.setId(departmentId);
//		department.setIntroduction(introduction);
//		department.setSequenceNumber(number);
//		department.setCreateDateTime(date);
//		department.setLastUpdateTime(date);
//
//		boolean result = departmentDao.addDepartment(department);
//
//		ResponseData responseData = departmentManagementDataCenterService.getResponseData();
//		if (!result) {
//			commonService.setHeadForResponseDataWithResponseHeadOfFailure(responseData);
//			return;
//		}
//		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);

	}

	public void getQuestionListRequestProcess() {
		// TODO Auto-generated method stub
		List<Questions> questionList = questionDao. getQuestionsList();

		JSONObject data = new JSONObject();
		data.put("questionList", questionList);

		ResponseData responseData = questionManagementDataCenterService.getResponseData();
		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);
		responseData.setData(data);
	}
	/**
	 * @Description: 添加部门请求处理过程
	 */
	public void addQuestionRequestProcess() {
		// TODO Auto-generated method stubgecommonService.getElementFromParam(requestMap, "departmentName");
		

		
		String departmentId = questionManagementDataCenterService.getData("departmentId");
		String title = questionManagementDataCenterService.getData("title");
		 System.out.println("试用前");
		 System.out.println(departmentId);
		 System.out.println(title);
		Department departmentList = questionsDao.getDepartmentList(departmentId);
		User user=questionManagementDataCenterService.getCurrentLoginUser();
		System.out.println(user.toString());
		
		String questionId = IdGenerator.getId();
		String id = SequenceIdConstant.Question;
		int number = sequenceDao.getNumber(id);

		
	
		
		Date date = new Date();

		 Questions questions = new Questions();
		 questions.setId(id); 
		 questions.setSequenceNumber(number);
		 questions.setTitle(title);
		 questions.setDepartmentId(departmentList.getId());
		 
		 
		 
	     questions.setDepartmentName(departmentList.getName()); 

		 questions.setFrequency(0);
		 questions.setUsername(user.getUsername());
		 questions.setRealName(user.getRealName());
		 questions.setNickName(user.getNickname());
		 questions.setTopOrNot("no");
		 
		 questions.setCreateDateTime(date);
		 questions.setLastUpdataDateTime(date);
		 questions.setContent("测试");
	
		 boolean result = questionDao.addQuestion(questions);
		 System.out.println("试过了。。。");
		 ResponseData responseData = questionManagementDataCenterService.getResponseData();
			if (!result) {
				commonService.setHeadForResponseDataWithResponseHeadOfFailure(responseData);
				return;
			}
			commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);

		 
		 //		 questions.setUsername(username);
//		 questions.setContent(content);
//		 questions.setCreateDateTime(date);
//		 questions.setDepartmentId(departmentId);
//		 questions.setFrequency(frequency);
//		 questions.setId(id); 
//		 questions.setImgNames(imgNames);
//		 questions.setLastUpdataDateTime(date);
//		 questions.setLastUpdataDateTimeString(lastUpdataDateTimeString);	
//		 questions.setNickName(nickName);
//		 questions.setNumberOfEvaluators(numberOfEvaluators);
//		 questions.setTitle(title);
		  
		 
//		String departmentName = departmentManagementDataCenterService.getData("departmentName");
//		String introduction = departmentManagementDataCenterService.getData("introduction");
//
//		User user=departmentManagementDataCenterService.getCurrentLoginUser();
//		System.out.println(user.toString());
//		
//		String departmentId = IdGenerator.getId();
//		String id = SequenceIdConstant.DEPARTMENT;
//		int number = sequenceDao.getNumber(id);
//
//		Date date = new Date();
//
//		Department department = new Department();
//		department.setName(departmentName);
//		department.setId(departmentId);
//		department.setIntroduction(introduction);
//		department.setSequenceNumber(number);
//		department.setCreateDateTime(date);
//		department.setLastUpdateTime(date);
		
		
		
	}

	
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

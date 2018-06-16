package cn.edu.fjnu.towide.xjw.questionmanagement.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.fjnu.towide.entity.ResponseData;

@Service
public class QuestionManagementService {

	@Autowired
	QuestionManagementDataCenterService QuestionManagementDataCenterService;
	@Autowired
	QuestionManagementCheckService QuestionManagementCheckService;
	@Autowired
	QuestionManagementBusinessService QuestionManagementBusinessService;

 
 
	/**
	 *@Description: 获取问题列表
	 */
	public void getQuestionListRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
		// TODO Auto-generated method stub
		QuestionManagementCheckService.getQuestionListRequestCheck();
		QuestionManagementBusinessService.getQuestionListRequestProcess();

	}



	public void addQuestionRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
		// TODO Auto-generated method stub
		//检测稍后再写
		QuestionManagementCheckService.addQuestionRequestCheck();
		QuestionManagementBusinessService.addQuestionRequestProcess();
	}

}

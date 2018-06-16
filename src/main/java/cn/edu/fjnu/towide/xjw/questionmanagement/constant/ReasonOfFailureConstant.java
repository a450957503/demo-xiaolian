package cn.edu.fjnu.towide.xjw.questionmanagement.constant;

public interface ReasonOfFailureConstant {

	String GENERATE_LOGIN_VERIFICATION_CODE_FAILURE = "生成登录验证码失败!";
	String USER_NOT_EXIST = "用户不存在!";
	String UPDATE_PHONE_VERIFICATION_CODE_FAILURE = "更新数据库手机验证码失败!";
	
	String THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_CODE ="The parameters submitted are incorrect";
	String THE_PARAMETERS_SUBMITTED_ARE_INCORRECT_DESCRIPTION ="提交的参数有误！";
	
	String THE_DEPARTMENT_DOES_NOT_EXIST_CODE = "The department does not exist";
	String THE_DEPARTMENT_DOES_NOT_EXIST_DESCRIPTION = "该部门不存在";

	String THE_DEPARTMENT_EXISTS_IN_THE_QUESTIONS_CODE = "The department exists in the questions";
	String THE_DEPARTMENT_EXISTS_IN_THE_QUESTIONS_DESCRIPTION = "删除失败！该部门与问题库中问题关联";
	
	
}

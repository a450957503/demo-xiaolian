package cn.edu.fjnu.towide.enums;


public enum ResponseHeadEnums {

	
	//通用错误
	RESPONSEHEAD_WRONG_JSON_FORMAT_ERROR("C0001","发送的数据不符合json规范！"),
	RESPONSEHEAD_NOT_MEET_REQUIREMENTS_OF_INTERFACE("C0002","发送的数据符合json规范，但不符合接口要求！"),
	RESPONSEHEAD_APPVERNO_ERROR("C0001","app版本号有误！"),
	RESPONSEHEAD_FUNCTIONNO_ERROR("C0003","功能号有误！"),
	RESPONSEHEAD_VERIFICATION_CODE_INCORRECT_ERROR("C0006","验证码错误！"),
	RESPONSEHEAD_VERIFICATION_CODE_EXPIRED_ERROR("C0007","验证码过期！"),
	
	RESPONSEHEAD_NEED_LOGIN_ERROR("C0008","未登录或登录失败！"),
	
	RESPONSEHEAD_PERMISSION_DENIED_ERROR("C0009","没有访问权限！"),
	
	RESPONSEHEAD_USER_NO_EXIST("UserNoExist","用户不存在！"),	
	
	
	//操作失败
	RESPONSEHEAD_OPERATION_FAILURE("C1000","抱歉，操作失败，请检查输入参数的正确性！"),

	//操作成功
	RESPONSEHEAD_OPERATION_SUCCESS("C2000","恭喜，操作成功！"); 
	
	
	
	
	
/*	//用户注册时，相关的错误
	RESPONSEHEAD_USER_EXIST_ERROR("C0201","用户已存在！")
*/	
//	RESPONSEHEAD_LOGIN_FAILURER()
	public String code;
	public String msg;
	private ResponseHeadEnums(String code,String msg){
		this.code=code;
		this.msg=msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

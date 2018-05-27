package cn.edu.fjnu.towide.entity;

/*import com.alibaba.fastjson.JSONObject

import cn.edu.fjnu.towide.utils.JsonUtils
*/
public class ResponseHead {
	private String code;
	private String msg;
	private String functionNo;
	private String functionCode;
	private String token;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getFunctionCode() {
		return functionCode;
	}
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}
	public String getFunctionNo() {
		return functionNo;
	}
	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}
	
}

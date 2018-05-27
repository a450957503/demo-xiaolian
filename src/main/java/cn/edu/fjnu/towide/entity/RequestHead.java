package cn.edu.fjnu.towide.entity;

public class RequestHead {
	public static String APP_VER_NO="1.0.0";
	private String appVerNo;
	private String functionNo;
	private String token;
	public String getAppVerNo() {
		return appVerNo;
	}
	public void setAppVerNo(String appVerNo) {
		this.appVerNo = appVerNo;
	}
	public String getFunctionNo() {
		return functionNo;
	}
	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}

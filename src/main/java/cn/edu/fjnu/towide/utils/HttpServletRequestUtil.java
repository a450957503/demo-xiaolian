package cn.edu.fjnu.towide.utils;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.entity.RequestHead;


public class HttpServletRequestUtil {
	
	public static Object getParamByParamName(HttpServletRequest request,String paramName){
		JSONObject jsonObject=JsonUtils.getJsonFromRequest(request);
		if (jsonObject==null) {
			return null;
		}
		JSONObject paramJson=(JSONObject) jsonObject.get("param");
		
		Object param=null;
		if (paramJson!=null)
			param= paramJson.get(paramName);
		return param;
	}

	public static String getFunctionNo(HttpServletRequest request){
		JSONObject jsonObject=JsonUtils.getJsonFromRequest(request);
		if (jsonObject==null) {
			return null;
		}
		JSONObject head=(JSONObject) jsonObject.get("head");
		
		String functionNo=null;
		if (head!=null)
			functionNo=(String) head.get("functionNo");
		return functionNo;
	}
	public static RequestHead getRequestHead(HttpServletRequest request) {
		JSONObject jsonObject=null;
		try{
			jsonObject=JsonUtils.getJsonFromRequest(request);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (jsonObject==null) {
			return null;
		}
		JSONObject head=(JSONObject) jsonObject.get("head");
		RequestHead requestHead=new RequestHead();
		requestHead.setAppVerNo(head.getString("appVerNo"));
		requestHead.setFunctionNo(head.getString("functionNo"));
		requestHead.setToken(head.getString("token"));
		return requestHead;
	}
	public static JSONObject getRequestParam(HttpServletRequest request) {
		JSONObject jsonObject=JsonUtils.getJsonFromRequest(request);
		JSONObject param=(JSONObject) jsonObject.get("param");
		return param;
	}
	public static String getLoginType(HttpServletRequest request) {
		return (String) getParamByParamName(request, "loginType");
	}
}

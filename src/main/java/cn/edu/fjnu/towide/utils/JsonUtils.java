package cn.edu.fjnu.towide.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
	//实现从request中，提取用户提交的json数据，封装成JSON对象返回
	public static JSONObject getJsonFromRequest(HttpServletRequest request) {
		try {
			InputStream in=request.getInputStream();
			Scanner scanner=new Scanner(in);
			StringBuffer stringBuffer=new StringBuffer();
			while(scanner.hasNext()){
				stringBuffer.append(scanner.nextLine());
			}
//			in.reset();
			scanner.close();
			JSONObject jsonObject=JSONObject.parseObject(stringBuffer.toString());
			return jsonObject;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//对reques中的数据进行校验，是否为合法的json格式，true合法，false不合法
	public static boolean verifyJsonFromRequest(HttpServletRequest request) {
		try {
			getJsonFromRequest(request);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	//利用json将map转化为对象
	public static <T> T mapToObject(Map<String, Object> map,Class<T>clazz) {
		JSONObject recipientAddressJson=(JSONObject) JSONObject.toJSON(map);
		T object=recipientAddressJson.toJavaObject(clazz);
		return object;
	}

}

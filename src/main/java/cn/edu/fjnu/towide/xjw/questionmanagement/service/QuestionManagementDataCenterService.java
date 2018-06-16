package cn.edu.fjnu.towide.xjw.questionmanagement.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.entity.User;
@Service
@PropertySource("classpath:LossPrevention.property")//指定本类中将要读取属性文件
/**
 * 此类主要用来暂存程序执行过程中产生的临时数据，供后续的程序中获取使用，以免数据的反复生成
 * @author 吴闻
 *
 */
public class QuestionManagementDataCenterService {
	
	@Autowired
	CommonService commonService;//公共服务类，里面提供了很多各模块都会用到一些方法

	//多线程并发的环境，必须使用ThreadLocal存放中间结果，
	private ThreadLocal<Map<String, Object>>requestMapLocal=new ThreadLocal<>();
	private ThreadLocal<ResponseData>responseDataLocal=new ThreadLocal<>();
	private ThreadLocal<User>currentLoginUserLocal=new ThreadLocal<>();
	private ThreadLocal<Date> eventProcessingStartTimeLocal=new ThreadLocal<>();
	private ThreadLocal<String> processResultLocal=new ThreadLocal<>();
	private ThreadLocal<String> processResultDescriptionLocal=new ThreadLocal<>();
	//大部分的中间结果，保存到data中，dataLocal存放当前线程的data，配合setData和getData来读写data中存放的数据
	private ThreadLocal<JSONObject> dataLocal=new ThreadLocal<>(); 
	/**
	 * 将数据写入到data中
	 * @param dataName 数据的名称，将来要通过它来获取存入的值
	 * @param dataValue 数据的值
	 */
	public <T> void setData(String dataName,T dataValue){
		JSONObject data=dataLocal.get();
		data.put(dataName, dataValue);
	}
	/**
	 *将数据从data中读出 
	 * @param dataName 要读取数据的名称 
	 * @return 返回数据的值
	 */
	@SuppressWarnings("unchecked")
	public <T> T getData(String dataName){
		JSONObject data=dataLocal.get();
		T tempData=(T) data.get(dataName);
		return tempData;
	}

	public String getProcessResultDescription() {
		return this.processResultDescriptionLocal.get();
	}
	public void setProcessResultDescription(String processResultDescription) {
		this.processResultDescriptionLocal.set(processResultDescription);
	}
	public String getProcessResult() {
		return this.processResultLocal.get();
	}
	public void setProcessResult(String processResult) {
		this.processResultLocal.set(processResult);
	}
	public Map<String, Object> getRequestMap() {
		return requestMapLocal.get();
	}
	public void setRequestMap(Map<String, Object> requestMap) {
		this.requestMapLocal.set(requestMap);
	}
	public void setEventProcessingStartTime(Date eventProcessingStartTime) {
		this.eventProcessingStartTimeLocal.set(eventProcessingStartTime);
	}
	public ResponseData getResponseData() {
		return responseDataLocal.get();
	}
	public void setResponseData(ResponseData responseData) {
		responseDataLocal.set(responseData);
	}
	public User getCurrentLoginUser() {
		User user=currentLoginUserLocal.get();
		if (user==null) {
			user=commonService.getCurrentLoginUser();
			currentLoginUserLocal.set(user);
		}
		return user;
	}
	//此示例为读取用户提交的某个参数操作，get后面跟上参数名称
	public String getParameFromRequestMapParam() {
		Map<String, Object>requestMap=getRequestMap();
		String plateProvince=commonService.getElementFromParam(requestMap, "plateProvince");
		return plateProvince;
			
	}
	
	
	public Date getEventProcessingStartTime() {

		return eventProcessingStartTimeLocal.get();
	
	}
	
	public void init(Map<String, Object> requestMap, ResponseData responseData) {
		
		Date eventProcessingStartTime=new Date();

		JSONObject data=new JSONObject();
		this.setData(data);
		
		this.setRequestMap(requestMap);
		this.setResponseData(responseData);
		this.setEventProcessingStartTime(eventProcessingStartTime);
	}
	@SuppressWarnings("unused")
	private JSONObject getData() {
		return dataLocal.get();
	}
	private void setData(JSONObject data) {
		dataLocal.set(data);
	}
    public void destory() {
		
		this.requestMapLocal.remove();
		this.responseDataLocal.remove();
		this.currentLoginUserLocal.remove();
		this.eventProcessingStartTimeLocal.remove();
		this.processResultLocal.remove();
		this.processResultDescriptionLocal.remove();
		this.dataLocal.remove();
		
	}
}

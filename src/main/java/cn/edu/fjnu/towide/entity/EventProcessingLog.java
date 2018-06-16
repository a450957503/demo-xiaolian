package cn.edu.fjnu.towide.entity;

import java.util.Date;

public class EventProcessingLog {
	public static final String EVENT_NAME_VEHICLE_ENTRY_REQUEST = "VehicleEntryRequest";
	public static final String EVENT_DESCRIPTION_VEHICLE_ENTRY_REQUEST = "车辆进场请求";
	
	
	public static final String PROCESS_RESULT_FAILURE_FOR_THE_PARAMETER_FAILED_THE_VALIDITY_CHECK = "FailureForTheParameterFailedTheValidityCheck";
	public static final String PROCESS_RESULT_DESCRIPTION_FAILURE_FOR_THE_PARAMETER_FAILED_THE_VALIDITY_CHECK = "操作失败，提交的参数未通过合法性校验！";
	public static final String EVENT_NAME_DEMO_OPERATION = "DemoOperation";
	public static final String EVENT_DESCRIPTION_DEMO_OPERATION = "时间描述，可使用中文";

	private String id;//事件id
	private String eventName;//事件名称，如addStudentRequest-添加学生请求
	private String eventDescription;//事件描述，如"添加学生请求"，此处可以使用中文描述，对事件进行描述
	private Date eventTime;//事件发生的时间
	private String eventInitiatorUsername;//事件的发起人用户名
	private String eventInitiatorRealName;//事件发起人真实姓名
	private String campusId;//校区id
	private String campusName;//校区名称
	private String processState;//处理的情况，如failure-失败，success-成功
	private String processResult;//处理的结果，"AddStudentSuccess"
	private String processResultDescription;//处理结果描述，"添加学生成功"
	private String timeConsuming;//处理该事件花费的时间
	private String logContent;//日志内容

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventInitiatorUsername() {
		return eventInitiatorUsername;
	}
	public void setEventInitiatorUsername(String eventInitiatorUsername) {
		this.eventInitiatorUsername = eventInitiatorUsername;
	}
	public String getEventInitiatorRealName() {
		return eventInitiatorRealName;
	}
	public void setEventInitiatorRealName(String eventInitiatorRealName) {
		this.eventInitiatorRealName = eventInitiatorRealName;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public String getProcessResult() {
		return processResult;
	}
	public void setProcessResult(String processResult) {
		this.processResult = processResult;
	}
	public String getProcessResultDescription() {
		return processResultDescription;
	}
	public void setProcessResultDescription(String processResultDescription) {
		this.processResultDescription = processResultDescription;
	}
	public String getTimeConsuming() {
		return timeConsuming;
	}
	public void setTimeConsuming(String timeConsuming) {
		this.timeConsuming = timeConsuming;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	public String getCampusId() {
		return campusId;
	}
	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	

}

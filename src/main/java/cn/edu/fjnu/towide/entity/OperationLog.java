package cn.edu.fjnu.towide.entity;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class OperationLog {
    private String id;

    private String username;

    private String realName;

    private String nickName;
    
    private String operationContent;

    private Date operationDateTime;
    @SuppressWarnings("unused")
	private String operationDateTimeString;

    private String operationResult;

    private String reason;

    
    
    public String getOperationDateTimeString() {
    	return DateTimeUtil.getDateTimeString(getOperationDateTime());
	}

	public void setOperationDateTimeString(String operationDateTimeString) {
		this.operationDateTimeString = operationDateTimeString;
	}
	
	

	public OperationLog(String id, String username, String realName, String nickName, String operationContent, Date operationDateTime, String operationResult, String reason) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.nickName = nickName;
        this.operationContent = operationContent;
        this.operationDateTime = operationDateTime;
        this.operationResult = operationResult;
        this.reason = reason;
    }

    public OperationLog() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent == null ? null : operationContent.trim();
    }

    public Date getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(Date operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    public String getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult == null ? null : operationResult.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }
}
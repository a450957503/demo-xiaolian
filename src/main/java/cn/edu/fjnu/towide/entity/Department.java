package cn.edu.fjnu.towide.entity;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class Department {
    private String id;

    private Integer sequenceNumber;

    private String name;

    private String parentDepartmentId;

    private String introduction;

    private Date createDateTime;

    private String createDateTimeString;
    
    private Date lastUpdateTime;

    public Department(String id, Integer sequenceNumber, String name, String parentDepartmentId, String introduction, Date createDateTime, Date lastUpdateTime) {
        this.id = id;
        this.sequenceNumber = sequenceNumber;
        this.name = name;
        this.parentDepartmentId = parentDepartmentId;
        this.introduction = introduction;
        this.createDateTime = createDateTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Department() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentDepartmentId() {
        return parentDepartmentId;
    }

    public void setParentDepartmentId(String parentDepartmentId) {
        this.parentDepartmentId = parentDepartmentId == null ? null : parentDepartmentId.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }
    public void setCreateDateTime(Date createDateTime) {
    	this.createDateTime=createDateTime;
    	this.createDateTimeString=DateTimeUtil.getDateTimeString(createDateTime);
    }


    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

	public String getCreateDateTimeString() {
		return createDateTimeString;
	}


}
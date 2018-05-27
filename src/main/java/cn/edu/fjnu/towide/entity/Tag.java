package cn.edu.fjnu.towide.entity;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class Tag {
    private String id;

    private String name;

    private Integer frequency;

    private Date createDateTime;
	private String createDateTimeString;
    
    private Date lastUpdateDateTime;
	private String lastUpdateDateTimeString;


	public void setCreateDateTimeString(String createDateTimeString) {
		this.createDateTimeString = createDateTimeString;
	}



	public void setLastUpdateDateTimeString(String lastUpdateDateTimeString) {
		this.lastUpdateDateTimeString = lastUpdateDateTimeString;
	}
	

	public Tag(String id, String name, Integer frequency, Date createDateTime, Date lastUpdateDateTime) {

        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.createDateTime = createDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public Tag() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
        this.createDateTimeString = DateTimeUtil.getDateTimeString(createDateTime);
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.lastUpdateDateTimeString = DateTimeUtil.getDateTimeString(lastUpdateDateTime);
    }

	public String getCreateDateTimeString() {
		return createDateTimeString;
	}

	public String getLastUpdateDateTimeString() {
		return lastUpdateDateTimeString;
	}
}
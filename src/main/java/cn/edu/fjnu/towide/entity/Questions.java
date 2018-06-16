package cn.edu.fjnu.towide.entity;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class Questions {
	private String id;

	private Integer sequenceNumber;

    private String title;
    
    private String content;
    
    private String imgNames;
    
    public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String departmentId;

    private String departmentName;

    private String state;

    private Integer frequency;

    private String username;

    private String realName;

    private String nickName;

    private String topOrNot;

    private Integer numberOfEvaluators;

    private Integer totalStars;

    private Date createDateTime;
    @SuppressWarnings("unused")
	private String createDateTimeString;
    
    
    private Date lastUpdateDateTime;
	private String lastUpdateDateTimeString;
    
    public String getCreateDateTimeString() {
    	return DateTimeUtil.getDateTimeString(getCreateDateTime());
	}

	public String getLastUpdataDateTimeString() {
		return DateTimeUtil.getDateTimeString(getLastUpdataDateTime());
	}

	public void setLastUpdataDateTimeString(String lastUpdataDateTimeString) {
		this.lastUpdateDateTimeString = lastUpdataDateTimeString;
	}

	public Questions(String id, Integer sequenceNumber, String title, String content, String departmentId,
			String departmentName, String state, Integer frequency, String username, String realName, String nickName,
			String topOrNot, Integer numberOfEvaluators, Integer totalStars, Date createDateTime,
			Date lastUpdataDateTime) {
		this.id = id;
		this.sequenceNumber = sequenceNumber;
		this.title = title;
		this.content = content;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.state = state;
		this.frequency = frequency;
		this.username = username;
		this.realName = realName;
		this.nickName = nickName;
		this.topOrNot = topOrNot;
		this.numberOfEvaluators = numberOfEvaluators;
		this.totalStars = totalStars;
		this.createDateTime = createDateTime;
		this.lastUpdateDateTime = lastUpdataDateTime;
	}

	public Questions() {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId == null ? null : departmentId.trim();
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName == null ? null : departmentName.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
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

	public String getTopOrNot() {
		return topOrNot;
	}

	public void setTopOrNot(String topOrNot) {
		this.topOrNot = topOrNot == null ? null : topOrNot.trim();
	}

	public Integer getNumberOfEvaluators() {
		return numberOfEvaluators;
	}

	public void setNumberOfEvaluators(Integer numberOfEvaluators) {
		this.numberOfEvaluators = numberOfEvaluators;
	}

	public Integer getTotalStars() {
		return totalStars;
	}

	public void setTotalStars(Integer totalStars) {
		this.totalStars = totalStars;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
		this.createDateTimeString = DateTimeUtil.getDateTimeString(createDateTime);
	}

	public String getUpdateDateTimeString() {
		return lastUpdateDateTimeString;
	}

	public Date getLastUpdataDateTime() {
		return lastUpdateDateTime;
	}


    public void setLastUpdataDateTime(Date lastUpdataDateTime) {
        this.lastUpdateDateTime = lastUpdataDateTime;
    }

	public String getImgNames() {
		return imgNames;
	}

	public void setImgNames(String imgNames) {
		this.imgNames = imgNames;
	}

}
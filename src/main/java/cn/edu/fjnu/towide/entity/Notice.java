package cn.edu.fjnu.towide.entity;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class Notice {
    private String id;

    private String title;

    private String content;

    private String publisherUsername;

    private String publisherRealName;

    private String publisherNickName;

    private String state;

    private Date createDateTime;
    
    @SuppressWarnings("unused")
	private String createDateTimeString;
    
    private Date updateDateTime;
    


	@SuppressWarnings("unused")
	private String updateDateTimeString;


    public Notice(String id, String title, String content, String publisherUsername, String publisherRealName, String publisherNickName, String state, Date createDateTime, Date updateDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publisherUsername = publisherUsername;
        this.publisherRealName = publisherRealName;
        this.publisherNickName = publisherNickName;
        this.state = state;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public Notice() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPublisherUsername() {
        return publisherUsername;
    }

    public void setPublisherUsername(String publisherUsername) {
        this.publisherUsername = publisherUsername == null ? null : publisherUsername.trim();
    }

    public String getPublisherRealName() {
        return publisherRealName;
    }

    public void setPublisherRealName(String publisherRealName) {
        this.publisherRealName = publisherRealName == null ? null : publisherRealName.trim();
    }

    public String getPublisherNickName() {
        return publisherNickName;
    }

    public void setPublisherNickName(String publisherNickName) {
        this.publisherNickName = publisherNickName == null ? null : publisherNickName.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
        this.createDateTimeString=DateTimeUtil.getDateTimeString(createDateTime);
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
        this.updateDateTimeString=DateTimeUtil.getDateTimeString(updateDateTime);
    }


	public String getCreateDateTimeString() {
		return DateTimeUtil.getDateTimeString(getCreateDateTime());
	}

	public void setCreateDateTimeString(String createDateTimeString) {
		this.createDateTimeString = createDateTimeString;
	}

	public String getUpdateDateTimeString() {
		return DateTimeUtil.getDateTimeString(getUpdateDateTime());
	}

	public void setUpdateDateTimeString(String updateDateTimeString) {
		this.updateDateTimeString = updateDateTimeString;

	}
}
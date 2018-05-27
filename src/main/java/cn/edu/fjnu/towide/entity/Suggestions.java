package cn.edu.fjnu.towide.entity;

import java.util.Date;

public class Suggestions {
    private String id;

    private String username;

    private String realName;

    private String nickName;

    private String content;

    private Date dateTime;

    public Suggestions(String id, String username, String realName, String nickName, String content, Date dateTime) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.nickName = nickName;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Suggestions() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
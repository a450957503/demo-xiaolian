package cn.edu.fjnu.towide.entity;

public class GroupMembers {
    private Long id;

    private String username;

    private Long groupId;

    public GroupMembers(Long id, String username, Long groupId) {
        this.id = id;
        this.username = username;
        this.groupId = groupId;
    }

    public GroupMembers() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
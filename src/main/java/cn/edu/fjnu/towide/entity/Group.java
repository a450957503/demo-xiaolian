package cn.edu.fjnu.towide.entity;

import java.util.List;

public class Group {
    private Long id;

    private String groupName;

    private String description;
    private String remark;
    private List<User> users;
    private List<GroupAuthorities> groupAuthorities;
    
    public Group(Long id, String groupName, String remark) {
        this.id = id;
        this.groupName = groupName;
        this.remark = remark;
    }

    public Group() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the groupAuthorities
	 */
	public List<GroupAuthorities> getGroupAuthorities() {
		return groupAuthorities;
	}

	/**
	 * @param groupAuthorities the groupAuthorities to set
	 */
	public void setGroupAuthorities(List<GroupAuthorities> groupAuthorities) {
		this.groupAuthorities = groupAuthorities;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
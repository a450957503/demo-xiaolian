package cn.edu.fjnu.towide.entity;

public class GroupAuthorities {
    private Long id;

    private Long groupId;

    private String authority;
    private String description;

    public GroupAuthorities(Long id, Long groupId, String authority) {
        this.id = id;
        this.groupId = groupId;
        this.authority = authority;
    }

    public GroupAuthorities() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
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
}
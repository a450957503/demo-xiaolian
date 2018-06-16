package cn.edu.fjnu.towide.entity;

public class ManagementInterfaceMenuItem {
    private String id;

    private String name;

    private String authority;

    private String description;
    
    private String remark;

    public ManagementInterfaceMenuItem(String id, String name, String authority, String description, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.authority = authority;
		this.description = description;
		this.remark = remark;
	}

	public ManagementInterfaceMenuItem() {
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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
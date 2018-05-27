package cn.edu.fjnu.towide.entity;

import java.util.Date;
import java.util.List;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class User {
	public static final String VERIFICATION_CODE_MAXIMUM_PERIOD = "5*60";

	public static final String DEFAULT_PASSWORD = "888888";// 初始密码
	private String username;
	private String phone;
	private String realName;
	private Integer type;
	private String verificationCode;
	private String password;
	private int unreadPrivateMessageNumber;
	private int unreadPublicMessageNumber;
	private String weiboLoginId;
    private String qqLoginId;
    private String wechatLoginId;
    private String email;
    private String gender;
    private String nickname;
    private Date birthday;
    private String head;
    private Date lastLoginDateTime;
    private String lastLoginIp;
    private String state;
    private Date createDateTime;
    private Date lastUpdateTime;
    private Integer enabled; 
    
	private String createDateTimeString;
	private String lastUpdateTimeString;
	private String birthdayString;
	
	
    private List<Authority>authorities;
    private List<Group> groups;
    
	


	private String logisticsStorageCenterId;


	public String getWeiboLoginId() {
		return weiboLoginId;
	}

	public void setWeiboLoginId(String weiboLoginId) {
		this.weiboLoginId = weiboLoginId;
	}

	public String getQqLoginId() {
		return qqLoginId;
	}

	public void setQqLoginId(String qqLoginId) {
		this.qqLoginId = qqLoginId;
	}

	public String getWechatLoginId() {
		return wechatLoginId;
	}

	public void setWechatLoginId(String wechatLoginId) {
		this.wechatLoginId = wechatLoginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
		this.birthdayString = DateTimeUtil.getDateTimeString(birthday);
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}

	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
		this.createDateTimeString = DateTimeUtil.getDateTimeString(createDateTime);
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateTimeString = DateTimeUtil.getDateTimeString(lastUpdateTime);
	}


	public String getUpdateDateTimeString() {
		return lastUpdateTimeString;
	}

	public static String getVerificationCodeMaximumPeriod() {
		return VERIFICATION_CODE_MAXIMUM_PERIOD;
	}

	public static String getDefaultPassword() {
		return DEFAULT_PASSWORD;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", phone=" + phone + ", realName=" + realName + ", type=" + type
				+ ", verificationCode=" + verificationCode + ", password=" + password + ", unreadPrivateMessageNumber="
				+ unreadPrivateMessageNumber + ", unreadPublicMessageNumber=" + unreadPublicMessageNumber
				+ ", weiboLoginId=" + weiboLoginId + ", qqLoginId=" + qqLoginId + ", wechatLoginId=" + wechatLoginId
				+ ", email=" + email + ", gender=" + gender + ", nickname=" + nickname + ", birthday=" + birthday
				+ ", head=" + head + ", lastLoginDateTime=" + lastLoginDateTime + ", lastLoginIp=" + lastLoginIp
				+ ", state=" + state + ", createDateTime=" + createDateTime + ", lastUpdateTime=" + lastUpdateTime
				+ ", logisticsStorageCenterId=" + logisticsStorageCenterId + "]";
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getUnreadPrivateMessageNumber() {
		return unreadPrivateMessageNumber;
	}

	public void setUnreadPrivateMessageNumber(int unreadPrivateMessageNumber) {
		this.unreadPrivateMessageNumber = unreadPrivateMessageNumber;
	}

	public int getUnreadPublicMessageNumber() {
		return unreadPublicMessageNumber;
	}

	public void setUnreadPublicMessageNumber(int unreadPublicMessageNumber) {
		this.unreadPublicMessageNumber = unreadPublicMessageNumber;
	}

	public int getUnreadMessageNumber() {
		int unreadMessageNumber = this.unreadPrivateMessageNumber + this.unreadPublicMessageNumber;
		return unreadMessageNumber;
	}

	public String getLogisticsStorageCenterId() {
		return logisticsStorageCenterId;
	}

	public void setLogisticsStorageCenterId(String logisticsStorageCenterId) {
		this.logisticsStorageCenterId = logisticsStorageCenterId;
	}

	public User(String username, String phone, String realName, Integer type, String verificationCode, String password,
			int unreadPrivateMessageNumber, int unreadPublicMessageNumber, String weiboLoginId, String qqLoginId,
			String wechatLoginId, String email, String gender, String nickname, Date birthday, String head,
			Date lastLoginDateTime, String lastLoginIp, String state, Date createDateTime, Date lastUpdateTime,
			String logisticsStorageCenterId) {
		super();
		this.username = username;
		this.phone = phone;
		this.realName = realName;
		this.type = type;
		this.verificationCode = verificationCode;
		this.password = password;
		this.unreadPrivateMessageNumber = unreadPrivateMessageNumber;
		this.unreadPublicMessageNumber = unreadPublicMessageNumber;
		this.weiboLoginId = weiboLoginId;
		this.qqLoginId = qqLoginId;
		this.wechatLoginId = wechatLoginId;
		this.email = email;
		this.gender = gender;
		this.nickname = nickname;
		this.birthday = birthday;
		this.head = head;
		this.lastLoginDateTime = lastLoginDateTime;
		this.lastLoginIp = lastLoginIp;
		this.state = state;
		this.createDateTime = createDateTime;
		this.lastUpdateTime = lastUpdateTime;
		this.logisticsStorageCenterId = logisticsStorageCenterId;
	}
	public User() {
		super();
	}

	/**
	 * @return the groups
	 */
	public List<Group> getGroups() {
		return groups;
	}
	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	/**
	 * @return the authorities
	 */
	public List<Authority> getAuthorities() {
		return authorities;
	}
	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	/**
	 * @return the enabled
	 */
	public Integer getEnabled() {
		return enabled;
	}
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public String getCreateDateTimeString() {
		return createDateTimeString;
	}
	public void setCreateDateTimeString(String createDateTimeString) {
		this.createDateTimeString = createDateTimeString;
	}
	public String getLastUpdateTimeString() {
		return lastUpdateTimeString;
	}
	public void setLastUpdateTimeString(String lastUpdateTimeString) {
		this.lastUpdateTimeString = lastUpdateTimeString;
	}
	public String getBirthdayString() {
		return birthdayString;
	}
	public void setBirthdayString(String birthdayString) {
		this.birthdayString = birthdayString;
	}
	
	
	

}

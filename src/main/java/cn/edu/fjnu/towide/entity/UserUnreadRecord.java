package cn.edu.fjnu.towide.entity;

public class UserUnreadRecord {
	
	private String username;
	private String realName;
	private String nickName;
	private Integer noticeUnreadNum;
	private Integer solvedQuestionUnreadnum;
	private Integer unsolvedQuestionUnreadNum;
	
	public UserUnreadRecord() {
		super();
	}

	public UserUnreadRecord(String username, String realName, String nickName, Integer noticeUnreadNum,
			Integer solvedQuestionUnreadnum, Integer unsolvedQuestionUnreadNum) {
		super();
		this.username = username;
		this.realName = realName;
		this.nickName = nickName;
		this.noticeUnreadNum = noticeUnreadNum;
		this.solvedQuestionUnreadnum = solvedQuestionUnreadnum;
		this.unsolvedQuestionUnreadNum = unsolvedQuestionUnreadNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getNoticeUnreadNum() {
		return noticeUnreadNum;
	}

	public void setNoticeUnreadNum(Integer noticeUnreadNum) {
		this.noticeUnreadNum = noticeUnreadNum;
	}

	public Integer getSolvedQuestionUnreadnum() {
		return solvedQuestionUnreadnum;
	}

	public void setSolvedQuestionUnreadnum(Integer solvedQuestionUnreadnum) {
		this.solvedQuestionUnreadnum = solvedQuestionUnreadnum;
	}

	public Integer getUnsolvedQuestionUnreadNum() {
		return unsolvedQuestionUnreadNum;
	}

	public void setUnsolvedQuestionUnreadNum(Integer unsolvedQuestionUnreadNum) {
		this.unsolvedQuestionUnreadNum = unsolvedQuestionUnreadNum;
	}
	
	
}

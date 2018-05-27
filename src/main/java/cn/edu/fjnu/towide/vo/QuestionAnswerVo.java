package cn.edu.fjnu.towide.vo;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class QuestionAnswerVo {
	private String id;

	private String questionerUsername;

	private String questionerRealName;

	private String questionerNickName;

	private String responderUsername;

	private String responderRealName;

	private String responderNickName;

	private String questionContent;

    private Date questionDateTime;
	private String questionDateTimeString;

	private String answerContent;

    private Date answerDateTime;
	private String answerDateTimeString;

	private String mainQuestionId;

	private String remark;

	private Integer stars;

	private Integer sequenceNumber;

	private Integer addQuestionNumber;

	private String state;
	
	private String questionerImgNames;
	
	private String answererImgNames;
	
	private Integer restSeconds;
	
	private String questionerReadState;
	
	private String answererReadState;

	public QuestionAnswerVo(String id, String questionerUsername, String questionerRealName, String questionerNickName,
			String responderUsername, String responderRealName, String responderNickName, String questionContent,
			Date questionDateTime, String questionDateTimeString, String answerContent, Date answerDateTime,
			String answerDateTimeString, String mainQuestionId, String remark, Integer stars, Integer sequenceNumber,
			Integer addQuestionNumber, String state, String questionerImgNames, String answererImgNames,
			Integer restSeconds, String lastUpdateTimeString, String questionerReadState, String answererReadState) {
		super();
		this.id = id;
		this.questionerUsername = questionerUsername;
		this.questionerRealName = questionerRealName;
		this.questionerNickName = questionerNickName;
		this.responderUsername = responderUsername;
		this.responderRealName = responderRealName;
		this.responderNickName = responderNickName;
		this.questionContent = questionContent;
		this.questionDateTime = questionDateTime;
		this.questionDateTimeString = questionDateTimeString;
		this.answerContent = answerContent;
		this.answerDateTime = answerDateTime;
		this.answerDateTimeString = answerDateTimeString;
		this.mainQuestionId = mainQuestionId;
		this.remark = remark;
		this.stars = stars;
		this.sequenceNumber = sequenceNumber;
		this.addQuestionNumber = addQuestionNumber;
		this.state = state;
		this.questionerImgNames = questionerImgNames;
		this.answererImgNames = answererImgNames;
		this.restSeconds = restSeconds;
		this.lastUpdateTimeString = lastUpdateTimeString;
		this.questionerReadState = questionerReadState;
		this.answererReadState = answererReadState;
	}

	public QuestionAnswerVo() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getQuestionerUsername() {
		return questionerUsername;
	}

	public void setQuestionerUsername(String questionerUsername) {
		this.questionerUsername = questionerUsername == null ? null : questionerUsername.trim();
	}

	public String getQuestionerRealName() {
		return questionerRealName;
	}

	public void setQuestionerRealName(String questionerRealName) {
		this.questionerRealName = questionerRealName == null ? null : questionerRealName.trim();
	}

	public String getQuestionerNickName() {
		return questionerNickName;
	}

	public void setQuestionerNickName(String questionerNickName) {
		this.questionerNickName = questionerNickName == null ? null : questionerNickName.trim();
	}

	public String getResponderUsername() {
		return responderUsername;
	}

	public void setResponderUsername(String responderUsername) {
		this.responderUsername = responderUsername == null ? null : responderUsername.trim();
	}

	public String getResponderRealName() {
		return responderRealName;
	}

	public void setResponderRealName(String responderRealName) {
		this.responderRealName = responderRealName == null ? null : responderRealName.trim();
	}

	public String getResponderNickName() {
		return responderNickName;
	}

	public void setResponderNickName(String responderNickName) {
		this.responderNickName = responderNickName == null ? null : responderNickName.trim();
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent == null ? null : questionContent.trim();
	}

	public Date getQuestionDateTime() {
		return questionDateTime;
	}

	public void setQuestionDateTime(Date questionDateTime) {
		this.questionDateTime = questionDateTime;
		this.questionDateTimeString = DateTimeUtil.getDateTimeString(questionDateTime);
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent == null ? null : answerContent.trim();
	}

	public Date getAnswerDateTime() {
		return answerDateTime;
	}

	public void setAnswerDateTime(Date answerDateTime) {
		this.answerDateTime = answerDateTime;
		this.answerDateTimeString = DateTimeUtil.getDateTimeString(answerDateTime);
	}

	public String getMainQuestionId() {
		return mainQuestionId;
	}

	public void setMainQuestionId(String mainQuestionId) {
		this.mainQuestionId = mainQuestionId == null ? null : mainQuestionId.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public Integer getAddQuestionNumber() {
		return addQuestionNumber;
	}

	public void setAddQuestionNumber(Integer addQuestionNumber) {
		this.addQuestionNumber = addQuestionNumber;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getQuestionDateTimeString() {
		return questionDateTimeString;
	}

	public String getAnswerDateTimeString() {
		return answerDateTimeString;
	}

	
	
	private String lastUpdateTimeString;//最后更新时间
	
	public String getLastUpdateTimeString() {
		return lastUpdateTimeString;
	}

	public void setLastUpdateTimeString(Date lastUpdateTime) {
		if(lastUpdateTime!=null)
			this.lastUpdateTimeString = DateTimeUtil.getDateTimeString(lastUpdateTime);
	}

	public String getAnswererImgNames() {
		return answererImgNames;
	}

	public void setAnswererImgNames(String answererImgNames) {
		this.answererImgNames = answererImgNames;
	}

	public String getQuestionerImgNames() {
		return questionerImgNames;
	}

	public void setQuestionerImgNames(String questionerImgNames) {
		this.questionerImgNames = questionerImgNames;
	}

	public Integer getRestSeconds() {
		return restSeconds;
	}

	public void setRestSeconds(Integer restSeconds) {
		this.restSeconds = restSeconds;
	}

	public String getQuestionerReadState() {
		return questionerReadState;
	}

	public void setQuestionerReadState(String questionerReadState) {
		this.questionerReadState = questionerReadState;
	}

	public String getAnswererReadState() {
		return answererReadState;
	}

	public void setAnswererReadState(String answererReadState) {
		this.answererReadState = answererReadState;
	}
}

package cn.edu.fjnu.towide.entity;

import java.util.Date;

import cn.edu.fjnu.towide.utils.DateTimeUtil;

public class QuestionEvaluation {
    private String id;

    private String questionId;

    private String evaluatorUsername;

    private String evaluatorRealName;

    private String evaluatorNickName;

    private Integer stars;
    
    private Date createDateTime;
    
    private String createDateTimeString;
    
    public QuestionEvaluation(String id, String questionId, String evaluatorUsername, String evaluatorRealName,
			String evaluatorNickName, Integer stars, Date createDateTime) {
		super();
		this.id = id;
		this.questionId = questionId;
		this.evaluatorUsername = evaluatorUsername;
		this.evaluatorRealName = evaluatorRealName;
		this.evaluatorNickName = evaluatorNickName;
		this.stars = stars;
		this.createDateTime = createDateTime;
	}

	public QuestionEvaluation() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
    }

    public String getEvaluatorUsername() {
        return evaluatorUsername;
    }

    public void setEvaluatorUsername(String evaluatorUsername) {
        this.evaluatorUsername = evaluatorUsername == null ? null : evaluatorUsername.trim();
    }

    public String getEvaluatorRealName() {
        return evaluatorRealName;
    }

    public void setEvaluatorRealName(String evaluatorRealName) {
        this.evaluatorRealName = evaluatorRealName == null ? null : evaluatorRealName.trim();
    }

    public String getEvaluatorNickName() {
        return evaluatorNickName;
    }

    public void setEvaluatorNickName(String evaluatorNickName) {
        this.evaluatorNickName = evaluatorNickName == null ? null : evaluatorNickName.trim();
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
		this.createDateTimeString=DateTimeUtil.getDateTimeString(createDateTime);
	}

	public String getCreateDateTimeString() {
		return createDateTimeString;
	}
}
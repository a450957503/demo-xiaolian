package cn.edu.fjnu.towide.entity;

public class QuestionAnswerStatistics {
    private String username;

    private String realName;

    private String nickName;

    private Integer questionAnswerNumber;

    private Integer questionAnswerEvaluation;

    public QuestionAnswerStatistics(String username, String realName, String nickName, Integer questionAnswerNumber, Integer questionAnswerEvaluation) {
        this.username = username;
        this.realName = realName;
        this.nickName = nickName;
        this.questionAnswerNumber = questionAnswerNumber;
        this.questionAnswerEvaluation = questionAnswerEvaluation;
    }

    public QuestionAnswerStatistics() {
        super();
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

    public Integer getQuestionAnswerNumber() {
        return questionAnswerNumber;
    }

    public void setQuestionAnswerNumber(Integer questionAnswerNumber) {
        this.questionAnswerNumber = questionAnswerNumber;
    }

    public Integer getQuestionAnswerEvaluation() {
        return questionAnswerEvaluation;
    }

    public void setQuestionAnswerEvaluation(Integer questionAnswerEvaluation) {
        this.questionAnswerEvaluation = questionAnswerEvaluation;
    }
}
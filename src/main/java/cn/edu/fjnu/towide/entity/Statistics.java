package cn.edu.fjnu.towide.entity;

public class Statistics {
    private String id;

    private Long userCount;

    private Long questionCount;

    public Statistics(String id, Long userCount, Long questionCount) {
        this.id = id;
        this.userCount = userCount;
        this.questionCount = questionCount;
    }

    public Statistics() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    public Long getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Long questionCount) {
        this.questionCount = questionCount;
    }
}
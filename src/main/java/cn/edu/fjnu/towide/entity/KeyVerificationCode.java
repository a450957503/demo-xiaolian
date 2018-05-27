package cn.edu.fjnu.towide.entity;

import java.util.Date;

public class KeyVerificationCode {
    private String keyWord;

    private String verificationCode;

    private Date generateTime;

    public KeyVerificationCode(String keyWord, String verificationCode, Date generateTime) {
        this.keyWord = keyWord;
        this.verificationCode = verificationCode;
        this.generateTime = generateTime;
    }

    public KeyVerificationCode() {
        super();
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode == null ? null : verificationCode.trim();
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }
}
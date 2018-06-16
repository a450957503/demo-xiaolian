package cn.edu.fjnu.towide.enums;

public enum PictureType {
	
    QUESTION(0,"QUESTION"),
    ANSWER(1,"ANSWER"),
    QUESTION_BANK(10,"QUESTION_BANK");
	
    private final int code;
    private final String desc;
    PictureType(int code,String desc){
        this.code=code;
        this.desc=desc;
    }
    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}

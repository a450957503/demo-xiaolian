package cn.edu.fjnu.towide.exception;

public class ParamWrongFormatException extends RuntimeException{
	
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
//		return super.getMessage();
		return "请求参数格式不符合接口要求";
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

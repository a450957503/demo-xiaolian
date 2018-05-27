package cn.edu.fjnu.towide.entity;

public class RequestData {
	private RequestHead head;
	private Object param;
	public RequestHead getHead() {
		return head;
	}
	public void setHead(RequestHead head) {
		this.head = head;
	}
	public Object getParam() {
		return param;
	}
	public void setParam(Object param) {
		this.param = param;
	}
	
}

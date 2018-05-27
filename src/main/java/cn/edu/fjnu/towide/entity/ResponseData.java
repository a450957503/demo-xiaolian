package cn.edu.fjnu.towide.entity;

public class ResponseData {
	private ResponseHead head;
	private Object data;
	public ResponseHead getHead() {
		return head;
	}
	public void setHead(ResponseHead head) {
		this.head = head;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}

package cn.edu.fjnu.towide.utils;

import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;

public class ResponseHeadUtil {
	public static ResponseHead createResponseHead(ResponseHeadEnums responseHeadEnum) {
		ResponseHead responseHead = new ResponseHead();
		responseHead.setCode(responseHeadEnum.getCode());
		responseHead.setMsg(responseHeadEnum.getMsg());
		return responseHead;
	}

}

package cn.edu.fjnu.towide.usercenter.service;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.common.service.CommonService;
import cn.edu.fjnu.towide.constant.ReasonOfFailureConstant;
import cn.edu.fjnu.towide.dao.KeyVerificationCodeDao;
import cn.edu.fjnu.towide.dao.UserDao;
import cn.edu.fjnu.towide.entity.ResponseData;
import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;
import cn.edu.fjnu.towide.utils.GraphicHelper;
import cn.edu.fjnu.towide.utils.IdGenerator;
import cn.edu.fjnu.towide.utils.ResponseHeadUtil;
@Service
public class UserCenterService {
	@Autowired
	UserDao usersDao;
	@Autowired
	CommonService commonService;
	@Autowired
	KeyVerificationCodeDao keyVerificationCodeDao;


	public void getPhoneVerificationCodeRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {
		@SuppressWarnings("unchecked")
		Map<String, String> param = (Map<String, String>) requestMap.get("param");
		String userNameOrPhone = param.get("userNameOrPhone");
		User user = usersDao.getUserByUserNameOrPhone(userNameOrPhone);
		ResponseHead responseHead;
		if (user == null) {
			String reasonOfFailure=ReasonOfFailureConstant.USER_NOT_EXIST;
			commonService.setResponseDataWithFailureInfo(responseData, reasonOfFailure);
			return;
		}

		String verificationCode = "" + Math.round(((1 + new Random().nextInt(9) + Math.random()) * 100000));

		if (!usersDao.updateVerificationCodeByUserName(user.getUsername(), verificationCode)) {
			String reasonOfFailure=ReasonOfFailureConstant.UPDATE_PHONE_VERIFICATION_CODE_FAILURE;
			commonService.setResponseDataWithFailureInfo(responseData, reasonOfFailure);
			return;
		}


		responseHead = ResponseHeadUtil.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_OPERATION_SUCCESS);
		responseData.setHead(responseHead);
		//暂时直接返回，后面将通过短信
		responseData.setData(verificationCode);
		
		//短信接口还未开发，暂时注释， 此处添加短信发送代码，如果发送成功，才将验证码写入数据库，否则，显示验证码发送失败信息
/*		String phoneNumber=user.getPhone();
		String templateCode=SmsSendService.GET_VERIFICATION_CODE_TEMPLATE_CODE;
		JSONObject templateParamJson=new JSONObject();
		templateParamJson.put("verificationCode", verificationCode);
		String templateParam=templateParamJson.toJSONString();
		smsSendService.sendSms(phoneNumber, templateCode, templateParam);
*/		

	
	}


	public void getLoginVerificationCodeRequestProcess(Map<String, Object> requestMap, ResponseData responseData) {

		
		String key=IdGenerator.getId();
//		String verificationCode = "" + Math.round(((1 + new Random().nextInt(9) + Math.random()) * 1000));

		ByteArrayOutputStream output=new ByteArrayOutputStream();
		int width=90;
		int height=40;
		String imgType="jpeg";
		String verificationCode=GraphicHelper.create(width, height, imgType, output);
		byte[]verificationCodeByteArray=output.toByteArray();
		
		verificationCodeByteArray=Base64Utils.encode(verificationCodeByteArray);
		String verificationCodeImgBase64Encode=new String(verificationCodeByteArray);

		boolean result=keyVerificationCodeDao.addKeyVerificationCode(key,verificationCode);
		if (!result) {
			String reasonOfFailure=ReasonOfFailureConstant.GENERATE_LOGIN_VERIFICATION_CODE_FAILURE;
			commonService.setResponseDataWithFailureInfo(responseData, reasonOfFailure);
			return;
		}


		// 验证码将以图片的方式返回

		commonService.setHeadForResponseDataWithResponseHeadOfSuccess(responseData);
		JSONObject data=new JSONObject();
		data.put("key", key);
//		data.put("verificationCode", verificationCode);
		data.put("verificationCodeImgBase64Encode", verificationCodeImgBase64Encode);
		responseData.setData(data);
		
		
	}



}

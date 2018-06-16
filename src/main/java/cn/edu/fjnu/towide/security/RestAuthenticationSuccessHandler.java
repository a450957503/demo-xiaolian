package cn.edu.fjnu.towide.security;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/*import cn.edu.fjnu.towide.dao.DepartmentUsersDao;
import cn.edu.fjnu.towide.dao.UserSectionsDao;
*/import cn.edu.fjnu.towide.dao.UserDao;
import cn.edu.fjnu.towide.entity.ResponseHead;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.enums.ResponseHeadEnums;
import cn.edu.fjnu.towide.utils.HttpServletRequestUtil;
import cn.edu.fjnu.towide.utils.ResponseHeadUtil;





@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	UserDao UserDao;
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	    response.setCharacterEncoding("UTF-8");  
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter out = response.getWriter();
		
		//创建head
		ResponseHead head=ResponseHeadUtil.createResponseHead(ResponseHeadEnums.RESPONSEHEAD_OPERATION_SUCCESS);
		head.setFunctionNo(HttpServletRequestUtil.getFunctionNo(request));
		//因为认证是在请求到达目标之前进行的，所以认证的结果保存在header中，此处拿出来放到json中，方便客户端的使用
/*		String token=response.getHeader("remember-me");
		head.setToken(token);
*/	
		
		
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("head", head);
		
		String userName=authentication.getName();
		User user=UserDao.getUserByUserName(userName);
/*		if (user.getType()==User.TYPE_STUDENT||user.getType()==user.TYPE_TEACHER) {
			int unreadPublicMessageNumber=departmentUsersDao.getUnReadPublicMessageNumber(userName);
			user.setUnreadPublicMessageNumber(unreadPublicMessageNumber);
		}
		List<String>sectionIds=null;
		if (user.getType()==User.TYPE_RESERVATION_ASSESSOR) {
			sectionIds=userSectionsDao.getSectionIdsByUsername(userName);
		}
*/
		JSONObject data=new JSONObject();
		data.put("user", user);
//		data.put("sectionIds", sectionIds);
		jsonObject.put("data", data);
		
		out.println(jsonObject.toJSONString());
		out.flush();
		out.close();
	}
}
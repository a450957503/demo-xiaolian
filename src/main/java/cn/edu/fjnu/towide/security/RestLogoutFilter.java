package cn.edu.fjnu.towide.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import cn.edu.fjnu.towide.constant.AuthorityConstants;
import cn.edu.fjnu.towide.utils.HttpServletRequestUtil;

public class RestLogoutFilter extends LogoutFilter{

	public RestLogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler...handlers) {
		super(logoutSuccessHandler, handlers);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean requiresLogout(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("requirlogout");
		String functionNo=HttpServletRequestUtil.getFunctionNo(request);
		if (functionNo!=null&&functionNo.equals(AuthorityConstants.LOG_OUT)) {
			return true;
		}
		return false;
//		return super.requiresLogout(request, response);
	}
	
}

package cn.edu.fjnu.towide.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.alibaba.fastjson.JSONObject;

import cn.edu.fjnu.towide.constant.AuthorityConstants;
import cn.edu.fjnu.towide.dao.KeyVerificationCodeDao;
import cn.edu.fjnu.towide.dao.UserDao;
import cn.edu.fjnu.towide.entity.User;
import cn.edu.fjnu.towide.utils.HttpServletRequestUtil;
//@Component
public class RestUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public static final String SPRING_SECURITY_RESTFUL_USERNAME_KEY = "username";
	public static final String SPRING_SECURITY_RESTFUL_PASSWORD_KEY = "password";
	public static final String SPRING_SECURITY_RESTFUL_LOGIN_URL = "/login";

	private String usernameParameter = SPRING_SECURITY_RESTFUL_USERNAME_KEY;
	private String passwordParameter = SPRING_SECURITY_RESTFUL_PASSWORD_KEY;
	private boolean postOnly = true;

	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	private KeyVerificationCodeDao keyVerificationCodeDao;
	public void setKeyVerificationCodeDao(KeyVerificationCodeDao keyVerificationCodeDao) {
		this.keyVerificationCodeDao = keyVerificationCodeDao;
	}
	
	
	
	//这个方法主要是用于判断是否是登录请求，如果返回为true，表示是登录请求，启动登录流程
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		logger.debug("判断是否是登录");
		String functionNo=HttpServletRequestUtil.getFunctionNo(request);
		if (functionNo==null) {
			return false;
		}
		if(functionNo.equals(AuthorityConstants.LOGIN_BY_PASSWORD)){
			return true;
		};
		if(functionNo.equals(AuthorityConstants.LOGIN_BY_PHONE_VERIFICATION_CODE)){
			return true;
		};
		if(functionNo.equals(AuthorityConstants.LOGIN_BY_VERIFICATION_AND_PASSWORD)){
			return true;
		};
		
		return false;
/*		boolean result=super.requiresAuthentication(request, response);
		logger.debug("requiresAuthentication:"+result);
		return result;
*///		return super.requiresAuthentication(request, response);
	}

	protected RestUsernamePasswordAuthenticationFilter() {
		super(new AntPathRequestMatcher(SPRING_SECURITY_RESTFUL_LOGIN_URL, "POST"));
	}
	
//    @Autowired
    @Override
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        logger.debug("setAuthenticationManager(AuthenticationManager) - start"); //$NON-NLS-1$
        super.setAuthenticationManager(authenticationManager);
        logger.debug("setAuthenticationManager(AuthenticationManager) - end"); //$NON-NLS-1$
    }
    

/*	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤过滤更健康！！！");
		super.doFilter(arg0, arg1, arg2);
	}
*/
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		System.out.println("我被执行啦啦啦");
		System.out.println(HttpServletRequestUtil.getParamByParamName(request, "loginType"));
	
		String loginType=HttpServletRequestUtil.getLoginType(request);
		System.out.println(loginType);
//		JSONObject jsonObject=JsonUtils.getJsonFromRequest(request);
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		/*		String username = obtainUsername(request);
		String password = obtainPassword(request);
*/
		String functionNo=HttpServletRequestUtil.getFunctionNo(request);

		JSONObject param=HttpServletRequestUtil.getRequestParam(request);
		//如果param为空，说明客户端发送的参数不符合接口要求，抛出异常
/*		if (param==null) {
			throw new ParamWrongFormatException();
		}
*/
		//只有当param非空时，才进行userName和password的读取操作，否则会报空指针异常
		String userName=null;
		String password=null;
		if (param!=null) {
			String userNameOrPhone=param.getString("userNameOrPhone");
			User user=userDao.getUserByUserNameOrPhone(userNameOrPhone);
			
			userName = user.getUsername();
			password=null;
			switch (functionNo) {
			case AuthorityConstants.LOGIN_BY_VERIFICATION_AND_PASSWORD:
				String key=param.getString("key");
				String verificationCode=param.getString("verificationCode");
				boolean result=checkKeyAndVerificationCode(key,verificationCode);
				if (!result) {
					userName=null;
					break;
				}
			case AuthorityConstants.LOGIN_BY_PASSWORD:
				password = param.getString("password");
				break;
			case AuthorityConstants.LOGIN_BY_PHONE_VERIFICATION_CODE:
//				userName=user.getUsername();
				password = param.getString("verificationCode");
			default:
				break;
			}
/*			if (functionNo.equals(AuthorityConstants.LOGIN_BY_PASSWORD)) {
			}
			
			if (functionNo.equals(AuthorityConstants.LOGIN_BY_VERIFICATION_CODE)) {
			}
*/		}

		
		
		if (userName == null) {
			userName = "";
		}

		if (password == null) {
			password = "";
		}

		userName = userName.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, password);

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}

	private boolean checkKeyAndVerificationCode(String key, String verificationCode) {
		boolean result=keyVerificationCodeDao.checkKeyAndVerificationCode(key,verificationCode);
		return result;
	}



	protected String obtainPassword(HttpServletRequest request) {
		return request.getParameter(passwordParameter);
	}

	protected String obtainUsername(HttpServletRequest request) {
		return request.getParameter(usernameParameter);
	}

	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	public String getUsernameParameter() {
		return usernameParameter;
	}

	public void setUsernameParameter(String usernameParameter) {
		this.usernameParameter = usernameParameter;
	}

	public String getPasswordParameter() {
		return passwordParameter;
	}

	public void setPasswordParameter(String passwordParameter) {
		this.passwordParameter = passwordParameter;
	}

	public boolean isPostOnly() {
		return postOnly;
	}

	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	public void setLoginUrl(String loginUrl) {
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(loginUrl, "POST"));
	}

}

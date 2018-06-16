package cn.edu.fjnu.towide.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

import cn.edu.fjnu.towide.constant.SecurityConstans;
import cn.edu.fjnu.towide.dao.KeyVerificationCodeDao;
import cn.edu.fjnu.towide.dao.UserDao;

//import cn.edu.fjnu.towide.constant.OtherConstans;

import cn.edu.fjnu.towide.filter.RequestAndResponseWrappterFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)//开启方法的权限注解式设置
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

	public static final int TOKEN_VALIDITY_SECONDS = 1*24*3600;
	@Autowired
	private DataSource dataSource;//数据源
	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;
	@Autowired
	private RestAuthenticationFailureHandler authenticationFailureHandler;
	@Autowired
	private RestAuthenticationSuccessHandler authenticationSuccessHandler;
	@Autowired
	private RestAuthenticationLogoutSuccessHandler restAuthenticationLogoutSuccessHandler;
	@Autowired
	private RestAccessDeniedHandler restAccessDeniedHandler;
	@Autowired
	private UserDao userDao;
	@Autowired
	private KeyVerificationCodeDao keyVerificationCodeDao;
	@Bean("JdbcUserDetailsManagerForLogin")
	public UserDetailsService jdbcUserDetailsServiceForLogin() {
		System.out.println("JdbcUserDetailsManagerForLogin");
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
		manager.setDataSource(dataSource);
		manager.setEnableGroups(true);
		manager.setUsersByUsernameQuery("select username,password,enabled from users where username = ? ");
		manager.setAuthoritiesByUsernameQuery("select username,authority from authorities where username = ? ");
		manager.setGroupAuthoritiesByUsernameQuery("select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authorities ga where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id");
		return manager;
	}
	
//	@Bean("JdbcUserDetailsManagerForLogin")
	public UserDetailsService jdbcUserDetailsServiceForVerificationCodeLogin() {
		System.out.println("jdbcUserDetailsServiceForVerificationCodeLogin");
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
		manager.setDataSource(dataSource);

		manager.setEnableGroups(true);
		//验证码的有效时间为5分钟
		manager.setUsersByUsernameQuery("select username,verification_code AS password,enabled from users where username = ?  AND UNIX_TIMESTAMP(NOW())-UNIX_TIMESTAMP(verification_code_generate_time)<"+SecurityConstans.MaximumPeriod);
		manager.setAuthoritiesByUsernameQuery("select username,authority from authorities where username = ? ");
		manager.setGroupAuthoritiesByUsernameQuery("select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authorities ga where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id");
		return manager;
	}

	
	
	
//	@Bean
	public RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter() throws Exception{
		RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter=new RestUsernamePasswordAuthenticationFilter();
		restUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
		restUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
		restUsernamePasswordAuthenticationFilter.setRememberMeServices(restPersistentTokenBasedRememberMeServices());
		restUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
		
		restUsernamePasswordAuthenticationFilter.setUserDao(userDao);
		restUsernamePasswordAuthenticationFilter.setKeyVerificationCodeDao(keyVerificationCodeDao);
		
		return restUsernamePasswordAuthenticationFilter;
		
	}
//	@Bean
	public RequestAndResponseWrappterFilter requestAndResponseWrappterFilter() throws Exception{
		RequestAndResponseWrappterFilter wrappterFilter=new RequestAndResponseWrappterFilter();
		return wrappterFilter;
		
	}
	@Bean
	public RestPersistentTokenBasedRememberMeServices restPersistentTokenBasedRememberMeServices(){
		RestPersistentTokenBasedRememberMeServices rememberMeServices=new RestPersistentTokenBasedRememberMeServices("ww", jdbcUserDetailsServiceForLogin(), jdbcTokenRepositoryImpl());
		rememberMeServices.setTokenValiditySeconds(TOKEN_VALIDITY_SECONDS);
		rememberMeServices.setParameter("remember-me-request");
		return rememberMeServices;
	}

	
	
	@Bean
	public JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl(){
		JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
		jdbcTokenRepositoryImpl.setDataSource(dataSource);
		return jdbcTokenRepositoryImpl;
	}
	
	public RestLogoutFilter restLogoutFilter(){
		RestLogoutFilter restLogoutFilter=new RestLogoutFilter(restAuthenticationLogoutSuccessHandler, restPersistentTokenBasedRememberMeServices());
		return restLogoutFilter;
	}
	
	@Bean
	public RememberMeAuthenticationFilter rememberMeAuthenticationFilter() throws Exception{
		RememberMeAuthenticationFilter rememberMeAuthenticationFilter=new RememberMeAuthenticationFilter(authenticationManager(), restPersistentTokenBasedRememberMeServices());
		return rememberMeAuthenticationFilter;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		AccessDeniedHandler accessDeniedHandler=new AccessDeniedHandlerImpl();
		return accessDeniedHandler;
	}

	
	
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.authenticationProvider(rememberMeAuthenticationProvider());
		builder.userDetailsService(jdbcUserDetailsServiceForLogin()).passwordEncoder(bCryptPasswordEncoder());
		builder.userDetailsService(jdbcUserDetailsServiceForVerificationCodeLogin());
	}
	@Bean
	public RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
		RememberMeAuthenticationProvider rememberMeAuthenticationProvider=new RememberMeAuthenticationProvider("ww");
		return rememberMeAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.requiresChannel().antMatchers("/security","/login","/logout").requiresSecure()
		.and()
		.exceptionHandling().accessDeniedHandler(restAccessDeniedHandler)
		.and()
    	  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		  .and()
		  .authorizeRequests()
//		    .antMatchers("/login","/register","/**","/security").permitAll()
		    .antMatchers("/login","/register","/**","/security").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .addFilterBefore(requestAndResponseWrappterFilter(),LogoutFilter.class)
		    .addFilterAt(restLogoutFilter(),LogoutFilter.class)
		    .addFilterAt(restUsernamePasswordAuthenticationFilter(),UsernamePasswordAuthenticationFilter.class)
		    .addFilterAt(rememberMeAuthenticationFilter(), RememberMeAuthenticationFilter.class)
		    .csrf().disable()
		    .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
	}
	//此处将所有的options请求全部直接放行，不纳入spring security的流程中，这个对于跨域请求，必须要进行设置
	//否则，spring security会对options请求也进行处理，添加不必要的麻烦
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
		web.ignoring().antMatchers("/images/**");
		super.configure(web);
	}
/*	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		String defaultPassword=bCryptPasswordEncoder.encode("888888");
		System.out.println(defaultPassword);
	}
*/}
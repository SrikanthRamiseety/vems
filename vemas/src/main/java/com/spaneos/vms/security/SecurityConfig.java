package com.spaneos.vms.security;

import java.sql.Connection;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.spaneos.vemas.util.DaoUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery(
						"select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery(
						"select username, role from user_roles where username=?");
	}
	@Autowired
	public boolean isAdmin(){
	Connection con=DaoUtil.getObject().getConnection();

		return false;
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
 
		
		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')").and().formLogin()
				.loginPage("/loginpage.jsp").failureUrl("/loginpage.jsp")
				.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/admin/landingpage_vendor").and().logout()
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/403").and().csrf();
		http.csrf().disable();
	
		http.authorizeRequests().antMatchers("/user/*")
		.access("hasRole('ROLE_USER')").and().formLogin()
		.loginPage("/loginpage_l.jsp").failureUrl("/loginpage_l.jsp")
		.usernameParameter("/j_spring_security_check")
		.usernameParameter("username").passwordParameter("password")
		.defaultSuccessUrl("/user/landingpageOfEmplyee").and().logout()
		.logoutSuccessUrl("/").and().exceptionHandling()
		.accessDeniedPage("/403").and().csrf();
 
	 	http.csrf().disable();
		 

	}

}
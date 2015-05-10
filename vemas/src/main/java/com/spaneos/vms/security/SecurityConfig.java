package com.spaneos.vms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.ldap.LdapAuthenticationProviderConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	javax.sql.DataSource dataSource;

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

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')").and().formLogin()
				.loginPage("/login.jsp").permitAll().failureUrl("/login.jsp")
				.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/admin/landingpage_vendor",true).and().logout()
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/403").and().csrf();
		http.csrf().disable();
		
		/*  http.authorizeRequests().antMatchers("/user/* ")
		  .access("hasRole('ROLE_USER')").anyRequest()
			.authenticated().and().formLogin()
		   .loginPage("/loginpage_l.jsp") .failureUrl("/login.jsp")
		  .loginProcessingUrl("/j_spring_security_check")
		   .usernameParameter("username").passwordParameter("password")
		   .defaultSuccessUrl("/user/landingpageOfEmplyee").and()
		   .logout().logoutSuccessUrl("/").and().exceptionHandling()
		  .accessDeniedPage("/403").and().csrf(); http.csrf().disable();
		 */

		/*
		 * http.authorizeRequests().antMatchers("/css/**").permitAll()
		 * .antMatchers("/js/**").permitAll().antMatchers("/images/**")
		 * .permitAll().antMatchers("/bootstrap/**").permitAll()
		 * .antMatchers("/upload/**").permitAll().anyRequest()
		 * .authenticated().antMatchers("/admin/**").hasRole("ADMIN")
		 * .and().formLogin().loginPage("/loginpage_l.jsp").permitAll()
		 * .failureUrl("/loginpage_l.jsp")
		 * .loginProcessingUrl("/j_spring_security_check")
		 * .defaultSuccessUrl("/admin/landingpage_vendor", true).and()
		 * .logout().logoutSuccessUrl("/").and().csrf().disable();
		 * http.csrf().disable();
		 */
		http.authorizeRequests().antMatchers("/css/**").permitAll()
				.antMatchers("/js/**").permitAll().antMatchers("/images/**")
				.permitAll().antMatchers("/bootstrap/**").permitAll()
				.antMatchers("/upload/**").permitAll().anyRequest()
				
				.authenticated().and().formLogin().loginPage("/login.jsp")
				.permitAll().failureUrl("/loginpage_l.jsp")
				
				.loginProcessingUrl("/j_spring_security_check")
				.defaultSuccessUrl("/user/landingpageOfEmplyee", true).and()

				.logout().logoutSuccessUrl("/").and().csrf().disable();
		http.csrf().disable();
	 
		

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		String ldap_url = "ldap://192.168.1.4/dc=spaneos,dc=local";

		DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource(
				ldap_url);

		contextSource.afterPropertiesSet();
		DefaultLdapAuthoritiesPopulator ldapAuthoritiesPopulator = new DefaultLdapAuthoritiesPopulator(
				contextSource, "ou=groups");
		ldapAuthoritiesPopulator.setGroupRoleAttribute("ou");

		LdapAuthenticationProviderConfigurer<AuthenticationManagerBuilder> ldapAuthenticationProviderConfigurer = auth
				.ldapAuthentication();

		ldapAuthenticationProviderConfigurer
				.userDnPatterns("uid={0},ou=people")

				.groupSearchBase("ou=groups").contextSource(contextSource)
				.ldapAuthoritiesPopulator(ldapAuthoritiesPopulator)
				.groupRoleAttribute(ldap_url);

	}

}
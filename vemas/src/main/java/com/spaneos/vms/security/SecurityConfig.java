package com.spaneos.vms.security;

import javax.activation.DataSource;

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
 @Autowired javax.sql.DataSource dataSource;
	 
	 @Autowired public void configAuthentication(AuthenticationManagerBuilder
	 auth) throws Exception {
	 
	 auth.jdbcAuthentication() .dataSource(dataSource) .usersByUsernameQuery(
	 "select username,password, enabled from users where username=?")
	 .authoritiesByUsernameQuery(
	 "select username, role from user_roles where username=?"); }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
	/*http.authorizeRequests().antMatchers("/admin/* ")
		 .access("hasRole('ROLE_ADMIN')").and().formLogin()
		 .loginPage("/loginpage.jsp").failureUrl("/login.jsp")
		 .loginProcessingUrl("/j_spring_security_check")
		 .usernameParameter("username").passwordParameter("password")
		 .defaultSuccessUrl("/admin/landingpage_vendor").and().logout()
		.logoutSuccessUrl("/").and().exceptionHandling()
		 .accessDeniedPage("/403").and().csrf();
		 
		 http.csrf().disable(); */
		 
		// http.authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll()
		/*
		 * .defaultSuccessUrl("/admin/landingpage_vendor").failureUrl("/login")
		 * .loginProcessingUrl("/vemas/j_spring_security_check")
		 * .and().csrf().disable();
		 */

		http.authorizeRequests().antMatchers("/css/**").permitAll()
				.antMatchers("/js/**").permitAll()
				 .antMatchers("/images/**").permitAll()
				.antMatchers("/bootstrap/**").permitAll().antMatchers("/upload/**").permitAll().anyRequest()
				.authenticated().and()

				.formLogin().loginPage("/login.jsp").permitAll()	
				.loginProcessingUrl("/j_spring_security_check")
				.defaultSuccessUrl("/admin/landingpage_vendor",true).and().logout().logoutSuccessUrl("/").and().csrf().disable();

	 /* http.authorizeRequests().antMatchers("/user/* ")
		 .access("hasRole('ROLE_USER')").and().formLogin()
		 .loginPage("/loginpage_l.jsp").failureUrl("/login.jsp")
		 .usernameParameter("/j_spring_security_check")
		 .usernameParameter("username").passwordParameter("password")
		 .defaultSuccessUrl("/user/landingpageOfEmplyee").and().logout()
		 .logoutSuccessUrl("/").and().exceptionHandling()
		 .accessDeniedPage("/403").and().csrf();
		 
		 http.csrf().disable();*/
		 

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
				.ldapAuthoritiesPopulator(ldapAuthoritiesPopulator);

	}

	/*
	 * @Configuration
	 * 
	 * @EnableWebSecurity static class LdapAuthenticationProviderConfig extends
	 * WebSecurityConfigurerAdapter { protected void registerAuthentication(
	 * AuthenticationManagerBuilder auth) throws Exception { auth
	 * .ldapAuthentication() .groupSearchBase("ou=groups")
	 * .userDnPatterns("uid={0},ou=people"); // ldap-server@user-dn-pattern } }
	 * 
	 * @Configuration
	 * 
	 * @EnableWebSecurity static class CustomLdapAuthenticationProviderConfig
	 * extends WebSecurityConfigurerAdapter { protected void
	 * registerAuthentication( AuthenticationManagerBuilder auth) throws
	 * Exception { auth .ldapAuthentication() .groupRoleAttribute("cn") //
	 * ldap-authentication-provider@group-role-attribute
	 * .groupSearchBase("ou=groups") //
	 * ldap-authentication-provider@group-search-base
	 * .groupSearchFilter("(member={0})") //
	 * ldap-authentication-provider@group-search-filter .rolePrefix("PREFIX_")
	 * // ldap-authentication-provider@group-search-filter
	 * .userDetailsContextMapper(new PersonContextMapper()) //
	 * ldap-authentication-provider@user-context-mapper-ref /
	 * ldap-authentication-provider@user-details-class
	 * .userDnPatterns("uid={0},ou=people") //
	 * ldap-authentication-provider@user-dn-pattern .userSearchBase("ou=users")
	 * // ldap-authentication-provider@user-dn-pattern
	 * .userSearchFilter("(uid={0})") //
	 * ldap-authentication-provider@user-search-filter //
	 * .contextSource(contextSource) // ldap-authentication-provider@server-ref
	 * .contextSource() .ldif("classpath:user.ldif") // ldap-server@ldif
	 * .managerDn("uid=admin,ou=system") // ldap-server@manager-dn
	 * .managerPassword("secret") // ldap-server@manager-password .port(33399)
	 * // ldap-server@port .root("dc=springframework,dc=org") //
	 * ldap-server@root //
	 * .url("ldap://localhost:33389/dc-springframework,dc=org") this overrides
	 * root and port and is used for external ; } }
	 * 
	 * @Configuration
	 * 
	 * @EnableWebSecurity static class PasswordCompareLdapConfig extends
	 * WebSecurityConfigurerAdapter { protected void registerAuthentication(
	 * AuthenticationManagerBuilder auth) throws Exception { auth
	 * .ldapAuthentication() .groupSearchBase("ou=groups")
	 * .userSearchFilter("(uid={0})") .passwordCompare() .passwordEncoder(new
	 * PlaintextPasswordEncoder()) //
	 * ldap-authentication-provider/password-compare/password-encoder@ref
	 * .passwordAttribute("userPassword"); //
	 * ldap-authentication-provider/password-compare@password-attribute } }
	 */
}
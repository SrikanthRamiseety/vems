 package com.spaneos.vms.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.spaneos.vemas.dao.VendorDAOImp;
import com.spaneos.vemas.pojo.user_d;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private VendorDAOImp vend;

	public VendorDAOImp getVend() {
		return vend;
	}

	public void setVend(VendorDAOImp vend) {
		this.vend = vend;
	}
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String user =authentication.getName();
		String password = (String) authentication.getCredentials();
	
		user_d user_i =vend.getUser(user);
		if(user_i.getRole()!=null){
		String role = user_i.getRole();
		System.out.println(role);
	
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		grantedAuths.add(new SimpleGrantedAuthority(role));
		Authentication auth = new UsernamePasswordAuthenticationToken(user,
				password, grantedAuths);
		return auth;
		}
		else{
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}

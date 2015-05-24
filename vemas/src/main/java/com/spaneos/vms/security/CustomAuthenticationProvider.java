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

import com.spaneos.vemas.dao.VendorDAOImp;
import com.spaneos.vemas.pojo.User;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
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
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		User user = vend.getUser(username);
		if (user.getRole() != null) {
			String role = user.getRole();
			System.out.println(role);
			

			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			grantedAuths.add(new SimpleGrantedAuthority(role));
			Authentication auth = new UsernamePasswordAuthenticationToken(
					username, password, grantedAuths);
			return auth;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
/*
 * package com.spaneos.fms.security;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import
 * 
 * org.springframework.beans.factory.annotation.Autowired; import
 * 
 * org.springframework.security.authentication.AuthenticationProvider; import
 * 
 * org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 * ; import
 * 
 * org.springframework.security.core.Authentication; import
 * org.springframework.security.core.AuthenticationException; import
 * 
 * org.springframework.security.core.GrantedAuthority; import
 * 
 * org.springframework.security.core.authority.SimpleGrantedAuthority;
 * 
 * import com.spaneos.fms.pojo.User; import
 * 
 * com.spaneos.fms.service.imp.FeedbackServiceImp;
 * 
 * public class CustomAuthenticationProvider implements AuthenticationProvider
 * 
 * {
 * 
 * @Autowired private FeedbackServiceImp fmsservice;
 * 
 * public FeedbackServiceImp getFmsservice() {
 * 
 * 
 * return fmsservice; }
 * 
 * public void setFmsservice(FeedbackServiceImp fmsservice) { this.fmsservice =
 * 
 * fmsservice; }
 * 
 * @Override public Authentication authenticate(Authentication authentication)
 * 
 * 
 * throws AuthenticationException { String email = (String)
 * authentication.getPrincipal(); String
 * 
 * password = (String) authentication.getCredentials();
 * 
 * User user = fmsservice.getUserEmail(email);
 * 
 * 
 * if(user.getRole()!=null){ String role = user.getRole().getRoleName();
 * 
 * 
 * 
 * List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
 * grantedAuths.add(new
 * 
 * SimpleGrantedAuthority(role)); Authentication auth = new
 * UsernamePasswordAuthenticationToken(email,
 * 
 * 
 * password, grantedAuths); return auth; } else{ return
 * 
 * null; } }
 * 
 * @Override public boolean supports(Class<?> authentication) { return
 * 
 * authentication.equals(UsernamePasswordAuthenticationToken.class); }
 * 
 * }
 */

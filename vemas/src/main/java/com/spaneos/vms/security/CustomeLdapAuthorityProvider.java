/*package com.spaneos.vms.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;

import com.spaneos.vemas.dao.VendorDAOImp;
import com.spaneos.vemas.pojo.user_d;
import com.spaneos.vemas.web.AdminServlet;

public class CustomeLdapAuthorityProvider implements LdapAuthoritiesPopulator {
	@Autowired
	private VendorDAOImp vend;

	public VendorDAOImp getVend() {
		return vend;
	}

	public void setVend(VendorDAOImp vend) {
		this.vend = vend;
	}

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities(
			DirContextOperations arg0, String username) {
		Collection<GrantedAuthority> gas = new HashSet<GrantedAuthority>();
		User user = vend.getUserLdap(username);
		if (user.getLdapName() != null
				&& username.equalsIgnoreCase(user.getLdapName())) {
			gas.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		}
		return gas;
	}
}
*/
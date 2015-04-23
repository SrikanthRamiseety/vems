package com.spaneos.vemas.pojo;

 
public class Admin {
	private String name;
	private String password;
	private  boolean isAdmin;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + ", isAdmin="
				+ isAdmin + "]";
	}
	
	

}

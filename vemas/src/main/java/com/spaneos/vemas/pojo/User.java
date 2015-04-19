package com.spaneos.vemas.pojo;

public class User {
	private String firstname;
	private String lastname;
	private String middlename;
	private String email;
	private String password;
	private String selectquestion;
	private String answer;
	private String mobile;
	private int userId;
	private boolean isadmin;

	public User() {

	}

	 
	

	public User(String firstname, String lastname, String middlename,
			String email, String password, String selectquestion,
			String answer, String mobile, int userId, boolean isadmin) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
		this.email = email;
		this.password = password;
		this.selectquestion = selectquestion;
		this.answer = answer;
		this.mobile = mobile;
		this.userId = userId;
		this.isadmin = isadmin;
	}




	public boolean Isadmin() {
		return isadmin;
	}

	public boolean setIsadmin(boolean isadmin) {
		return this.isadmin = isadmin;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSelectquestion() {
		return selectquestion;
	}

	public void setSelectquestion(String selectquestion) {
		this.selectquestion = selectquestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname
				+ ", middlename=" + middlename + ", email=" + email
				+ ", password=" + password + ", selectquestion="
				+ selectquestion + ", answer=" + answer + ", mobile=" + mobile
				+ ", userId=" + userId + "]";
	}

}

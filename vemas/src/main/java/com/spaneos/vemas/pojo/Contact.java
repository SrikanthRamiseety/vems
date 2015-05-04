package com.spaneos.vemas.pojo;

public class Contact {
	private int id;
	private String name;
	private String designation;
	private String mobile;
	private String mobile1;
	private String mobile2;
	private String email;
	private String email1;
	private String email2;
	private String employmentStatus;
	private String reportingManager;
	
	public Contact() {
		
	}

	 

	public Contact(int id, String name, String designation, String mobile,
			String mobile1, String mobile2, String email, String email1,
			String email2, String employmentStatus, String reportingManager) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.mobile = mobile;
		this.mobile1 = mobile1;
		this.mobile2 = mobile2;
		this.email = email;
		this.email1 = email1;
		this.email2 = email2;
		this.employmentStatus = employmentStatus;
		this.reportingManager = reportingManager;
	}



	/**
	 * @return the mobile1
	 */
	public String getMobile1() {
		return mobile1;
	}



	/**
	 * @param mobile1 the mobile1 to set
	 */
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}



	/**
	 * @return the mobile2
	 */
	public String getMobile2() {
		return mobile2;
	}



	/**
	 * @param mobile2 the mobile2 to set
	 */
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}



	/**
	 * @return the email1
	 */
	public String getEmail1() {
		return email1;
	}



	/**
	 * @param email1 the email1 to set
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}



	/**
	 * @return the email2
	 */
	public String getEmail2() {
		return email2;
	}



	/**
	 * @param email2 the email2 to set
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", designation="
				+ designation + ", mobile=" + mobile + ", email=" + email
				+ ", employmentStatus=" + employmentStatus
				+ ", reportingManager=" + reportingManager + "]";
	}	
	
}

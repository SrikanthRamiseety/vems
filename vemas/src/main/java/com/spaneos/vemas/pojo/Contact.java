package com.spaneos.vemas.pojo;

public class Contact {
	private int id;
	private String name;
	private String designation;
	private String mobile;
	private String email;
	private String employmentStatus;
	private String reportingManager;
	
	public Contact() {
		
	}

	public Contact(int id, String name, String designation, String mobile,
			String email, String employmentStatus, String reportingManager) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.mobile = mobile;
		this.email = email;
		this.employmentStatus = employmentStatus;
		this.reportingManager = reportingManager;
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

package com.spaneos.vemas.pojo;

import java.util.ArrayList;
import java.util.List;

public class Vendor {
	private int id;
	private String vendorCode;
	private String vendorType;
	private String vendorCategory;
	private String vendorName;
	private String vendorLandlineNumber;
	private String vendorMobileNumber;
	private String vendorMobileNumber1;
	private String vendorMobileNumber2;
	private String vendorWebsite;
	private String vendorAddress;
	private List<Contact> vendorContacts;
	
	public Vendor() {
		
	}

	

	 

	





	public Vendor(int id, String vendorCode, String vendorType,
			String vendorCategory, String vendorName,
			String vendorLandlineNumber, String vendorMobileNumber,
			String vendorMobileNumber1, String vendorMobileNumber2,
			String vendorWebsite, String vendorAddress,
			List<Contact> vendorContacts) {
		super();
		this.id = id;
		this.vendorCode = vendorCode;
		this.vendorType = vendorType;
		this.vendorCategory = vendorCategory;
		this.vendorName = vendorName;
		this.vendorLandlineNumber = vendorLandlineNumber;
		this.vendorMobileNumber = vendorMobileNumber;
		this.vendorMobileNumber1 = vendorMobileNumber1;
		this.vendorMobileNumber2 = vendorMobileNumber2;
		this.vendorWebsite = vendorWebsite;
		this.vendorAddress = vendorAddress;
		this.vendorContacts = vendorContacts;
	}











	/**
	 * @return the vendorMobileNumber1
	 */
	public String getVendorMobileNumber1() {
		return vendorMobileNumber1;
	}











	/**
	 * @param vendorMobileNumber1 the vendorMobileNumber1 to set
	 */
	public void setVendorMobileNumber1(String vendorMobileNumber1) {
		this.vendorMobileNumber1 = vendorMobileNumber1;
	}











	/**
	 * @return the vendorMobileNumber2
	 */
	public String getVendorMobileNumber2() {
		return vendorMobileNumber2;
	}











	/**
	 * @param vendorMobileNumber2 the vendorMobileNumber2 to set
	 */
	public void setVendorMobileNumber2(String vendorMobileNumber2) {
		this.vendorMobileNumber2 = vendorMobileNumber2;
	}











	/**
	 * @return the vendorCode
	 */
	public String getVendorCode() {
		return vendorCode;
	}





	/**
	 * @param vendorCode the vendorCode to set
	 */
	public void setVendorCode(String vendorCode) {
		this.vendorCode = vendorCode;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public String getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(String vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorLandlineNumber() {
		return vendorLandlineNumber;
	}

	public void setVendorLandlineNumber(String vendorLandlineNumber) {
		this.vendorLandlineNumber = vendorLandlineNumber;
	}

	public String getVendorMobileNumber() {
		return vendorMobileNumber;
	}

	public void setVendorMobileNumber(String vendorMobileNumber) {
		this.vendorMobileNumber = vendorMobileNumber;
	}

	public String getVendorWebsite() {
		return vendorWebsite;
	}

	public void setVendorWebsite(String vendorWebsite) {
		this.vendorWebsite = vendorWebsite;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public List<Contact> getVendorContacts() {
		return vendorContacts;
	}



	public void setVendorContacts(List<Contact> vendorContacts) {
		this.vendorContacts = vendorContacts;
	}



	@Override
	public String toString() {
		return "Vendor [id=" + id + ", vendorType=" + vendorType
				+ ", vendorCategory=" + vendorCategory + ", vendorName="
				+ vendorName + ", vendorLandlineNumber=" + vendorLandlineNumber
				+ ", vendorMobileNumber=" + vendorMobileNumber
				+ ", vendorWebsite=" + vendorWebsite + ", vendorAddress="
				+ vendorAddress + ", vendorContacts=" + vendorContacts + "]";
	}	
	
}

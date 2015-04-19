package com.spaneos.vemas.pojo;

public class VendorType {
	private String vendorCategory;
	private String vendorType;

	
	public VendorType() {
		
		// TODO Auto-generated constructor stub
	}

	public VendorType(String vendorCategory, String vendorType) {
		super();
		this.vendorCategory = vendorCategory;
		this.vendorType = vendorType;
	}

	public String getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(String vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	@Override
	public String toString() {
		return "VendorType [vendorCategory=" + vendorCategory + ", vendorType="
				+ vendorType + "]";
	}

}

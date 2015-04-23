package com.spaneos.vemas.pojo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class Billes {
	
	private String billNo;
	private String shopName;
	private String amount;
	private String name;
	private String mobile;
	private   File imagepath;
	private FileOutputStream f;
	private String date;
	
	
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public FileOutputStream getF() {
		return f;
	}

	public void setF(FileOutputStream f) {
		this.f = f;
	}

	public File getImagepath() {
		return imagepath;
	}

	public void setImagepath(File imagepath) {
		this.imagepath = imagepath;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String string) {
		this.billNo = string;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Billes [billNo=" + billNo + ", shopName=" + shopName
				+ ", amount=" + amount + ", name=" + name + ", mobile="
				+ mobile + ", imagepath=" + imagepath + ", f=" + f + ", date="
				+ date + "]";
	}

	 

 
 	 
}

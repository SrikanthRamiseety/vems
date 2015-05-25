package com.spaneos.vemas.dao;

import java.util.List;

import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.util.SQLQueries;

public interface VendorDaoInf extends SQLQueries {
	boolean addVendor(Vendor vendor);

	boolean addContact(Contact contact, int vendorId);

	boolean updateContactByEmail(Contact contact);

	boolean updateVendorByVendorId(Vendor vendor);

	List<Contact> getContactsById(int id);

	List<Vendor> getVendorsByVendorname(String name);

	;

	public Vendor getVendorsByVendorMobile(String mobile);

	public boolean isadmin(int id);

	public boolean addVendortype(VendorType vendortype);

	public List<VendorType> getAllVendorTypes();

	public boolean addBills(Billes billes);

	public List<Billes> getAllBilles();

	public boolean addBank(Bank bank);

	public List<Bank> getAllBAnkDetalies();

	public List<Billes> getBillByDate(String Date);

	public List<Billes> getBillByVendorName(String vendor);

	public List<Vendor> getAllVendors();

	public List<Bank> getBankdetiles(String name);

	public com.spaneos.vemas.pojo.User getUser(String name);
     public boolean addUser(User user);
     
}

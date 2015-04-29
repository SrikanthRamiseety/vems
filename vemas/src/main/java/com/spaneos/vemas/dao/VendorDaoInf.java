package com.spaneos.vemas.dao;

import java.util.Date;
import java.util.List;

import com.spaneos.vemas.pojo.Admin;
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

	boolean addUser(User signup);

	boolean updateContactByEmail(Contact contact);

	boolean updateVendorByVendorId(Vendor vendor);

	List<Contact> getContactsById(int id);

	List<Vendor> getVendorsByVendorname(String name);

	List<User> getPasswordByEmail(String email);

	public Vendor getVendorsByVendorMobile(String mobile);

	public List<User> getAllUsers();

	public User getUserByEmail(String email);

	public boolean isadmin(int id);

	public boolean addVendortype(VendorType vendortype);

	public List<VendorType> getAllVendorTypes();

	public boolean addBills(Billes billes);

	public List<Billes> getAllBilles();

	public boolean addBank(Bank bank);

	public List<Bank> getAllBAnkDetalies();

	public Admin getPassword(String name);

	public List<Billes> getBillByDate(Date Date);
	public List<Billes> getBillByVendorName(String vendor);
	

}

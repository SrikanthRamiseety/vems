package com.spaneos.vemas.dao;

import java.util.List;

import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
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
}

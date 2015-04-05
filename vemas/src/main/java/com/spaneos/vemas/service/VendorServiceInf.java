package com.spaneos.vemas.service;

import java.util.List;

import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.util.SQLQueries;

public interface VendorServiceInf extends SQLQueries {
	boolean addVendor(Vendor vendor);

	boolean addContact(Contact contact, Vendor vendor);

	boolean addUser(User signup);

	boolean updateContactByEmail(Contact contact);

	boolean updateVendorByVendorId(Vendor vendor);

	List<Contact> getContactsById(int id);

	List<Vendor> getVendorsByVendorname(String name);

	List<User> getPasswordByEmail(String email);

	Vendor createVendor(String type, String category, String name,
			String lNumber, String mNumber, String website, String address);

	Contact createContact(String name, String designation, String mobile,
			String email, String empStatus, String manager);

	User createUser(String fname, String mname, String lname, String email,
			String password, String seqQuestion, String answer, String mobile);

	List<Contact> updateContact(String name, String designation, String mobile,
			String email, String empStatus, String manager,
			List<Contact> contactsList);

	List<Contact> deleteContacts(String ids, List<Contact> contactsList);

	boolean addContactToVendor(Contact contact, List<Contact> vendorContacts);

	public boolean authenticateUser(String userName, String password);
	
	public User getUserByEmail(String email);
}

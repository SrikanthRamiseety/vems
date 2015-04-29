package com.spaneos.vemas.service;

import java.util.List;

import com.spaneos.vemas.pojo.Admin;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
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

	public boolean admin(String email, String password);

	public User getUserByEmail(String email);

	public boolean addVendortype(VendorType vendortype);

	public List<VendorType> getAllVendorTypes();

	public boolean addBills(Billes billes);

	public List<Billes> getAllBilles();

	public List<User> getAllUsers();

	public boolean addBank(Bank bank);

	public List<Bank> getAllBAnkDetalies();

	public Admin getPassword(String name);
	public List<Billes> getBillByDate(String Date);
	public List<Billes> getBillByVendorName(String vendor);
}

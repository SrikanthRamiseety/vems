package com.spaneos.vemas.service;

import java.util.List;

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

	 
	boolean updateContactByEmail(Contact contact);

	boolean updateVendorByVendorId(Vendor vendor);

	List<Contact> getContactsById(int id);

	List<Vendor> getVendorsByVendorname(String name);

 

	Vendor createVendor(String code, String type, String category, String name,
			String lNumber, String mNumber, String mNumber1, String mNumber2,
			String website, String address);

	Contact createContact(String name, String designation, String mobile,
			String mobile1, String mobile2, String email, String email1,
			String email2, String empStatus, String manager);

	 

	List<Contact> updateContact(String name, String designation, String mobile,
			String email, String empStatus, String manager,
			List<Contact> contactsList);

	List<Contact> deleteContacts(String ids, List<Contact> contactsList);

	boolean addContactToVendor(Contact contact, List<Contact> vendorContacts);

	public boolean authenticateUser(String userName, String password);

	public boolean admin(String email, String password);

	 

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

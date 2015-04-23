package com.spaneos.vemas.service;

import java.util.List;

import com.spaneos.vemas.dao.VendorDAOImp;
import com.spaneos.vemas.pojo.Admin;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;

public class VendorServiceImp implements VendorServiceInf {
	private static VendorServiceImp vendorServiceImp = null;
	private VendorDAOImp vendorDaoImp = VendorDAOImp.getInstance();

	private VendorServiceImp() {

	}

	public static VendorServiceImp getInstance() {
		if (vendorServiceImp == null)
			vendorServiceImp = new VendorServiceImp();

		return vendorServiceImp;
	}


	
	@Override
	public boolean addVendor(Vendor vendor) {
		/* List<Vendor> vendorsList = vendorDaoImp.getAllVendors(); */

		return vendorDaoImp.addVendor(vendor);
	}

	@Override
	public boolean addContact(Contact contact, Vendor vendor) {
		
		Vendor DBvendor = vendorDaoImp.getVendorsByVendorMobile(vendor
				.getVendorMobileNumber());
		return vendorDaoImp.addContact(contact, DBvendor.getId());
	}

	@Override
	public boolean addUser(User signup) {
		List<User> usersList = vendorDaoImp.getAllUsers();

		for (User user : usersList) {
			if (user.getEmail().equalsIgnoreCase(signup.getEmail())) {
				return false;
			}
		}
		return vendorDaoImp.addUser(signup);
	}

	@Override
	public boolean updateContactByEmail(Contact contact) {

		return false;
	}

	@Override
	public boolean updateVendorByVendorId(Vendor vendor) {

		return false;
	}

	@Override
	public List<Contact> getContactsById(int id) {

		return null;
	}

	@Override
	public List<Vendor> getVendorsByVendorname(String name) {

		return vendorDaoImp.getVendorsByVendorname(name);
	}

	@Override
	public List<User> getPasswordByEmail(String email) {

		return null;
	}

	@Override
	public Vendor createVendor(String type, String category, String name,
			String lNumber, String mNumber, String website, String address) {

		if (type == null || category == null || name == null || lNumber == null
				|| mNumber == null || address == null) {
			return null;
		}
		return new Vendor(0, type, category, name, lNumber, mNumber, website,
				address, null);
	}

	@Override
	public Contact createContact(String name, String designation,
			String mobile, String email, String empStatus, String manager) {

		if (name == null || designation == null || mobile == null
				|| email == null) {
			return null;
		}
		return new Contact(0, name, designation, mobile, email, empStatus,
				manager);
	}

	@Override
	public List<Contact> updateContact(String name, String designation,
			String mobile, String email, String empStatus, String manager,
			List<Contact> contactsList) {

		if (contactsList == null) {
			return null;
		}

		for (Contact contact : contactsList) {
			if (contact.getEmail().equalsIgnoreCase(email)) {
				contact.setName(name);
				contact.setDesignation(designation);
				contact.setMobile(mobile);
				contact.setEmploymentStatus(empStatus);
				contact.setReportingManager(manager);
			}
		}

		return contactsList;
	}

	@Override
	public List<Contact> deleteContacts(String ids, List<Contact> contactsList) {
		if (ids == null || contactsList == null)
			return null;

		String[] emails = ids.split(",");
		int i = 0;

		for (int j = 0; j < contactsList.size(); j++) {
			if (contactsList.get(j).getEmail().equalsIgnoreCase(emails[i])) {
				contactsList.remove(j);
				i++;
			}
		}
		return contactsList;
	}

	@Override
	public boolean addContactToVendor(Contact contact,
			List<Contact> vendorContacts) {
		for (Contact vendorContact : vendorContacts) {
			if (vendorContact.getEmail().equalsIgnoreCase(contact.getEmail()))
				return false;
		}

		vendorContacts.add(contact);
		return true;
	}

	@Override
	public boolean authenticateUser(String email, String password) {
		User user = vendorDaoImp.getUserByEmail(email);

		if (user.getEmail().equalsIgnoreCase(email)
				&& user.getPassword().equals(password))
			return true;

		return false;
	}

	@Override
	public User createUser(String fname, String mname, String lname,
			String email, String password, String seqQuestion, String answer,
			String mobile) {

		if (fname == null || email == null || password == null
				|| seqQuestion == null || answer == null || mobile == null) {
			return null;
		}

		return new User(fname, lname, mname, email, password, seqQuestion,
				answer, mobile, 0,false);
	}

	@Override
	public User getUserByEmail(String email) {

		return vendorDaoImp.getUserByEmail(email);
	}

	public boolean saveAllData(Vendor vendor) {
		if (vendor == null)
			return false;
		
		if (!vendorServiceImp.addVendor(vendor)) {
			
			return false;
		}
		
		List<Contact> vendorContacts = vendor.getVendorContacts();
		// boolean allSaved = true;
		
		for (Contact contact : vendorContacts) {
			if (!vendorServiceImp.addContact(contact, vendor))
				return false;
		}
		
		return true;
	}

	public boolean checkCredentials(String email, String seq_question,
			String answer) {
		User user = vendorServiceImp.getUserByEmail(email);
		/*System.out.println(seq_question.equalsIgnoreCase(user.getSelectquestion()));
		System.out.println(user.getSelectquestion());
		System.out.println(answer.trim().equalsIgnoreCase(user.getAnswer().trim()));*/
		if (user != null
				&& user.getSelectquestion().trim().equalsIgnoreCase(seq_question.trim())
				&& user.getAnswer().trim().equalsIgnoreCase(answer.trim()))
			return true;

		return false;
	}

	@Override
	public boolean admin(String email, String password) {
		
		

		if ("rani@gmail.com".equalsIgnoreCase(email)
				&& "Rani123456".equals(password))
			return true;

		return false;

	}

	@Override
	public boolean addVendortype(VendorType vendortype) {
		
		return  vendorDaoImp.addVendortype(vendortype);
	}

	@Override
	public List<VendorType> getAllVendorTypes() {
		
		return vendorDaoImp.getAllVendorTypes();
	}

	@Override
	public boolean addBills(Billes billes) {
		
		return vendorDaoImp.addBills(billes);
	}

	@Override
	public List<Billes> getAllBilles() {
		
		return vendorDaoImp.getAllBilles();
	}

	@Override
	public List<User> getAllUsers() {
		
		return vendorDaoImp.getAllUsers();
	}

	@Override
	public boolean addBank(Bank bank) {
		
		return vendorDaoImp.addBank(bank);
	}

	@Override
	public List<Bank> getAllBAnkDetalies() {
 		return vendorDaoImp.getAllBAnkDetalies();
	}

	@Override
	public Admin getPassword(String name) {
		// TODO Auto-generated method stub
		return vendorDaoImp.getPassword(name);
	}

}

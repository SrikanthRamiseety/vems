package com.spaneos.vemas.service;

import java.util.Date;
import java.util.List;

import com.spaneos.vemas.dao.VendorDAOImp;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
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
	public Vendor createVendor(String code,String type, String category, String name,
			String lNumber,  String mNumber,String mNumber1,String mNumber2, String website, String address) {

		if (code==null||type == null || category == null || name == null || lNumber == null
				|| mNumber == null || address == null) {
			return null;
		}
		return new Vendor(0,code, type, category, name, lNumber, mNumber,mNumber1,mNumber2, website,
				address, null);
	}

	@Override
	public Contact createContact(String name, String designation,
			String mobile,String mobile1,String mobile2, String email,String email1,String email2, String empStatus, String manager) {

		if (name == null || designation == null || mobile == null
				|| email == null) {
			return null;
		}
		return new Contact(0, name, designation, mobile,mobile1,mobile2, email,email1,email2, empStatus,
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
	public boolean addBank(Bank bank) {
		
		return vendorDaoImp.addBank(bank);
	}

	@Override
	public List<Bank> getAllBAnkDetalies() {
 		return vendorDaoImp.getAllBAnkDetalies();
	}

	 

	@Override
	public List<Billes> getBillByDate(Date Date) {
		 
		return vendorDaoImp.getBillByDate(Date);
	}

	@Override
	public List<Billes> getBillByVendorName(String vendor) {
		
		return  vendorDaoImp.getBillByVendorName(vendor);
	}

	@Override
	public List<Billes> getBillByDate(String Date) {
		// TODO Auto-generated method stub
		return vendorDaoImp.getBillByDate(Date);
	}

	@Override
	public List<Vendor> getAllVendors() {
		 
		return vendorDaoImp.getAllVendors();
	}

	@Override
	public List<Bank> getBankdetiles(String name) {
		
		return vendorDaoImp.getBankdetiles(name);
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public com.spaneos.vemas.pojo.User getUser(String name) {
	 
		return vendorDaoImp.getUser(name);
	}

 
	 

}

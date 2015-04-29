package com.spaneos.vemas.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spaneos.vemas.pojo.Admin;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
import com.spaneos.vemas.pojo.User;
import com.spaneos.vemas.pojo.Vendor;
import com.spaneos.vemas.pojo.VendorType;
import com.spaneos.vemas.util.DaoUtil;

public class VendorDAOImp implements VendorDaoInf {
	private static final int BUFFER_SIZE = 4096;
	static VendorDAOImp vendorDAOImp = null;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DaoUtil daoUtil = DaoUtil.getObject();

	private VendorDAOImp() {

	}

	public static VendorDAOImp getInstance() {
		if (vendorDAOImp == null)
			vendorDAOImp = new VendorDAOImp();

		return vendorDAOImp;
	}

	@Override
	public boolean addVendor(Vendor vendor) {
		System.out.println("adding vendor in DAO...");
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(ADD_VENDOR);

			pstmt.setString(1, vendor.getVendorType());
			pstmt.setString(2, vendor.getVendorCategory());
			pstmt.setString(3, vendor.getVendorName());
			pstmt.setString(4, vendor.getVendorMobileNumber());
			pstmt.setString(5, vendor.getVendorLandlineNumber());
			pstmt.setString(6, vendor.getVendorWebsite());
			pstmt.setString(7, vendor.getVendorAddress());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return false;
	}

	@Override
	public boolean addContact(Contact contact, int vendorId) {
		System.out.println("adding in DAO...");
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(ADD_CONTACT);
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getDesignation());
			pstmt.setString(3, contact.getMobile());
			pstmt.setString(4, contact.getEmail());
			pstmt.setString(5, contact.getEmploymentStatus());
			pstmt.setString(6, contact.getReportingManager());
			pstmt.setInt(7, vendorId);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return false;
	}

	@Override
	public boolean addUser(User user) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(ADD_USER);
			pstmt.setString(1, user.getFirstname());
			pstmt.setString(2, user.getMiddlename());
			pstmt.setString(3, user.getLastname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPassword());
			pstmt.setString(6, user.getSelectquestion());
			pstmt.setString(7, user.getAnswer());
			pstmt.setString(8, user.getMobile());
			pstmt.setBoolean(9, user.Isadmin());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}

		return false;
	}

	@Override
	public List<Contact> getContactsById(int id) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_CONTACTS_BY_VENDORID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			List<Contact> contactList = new ArrayList<Contact>();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setName(rs.getString("CONTACTNAME"));
				contact.setDesignation(rs.getString("DESIGNATION"));
				contact.setMobile(rs.getString("MOBILE"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setEmploymentStatus(rs.getString("EMPLOYMENTSTATUS"));
				contact.setReportingManager(rs.getString("REPORTINGMANAGER"));
				contactList.add(contact);

			}
			return contactList;
		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return null;
	}

	@Override
	public List<Vendor> getVendorsByVendorname(String name) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_VENDORS_BY_VENDORNAME);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			int i = 1;
			
			while (rs.next()) {
				Vendor vendor = new Vendor();
				vendor.setId(i++);
				vendor.setVendorType(rs.getString("VENDORTYPE"));
				vendor.setVendorCategory(rs.getString("VENDORCATEGORY"));
				vendor.setVendorName(rs.getString("VENDORNAME"));
				vendor.setVendorMobileNumber(rs.getString("MOBILE"));
				vendor.setVendorLandlineNumber(rs.getString("LANDLINE"));
				vendor.setVendorWebsite(rs.getString("WEBSITE"));
				vendor.setVendorAddress(rs.getString("ADDRESS"));
				vendor.setVendorContacts(getContactsByVendorName(name));
				vendorList.add(vendor);
			}
			
			if(vendorList.size() == 0)
				return null;
			
			return vendorList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}

		return null;
	}

	private List<Contact> getContactsByVendorName(String name) {
		ResultSet rs = null;
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_CONTACTS_BY_VENDORNAME);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			List<Contact> contactList = new ArrayList<Contact>();
			int j = 1;
			
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(j++);
				contact.setName(rs.getString("CONTACTNAME"));
				contact.setDesignation(rs.getString("DESIGNATION"));
				contact.setMobile(rs.getString("MOBILE"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setEmploymentStatus(rs.getString("EMPLOYEMENTSTATUS"));
				contact.setReportingManager(rs.getString("REPORTINGMANAGER"));
				contactList.add(contact);
			}
			return contactList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return null;
	}

	@Override
	public boolean updateContactByEmail(Contact contact) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(UPDATE_CONTACT_BY_EMAIL);
			pstmt.setString(1, contact.getName());
			pstmt.setString(2, contact.getDesignation());
			pstmt.setString(3, contact.getMobile());
			pstmt.setString(4, contact.getEmail());
			pstmt.setString(5, contact.getEmploymentStatus());
			pstmt.setString(6, contact.getReportingManager());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return false;
	}

	@Override
	public boolean updateVendorByVendorId(Vendor vendor) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(UPDATE_VENDOR_BY_VENDORID);
			pstmt.setInt(1, vendor.getId());
			pstmt.setString(2, vendor.getVendorType());
			pstmt.setString(3, vendor.getVendorCategory());
			pstmt.setString(4, vendor.getVendorName());
			pstmt.setString(5, vendor.getVendorMobileNumber());
			pstmt.setString(6, vendor.getVendorLandlineNumber());
			pstmt.setString(7, vendor.getVendorWebsite());
			pstmt.setString(8, vendor.getVendorAddress());
			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			}
		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return false;
	}

	@Override
	public List<User> getPasswordByEmail(String email) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_PASSWORD_BY_EMAIL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			List<User> userList = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setPassword(rs.getString("PASSWORD"));
				user.setSelectquestion(rs.getString("SELECTQUESTION"));
				user.setAnswer(rs.getString("ANSWER"));
				userList.add(user);
			}
			return userList;
		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		try {
			con = daoUtil.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(GET_ALL_USERS);
			while (rs.next()) {
				User user = new User();
				user.setFirstname(rs.getString("FIRSTNAME"));
				user.setMiddlename(rs.getString("MIDDLENAME"));
				user.setLastname(rs.getString("LASTNAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setSelectquestion(rs.getString("SELECT_QUESTION"));
				user.setAnswer(rs.getString("ANSWER"));
				user.setMobile(rs.getString("MOBILE"));

				userList.add(user);
			}

		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_USER_BY_EMAIL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			User user = new User();
			while (rs.next()) {
				user.setFirstname(rs.getString("FIRSTNAME"));
				user.setMiddlename(rs.getString("MIDDLENAME"));
				user.setLastname(rs.getString("LASTNAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setSelectquestion(rs.getString("SELECT_QUESTION"));
				user.setAnswer(rs.getString("ANSWER"));
				user.setMobile(rs.getString("MOBILE"));
				user.setUserId(rs.getInt("USERID"));
				user.setIsadmin(rs.getBoolean("ISADMIN"));
			}
			return user;
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}
		return null;
	}

	@Override
	public Vendor getVendorsByVendorMobile(String mobile) {
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_VENDORS_BY_VENDORMOBILE);
			pstmt.setString(1, mobile);
			rs = pstmt.executeQuery();
			Vendor vendor = null;
			while (rs.next()) {
				vendor = new Vendor();
				vendor.setId(rs.getInt("VENDORID"));
				vendor.setVendorType(rs.getString("VENDORTYPE"));
				vendor.setVendorCategory(rs.getString("VENDORCATEGORY"));
				vendor.setVendorName(rs.getString("VENDORNAME"));
				vendor.setVendorMobileNumber(rs.getString("MOBILE"));
				vendor.setVendorLandlineNumber(rs.getString("LANDLINE"));
				vendor.setVendorWebsite(rs.getString("WEBSITE"));
				vendor.setVendorAddress(rs.getString("ADDRESS"));

			}
			return vendor;
		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}

		return null;
	}

	@Override
	public boolean isadmin(int id) {
		boolean isadmin = false;
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement("select ISADMIN from USER where USERID=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
			isadmin=	user.setIsadmin(rs.getBoolean("ISADMIN"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
 		return  isadmin;
	}

	@Override
	public boolean addVendortype(VendorType vendortype) {
		try {
			con =daoUtil.getConnection();
			pstmt=con.prepareStatement(ADD_VENDORTYPE);
			pstmt.setString(1, vendortype.getVendorCategory());
			pstmt.setString(2, vendortype.getVendorType());
			int i=pstmt.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}
		return false;
	}

	@Override
	public List<VendorType> getAllVendorTypes() {
		List<VendorType> vendorTypes=new ArrayList<VendorType>();
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement(GET_VENDORTYPE);
			rs=pstmt.executeQuery();
			while(rs.next()){
				VendorType type=new VendorType(rs.getString("VENDORCATEGORY"), rs.getString("VENDORTYPE"));
				vendorTypes.add(type);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return vendorTypes;
	}

	@Override
	public boolean addBills(Billes billes) {
		try {
			String filepath="C:/Users/Srikanth.Lakshman/Downloads/images/"+billes.getImagepath();
			System.out.println(filepath);
			InputStream inputStream=new FileInputStream(new File(filepath));
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement("insert into BILLES(BILLID,VENDORNAME,AMOUNT,NAME,MOBILE,PHOTO,DATE1) values(?,?,?,?,?,?,?);");
			pstmt.setString(1, billes.getBillNo());
			pstmt.setString(2,billes.getShopName());
		
			pstmt.setString(3, billes.getAmount());
			pstmt.setString(4, billes.getName());
			pstmt.setString(5,billes.getMobile());
		    pstmt.setBinaryStream(6, inputStream);
		    pstmt.setDate(7,  (java.sql.Date) billes.getDate1());
		   

				 
			
		int i=	pstmt.executeUpdate();
		if(i>0){
			return true;
		}
		} catch (SQLException | FileNotFoundException e) {
			
			e.printStackTrace();
		}
		finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}

		return false;
	}

	@Override
	public List<Billes> getAllBilles() {
		List<Billes> billes=new ArrayList<Billes>();
		String filepath="C:/Users/Srikanth.Lakshman/Downloads/";
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement("select * from BILLES");
			rs=pstmt.executeQuery();
 			int i = 0;
			while(rs.next()){
				Billes bill=new Billes();
				bill.setBillNo(rs.getString("BILLID"));
				bill.setShopName(rs.getString("VENDORNAME"));
				 
				bill.setAmount(rs.getString("AMOUNT"));
				bill.setName(rs.getString("NAME"));
				bill.setMobile(rs.getString("MOBILE"));
				bill.setDate1(rs.getDate("DATE1"));
			 
 				InputStream in = rs.getBinaryStream("PHOTO");
 				String name=rs.getString("BILLID")+"_"+rs.getDate("DATE1")+".jpg";
 				
 				FileOutputStream f = new FileOutputStream(new File("C:/Users/Srikanth.Lakshman/git/vems1/vemas/src/main/webapp/upload/"+name));
 				
				i++;
				int c = 0;
				while ((c = in.read()) != -1) {
					f.write(c);
				}
		bill.setImageName(name);
				billes.add(bill);
					
System.out.println(billes);	
}
		
		} catch ( Exception e) {
			
			e.printStackTrace();
		}
		finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}

		
		return billes;
	}

	@Override
	public boolean addBank(Bank bank) {
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement(ADD_BANK);
			pstmt.setString(1,bank.getVendorName() );
			pstmt.setString(2,bank.getBankName() );
			pstmt.setString(3,bank.getAcno() );
			pstmt.setString(4,bank.getAcName() );
			pstmt.setString(5,bank.getIcfcode() );
			pstmt.setString(6,bank.getOtherbankname() );
			pstmt.setString(7,bank.getA_cno() );
			pstmt.setString(8,bank.getA_cName() );
			pstmt.setString(9,bank.getIcf_code() );
		int i=	pstmt.executeUpdate();
		if(i>0){
			return true;
		}
			
			
		} catch (SQLException e) {
 			e.printStackTrace();
		}finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}
		
 		return false;
	}

	@Override
	public List<Bank> getAllBAnkDetalies() {
		List<Bank> list=new ArrayList<Bank>();
		con=daoUtil.getConnection();
		try {
			pstmt=con.prepareStatement(GETALL_BANKDETALIES);
			rs=pstmt.executeQuery();
			 
			while(rs.next()){
				Bank bank=new Bank();
				bank.setVendorName(rs.getString("VANDORNAME"));
				bank.setBankName(rs.getString("BANKNAME"));
				bank.setAcName(rs.getString("ACCOUNTNAME"));
				bank.setAcno(rs.getString("ACCOUNTNUMBER"));
				bank.setIcfcode(rs.getString("ISCFCODE"));
				bank.setOtherbankname(rs.getString("BANKNAME_1"));
				bank.setA_cno(rs.getString("ACCOUNTNUMBER_1"));
				bank.setA_cName(rs.getString("ACCOUNTNAME_1"));
			 
				bank.setIcf_code(rs.getString("ISCFCODE_1"));
				list.add(bank);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}
		return list;
	}

	@Override
	public Admin getPassword(String name) {
		 con=daoUtil.getConnection();
		 Admin admin=new Admin();
		 try {
			pstmt=con.prepareStatement("select password,enable from users where username=?;");
			pstmt.setString(1, name);
		rs=pstmt.executeQuery();
		while(rs.next()){
			admin.setPassword(rs.getString("password"));
			admin.setAdmin(rs.getBoolean("enable"));
		}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}
		return admin;
	}

	@Override
	public List<Billes> getBillByDate(Date Date) {
		List<Billes> blist =new ArrayList<Billes>();
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement("select * from BILLES where DATE1=?;");
			pstmt.setDate(1, (java.sql.Date) Date);
			rs=pstmt.executeQuery();
			int i = 0;
			while(rs.next()){
				Billes bill=new Billes();
				bill.setBillNo(rs.getString("BILLID"));
				bill.setShopName(rs.getString("VENDORNAME"));
				 
				bill.setAmount(rs.getString("AMOUNT"));
				bill.setName(rs.getString("NAME"));
				bill.setMobile(rs.getString("MOBILE"));
				bill.setDate1(rs.getDate("DATE1"));
				InputStream in = rs.getBinaryStream("PHOTO");
 				String name=rs.getString("BILLID")+"_"+rs.getString("DATE1")+".jpg";
 				
 				FileOutputStream f = new FileOutputStream(new File("C:/Users/Srikanth.Lakshman/git/vems1/vemas/src/main/webapp/upload/"+name));
 				
				i++;
				int c = 0;
				while ((c = in.read()) != -1) {
					f.write(c);
				}
		bill.setImageName(name);
				blist.add(bill);
				System.out.println("in Dao"+blist);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}
		return blist;
	}

	@SuppressWarnings("resource")
	@Override
	public List<Billes> getBillByVendorName(String vendor) {
		List<Billes> blist =new ArrayList<Billes>();
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement("select * from  BILLES where VENDORNAME=?;");
			pstmt.setString(1, vendor);
			rs=pstmt.executeQuery();
			int i = 0;
			while(rs.next()){
				Billes bill=new Billes();
				bill.setBillNo(rs.getString("BILLID"));
				bill.setShopName(rs.getString("VENDORNAME"));
				 
				bill.setAmount(rs.getString("AMOUNT"));
				bill.setName(rs.getString("NAME"));
				bill.setMobile(rs.getString("MOBILE"));
				bill.setDate1(rs.getDate("DATE1"));
				 
				InputStream in = rs.getBinaryStream("PHOTO");
 				String name=rs.getString("BILLID")+"_"+rs.getString("DATE1")+".jpg";
 				
 				FileOutputStream f = new FileOutputStream(new File("C:/Users/Srikanth.Lakshman/git/vems1/vemas/src/main/webapp/upload/"+name));
 				
				i++;
				int c = 0;
				while ((c = in.read()) != -1) {
					f.write(c);
				}
		bill.setImageName(name);
				blist.add(bill);
				System.out.println("in Dao"+blist);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			daoUtil.close(con, stmt, pstmt, rs);

		}
		return blist;
	}
	}
 

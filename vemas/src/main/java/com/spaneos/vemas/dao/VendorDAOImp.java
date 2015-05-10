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

import org.springframework.security.core.userdetails.User;

import com.spaneos.vemas.pojo.user_d;
import com.spaneos.vemas.pojo.Bank;
import com.spaneos.vemas.pojo.Billes;
import com.spaneos.vemas.pojo.Contact;
 
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
			pstmt.setString(8, vendor.getVendorCode());
			pstmt.setString(9, vendor.getVendorMobileNumber1());
			pstmt.setString(10, vendor.getVendorMobileNumber2());
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
			pstmt.setString(8, contact.getMobile1());
			pstmt.setString(9, contact.getMobile2());
			pstmt.setString(10, contact.getEmail1());
			pstmt.setString(11, contact.getEmail2());
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
				vendor.setVendorCode(rs.getString("VENDORCODE"));
				vendor.setVendorMobileNumber1(rs.getString("MOBILE1"));
				vendor.setVendorMobileNumber2(rs.getString("MOBILE2"));
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
				contact.setMobile(rs.getString("MOBILE"));
				contact.setMobile1(rs.getString("MOBILE1"));
				contact.setMobile2(rs.getString("MOBILE2"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setEmail1(rs.getString("EMAIL1"));
				contact.setEmail2(rs.getString("EMAIL2"));
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
				vendor.setVendorCode(rs.getString("VENDORCODE"));
				vendor.setVendorMobileNumber1(rs.getString("MOBILE1"));
				vendor.setVendorMobileNumber2(rs.getString("MOBILE2"));

			}
			return vendor;
		} catch (Exception e) {

		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}

		return null;
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
		    pstmt.setDate(7, java.sql.Date.valueOf(billes.getDate()));
		   

				 
			
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
				f.close();
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
	public user_d getPassword(String name) {
		 con=daoUtil.getConnection();
		 user_d admin=new user_d();
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
	public List<Billes> getBillByDate(String Date) {
		List<Billes> blist =new ArrayList<Billes>();
		try {
			con=daoUtil.getConnection();
			pstmt=con.prepareStatement("select * from BILLES where DATE1=?;");
			pstmt.setDate(1,  java.sql.Date.valueOf(Date));
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
				f.close();
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
				f.close();
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

	@Override
	public List<Billes> getBillByDate(Date Date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vendor> getAllVendors() {
		List<Vendor> vendorList = new ArrayList<Vendor>();
		try {
			con = daoUtil.getConnection();
			pstmt = con.prepareStatement(GET_ALLVENDORS);
		 
			rs = pstmt.executeQuery();
			int i = 1;
			List<Contact> contactList = new ArrayList<Contact>();
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
				vendor.setVendorCode(rs.getString("VENDORCODE"));
				 
				vendor.setVendorMobileNumber1(rs.getString("MOBILE1"));
				vendor.setVendorMobileNumber2(rs.getString("MOBILE2"));
				Contact contact = new Contact();
			 
				contact.setName(rs.getString("CONTACTNAME"));
				contact.setDesignation(rs.getString("DESIGNATION"));
				contact.setMobile(rs.getString("MOBILE"));
				contact.setEmail(rs.getString("EMAIL"));
				contact.setEmploymentStatus(rs.getString("EMPLOYEMENTSTATUS"));
				contact.setReportingManager(rs.getString("REPORTINGMANAGER"));
				contactList.add(contact);
				vendor.setVendorContacts(contactList);
				vendorList.add(vendor);
			}
			 
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			daoUtil.close(con, stmt, pstmt, rs);
		}

		return vendorList;
		 
		 
	}

	@Override
	public List<Bank> getBankdetiles(String name) {
		 List<Bank> blist=new ArrayList<Bank>();
		 con=daoUtil.getConnection();
			try {
				pstmt=con.prepareStatement("select * from bank where VANDORNAME LIKE ?");
				pstmt.setString(1,"%"+name+"%");
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
					blist.add(bank);
					System.out.println(bank);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				daoUtil.close(con, stmt, pstmt, rs);

			}
		return blist;
	}

	@Override
	public boolean isadmin(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public user_d getUser(String name) {
		user_d user_d=new user_d();
		  con=daoUtil.getConnection();
		  try {
			pstmt=con.prepareStatement("select username, role from user_roles where username=?");
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			while(rs.next()){
			user_d.setName(rs.getString(2));
			user_d.setRole(rs.getString(3));
			
			}
		} catch (SQLException e) {
		 
			e.printStackTrace();
		}
		return user_d;
	}
	}
 

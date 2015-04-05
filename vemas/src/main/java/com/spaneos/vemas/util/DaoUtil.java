package com.spaneos.vemas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DaoUtil {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static DaoUtil daoUtil = null;
	
	private DaoUtil() {
		
	}
	
	public static DaoUtil getObject() {
		if(daoUtil == null)
				daoUtil = new DaoUtil();
		
		return daoUtil;
	}
	
	public Connection getConnection() {
		try {
			Properties pro = new Properties();
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("DB.properties"));
			Class.forName(pro.getProperty("DriverName"));
			con = DriverManager.getConnection(pro.getProperty("URL"),pro);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void closeAllResources() {
		try {
			if(rs != null)
				rs.close();
			
			if(pstmt != null)
				pstmt.close();
			
			if(stmt != null)
				stmt.close();
			
			if(con != null)
				con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con,Statement stmt,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(rs != null)
				rs.close();
			
			if(pstmt != null)
				pstmt.close();
			
			if(stmt != null)
				stmt.close();
			
			if(con != null)
				con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

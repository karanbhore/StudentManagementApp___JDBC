package com.prowings.student_manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class TestConnectivity {
	
		
		public static void main(String[] args) {

			Student std1 = new Student(10, "Ram", "66565","koj");

			// store std1 into DB - table

			// Steps to connect DB

			Connection con = null;

			try {
				// 1-Register the Driver class
				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2-Create Connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "Pass@123");
				
				//3-Create Statement
				java.sql.Statement stmt =  con.createStatement();
				
				//4-Execute the Query
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select * from students");
				
				int sid;
				String sname;
				String sphone;
				String scity;
				
				//print the ResultSet
	            while (rs.next()) {
	                sid = rs.getInt("sid");
	                sname= rs.getString("sname").trim();
	                sphone= rs.getString("sphone").trim();
	                scity=rs.getString("scity");
	                System.out.println("Roll : "+sid+"    Name : "+sname+ "    city: "+scity);
	            }
				
				
				

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
	}

}

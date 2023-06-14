package com.prowings.student_manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	public static boolean insertStudentToDB(Student st) {

		boolean f = false;
		try {
//		jdbc code to insert...
			Connection conn = ConnectionProvider.createC();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";

//		prepared statement
			PreparedStatement pstmt = conn.prepareStatement(q);

//		set the values of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

//		execute ...
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;

	}

	public static boolean deleteStudent(int userId) {

		boolean f = false;
		try {
//		jdbc code to insert...
			Connection conn = ConnectionProvider.createC();
			String q = "delete from students where sid=?";

//		prepared statement
			PreparedStatement pstmt = conn.prepareStatement(q);

//		set the values of parameter
			pstmt.setInt(1, userId);
			
//		execute ...
			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;


		
		
	}

	public static void showAllStudents() {
		boolean f = false;
		try {
//		jdbc code to insert...
			Connection conn = ConnectionProvider.createC();
			String q = "select * from students;";

		Statement stmt=conn.createStatement();
		ResultSet set=stmt.executeQuery(q);
		
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString(4);
			
			System.out.println("student from database...");
			System.out.println("Id "+id);
			System.out.println("Name "+name);
			System.out.println("phone "+phone);
			System.out.println("city "+city);
			System.out.println("++++++++++++++++++++++++++++++++");
		}
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	
}

package com.prowings.student_manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	static Connection conn;

	public static Connection createC() {
		try {
//		load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

//      create the connection
//			String user = "root";
//			String password = "Pass@123";
			// 2-Create Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_manage", "root", "Pass@123");

//			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;

	}
}

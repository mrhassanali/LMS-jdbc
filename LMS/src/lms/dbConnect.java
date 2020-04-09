package lms;

import java.sql.*;
public class dbConnect {

	public Connection db(){
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DB_URL = "jdbc:mysql://localhost:3306/lms";
			String DB_USER = "root";
			String DB_PASSWORD = "technicalhassanali";
			Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
			
//			if(con!=null) {
//				System.out.println("Connection Eastablished");
//			}
			return con;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}

	}

}

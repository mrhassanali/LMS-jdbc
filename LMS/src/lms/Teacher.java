package lms;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Teacher {

	static Connection con = null;
	static Statement stmt = null;
	public static void show()throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		dbConnect database = new dbConnect();
		con = database.db();
		Statement st = con.createStatement();
		stmt = st;
		
		 while(true) {
			 System.out.println("Press 1: Show Teacher Data");
			 System.out.println("Press 2: Insert New Teacher Data");
			 System.out.println("Press 3: Update Teacher Data");
			 System.out.println("Press 4: Delete Teacher Data");
			 System.out.println("Press 5: Back");
			 int a = Integer.parseInt(Bf.readLine());
			 
			 if(a==1) {
				 showteacher();
			 }else if(a==2) {
				 insertTeacher();
			 }else if(a==3) {
				 UpdateTeacher();
			 }else if(a==4) {
				 DeleteTeacher();
			 }else if(a==5) {
				 break;
			 }else {
					System.out.println("\t\t\t--------------------");
					System.out.println("\t\t\tEnter Correct Number");
					System.out.println("\t\t\t--------------------");
				}	 
		 }//close while loop
	}
	
	public static void showteacher() {
		try {
			 String Query = "Select * from lms.teacher";
			 ResultSet rs = stmt.executeQuery(Query);
			 System.out.format("+---------------------+-----------------+------------------------+----------------------+%n");
			 System.out.format("|        Name         |     Teacher ID  |     Qualification      |    Department Name   |%n");
			 System.out.format("+---------------------+-----------------+------------------------+----------------------+%n");

				while(rs.next()) {
					String n=String.format("| %-20s",rs.getString("Name"));
					String id = String.format("| %-16s",rs.getString("ID"));
					String qulifi =String.format("| %-23s", rs.getString("Qualification"));
					String depart =String.format("| %-21s|",rs.getString("Department"));
					
					System.out.println(n+""+id+""+qulifi+""+depart);
					}
				 System.out.format("+---------------------+-----------------+------------------------+----------------------+%n");

				
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void insertTeacher() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Teacher Name = ");
			String tname =Bf.readLine();
		System.out.print("Teacher ID = ");
			String tid = Bf.readLine();
		System.out.print("Teacher Qualification = ");
			String tqualification = Bf.readLine();
		System.out.print("Department = ");
			String tdepart = Bf.readLine();
			
		
		String Query = "Insert into teacher(Name,ID,Qualification,Department)values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1,tname);
			pst.setString(2,tid);
			pst.setString(3,tqualification);
			pst.setString(4,tdepart);
			pst.executeUpdate();
		
		
		System.out.println("_____________________________");
		System.out.println("Record Insert Sucessfully");
		System.out.println("_____________________________");
		

		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void DeleteTeacher() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("Enter Teacher ID = ");
			String s = Bf.readLine();
			
			String query = "Delete From teacher where ID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, s);
			int check = pst.executeUpdate();
			if(check>0) {
				System.out.println("Data Delete Successfully");
			}else {
				System.out.println("Record Not Delete Check ID");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void UpdateTeacher() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Teacher ID = ");
			String tid = Bf.readLine();
			System.out.print("Teacher Name = ");
			String tname =Bf.readLine();
		System.out.print("Teacher Qualification = ");
			String tqualification = Bf.readLine();
		System.out.print("Department = ");
			String tdepart = Bf.readLine();
			
			String Query = "update teacher SET Name=?,ID=?,Qualification=?,Department=? where ID =?";
			PreparedStatement pst = con.prepareStatement(Query);
			
			pst.setString(1,tname);
			pst.setString(2, tid);
			pst.setString(3,tqualification);
			pst.setString(4,tdepart);
			pst.setString(5,tid);
			
			int result = pst.executeUpdate();
			 if(result>0) {
				 System.out.println("_____________________________");
				 System.out.println("Record Updated Sucessfully");
				 System.out.println("_____________________________");
			 }else {
				 System.out.println("________________________");
				 System.out.println("Record Not Updated");
				 System.out.println("________________________");
			 }
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

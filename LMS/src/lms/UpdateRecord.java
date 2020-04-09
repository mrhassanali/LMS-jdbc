package lms;

import java.sql.*;
import java.io.*;
public class UpdateRecord {
	
	static Connection con = null;
	static Statement stmt = null;
	
	public void show() throws Exception{
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		dbConnect database = new dbConnect();
		 con = database.db();
		 Statement statement = con.createStatement();
		 stmt = statement;
		 
		 while(true) {
			 System.out.println("Press 1: Update Student Data");
			 System.out.println("Press 2: Update Student Address Data");
			 System.out.println("Press 3: Back");
			 int a = Integer.parseInt(Bf.readLine());
			 
			 if(a==1) {
				 UpdateProfile();
			 }else if(a==2) {
				 UpdateAddress();
			 }else if(a==3) {
				 break;
			 }else {
					System.out.println("\t\t\t--------------------");
					System.out.println("\t\t\tEnter Correct Number");
					System.out.println("\t\t\t--------------------");
				}	 
		 }//close while loop

	}//close method
	
	public static void UpdateProfile() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Student ID = ");
			String sid =Bf.readLine();
		System.out.print("First Name = ");
			String firstname = Bf.readLine();
		System.out.print("Last Name = ");
			String lastname = Bf.readLine();
			String fullname = firstname + " " + lastname;
		System.out.print("Father Name = ");
			String fathername = Bf.readLine();
		System.out.print("Email Address = ");
			String email = Bf.readLine();
		System.out.print("Age = ");
			int age = Integer.parseInt(Bf.readLine());
			
			String Query = "update Student_Profile SET First_Name=?,Last_Name=?,Name=?,Father_Name=?,Email_Address=?,Age=? where Student_ID =?";
			PreparedStatement pst = con.prepareStatement(Query);
			
			pst.setString(1,firstname);
			pst.setString(2,lastname);
			pst.setString(3,fullname);
			pst.setString(4,fathername);
			pst.setString(5,email);
			pst.setInt(6,age);
			pst.setString(7,sid);
			
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
	
	public static void UpdateAddress() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.print("Student ID = ");
			String sid =Bf.readLine();
		System.out.print("Phone No = ");
			String sphone = Bf.readLine();
		System.out.print("Mailing Address = ");
			String smail = Bf.readLine();
		System.out.print("Parmanant Address = ");
			String sparmanant = Bf.readLine();
			
		
		String Query = "update Student_Address SET Phone_Number=?,Mailing_Address=?,Parmanant_Address=? where Student_ID=?";
		PreparedStatement pst = con.prepareStatement(Query);
			
			pst.setString(1,sphone);
			pst.setString(2,smail);
			pst.setString(3,sparmanant);
			pst.setString(4,sid);
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

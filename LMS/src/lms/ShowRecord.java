package lms;

import java.sql.*;
import java.io.*; 						//For BufferedReader
public class ShowRecord {
	static Connection con = null;
	static Statement stmt = null;
	public static void show() throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		dbConnect database = new dbConnect();
		 con = database.db();
		 Statement statement = con.createStatement();
		 stmt = statement;
		 
		 while(true) {
			 System.out.println("Press 1 : Show Student Profile");
			 System.out.println("Press 2 : Show Student Address");
			 System.out.println("Press 3 : Back");
			 int n = Integer.parseInt(Bf.readLine());
			 if(n==1) {
				 studentProfile();   //call student profile Method
			 }else if(n==2) {
				 studentAddress();
			 }else if(n==3) {
				 break;
			 }else {
				 System.out.println("Enter Correct Number");
			 }
		 }//close while loop
		 
		 
		 
		 
		 
		 
		 
		 
	}//close main
	
	
	public static void studentProfile() {
		 try {
			 String Query = "Select * from lms.Student_Profile where Student_ID='bsf1905804'";
			 ResultSet rs = stmt.executeQuery(Query);
			 System.out.format("+------------+-----------------+----------------+----------------+--------------------------+--------------------+-------------------------------+-----+%n");
			 System.out.format("| Student ID | Registration No |  First Name    |    Last Name   |        Name              |     Father Name    |          Email Address        | Age |%n");
			 System.out.format("+------------+-----------------+----------------+----------------+--------------------------+--------------------+-------------------------------+-----+%n");

				while(rs.next()) {
					String std_id=String.format("| %-11s",rs.getString("Student_ID"));
					String registration = String.format("| %-16s",rs.getString("Registration_No"));
					String firstname =String.format("| %-15s", rs.getString("First_Name"));
					String lastname =String.format("| %-15s",rs.getString("Last_Name"));
					String fullname =String.format("| %-25s",rs.getString("Name"));
					String fathername = String.format("| %-19s",rs.getString("Father_Name"));
					String email_address = String.format("| %-30s",rs.getString("Email_Address"));
					String sage = String.format("| %-4s|",rs.getString("Age"));
					
					System.out.println(std_id+""+registration+""+firstname+""+lastname+""+fullname+""+fathername+""+email_address+""+sage);
					}
				System.out.format("+------------+-----------------+----------------+----------------+--------------------------+--------------------+-------------------------------+-----+%n");
				
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }//close Student Profile Method
	
	public static void studentAddress() {
		try {
			String Address_Query = "Select * from lms.Student_Address";
			ResultSet rs = stmt.executeQuery(Address_Query);
			 System.out.format("+------------+-----------------+----------------------------------+------------------------------------+%n");
			 System.out.format("| Student ID |    Phone Number |           Mailing Address        |        Permanant Address           |%n");
			 System.out.format("+------------+-----------------+----------------------------------+------------------------------------+%n");
			 while(rs.next()) {

					String sid = String.format("| %-11s",rs.getString("Student_ID"));
					String sphone = String.format("| %-16s",rs.getString("Phone_Number"));
					String smail =String.format("| %-33s", rs.getString("Mailing_Address"));
					String peramanant =String.format("| %-34s |",rs.getString("Parmanant_Address"));
					System.out.println(sid+""+sphone+""+smail+""+peramanant);
			 	}
			 System.out.format("+------------+-----------------+----------------------------------+------------------------------------+%n");
			 }catch(Exception e) {
			System.out.println(e);
		}
	}

	
}//close class

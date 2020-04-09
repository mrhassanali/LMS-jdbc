package lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InsertRecord {
	static Connection con = null;
	static Statement stmt = null;
	public void khan() throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		dbConnect database = new dbConnect();
		 con = database.db();
		 Statement statement = con.createStatement();
		 stmt = statement;
		 
		 while(true) {
				System.out.println("Press 1 : Insert Student Data");
				System.out.println("Press 2 : Insert Student Address");
				System.out.println("Press 3 : Back");
				int n = Integer.parseInt(Bf.readLine());
				if(n==1) {
					insertStudent();
				}else if(n==2) {
					StudentAddress();
				}else if(n==3) {
					break;
				}else {
					System.out.println("\t\t\t--------------------");
					System.out.println("\t\t\tEnter Correct Number");
					System.out.println("\t\t\t--------------------");
				}
			}//close while	
	}
	
	public static void insertStudent() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {			
			System.out.print("Student ID = ");
				String sid =Bf.readLine();
			System.out.print("Registration No = ");
				String registration = Bf.readLine();
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
			
			String Query = "Insert into Student_Profile(Student_ID,Registration_No,First_Name,Last_Name,Name,Father_Name,Email_Address,Age)values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(Query);
				pst.setString(1,sid);
				pst.setString(2,registration);
				pst.setString(3,firstname);
				pst.setString(4,lastname);
				pst.setString(5,fullname);
				pst.setString(6,fathername);
				pst.setString(7,email);
				pst.setInt(8,age);
				pst.executeUpdate();
			
			
			System.out.println("_____________________________");
			System.out.println("Record Insert Sucessfully");
			System.out.println("_____________________________");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}//close insert Data Method
	
	
	public static void StudentAddress() {
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
				
			
			String Query = "Insert into student_address(Student_ID,Phone_Number,Mailing_Address,Parmanant_Address)values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(Query);
				pst.setString(1,sid);
				pst.setString(2,sphone);
				pst.setString(3,smail);
				pst.setString(4,sparmanant);
				pst.executeUpdate();
			
		
			System.out.println("________________________________");
			System.out.println("Address Record Insert Sucessfully");
			System.out.println("________________________________");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}//close insert Data Method
	
}

package lms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
public class Course {

	static Connection con = null;
	static Statement stmt = null;
	public static void show() throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));

		dbConnect database = new dbConnect();
		con = database.db();
		Statement statement = con.createStatement();
		stmt = statement;
		
		while(true) {
			 System.out.println("Press 1 : Show Course");
			 System.out.println("Press 2 : Insert New Course");
			 System.out.println("Press 3 : Course Selection");
			 System.out.println("Press 4 : Show Select Course");
			 System.out.println("Press 5 : Delete Course");
			 System.out.println("Press 6 : Back");
			 int n = Integer.parseInt(Bf.readLine());
			 if(n==1) {
				 selectCourse();   //call student profile Method
			 }else if(n==2) {
				 InsertCourse();
			 }else if(n==3) {
				 course_selection();
			 }else if(n==4) {
				 showSelectCourse();
			 }else if(n==5) {
				 DeleteCourse();
			 }
			 else if(n==6) {
				 break;
			 }else {
				System.out.println("\t\t\t--------------------");
				System.out.println("\t\t\tEnter Correct Number");
				System.out.println("\t\t\t--------------------");
			 }
		 }//close while loop
	}
	
	public static void selectCourse() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String Query = "select * from lms.course";
			 ResultSet rs = stmt.executeQuery(Query);
			 System.out.format("+--------------+------------------------+--------------------------------------------+----------------+%n");
			 System.out.format("|  Course Code |           Name         |                Description                 |    Credit Hours|%n");
			 System.out.format("+--------------+------------------------+--------------------------------------------+----------------+%n");

			 while(rs.next()) {
				String courseId=String.format("| %-13s",rs.getString("Course_Code"));
				String Name = String.format("| %-23s",rs.getString("Name"));
				String Description =String.format("| %-43s", rs.getString("Description"));
				String Credit =String.format("| %-14s |",rs.getString("Credit_Hours"));
				System.out.println(courseId+""+Name+""+Description+""+Credit);
			 
			 }
			 System.out.format("+--------------+------------------------+--------------------------------------------+----------------+%n");

		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public static void InsertCourse() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String Query = "insert into Course(Course_Code,Name,Description,Credit_Hours)values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(Query);
			System.out.println("Course Code = ");
			String course_id=Bf.readLine();
			System.out.println("Name = ");
			String name=Bf.readLine();
			System.out.println("Description = ");
			String desc=Bf.readLine();
			System.out.println("Credit Hours = ");
			String hours=Bf.readLine();
			
			pst.setString(1, course_id);
			pst.setString(2, name);
			pst.setString(3, desc);
			pst.setString(4, hours);
			int check = pst.executeUpdate();
			if(check>0) {
				System.out.println("Course Added Successfully");
			}else {
				System.out.println("Error Check Data");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void course_selection() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			
			String Query = "insert into course_selection(Student_ID,Course_Code,Course_Name,Teacher_ID)values(?,?,?,?)";
			 
			System.out.println("Student ID");
				String std_id = Bf.readLine();
			System.out.println("Course Code = ");
				String course_id=Bf.readLine();
				System.out.println("Name = ");
				String name=Bf.readLine();
			System.out.println("Teacher ID = ");
				String tname=Bf.readLine();
				
		    PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, std_id);
			pst.setString(2, course_id);
			pst.setString(3, name);
			pst.setString(4, tname);
			int check = pst.executeUpdate();
			if(check>0) {
				System.out.println("Course Select Successfully");
			}else {
				System.out.println("Error Check Data");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	public static void showSelectCourse() {
		try {
			BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
			try {
				
				String Query = "Select * from lms.course_selection";
				 
				
				 System.out.format("+------------+-----------------+------------------------+----------------+--------------------------+--------------------+%n");
				 System.out.format("| Student ID |    Course Code  |       Course Name      |    Teacher ID  | Obtained_Number          |   Total_Number     |%n");
				 System.out.format("+------------+-----------------+------------------------+----------------+--------------------------+--------------------+%n");
				 ResultSet rs = stmt.executeQuery(Query);
					while(rs.next()) {
						String std_id=        String.format("| %-11s",rs.getString("Student_ID"));
						String ccode =        String.format("| %-16s",rs.getString("Course_Code"));
						String cname =        String.format("| %-23s", rs.getString("Course_Name"));
						String teacherid =    String.format("| %-15s",rs.getString("Teacher_ID"));
						String obtn_number =  String.format("| %-25s",rs.getString("Obtained_Number"));
						String total_number = String.format("| %-19s|", rs.getString("Total_Number"));
						System.out.println(std_id+""+ccode+""+cname+""+teacherid+""+obtn_number+""+total_number);
						}
					System.out.format("+------------+-----------------+------------------------+----------------+--------------------------+--------------------+%n");
				}	
			catch(Exception e) {
				System.out.println(e);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void DeleteCourse() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Student ID");
			String std_id = Bf.readLine();
			
			System.out.println("Course Code = ");
			String course_code=Bf.readLine();
			
			String Query = "Delete from course_selection where Course_Code=? and Student_ID=?";
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, course_code);
			pst.setString(2, std_id);
			int check = pst.executeUpdate();
			if(check>0) {
				System.out.println("Course Delete Successfully");
			}else {
				System.out.println("Error Check Course Code");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}

package lms;

import java.sql.*;
import java.io.*;
public class Challen {
	static Connection con = null;
	static Statement stmt = null;
	public static void show() throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		dbConnect database = new dbConnect();
		 con = database.db();
		 Statement statement = con.createStatement();
		 stmt = statement;
		 
		 while(true) {
			 System.out.println("Press 1: See Challen");
			 System.out.println("Press 2: Insert New Challen");
			 System.out.println("Press 3: Add Paid Date or Status");
			 System.out.println("Press 4: Back");
			 int a = Integer.parseInt(Bf.readLine());
			 
			 if(a==1) {
				 seeChallen();  	
			 }else if(a==2) {
				 newChallen();   	
			 }else if(a==3) {
				 updateChallen();  
			 }else if(a==4) {
				 break;
			 }else {
					System.out.println("\t\t\t--------------------");
					System.out.println("\t\t\tEnter Correct Number");
					System.out.println("\t\t\t--------------------");
				}	 
		 }//close while loop		 
	}//close main 
	
	
	private static void seeChallen() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		 try {
			 String Query = "Select * from Challen";
			 ResultSet rs = stmt.executeQuery(Query);			 
			 
				 while(rs.next()) {
					 
					 System.out.println("________________________________________");
					 System.out.println("Student ID = " +rs.getString("Student_ID"));
					 System.out.println("Semester   = " +rs.getString("Semester"));
					 System.out.println("Shift M/E  = " +rs.getString("Shift"));
					 System.out.println("Challen No = "+rs.getString("Challen_No"));
					 System.out.println("Amount     = "+rs.getString("Amount"));
					 System.out.println("Fine       = "+rs.getString("Fine"));
					 System.out.println("Due Date   = "+rs.getString("Due_Date"));
					 System.out.println("Paid Date  = "+rs.getString("Paid_Date"));
					 System.out.println("Status     = "+rs.getString("Status"));
					 System.out.println("________________________________________");
				 } 
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }//close
	
	
	
	private static void newChallen() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			 System.out.print("Student ID = ");
			 	String sid = Bf.readLine();
			 System.out.print("Semester = ");
			 	String semester = Bf.readLine();
			 System.out.print("Shift M/E = ");
			 	String shift = Bf.readLine();
			 System.out.print("Department = ");
			 	String department = Bf.readLine();
			 System.out.println("Challen No = ");
			 	String schallen = Bf.readLine();
			 System.out.print("Amount  = ");
			 	String samount = Bf.readLine();
			 System.out.print("Fine  = ");
			 	String sfine = Bf.readLine();
			 System.out.print("Due Date   = ");
			 	String Due_Date = Bf.readLine();
			 	
		 	String Query = "INSERT INTO Challen(Student_ID,Challen_No,Amount,Fine,Due_Date,Semester,Shift,Department)VALUES(?,?,?,?,?,?,?,?)";
			 PreparedStatement pst = con.prepareStatement(Query);	
			 pst.setString(1,sid);
			 pst.setString(2,schallen);
			 pst.setString(3,samount);
			 pst.setString(4,sfine);
			 pst.setString(5,Due_Date);
			 pst.setString(6,semester);
			 pst.setString(7,shift);
			 pst.setString(8,department);
			int check= pst.executeUpdate(); 
			if(check>0) {
				System.out.println("\t\t\t+______________________+");
				System.out.println("\t\t\t| Data ADD Sucessfully |");
				System.out.println("\t\t\t+______________________+");
			}else {
				System.out.println("\t\t\t--------------------");
				System.out.println("\t\t\tPlease enter Correct Data");
				System.out.println("\t\t\t--------------------");
			   }
			 
			 
		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }//close 

	public static void updateChallen() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			 String Query = "Update Challen Set Paid_Date=?,Status=? where Student_ID=?";
			 PreparedStatement pst = con.prepareStatement(Query);
			 System.out.print("Student ID = ");
			 	String sid = Bf.readLine();
			 System.out.print("Paid Date = ");
			 	String paid_date = Bf.readLine();
			 System.out.print("Status Paid/Not Paid = ");
			 	String status = Bf.readLine();
			 pst.setString(1,paid_date);
			 pst.setString(2,status);
			 pst.setString(3,sid);
			 int Add_Tuple = pst.executeUpdate();  // pst.executeUpdate() return 1 row that affected
			 
			 if(Add_Tuple>0) {
				 System.out.println("\t\t\t+______________________+");
				 System.out.println("\t\t\t| Data ADD Sucessfully |");
				 System.out.println("\t\t\t+______________________+");
			 }else {
				System.out.println("\t\t\t--------------------");
				System.out.println("\t\t\tPlease enter Correct Data");
				System.out.println("\t\t\t--------------------");
			 }
			 

		 }catch(Exception e) {
			 System.out.println(e);
		 }
	 }//close 
	
	
}

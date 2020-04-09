package lms;

import java.sql.*;
import java.io.*;
public class Result {
	
	static Connection con = null;
	static Statement stmt = null;
	public static void ResultShow() throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		dbConnect database= new dbConnect();
		con=database.db();
		Statement st = con.createStatement();
		stmt = st;
		
		
		while(true) {
			System.out.println("Press 1 : Show Grade");
			System.out.println("Press 2 : Insert Grade");
			System.out.println("Press 3 : Delete Record");
			System.out.println("Press 4 : Back");
			int n = Integer.parseInt(Bf.readLine());
			if(n==1) {
				showResult();
			}else if(n==2) {
				InsertResult();
			}else if(n==3) {
				deleteRecord();
			}else if(n==4) {
				break;
			}else {
				System.out.println("\t\t\t--------------------");
				System.out.println("\t\t\tEnter Correct Number");
				System.out.println("\t\t\t--------------------");
			}
		}//close while
	

	}
	
	private static void showResult() throws IOException {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Student ID = ");
			String sid = Bf.readLine();
			System.out.println("Semester = ");
			String sm = Bf.readLine();
			PreparedStatement pst = con.prepareStatement("select * from detail_grade where Student_ID=? and Semester=?");
			pst.setString(1, sid);
			pst.setString(2, sm);
			ResultSet rs = pst.executeQuery();
			
			System.out.format("+--------------+---------------+----------+----------------------+-------+--------------+------------+-------+%n");
			System.out.format("| Year         | Course Code   |   Status |      Subject Name    | Score | Obtained CGPA| Total CGPA | Grade |%n");
			System.out.format("+--------------+---------------+----------+----------------------+-------+--------------+------------+-------+%n");

			while(rs.next()) {
				String syear = String.format("| %-13s",rs.getString("Year"));
				String ccode = String.format("| %-14s",rs.getString("course_code"));
				String status =String.format("| %-9s", rs.getString("status"));
				String subject_name =String.format("| %-21s",rs.getString("Subject_Name"));
				String subject_score =String.format("| %-6s",rs.getString("Score"));
				String obtn_no = String.format("| %-13s",rs.getString("Obtained_CGPA"));
				String total_no = String.format("| %-11s",rs.getString("Total_CGPA"));
				String grade = String.format("| %-6s|",rs.getString("Grade"));
				
 			    System.out.println(syear+""+ccode+""+status+""+subject_name+""+subject_score+""+obtn_no+""+total_no+""+grade);
			
				}
			System.out.format("+--------------+---------------+----------+----------------------+-------+--------------+------------+-------+%n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void InsertResult() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String insert_Query = "Insert into detail_grade(Student_ID,Year,Course_code,Status,Subject_Name,Score,Obtained_CGPA,Total_CGPA,Grade,Semester)values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(insert_Query);
			System.out.print("Student ID =");
				String sid = Bf.readLine();
			System.out.print("Year Like Fall/Spring 2000 =");
				String syear = Bf.readLine();
			System.out.print("Course ID =");
				String cid = Bf.readLine();
			System.out.print("Status =");
				String st = Bf.readLine();
			System.out.print("Subject Name =");
				String subjectName = Bf.readLine();
			System.out.print("Score =");
				String score = Bf.readLine();
			System.out.print("Obtained CGPA =");
				String obt_cgpa = Bf.readLine();
			System.out.print("Total CGPA =");
				String total_cgpa = Bf.readLine();
			System.out.print("Grade=");
				String sgarde = Bf.readLine();
			System.out.print("Semester =");
				String semester = Bf.readLine();
			pst.setString(1, sid);
			pst.setString(2, syear);
			pst.setString(3, cid);
			pst.setString(4, st);
			pst.setString(5, subjectName);
			pst.setString(6, score);
			pst.setString(7, obt_cgpa);
			pst.setString(8, total_cgpa);
			pst.setString(9, sgarde);
			pst.setString(10, semester);
			pst.executeUpdate();
			
			System.out.println("_________________________________________");
			System.out.println("Result Added Sucessfully");
			System.out.println("_________________________________________");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	public static void deleteRecord() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Student ID = ");
			String sid = Bf.readLine();
			System.out.println("Semester = ");
			String sm = Bf.readLine();
			String Query = "Delete From detail_grade where Student_ID=? and Semester=?";
			PreparedStatement pst = con.prepareStatement(Query);
			pst.setString(1, sid);
			pst.setString(2, sm);
			pst.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}//close Delete Record

}//close class

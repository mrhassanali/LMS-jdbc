package lms;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Delete {

	static Connection con = null;
	static Statement stmt = null;
	public static void Data()throws Exception {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		
		dbConnect database = new dbConnect();
		con=database.db();
		Statement st = con.createStatement();
		stmt = st;
		
		
		
		while(true){
			System.out.println("Press 1: Delete Profile Record");
			System.out.println("Press 2: Delete Address Record");
			System.out.println("Press 3: Back");
			int n = Integer.parseInt(Bf.readLine());
			if(n==1) {
				DeleteData();
			}else if(n==2) {
				DeleteAddress() ;
			}else if(n==3) {
				break;
			}else {
				System.out.println("\t\t\t--------------------");
				System.out.println("\t\t\tEnter Correct Number");
				System.out.println("\t\t\t--------------------");
			}
		}
		
		
	}
	
	
	public static void DeleteData() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Student ID");
			String sid = Bf.readLine();
			
			String query = "Delete From Student_profile where Student_ID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, sid);
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
	public static void DeleteAddress() {
		BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter Student ID");
			String sid = Bf.readLine();
			
			String query = "Delete From Student_Address where Student_ID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, sid);
			int check = pst.executeUpdate();
			if(check>0) {
				System.out.println("Address Delete Successfully");
			}else {
				System.out.println("Address Not Delete Check ID");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}

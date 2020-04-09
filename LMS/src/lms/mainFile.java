package lms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
public class mainFile {
	static Connection con = null;
	public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			BufferedReader Bf = new BufferedReader(new InputStreamReader(System.in));
			dbConnect d = new dbConnect();
			con=d.db();
			
			System.out.format("\t\t\t+---------------------------------------------------+%n");
			System.out.format("\t\t\t|         Welcome to Learning Management System      |%n");
			System.out.format("\t\t\t+---------------------------------------------------+%n");

			while(true) {
				System.out.println("Enter 1 : Insert Student Data");
				System.out.println("Enter 2 : show Student Data");
				System.out.println("Enter 3 : Update Record");
				System.out.println("Enter 4 : Course");
				System.out.println("Enter 5 : Challen");
				System.out.println("Enter 6 : Delete Record");
				System.out.println("Enter 7 : Result");
				System.out.println("Enter 8 : Teacher");
				System.out.println("Enter 9 : Exit");
				int n = Integer.parseInt(Bf.readLine());
				
				
				if(n==1) {
					InsertRecord str = new InsertRecord(); // Object of Insert Class
					str.khan();
				}else if(n==2) {
					new ShowRecord();  //Object of Show Record Class
					ShowRecord.show();
				}else if(n==3) {
					UpdateRecord up = new UpdateRecord();
					up.show();
				}else if(n==4) {
					Course c = new Course();
					c.show();
				}else if(n==5) {
					new Challen();   
					Challen.show();
				}else if(n==6) {
					new Delete();
					Delete.Data();
				}else if(n==7) {
					 new Result();
					 Result.ResultShow();
				}else if(n==8) {
					Teacher t= new Teacher();
					t.show();
				}
				else if(n==9) {
					con.close();
					break;	
				}
				else {
					System.out.println("\t\t\t--------------------");
					System.out.println("\t\t\tEnter Correct Number");
					System.out.println("\t\t\t--------------------");
				}
			}//close while loop
			System.out.format("\t\t\t+---------------------------------------------------+%n");
			System.out.format("\t\t\t|         Thanks for Using LMS                      |%n");
			System.out.format("\t\t\t+---------------------------------------------------+%n");

		}

}

package zDB_TEST;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		System.out.println("puppyfarts");
		
		String url = "jdbc:mysql://localhost:3306/vaalikone";
		String user = "student";
		String pwd = "Student1234?";
		
//		CRUDtest.insert_data(url, user, pwd, "1", "1", "1", "geez");
		
		
//		try {
//			// 1. Get a connection to database
//			Connection myConn = DriverManager.getConnection(url, user, pwd);
//			
//			//2. create statement
//			Statement myStmt = myConn.createStatement();
//			
//			//3. execute sql query
//			ResultSet myRs = myStmt.executeQuery("SELECT * FROM vaalikone.kysymykset;");
//			
//			// 4. Process the result set
//			while (myRs.next()) {
//				System.out.println(myRs.getString("KYSYMYS_ID") + ": " + myRs.getString("KYSYMYS"));			}
//		}
//		catch (Exception exc) {
//			exc.printStackTrace();
//		}


			

		
	}//main
}


class Fudge {
	
	String url = "jdbc:mysql://localhost:3306/vaalikone";
	String user = "student";
	String pwd = "Student1234?";

		try {
		// 1. Get a connection to database
		Connection myConn = DriverManager.getConnection(url, user, pwd);
		
		//2. create statement
		Statement myStmt = myConn.createStatement();
		
		//3. execute sql query
		ResultSet myRs = myStmt.executeQuery("SELECT * FROM vaalikone.kysymykset;");
		
		// 4. Process the result set
		while (myRs.next()) {
			System.out.println(myRs.getString("KYSYMYS_ID") + ": " + myRs.getString("KYSYMYS"));			
			}
	}
	catch (Exception exc) {
		exc.printStackTrace();
	}
	
	}
//	
//	
//	
//	try {
//		// 1. Get a connection to database
//		Connection myConn = DriverManager.getConnection(url, user, pwd);
//		
//		//2. create statement
//		Statement myStmt = myConn.createStatement();
//		
//		//3. execute sql query
//		ResultSet myRs = myStmt.executeQuery("SELECT * FROM vaalikone.kysymykset;");
//		
//		// 4. Process the result set
//		while (myRs.next()) {
//			System.out.println(myRs.getString("KYSYMYS_ID") + ": " + myRs.getString("KYSYMYS"));			}
//	}
//	catch (Exception exc) {
//		exc.printStackTrace();
//	}
//}


//class Fudge {
//	public String url = "jdbc:mysql://localhost:3306/vaalikone";
//	public String user = "student";
//	public String paswd = "Student1234?";
//	
//	try {
//		Connection conn = DriverManager.getConnection(url, user, paswd);
//		if (conn != null) {
//			System.out.println("insert--connected");
//			
//			String sql = "INSERT INTO vaalikone.citizenkane (citizen_ID, kysymys_id, vastaus, kommentti) VALUES (?, ?, ?, ?)";
//			try {
//				PreparedStatement statement = conn.prepareStatement(sql);
//				statement.setString(1, "1"); 
//				statement.setString(2, "1");
//				statement.setString(3, "1");
//				statement.setString(4, "looody");
//
//				int rowsInserted = statement.executeUpdate();
//				if (rowsInserted > 0) {
//					System.out.println("A new user was inserted successfully!");
//					}
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			
//		}
//	}catch (Exception exc) {
//			exc.printStackTrace();}
//	
//}

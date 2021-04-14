import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * 
 * UNUSED CRUD CLASS
 * 
 * This CRUD class was the first one created. It was not finished, 
 * as it was deemed too elaborate, and unnecessarily generalized.
 * 
 * Following versions of the project's CRUD system:
 * -CRUD.java (also scrapped)
 * -dao packages (used)
 * 
 * No further documentaion required for this section.
 * Section should not be documented in Java Docs.
 * 
 */


public class Test {
	
	/* v 1.0
	 * author: Les Heidrich
	 * email: lesheid@protonmail.com
	 * 
	 * -= STATIC methods =-
	 *  all methods are static and wrapped in try-catch so they can be
	 *  run individually..
	 * 	  - COMMAND: takes sql command -> e.g.: sql="create table test;"
	 *    - insert into table
	 *    - select from table
	 *    - alter table
	 *    - update table
	 *    - delete table
	 * 
	 * -= CONSTRUCTORS =-
	 * 	  1) default:
	 * 			-> initialized with default user settings
	 * 			-> default vaalikone connection
	 * 	  2) param.ized:
	 * 			-> all 3 attrib take params in below spec order		
	 */
	
	private static String dbURL;
	private static String username;
	private static String password;
		
	
	public Test() {		
		Test.dbURL = "jdbc:mysql://localhost:3306/vaalikone";
		Test.username = "student";
		Test.password = "Student1234?";
	}
	
	public Test(String url, String user, String pwd) {		
		Test.dbURL = url;
		Test.username = user;
		Test.password = pwd;
	}
	
	
	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	public static String getDbURL() {
		return dbURL;
	}

	public static void setDbURL(String dbURL) {
		Test.dbURL = dbURL;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Test.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Test.password = password;
	}

	
	/***************************************************
	 ********************   METHODS   ******************
	 ***************************************************/
	
//	public static void command(String sql) {
//		/*  Takes param of SQL string
//		 *  Applies desired command to DB
//		 *  Throws connection error
//		 */
//		try {
//			Connection conn = DriverManager.getConnection(dbURL, username, password);
//			if (conn != null) {
//				System.out.println("command--connected");
//				
//	            Statement statement = (Statement) conn.createStatement();
//	            try {
//	            	((java.sql.Statement) statement).executeUpdate(sql);
//	            }catch (SQLException e) {
//	            	e.printStackTrace();
//	            	System.out.println("run error--command");
//	            }     
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connection error--command!");
//		}	
//	}
	
	
	public static void insert_data(String cid, String kid, String vst, String kmt) {
		/*
		 * 
		 */
		try {
			Connection conn = DriverManager.getConnection(dbURL, username, password);
			if (conn != null) {
				System.out.println("insert--connected");
				
				String sql = "INSERT INTO vaalikone.citizenkane (citizen_ID, kysymys_id, vastaus, kommentti) VALUES (?, ?, ?, ?)";
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, cid); 
					statement.setString(2, kid);
					statement.setString(3, vst);
					statement.setString(4, kmt);

					int rowsInserted = statement.executeUpdate();
					if (rowsInserted > 0) {
						System.out.println("A new user was inserted successfully!");
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert--connection error!");
		}	
	}
	
	
//	public static void select_data() {
//		/*
//		 * 
//		 */
//		try {
//			Connection conn = DriverManager.getConnection(dbURL, username, password);
//			if (conn != null) {
//				System.out.println("Connected");
//				
//				String sql = "SELECT * FROM Users";
//				int count = 0;
//
//				try {
//					Statement statement = conn.createStatement();
//					ResultSet result = statement.executeQuery(sql);
//
//					while (result.next()) {
//						String name = result.getString(2); // using getString -version relying on column index
//						String pass = result.getString(3);
//						String fullname = result.getString("fullname"); // using getString -version relying on column name
//						String email = result.getString("email");
//
//						String output = "User #%d: %s - %s - %s - %s";
//						System.out.println(String.format(output, ++count, name, pass, fullname, email));
//					}
//
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connection error!");
//		}
//	}
	
	
//	public static void update_data() {
//		/*
//		 * 
//		 */
//		try {
//			Connection conn = DriverManager.getConnection(dbURL, username, password);
//			if (conn != null) {
//				System.out.println("Connected");
//				
//				String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
//				try {
//					PreparedStatement statement = conn.prepareStatement(sql);
//
//					statement.setString(1, password);
//					statement.setString(2, fullname);
//					statement.setString(3, email);
//					statement.setString(4, username);
//
//					int rowsUpdated = statement.executeUpdate();
//					if (rowsUpdated > 0) {
//						System.out.println("An existing user was updated successfully!");
//					}
//
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connection error!");
//		}
//	}
 
	
//	public static void delete_data() {
//		/*
//		 * 
//		 */
//		try {
//			Connection conn = DriverManager.getConnection(dbURL, username, password);
//			if (conn != null) {
//				System.out.println("Connected");
//				
//				String sql = "DELETE FROM Users WHERE username=?";
//
//				try {
//					PreparedStatement statement = conn.prepareStatement(sql);
//					
//					statement.setString(1, username);
//					 
//					int rowsDeleted = statement.executeUpdate();
//					if (rowsDeleted > 0) {
//					    System.out.println("A user was deleted successfully!");
//					}
//					
//					
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("Connection error!");
//		}
//	}
	
}//end CRUD class



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class CRUD {
	
	/* CRUD class is designed to be run through instances for tables.
	 * 
	 * -= METHODS =-
	 *  all methods are wrapped in try-catch so they can be
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
	 * 			-> takes no params
	 * 			-> default user/pwd
	 * 			-> default db: vaalikone
	 * 			-> default table: kysymykset
	 * 	  2) param.ized:
	 * 			-> all 3 attrib take params in order:
	 * 			     dbURL, username, password, table	
	 */
	
	protected String dbURL;
	protected String username;
	protected String password;
	protected String table_name;
			
		
	public CRUD() {		
		this.dbURL = "jdbc:mysql://localhost:3306/electionmachine";
		this.username = "pena";
		this.password = "kukkuu";
	}
	
	public CRUD(String url, String user, String pwd) {		
		this.dbURL = url;
		this.username = user;
		this.password = pwd;
	}
	
	
	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	public String getDbURL() {
		return dbURL;
	}

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/***************************************************
	 ********************   METHODS   ******************
	 ***************************************************/
	
	/*
	*2) answers table: user answers -> String answers into this
	*3) candidate table: answers -> returns answers Strings
	*4) answers table: user answers -> returns answers String
	*
	*/
	
	public String[] getQ() {
		/*
		 * Returns -> array of question strings
		 */
		String arrQ[] = null;
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			if (conn != null) {
				System.out.println("select--connected");
				
				String script = "SELECT * FROM electionmachine.questions;";
				java.sql.Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(script);
				
				int count = 0; 
				arrQ = new String[19];
				while (result.next()) {
				    String id = result.getString("QUESTION_ID");
				    String q = result.getString("QUESTION");
				    arrQ[count] = q;
//				    System.out.println(arrQ[count]);
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("select--connection error!\n" + dbURL + "\nTable:" + 
					"\nUser/Pwd:" + username + "/" + password);
		}
		return arrQ;
	}
	
	
	public String[] get_candA() {
		/*
		 * Returns -> array of question strings
		 * 
		 */
		String arrCA[][] = null;
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			if (conn != null) {
				System.out.println("select--connected");
				
				String script = "SELECT * FROM electionmachine.answers;";
				java.sql.Statement statement = conn.createStatement();
				ResultSet result = statement.executeQuery(script);
				
				
				/*
				 * hashmap https://stackoverflow.com/questions/1540673/java-equivalent-to-python-dictionaries
				 * hashmap -> [1, [1-19]]
				 * next step: put hash map in for loop for length of politicians
				 */
				int count = 0; 
				arrCA = new String[19][19];
				while (result.next()) {
				    String cid = result.getString("CANDIDATE_ID");
				    String qid = result.getString("QUESTION_ID");
				    String answer = result.getString("ANSWER");
				    arrCA[count] = [cid, qid, answer];
//				    System.out.println(arrQ[count]);
				    
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("select--connection error!\n" + dbURL + "\nTable:" + 
					"\nUser/Pwd:" + username + "/" + password);
		}
		return arrCA;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		public void command(String sql) {
//			/*  
//			 * Input: SQL string to run
//			 * Applies desired command to DB
//			 * Throws: connection error, run error
//			 */
//			try {
//				Connection conn = DriverManager.getConnection(dbURL, username, password);
//				if (conn != null) {
//					System.out.println("command--connected");
//					
//		            Statement statement = (Statement) conn.createStatement();
//		            try {
//		            	((java.sql.Statement) statement).executeUpdate(sql);
//		            }catch (SQLException e) {
//		            	e.printStackTrace();
//		            	System.out.println("run error--command");
//		            }     
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("insert--connection error!\n" + dbURL + 
//						"\nUser/Pwd:" + username + "/" + password);
//			}
//		}
	
//	public void insert_data(String cid, String kid, String vst, String kmt) {
//		/* 
//		 * Input: all String -> 4 values to input into table
//		 * Change: table/user/pwd/db with setter
//		 * Throws: connection error, command error
//		 * Confirms: connection, insert 
//		 */
//		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
//			if (conn != null) {
//				System.out.println("insert--connected");
//				
//				String sql = "INSERT INTO vaalikone." + table_name + " (citizen_ID, kysymys_id, vastaus, kommentti) VALUES (?, ?, ?, ?)";
//				try {
//					PreparedStatement statement = conn.prepareStatement(sql);
//					statement.setString(1, cid); 
//					statement.setString(2, kid);
//					statement.setString(3, vst);
//					statement.setString(4, kmt);
//
//					int rowsInserted = statement.executeUpdate();
//					if (rowsInserted > 0) {
//						System.out.println("A new user was inserted into " + table_name.toUpperCase() + " successfully!");
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("insert--connection error!\n" + dbURL + "\nTable:" + table_name.toUpperCase() + 
//					"\nUser/Pwd:" + username + "/" + password);
//		}	
//	}
	
	
//	public void select_data(String sql) {
//		/*
//		 * Input: param -> sql string from table name to additional options
//		 * 		  existing sql string to append: "SELECT * FROM "..
//		 * Throws: Connection error
//		 * 
//		 */
//		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
//			if (conn != null) {
//				System.out.println("select--connected");
//				
//				String script = "SELECT * FROM " + sql;
//				java.sql.Statement statement = conn.createStatement();
//				ResultSet result = statement.executeQuery(script);
//
//				int count = 0; 
//				while (result.next()) {
//				    String name = result.getString(2);
//				    String pass = result.getString(3);
//				    String fullname = result.getString("fullname");
//				    String email = result.getString("email");
//				 
//				    String output = "User #%d: %s - %s - %s - %s";
//				    System.out.println(String.format(output, ++count, name, pass, fullname, email));
//				}
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("select--connection error!\n" + dbURL + "\nTable:" + 
//					"\nUser/Pwd:" + username + "/" + password);
//		}
//	}
	
	
//		public static void update_data() {
//			/*
//			 * 
//			 */
//			try {
//				Connection conn = DriverManager.getConnection(dbURL, username, password);
//				if (conn != null) {
//					System.out.println("Connected");
//					
//					String sql = "UPDATE Users SET password=?, fullname=?, email=? WHERE username=?";
//					try {
//						PreparedStatement statement = conn.prepareStatement(sql);
//
//						statement.setString(1, password);
//						statement.setString(2, fullname);
//						statement.setString(3, email);
//						statement.setString(4, username);
//
//						int rowsUpdated = statement.executeUpdate();
//						if (rowsUpdated > 0) {
//							System.out.println("An existing user was updated successfully!");
//						}
//
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("Connection error!");
//			}
//		}
 
	
//		public static void delete_data() {
//			/*
//			 * 
//			 */
//			try {
//				Connection conn = DriverManager.getConnection(dbURL, username, password);
//				if (conn != null) {
//					System.out.println("Connected");
//					
//					String sql = "DELETE FROM Users WHERE username=?";
//
//					try {
//						PreparedStatement statement = conn.prepareStatement(sql);
//						
//						statement.setString(1, username);
//						 
//						int rowsDeleted = statement.executeUpdate();
//						if (rowsDeleted > 0) {
//						    System.out.println("A user was deleted successfully!");
//						}
//						
//						
//					} catch (Exception e) {
//						// TODO: handle exception
//					}
//					
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("Connection error!");
//			}
//		}
	
}//end CRUD class





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class CRUD {
	
	/* 
	 * -= METHODS =-
	 *  all methods are fully parameterized to work with specific DBs, users,
	 *  and tables to perform single purpose functions.
	 * 	  - getQ(): 
	 * 			PARAMS  -> none
	 * 			RETURNS -> array of question strings
	 * 			THROWS  -> connection error
	 *    - storeA():
	 *    		PARAMS	-> (String) user id, question id, answer (1-5), nullable comment
	 * 			RETURNS -> array of question strings
	 * 			THROWS  -> connection error
	 *    - getA():
	 *    			not finished
	 * 
	 * -= CONSTRUCTORS =-
	 * 	  1) default:
	 * 			-> takes no args
	 * 			-> default user/pwd
	 * 			-> default db: electionmachine
	 * 	  2) param.ized:
	 * 			-> all 3 attrib take params in order:
	 * 			   dbURL, username, password (Strings)	
	 */
	
	protected String dbURL;
	protected String username;
	protected String password;		
		
	
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
	
	public String[] getQ() {
		/*
		 * RETURNS: array of question strings
		 * THROWS: connection error
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
	
	
	public void storeA(String uid, String qid, String ans, String com) {
		/* 
		 * PARAMS: 
		 * 		  uid -> user id as string (not null)
		 * 		  qid -> id of question as string (not null)
		 * 		  ans -> answer (1-5) input by user as string (not null)
		 * 		  com -> comments as string (nullable)
		 * RETURNS: no return value 
		 * THROWS: connection error
		 * 		  
		 */
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			if (conn != null) {
				System.out.println("insert--connected");
				
				String sql = "INSERT INTO electionmachine.user_answers (USER_ID, QUESTION_ID, ANSWER, COMMENTS) VALUES (?, ?, ?, ?)";

				PreparedStatement statement = conn.prepareStatement(sql);
				
				statement.setString(1, uid); 
				statement.setString(2, qid);
				statement.setString(3, ans);
				statement.setString(4, com);
				
				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("A new user was inserted into electionmachine.user_answers successfully!");
				}		
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert--connection error!\n" + dbURL + "\nTable:" + 
					"\nUser/Pwd:" + username + "/" + password);
		}
	}
	
//	public String[] get_A() {
//		/*
//		 * Returns -> array of question strings
//		 * 
//		 */
//		String arrCA[][] = null;
//		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
//			if (conn != null) {
//				System.out.println("select--connected");
//				
//				String script = "SELECT * FROM electionmachine.answers;";
//				java.sql.Statement statement = conn.createStatement();
//				ResultSet result = statement.executeQuery(script);
//				
//				
//				/*
//				 * hashmap https://stackoverflow.com/questions/1540673/java-equivalent-to-python-dictionaries
//				 * hashmap -> [1, [1-19]]
//				 * next step: put hash map in for loop for length of politicians
//				 */
//				int count = 0; 
//				arrCA = new String[19][19];
//				while (result.next()) {
//				    String cid = result.getString("CANDIDATE_ID");
//				    String qid = result.getString("QUESTION_ID");
//				    String answer = result.getString("ANSWER");
//				    arrCA[count] = [cid, qid, answer];
////				    System.out.println(arrQ[count]);
//				    
//				}
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("select--connection error!\n" + dbURL + "\nTable:" + 
//					"\nUser/Pwd:" + username + "/" + password);
//		}
//		return arrCA;
//	}
	
	
	
}

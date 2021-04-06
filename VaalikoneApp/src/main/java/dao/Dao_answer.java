package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.Answer;
import java.sql.Connection;

public class Dao_answer {
	
	/*
	 * Data Access Object class for Answers class
	 * 
	 * -= CONSTRUCTOR =-
	 * Initializes instance of Dao with String parameters forDB connection: url, user, pass.
	 * Doesn't connect, just inits attribs.
	 * 
	 * -= METHODS =-
	 * getConnection():
	 * 		-> returns true if successful connection
	 * 		-> returns false if unsuccessful connection
	 * readAllAnswer():
	 * 		-> returns Answer arraylist with attrib: CANDIDATE_ID, QUESTION_ID, ANSWER
	 * updateAnswer(Answer a):
	 * 		-> returns updated Answer arraylist
	 * deleteAnswer(String CANDIDATE_ID, String QUESTION_ID):
	 * 		-> returns updated Answer arraylist
	 * readAnswer(String CANDIDATE_ID):
	 * 		-> returns politician object with attrib for 1 politician's answers
	 * 		-> question ID + answer
	 * 
	 * 
	 * author: with much love from HAMK's Finest:)
	 */
	
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	
	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	
	/***************************************************
	 ********************   METHODS   ******************
	 ***************************************************/

	public Dao_answer(String url, String user, String pass) {
		/*
		 * PARAMETERS:
		 * url  -> (String) DB url
		 * user -> (String) Username for DB access
		 * pass -> (String) Password for DB access
		 * 
		 * THROWS:
		 * console -> connection information upon successful initialization
		 */
		System.out.println("Dao_answer constructor running with..\nurl: " + url + 
				"\nuser/pass: " + user + " / " + pass);
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	
	public boolean getConnection() {
		/*
		 * PARAMETERS: method takes no args
		 * 
		 * RETURNS:
		 * true  -> successful connection
		 * false -> unsuccessful connection
		 * 
		 * THROWS:
		 * exception error -> SQL
		 * console 		   -> connection info upon successful/unsuccessful connect
		 */
		System.out.println("getConnection() running");
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        System.out.println("Connected--" + url + "\nUser: " + user + " / " + pass);
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Couldn't Connect--" + url + "\nUser: " + user + " / " + pass);
			return false;
		}
	}
	
	
	public ArrayList<Answer> readAllAnswer() {
		/*
		 * PARAMS: method takes no args
		 * 
		 * RETURNS: arraylist Answer with attrib:
		 * 			- Candidate ID
		 * 			- Answer ID	
		 * 			- Answer
		 * 
		 * THROWS:
		 * exception error -> SQL
		 * console		   -> connection info upon success/fail to init
		 */
		System.out.println("readAllAnswer() running");
		ArrayList<Answer> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("SELECT * FROM answers;");
			System.out.println("RS: " + RS);
			while (RS.next()){
				Answer a=new Answer();
				a.setCANDIDATE_ID(RS.getString("CANDIDATE_ID"));
				a.setQUESTION_ID(RS.getString("QUESTION_ID"));
				a.setANSWER(RS.getString("ANSWER"));
				list.add(a);
			}
			return list;
		}
		catch(SQLException e) {
			System.out.println("Operation error readAllAnswer()--" + url + "\nUser: " + user + " / " + pass);
			return null;
		}
	}
	
	
	private ResultSet getString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Answer> updateAnswer(Answer a) {
		/*
		 * PARAMETERS: answer object you wish to ammend with attrib answer, candidate_id, question_id
		 * 
		 * RETURNS: answer arraylist with updated attributes:
		 * 			- candidate ID
		 * 			- question ID
		 * 			- answer
		 * 
		 * THROWS:
		 * exception error -> SQL
		 * console		   -> connection info upon success/fail to init
		 */
		System.out.println("updateAnswer running");
		try {
			String sql="UPDATE answers SET answer=? WHERE CANDIDATE_ID=? AND QUESTION_ID=?;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, a.getANSWER());
			pstmt.setString(2, a.getCANDIDATE_ID());
			pstmt.setString(3, a.getQUESTION_ID());
			pstmt.executeUpdate();
			return readAllAnswer();
		}
		catch(SQLException e) {
			System.out.println("Operation error updateAnswer()--" + url + "\nUser: " + user + " / " + pass);
			return null;
		}
	}
	
	
	public ArrayList<Answer> deleteAnswer(String CANDIDATE_ID, String QUESTION_ID) {
		/*
		 * PARAMETERS: CANDIDATE_ID and QUESTION_ID to mark row for deletion in answers table
		 * 
		 * RETURNS: Answer object with marked row deleted
		 * 
		 * THROWS:
		 * exception error -> SQL
		 * console		   -> connection info upon success/fail to init, deletion message
		 */
		System.out.println("deleteAnswer() running");
		try {
			String sql="DELETE FROM answers WHERE CANDIDATE_ID=? AND QUESTION_ID=?;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, CANDIDATE_ID);
			pstmt.setString(2, QUESTION_ID);
			pstmt.executeUpdate();
			System.out.println("answers table row with CANDIDATE_ID: " + CANDIDATE_ID + "and QUESTION_ID: "
					+ QUESTION_ID + " has been deleted successfully");
			return readAllAnswer();
		}
		catch(SQLException e) {
			System.out.println("Operation error deleteAnswer()--" + url + "\nUser: " + user + " / " + pass);
			return null;
		}
	}

	
	public Answer readAnswer(String CANDIDATE_ID) {
		/*
		 * PARAMETERS: (String) candidate id to return answers for 
		 * 
		 * RETURNS: ..warning! politician object! make sure to not trust what you read!:)
		 * 			returns Answer object with atribbutes:
		 * 				- question id
		 * 				- answer
		 * 
		 * exception error -> SQL
		 * console		   -> connection info upon success/fail to init
		 */
		Answer politician=null;
		try {
			String sql="SELECT * FROM answers WHERE CANDIDATE_ID=? ORDER BY QUESTION_ID;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, CANDIDATE_ID);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				politician=new Answer();
				politician.setQUESTION_ID(RS.getString("QUESTION_ID"));
				politician.setANSWER(RS.getString("ANSWER"));
			}
			System.out.println("Your lies are ready for processing:)");
			return politician;
		}
		catch(SQLException e) {
			System.out.println("Operation error deleteAnswer()--" + url + "\nUser: " + user + " / " + pass);
			return null;
		}
	}
	
	
}

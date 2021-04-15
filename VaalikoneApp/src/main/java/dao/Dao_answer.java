package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.Answer;
import java.sql.Connection;


/**
 * This Data Access Object class contains methods that work in conjunction
 * with the Answer class. It establishes a connection with the 
 * electionmachine DB and its methods allow for the performing of CRUD operations
 * on said data through the utilization of attributes from the aforementioned class.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Dao_answer {
	
	/**
	 * String value matching the DB url to connect to.
	 */
	private String url;
	/**
	 * String value matching the username for account used to access DB.
	 */
	private String user;
	/**
	 * String value matching the password for account used to access DB.
	 */
	private String pass;
	/**
	 * Connection object representing the connection to the DB.
	 */
	private Connection conn;
	
	
	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	/**
	 * url attribute getter.
	 * @return String of url for DB connection.
	 */
	public String getUrl() {
		return url;
	}

	
	/**
	 * url attribute setter.
	 * @param url takes String arg for DB connection.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	
	/**
	 * user attribute getter.
	 * @return user String of username used to access DB.
	 */
	public String getUser() {
		return user;
	}

	
	/**
	 * user attribute setter.
	 * @param user takes String arg for username used to access DB.
	 */
	public void setUser(String user) {
		this.user = user;
	}

	
	/**
	 * pass attribute getter.
	 * @return String pass for password used to access DB.
	 */
	public String getPass() {
		return pass;
	}

	
	/**
	 * pass attribute setter.
	 * @param pass takes String arg for password used to access DB.
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	
	/**
	 * conn attribute getter.
	 * @return returns connection object representing connection to DB.
	 */
	public Connection getConn() {
		return conn;
	}

	
	/**
	 * conn attribute setter.
	 * @param conn takes connection object as arg to establish connection to DB.
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	/**
	 * String ResultSet getter.
	 * @param string takes String arg for string to identify return value from RS.
	 * @return null
	 */
	private ResultSet getString(String string) {
		return null;
	}

	
	/***************************************************
	 ********************   METHODS   ******************
	 ***************************************************/

	/**
	 * @param url takes String 
	 * @param user
	 * @param pass
	 */
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
	
	
	/**
	 * @return
	 */
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
	
	
	/**
	 * @return
	 */
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
				a.setCANDIDATE_ID(RS.getInt("CANDIDATE_ID"));
				a.setQUESTION_ID(RS.getInt("QUESTION_ID"));
				a.setANSWER(RS.getInt("ANSWER"));
				list.add(a);
			}
			return list;
		}
		catch(SQLException e) {
			System.out.println("Operation error readAllAnswer()--" + url + "\nUser: " + user + " / " + pass);
			return null;
		}
	}
	
	


	/**
	 * @param a
	 * @return
	 */
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
			pstmt.setInt(1, a.getANSWER());
			pstmt.setInt(2, a.getCANDIDATE_ID());
			pstmt.setInt(3, a.getQUESTION_ID());
			pstmt.executeUpdate();
			return readAllAnswer();
		}
		catch(SQLException e) {
			System.out.println("Operation error updateAnswer()--" + url + "\nUser: " + user + " / " + pass);
			return null;
		}
	}
	
	
	/**
	 * @param CANDIDATE_ID
	 * @param QUESTION_ID
	 * @return
	 */
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

	
	/**
	 * @param CANDIDATE_ID
	 * @return
	 */
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
				politician.setQUESTION_ID(RS.getInt("QUESTION_ID"));
				politician.setANSWER(RS.getInt("ANSWER"));
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

package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.QAnswer;

import java.sql.Connection;

/**
 * This Data Access Object class contains methods that work in conjunction
 * with the QAnswer class. It establishes a connection with the 
 * electionmachine DB and its methods allow for the performing of CRUD operations
 * on said data through the utilization of attributes from the aforementioned class.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Dao_qanswer {
	
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
	
	
	/**	 
	 * String based parameterized constructor for Dao_qanswer class.
	 * 
	 * @param url takes String arg of url for to connecto to.
	 * @param user takes String arg of username for user to access DB. 
	 * @param pass takes String arg of password for user to access DB.
	 */
	public Dao_qanswer(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	/* #################################################
	 * ##################   METHODS   ##################
	 * #################################################*/
	
	/**
	 * Method creates DB connection conn utilizing JDBC driver. 
	 * @return boolean indication connection success or failure
	 */
	public boolean getConnection() {
//		System.out.println("getConnection()");
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * CRUD method operates utilizing QAnswer class instance and connection established
	 * as conn to perform select (read) SQL statement on answers table. ArrayList of QAnswer type instance is
	 * returned with attributes to the servlet and carried over to the view page.
	 * 
	 * @return ArrayList of QAnswer type containing all the candidate answers stored in answers table.
	 */
	public ArrayList<QAnswer> readAllAnswer() {
//		System.out.println("readAllAnswer()");
		ArrayList<QAnswer> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from answers");
			System.out.println("RS: " + RS);
			while (RS.next()){
				QAnswer a=new QAnswer();
				a.setCId(RS.getInt("CANDIDATE_ID"));
				a.setQId(RS.getInt("QUESTION_ID"));
				a.setAnswer(RS.getInt("ANSWER"));
				list.add(a);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	/**
	 * CRUD method operates utilizing QAnswer class instance and connection established
	 * as conn to perform select (read) SQL statement on answers table. ArrayList of QAnswer type instance is
	 * returned with attributes to the servlet and carried over to the view page.
	 * 
	 * @return ArrayList of QAnswer type containing the answers of the selected candidate.
	 * @param id takes a string arg identified as the CANDIDATE_ID in the ansers table.
	 */
	public ArrayList<QAnswer> readAnswersForCandidate(String id) {
//		System.out.println("readAnswersForCandidate()");
		ArrayList<QAnswer> answerList = new ArrayList<QAnswer>();
		try {
			String sql="select a.CANDIDATE_ID, a.QUESTION_ID, q.QUESTION, a.ANSWER from electionmachine.answers a join electionmachine.questions q on q.QUESTION_ID=a.QUESTION_ID where CANDIDATE_ID = ?";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet RS=stmt.executeQuery();
			while(RS.next())
			{
				QAnswer qanswer = new QAnswer();
				qanswer.setCId(RS.getInt("CANDIDATE_ID"));
				qanswer.setQId(RS.getInt("QUESTION_ID"));
				qanswer.setQTxt(RS.getString("QUESTION"));
				qanswer.setAnswer(RS.getInt("ANSWER"));
				answerList.add(qanswer);
			}
			return answerList;
		}
		catch(SQLException e) {
			return null;
		}
	}

	/**
	 * CRUD method operates utilizing QAnswer class instance and connection established
	 * as conn to perform insert SQL statement on answers table. 
	 * @param a takes a QAnswer type of object amended with the QUESTION_ID and ANSWER attributes.
	 */
	public void insertAnswer(QAnswer a) {
//		System.out.println("insertAnswer()");
		try {
			String sql="insert into answers (CANDIDATE_ID, QUESTION_ID, ANSWER) values (?, ?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, a.getAnswer());
			pstmt.setInt(2, a.getQId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * CRUD method operates utilizing QAnswer class instance and connection established
	 * as conn to perform insert SQL statement on answers table. 
	 * @param answerList takes an ArrayList of QAnswer type of object amended with the CANDIDATE_ID QUESTION_ID and ANSWER attributes.
	 */
	public void insertAllAnswer(ArrayList<QAnswer> answerList) {
//		System.out.println("insertAllAnswer()");
		try {
			String sql="insert into answers (CANDIDATE_ID, QUESTION_ID, ANSWER, COMMENTS) values (?, ?, ?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			for (QAnswer qAnswer : answerList) {
				pstmt.setInt(1, qAnswer.getCId());
				pstmt.setInt(2, qAnswer.getQId());
				pstmt.setInt(3, qAnswer.getAnswer());
				pstmt.setString(4, "candidate's answer to question");
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * CRUD method operates utilizing QAnswer class instance and connection established
	 * as conn to perform delete SQL statement on answers table. 
	 * @param id takes a string representing the CANDIDATE_ID appointing the data which will be removed from the answer
	 */
	public void deleteAnswers(String id) {
//		System.out.println("deleteAnswer(String id)");
		try {
			String sql="delete from answers where CANDIDATE_ID=?;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			
		}
	}
	
	/**
	 * CRUD method operates utilizing QAnswer class instance and connection established
	 * as conn to perform delete SQL statement on answers table. 
	 * @param a takes a QAnswer type of object amended with the QUESTION_ID and ANSWER attributes.
	 */
	public void updateAnswers(QAnswer a) {
		System.out.println("updateAnswer(QAnswer a)");
		try {
			String sql="update answers set QUESTION_ID=?, ANSWER=?, COMMENTS where CANDIDATE_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, a.getCId());
			pstmt.setInt(2, a.getAnswer());
			pstmt.setInt(3, a.getQId());
			pstmt.setString(4, "Candidate's answer to the question.");
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			
		}
	}

}

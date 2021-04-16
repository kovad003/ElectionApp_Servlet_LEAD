package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.Question;
import java.sql.Connection;


/**
 * This Data Access Object class contains methods that work in conjunction
 * with the Question class. It establishes a connection with the 
 * electionmachine DB and its methods allow for the performing of CRUD operations
 * on said data through the utilization of attributes from the aforementioned class.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Dao_question {
	
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
	 * String based parameterized constructor for Dao_question class.
	 * 
	 * @param url takes String arg of url for to connecto to.
	 * @param user takes String arg of username for user to access DB. 
	 * @param pass takes String arg of password for user to access DB.
	 */
	public Dao_question(String url, String user, String pass) {
		System.out.println("Dao(String url, String user, String pass) CONSTRUCTOR ******");
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	
	/* #################################################
	 * ##################   METHODS   ##################
	 * #################################################*/
	
	/**
	 * Method attempts to establish a DB connection based on supplied attributes if one does
	 * not exist already. Method requires JDBC driver. 
	 * 
	 * @return boolean value representing connection success or failure.
	 * @throws SQLException error
	 */
	public boolean getConnection() {
		System.out.println("getConnection()");
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
	 * CRUD method operates in conjunction with the Question class. Creates list
	 * as instance of said class, then utilizes DB connection to read all questions
	 * from the new_questions table. ResultSet is then iterated over, and values are
	 * packed into attributes of Question class that match the columns as specified 
	 * in Question class notes.
	 * 
	 * @return ArrayList of Question instance with attributes packed with values
	 * from database.
	 * @throws SQLException error
	 */
	public ArrayList<Question> readNewQuestions() {
		System.out.println("readNewQuestions()");
		ArrayList<Question> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from new_questions ORDER BY NEW_QUESTION_ID DESC;");
			while (RS.next()){
				Question q=new Question();
				q.setId(RS.getInt("NEW_QUESTION_ID"));
				q.setQuestion(RS.getString("NEW_QUESTION"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	
	/**
	 * CRUD method utilizes established connection conn to DB in order to
	 * run insert statement, inserting new question value into new_questions
	 * DB. 
	 * 
	 * @param q takes String q of question to insert into DB.
	 * @throws SQLException error
	 */
	public void insertQuestion(String q)
	{
		try {
			String sql="INSERT INTO electionmachine.new_questions (NEW_QUESTION) VALUES (?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, q); 
				pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * CRUD method utilizes Question class to insert new question value into the 
	 * new_questions DB. Attribute is loaded with new questions, and used to pass
	 * value to DB with conn connection.
	 * 
	 * @param question takes String question set to Question object's question 
	 * attribute.
	 * @throws SQLException error
	 */
	public void insertNewQuestion(Question question){
		try {
			System.out.println("insertNewQuestion");
			String sql="INSERT INTO new_questions (NEW_QUESTION) VALUES (?);";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, question.getQuestion());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * CRUD method deletes question (and entire row) from new_questions
	 * table based on provided NEW_QUESTION_ID. Uses conn connection 
	 * established through constructor.
	 * 
	 * @param question takes String of question marking NEW_QUESTION_ID number.
	 * @throws SQLException error
	 */
	public void deleteNewQuestion(String question){
		try {
			System.out.println("insertNewQuestion");
			String sql="Delete FROM new_questions WHERE NEW_QUESTION_ID=?;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, question);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * CRUD method utilizes Question class instance as list and constructor 
	 * established connection as conn to read entire questions table. Results
	 * are placed in ResultSet and through iterator and attributes of instance
	 * of Question class which match columns of the table and hold individual
	 * rows per column.
	 * 
	 * @return list object (instance of Question class) with attributes loaded
	 * from matching columns of questions table.
	 * @throws SQLException exception.
	 */
	public ArrayList<Question> readAllQuestion() {
		System.out.println("readAllQuestion()");
		ArrayList<Question> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from questions");
			System.out.println("RS: " + RS);
			while (RS.next()){
				Question q=new Question();
				q.setId(RS.getInt("QUESTION_ID"));
				q.setQuestion(RS.getString("QUESTION"));
				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	
	/**
	 * CRUD method utilizes Question class instance as list and constructor 
	 * established connection as conn to update question(s) in questions table
	 * based on provided QUESTION_ID.
	 * 
	 * @param q takes Question instance loaded with Id attribute for Id where
	 * question should be changed.
	 * @return list object (instance of Question class) with attributes loaded
	 * from matching columns of entire updated questions table.
	 * @throws SQLException exception.
	 */
	public ArrayList<Question> updateQuestion(Question q) {
		System.out.println("updateQuestion(Question q)");
		try {
			String sql="update questions set question=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getQuestion());
			pstmt.setInt(2, q.getId());
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	
	/**
	 * CRUD method utilizes Question class instance as list and constructor 
	 * established connection as conn to delete question(s) from question table
	 * based on provided QUESTION_ID as id.
	 * 
	 * @param id takes String id of question id where question is to be deleted.
	 * @return list object (instance of Question class) with attributes loaded
	 * from matching columns of entire updated questions table.
	 * @throws SQLException exception.
	 */
	public ArrayList<Question> deleteQuestion(String id) {
		System.out.println("deleteQuestion(String id)");
		try {
			String sql="delete from question where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}
	}

	
	/**
	 * CRUD method utilizes established connection of conn and Question
	 * class instance to select all rows of questions table mathing provided
	 * QUESTION_IDs. Values are returned with ResultSet, which is iterated 
	 * over allowing values to be packed in Question instance's attributes.
	 * 
	 * @param id takes String of id(s) matching QUESTION_ID for questions to
	 * return
	 * @return Question class instance whose attributes have been loaded with
	 * required questions and ids based on provided QUESTION_ID args.
	 * @throws SQLException exception.
	 */
	public Question readQuestion(String id) {
		Question f=null;
		try {
			String sql="select * from questions where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Question();
				f.setId(RS.getInt("QUESTION_ID"));
				f.setQuestion(RS.getString("QUESTION"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
}

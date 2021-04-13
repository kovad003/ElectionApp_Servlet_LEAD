package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidate;
import data.Question;

import java.sql.Connection;


public class Dao_question {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao_question(String url, String user, String pass) {
		System.out.println("Dao(String url, String user, String pass) CONSTRUCTOR ******");
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
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
	
	
	public void insertQuestion(String NEW_QUESTION)
	{
	try {
	String sql="INSERT INTO electionmachine.new_questions (NEW_QUESTION) VALUES (?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, NEW_QUESTION);
	pstmt.executeUpdate();
	}
	catch(SQLException e) {
	e.printStackTrace();
	}
	}
	
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
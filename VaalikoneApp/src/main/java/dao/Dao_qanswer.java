package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.QAnswer;

import java.sql.Connection;


public class Dao_qanswer {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao_qanswer(String url, String user, String pass) {
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
	public ArrayList<QAnswer> readAllAnswer() {
		System.out.println("readAllAnswer()");
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
	
	// Will insert new record to the answers table
	public void insertAnswer(QAnswer a) {
		System.out.println("insertAnswer()");
		try {
			//CANDIDATE_ID has to be added later
			String sql="insert into answers (QUESTION_ID, ANSWER) values (?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, a.getAnswer());
			pstmt.setInt(2, a.getQId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<QAnswer> updateAnswer(QAnswer a) {
		System.out.println("updateAnswer(QAnswer a)");
		try {
			String sql="update questions set answer=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, a.getAnswer());
			pstmt.setInt(2, a.getQId());
			pstmt.executeUpdate();
			return readAllAnswer();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<QAnswer> deleteAnswer(String id) {
		System.out.println("deleteAnswer(String id)");
		try {
			String sql="delete from question where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllAnswer();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public QAnswer readAnswer(String id) {
		QAnswer a=null;
		try {
			String sql="select * from questions where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				a=new QAnswer();
				a.setQId(RS.getInt("ANSWER_ID"));
				a.setAnswer(RS.getInt("ANSWER"));
			}
			return a;
		}
		catch(SQLException e) {
			return null;
		}
	}
}

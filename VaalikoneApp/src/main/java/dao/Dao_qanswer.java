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
	
	public ArrayList<QAnswer> readAnswersForCandidate(String id) {
		System.out.println("readAnswersForCandidate()");
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
	
	// Will insert new record to the answers table
	public void insertAnswer(QAnswer a) {
		System.out.println("insertAnswer()");
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
	
	// Will insert new record to the answers table
	public void insertAllAnswer(ArrayList<QAnswer> answerList) {
		System.out.println("insertAllAnswer()");
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
	
	public void deleteAnswers(String id) {
		System.out.println("deleteAnswer(String id)");
		try {
			String sql="delete from answers where CANDIDATE_ID=?;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			
		}
	}
	
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

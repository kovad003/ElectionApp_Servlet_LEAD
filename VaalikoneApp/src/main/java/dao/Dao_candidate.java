package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidate;

import java.sql.Connection;


public class Dao_candidate {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao_candidate(String url, String user, String pass) {
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
	public ArrayList<Candidate> readAllCandidate() {
		System.out.println("readAllCandidate()");
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from candidates");
			System.out.println("RS: " + RS);
			while (RS.next()){
				Candidate q=new Candidate();
				q.setId(RS.getInt("CANDIDATE_ID"));
				q.setCandidate(RS.getString("PARTY"));
//				q.setCandidateLocation(RS.getString("LOCATION"));

				list.add(q);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> updateCandidate(Candidate q) {
		System.out.println("updateCandidate(Candidate q)");
		try {
			String sql="update candidates set candidate=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getCandidate());
			pstmt.setInt(2, q.getId());
//			pstmt.setInt(3, q.getCandidateLocation());
			pstmt.executeUpdate();
			return readAllCandidate();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> deleteCandidate(String id) {
		System.out.println("deleteCandidate(String id)");
		try {
			String sql="delete from candidate where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllCandidate();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Candidate readCandidate(String id) {
		Candidate f=null;
		try {
			String sql="select * from candidates where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidate();
				f.setId(RS.getInt("CANDIDATE_ID"));
				f.setCandidate(RS.getString("PARTY"));
//				f.setCandidateLocation(RS.getString("LOCATION"));

			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
}

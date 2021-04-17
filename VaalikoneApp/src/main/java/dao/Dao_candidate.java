package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.Candidate;
import java.sql.Connection;


/**
 * This Data Access Object class contains methods that work in conjunction
 * with the Candidate class. It establishes a connection with the 
 * electionmachine DB and its methods allow for the performing of CRUD operations
 * on said data through the utilization of attributes from the aforementioned class.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Dao_candidate {
	
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
	public Dao_candidate(String url, String user, String pass) {
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
	 */
	public boolean getConnection() {
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
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to perform insert SQL statement on candidates table. Candidate instance is
	 * loaded with attributes to populate into DB.
	 * 
	 * @param c takes instance of Candidate object with attributes loaded matching columns
	 * of candidates table.
	 */
	public void insertCandidate(Candidate c) {
		try {
			String sql="insert into CANDIDATES (SURNAME, FIRSTNAME, PARTY, LOCATION, AGE, REASON_FOR_RUNNING, AIMS_AND_GOALS, PROFESSION, USERNAME, PASSWORD) VALUES (?, ?, ?, ?, ?, ?, ?, ?, CONCAT(RTRIM((LTRIM(SURNAME))), CONVERT(CANDIDATE_ID, CHAR)), '1a59ef90d1ea801448e1567d0896a99f');";
			PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, c.getSName());
				pstmt.setString(2, c.getFName());
				pstmt.setString(3, c.getParty());
				pstmt.setString(4, c.getLocation());
				pstmt.setInt(5, c.getAge());
				pstmt.setString(6, c.getReason());
				pstmt.setString(7, c.getGoals());
				pstmt.setString(8, c.getProfession());
				pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to perform SQL update statement based on CANDIDATE_ID and Candidate instance
	 * with loaded attributes for DB update.
	 * 
	 * @param c takes instance of Candidate object with attributes loaded matching columns
	 * of candidates table.
	 */
	public void updateCandidate(Candidate c) {
		System.out.println("updateCandidate(Candidate q)");
		try {
			String sql="UPDATE CANDIDATES SET SURNAME=?, FIRSTNAME=?, PARTY=?, LOCATION=?, AGE=?, REASON_FOR_RUNNING=?, AIMS_AND_GOALS=?, PROFESSION=? WHERE CANDIDATE_ID=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, c.getSName());
			pstmt.setString(2, c.getFName());
			pstmt.setString(3, c.getParty());
			pstmt.setString(4, c.getLocation());
			pstmt.setInt(5, c.getAge());
			pstmt.setString(6, c.getReason());
			pstmt.setString(7, c.getGoals());
			pstmt.setString(8, c.getProfession());
			pstmt.setInt(9, c.getId());
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to perform SQL delete statement based on CANDIDATE_ID from candidates table.
	 * 
	 * @param id takes String arg for CANDIDATE_ID in candidates table where rows are to
	 * be deleted.
	 */
	public void deleteCandidate(String id) {
		System.out.println("deleteCandidate(String id)");
		try {
			String sql="DELETE FROM candidates WHERE CANDIDATE_ID=?;";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to perform SQL select statement reading all candidates from the candidates 
	 * table. ResultSet is iterated over in order to populate Candidate instance attributes
	 * with values from table.
	 * 
	 * @return Candidate instance with attributes populated from DB.
	 */
	public ArrayList<Candidate> readAllCandidate() { 
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from candidates");
			while (RS.next()){
				Candidate c=new Candidate();
				c.setId(RS.getInt("CANDIDATE_ID"));
				c.setSName(RS.getString("SURNAME"));
				c.setFName(RS.getString("FIRSTNAME"));
				c.setParty(RS.getString("PARTY"));
				c.setLocation(RS.getString("LOCATION"));
				c.setAge(RS.getInt("AGE"));
				c.setReason(RS.getString("REASON_FOR_RUNNING"));
				c.setGoals(RS.getString("AIMS_AND_GOALS"));
				c.setProfession(RS.getString("PROFESSION"));
				list.add(c);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to perform SQL select statement reading all candidates in descending order
	 * from the candidates table. ResultSet is iterated over in order to populate Candidate 
	 * instance attributes with values from table.
	 * 
	 * @return Candidate instance with attributes populated in reverse order from DB.
	 */
	public ArrayList<Candidate> readAllCandidateDesc() { 
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from candidates order by CANDIDATE_ID desc");
			while (RS.next()){
				Candidate c=new Candidate();
				c.setId(RS.getInt("CANDIDATE_ID"));
				c.setSName(RS.getString("SURNAME"));
				c.setFName(RS.getString("FIRSTNAME"));
				c.setParty(RS.getString("PARTY"));
				c.setLocation(RS.getString("LOCATION"));
				c.setAge(RS.getInt("AGE"));
				c.setReason(RS.getString("REASON_FOR_RUNNING"));
				c.setGoals(RS.getString("AIMS_AND_GOALS"));
				c.setProfession(RS.getString("PROFESSION"));
				list.add(c);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to iterate over candidates table checking for a USERNAME and PASSWORD from
	 * the respective columns that matches those provided in the arguments. Candidate instance
	 * attributes are utilized for the operation.
	 * NOTE: LoginServlet utilizing the method has built in SQL statement that reads login
	 * info from browser input.
	 * 
	 * @param login_sql takes String arg of full SQL command to check USERNAME and PASSWORD.
	 * @return Candidate instance with USERNAME, PASSWORD and CANDIDATE_ID of candidate matching
	 * input arg containing username and password.
	 */
	public ArrayList<Candidate> loginCandidate(String login_sql) {
		System.out.println("loginCandidate() is connected..");
		ArrayList<Candidate> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery(login_sql);
			System.out.println("RS: " + RS);
			while (RS.next()){
				Candidate c=new Candidate();
				c.setId(RS.getInt("CANDIDATE_ID"));
				c.setUSERNAME(RS.getString("USERNAME"));
				c.setPASSWORD(RS.getString("PASSWORD"));
				list.add(c);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * CRUD method operates utilizing Candidate class instance and connection established
	 * as conn to run SQL command in candidates table reading all candidates from the
	 * table that match the provided CANDIDATE_ID. Attributes of instance are set through 
	 * iteration of ResultSet.
	 * 
	 * @param id takes String arg matching CANDIDATE_ID of rows to be returned.
	 * @return instance of Candidate class with parameters populated for specified CANDIDATE_ID.
	 */
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
				f.setParty(RS.getString("PARTY"));
//				f.setCandidateLocation(RS.getString("LOCATION"));
			}
			return f;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_candidate;
import data.Candidate;

/**
 * @author HAMK's Finest
 * Servlet implementation class AdminAddCandidate.
 * Will process the request for adding candidates from page adminUpdateCandidates.jsp
 * @see webapp.adminUpdateCandidates.jsp
 */
@WebServlet("/AdminAddCandidate")
public class AdminAddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_candidate dao_candidate=null;
		
	/**
	 * Object initialization method for Dao_candidate class
	 * @see dao.Dao_candidate.java
	 * User/pass: pena/kukkuu
	 */
	@Override
	public void init() {

		dao_candidate=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * creates candidate arraylist with attributres appended so data can be inserted into database. 
	 * Will redirect back to the view page(adminUpdateCandidate.jsp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sName = request.getParameter("SURNAME");
		String fName = request.getParameter("FIRSTNAME");
		String party = request.getParameter("PARTY");
		String location = request.getParameter("LOCATION");
		int age = Integer.parseInt(request.getParameter("AGE"));
		String reason = request.getParameter("REASON_FOR_RUNNING");
		String goals =  request.getParameter("AIMS_AND_GOALS");
		String profession = request.getParameter("PROFESSION");

		Candidate candidate = new Candidate();
		candidate.setSName(sName);
		candidate.setFName(fName);
		candidate.setParty(party);
		candidate.setLocation(location);
		candidate.setAge(age);
		candidate.setReason(reason);
		candidate.setGoals(goals);
		candidate.setProfession(profession);
		
		System.out.println(candidate.getSName() + candidate.getFName() +
				candidate.getParty() +	candidate.getLocation()+
				candidate.getAge() + candidate.getReason()+
				candidate.getGoals() +	candidate.getProfession());
		
		/*
		 * connecting to DB and inserting new candidate's data
		 */
		if(dao_candidate.getConnection())
		{
			System.out.println("AdminAddCandidate");
			System.out.println("Successfully connected to the database");
			dao_candidate.insertCandidate(candidate);
			System.out.println("Candidate Profile: " + candidate);
			System.out.println("Password is: 11935. Dont tell it to anyone!!! :)");
		}
		else
		{
			System.out.println("No connection to database");
		}
		
		response.sendRedirect("/AdminCandidates");
	}

}

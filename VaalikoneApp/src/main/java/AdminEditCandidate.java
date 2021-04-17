

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_candidate;
import data.Candidate;

/**
 * Servlet implementation class AdminEnableUpdate
 * Will collect and forward the current candidate profile data from the DB to the adminUpdateCandidates.jsp page.
 * @see webapp.adminUpdateCandidates.jsp
 * 
 * @author HAMK's Finest 
 */
@WebServlet("/AdminEditCandidate")
public class AdminEditCandidate extends HttpServlet {
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
     * Constructor
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Creates candidate arraylist which will update the chosen candidates data in the database.
	 * Will redirect back to the view page (adminUpdateCandidate.jsp)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Candidate candidate = new Candidate();
		
		int cId = Integer.parseInt(request.getParameter("CID"));
		System.out.println(request.getParameter("CID"));
		String sName = request.getParameter("SURENAME");
		String fName = request.getParameter("FIRSTNAME");
		String party = request.getParameter("PARTY");
		String location = request.getParameter("LOCATION");
		int age = Integer.parseInt(request.getParameter("AGE"));
		String reason = request.getParameter("REASON_FOR_RUNNING");
		String goals =  request.getParameter("AIMS_AND_GOALS");
		String profession = request.getParameter("PROFESSION");

		candidate.setId(cId);
		candidate.setSName(sName);
		candidate.setFName(fName);
		candidate.setParty(party);
		candidate.setLocation(location);
		candidate.setAge(age);
		candidate.setReason(reason);
		candidate.setGoals(goals);
		candidate.setProfession(profession);

//		<<< Debugging Messages >>>
		System.out.println("CID: " + candidate.getId() + " - NAME: " + candidate.getFName() + candidate.getSName() +
			"PARTY: " + candidate.getParty() + " - LOCATION: " + candidate.getLocation() +
			" - AGE: " + candidate.getAge() + " - Reason: " + candidate.getReason() +
			" - Goals: " + candidate.getGoals() + " - Profesion: " + candidate.getProfession());

		request.setAttribute("candidate", candidate);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/");
//		rd.forward(request, response);
		
		if(dao_candidate.getConnection())
		{
			System.out.println("Successfully connected to the database");
			dao_candidate.updateCandidate(candidate);
			System.out.println("Candidate Profile: " + candidate);	
		}
		else
		{
			System.out.println("No connection to database");
		}
	
		response.sendRedirect("/AdminUpdateCandidate");

	}

}

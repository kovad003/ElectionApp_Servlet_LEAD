

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
 */
@WebServlet("/AdminEditCandidate")
public class AdminEditCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_candidate dao_candidate=null;
	
	@Override
	public void init() {

		dao_candidate=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Candidate candidate = new Candidate();

		System.out.println(request.getParameter("CANDIDATE_ID"));
		int cId = Integer.parseInt(request.getParameter("CANDIDATE_ID"));
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
	}

}

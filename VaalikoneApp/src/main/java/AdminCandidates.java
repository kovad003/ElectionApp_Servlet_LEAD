

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_candidate;
import data.Candidate;

/**
 * @author HAMK's Finest
 * Servlet implementation class AdminCandidate.
 * Will collect and forward the current candidate profile data from the DB to the adminUpdateCandidates.jsp page.
 * @see webapp.adminUpdateCandidates.jsp
 */
@WebServlet("/AdminCandidates")
public class AdminCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_candidate dao=null;
	
	/**
	 * Object initialization method for Dao_candidate class
	 * @see dao.Dao_candidate.java
	 * User/pass: pena/kukkuu
	 */
	@Override
	public void init() {
		dao=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
       
    /**
     * Constructor
     * @see HttpServlet#HttpServlet()
     */
    public AdminCandidates() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Creates candidate arraylist set as an attribute so it will be forwarded to the view page adminUpdateCandidate.jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Candidate> list=null;
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to the database");
			list=dao.readAllCandidateDesc();
			System.out.println("Can_List: " + list);
			
			for (int i = 0; i < list.size(); i++) {
				Candidate c = list.get(i);//		
				System.out.println("Candidate name: " + c.getFName() + " " + c.getSName());//
				System.out.println("location: " + c.getLocation() );//
			}
		}
		else
		{
			System.out.println("No connection to database");
		}
		
		request.setAttribute("candidatelist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/adminUpdateCandidates.jsp");
		rd.forward(request, response);
	}
}


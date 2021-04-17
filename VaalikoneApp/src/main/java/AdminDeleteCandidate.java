

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_candidate;

/**
 * Servlet implementation class AdminDeleteCandidate
 * Will collect and forward the current candidate profile data from the DB to the adminUpdateCandidates.jsp page.
 * webapp.adminUpdateCandidates.jsp
 * 
 * @author HAMK's Finest
 */
@WebServlet("/AdminDeleteCandidate")
public class AdminDeleteCandidate extends HttpServlet {
	
	/**
	 * Identifier that ensures same version used for serialization and
	 * deserialization by JVM. 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Dao_candidate object instance initialization.
	 */
	private Dao_candidate dao_candidate=null;
	
	/**
	 * Object initialization method for Dao_candidate class
	 * see dao.Dao_candidate.java
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
    public AdminDeleteCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Will locate the selected candidate from the view page in the database so it can be deleted.
	 * Will redirect back to the view page(adminUpdateCandidate.jsp) so amended candidate table can be checked.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cId = request.getParameter("CID");
		
//		<<< Debugging Messages >>>
//		System.out.println("CID for delete: " + cId);
		
		if(dao_candidate.getConnection())
		{
			System.out.println("Successfully connected to the database");
			dao_candidate.deleteCandidate(cId);
		}
		else
		{
			System.out.println("No connection to database");
		}
		
		response.sendRedirect("/AdminCandidates");
	}

}



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_candidate;

/**
 * Servlet implementation class AdminDeleteCandidate
 */
@WebServlet("/AdminDeleteCandidate")
public class AdminDeleteCandidate extends HttpServlet {
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
    public AdminDeleteCandidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cId = request.getParameter("CID");
		
//		<<< Debugging Messages >>>
		System.out.println("CID for delete: " + cId);
		
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

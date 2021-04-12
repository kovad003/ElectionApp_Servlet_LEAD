

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
 * Servlet implementation class ShowCandidates
 */
@WebServlet("/AdminCandidates")
public class AdminCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_candidate dao=null;
	
	@Override
	public void init() {
		dao=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCandidates() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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


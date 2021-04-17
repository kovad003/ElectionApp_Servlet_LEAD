
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
 * Servlet implementation class ShowCandidates
 * Will collect candidate profile data from the databse so it can be dsiplayed on the view.
 * @see webapp.candidates.jsp
 */
@WebServlet("/ShowCandidates")
public class ShowCandidates extends HttpServlet {
	
	/**
	 * Identifier that ensures same version used for serialization and
	 * deserialization by JVM.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Data Access Object initialization for candidates table.
	 * Utilizes Candidate and Dao_candidate classes.
	 */
	private Dao_candidate dao=null;
	
	
	/**
	 * Object initialization method for Dao_candidate.
	 * User/pass: pena/kukkuu
	 */
	@Override
	public void init() {
		dao=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
       
    /**
     * Constructor initializing ShowCandidates
     * @see HttpServlet#HttpServlet()
     */
    public ShowCandidates() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * HTTP Get method utilizes instance of Candidate class and connection conn established with Dao_candidate.
	 * If connection is established, all candidates are iterated into ArrayList Candidate instance imaginatively
	 * created as list, which is passed on to "candidates.jsp" for further use.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @throws ServletException | IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Candidate> list=null;
		
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to the database");
			list=dao.readAllCandidate();
			System.out.println("Can_List: " + list);
			for (int i = 0; i < list.size(); i++) {
				Candidate c = list.get(i);//		
				System.out.println("Candidate name: " + c.getFName() + " " + c.getSName());//
				System.out.println("location: " + c.getLocation() );//
			}
		}
		else{
			System.out.println("No connection to database");
		}
		
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/candidates.jsp");
		rd.forward(request, response);

	}
	
}

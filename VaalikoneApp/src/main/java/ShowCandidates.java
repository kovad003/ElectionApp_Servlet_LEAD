
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		
/*		
		// get URLs
		URL currentUrl = new URL(request.getRequestURL().toString());
		URL prevUrl = new URL(request.getHeader("referer"));
		
		// convert the absolute path to URI
	    URI path1 = null;
		try {
			path1 = currentUrl.toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    URI path2 = null;
		try {
			path2 = prevUrl.toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // create a relative path from the two paths
	    URI relativePath = path2.relativize(path1);
	    

	    // convert the URI to string
	    String path = relativePath.getPath();
		
		System.out.println("Current URL path:" + currentUrl);
		System.out.println("Request is comming from : " + prevUrl);
		System.out.println("Relative path : " + relativePath);
		
*/
	}
	
}

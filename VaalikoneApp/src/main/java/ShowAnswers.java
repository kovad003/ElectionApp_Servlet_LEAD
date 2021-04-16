
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_answer;
import data.Answer;


/**
 * Servlet implementation class ShowAnswers
 */
@WebServlet("/ShowAnswers")
public class ShowAnswers extends HttpServlet {
	
	/**
	 * Identifier that ensures same version used for serialization and
	 * deserialization by JVM.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Data Access Object initialization for candidates table.
	 * Utilizes Candidate and Dao_candidate classes.
	 */
	private Dao_answer dao=null;
       
	
    /**
     * Object initialization method for Dao_candidate.
	 * User/pass: pena/kukkuu
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() {
		dao = new Dao_answer("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
	
    /**
     * Constructor initializing ShowAnswers
     */
    public ShowAnswers() { 
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Answer> alist = null;
		if(dao.getConnection())
		{
			System.out.println("Servlet doGet connected to the database");
			alist=dao.readAllAnswer();
			System.out.println("List: " + alist);
		}
		else
		{
			System.out.println("doGet has no connection to database");
		}
		request.setAttribute("answerlist", alist);
		
		RequestDispatcher rd = request.getRequestDispatcher("/survey.jsp");
		rd.forward(request, response);
	}


}

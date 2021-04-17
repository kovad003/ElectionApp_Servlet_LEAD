
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao_question;
import data.Question;


/**
 * @author HAMK's Finest
 * Servlet implementation class ShowQuestions
 * Will collect the questions from the database so they can be dispalyed on the view page when someone takes the quiz..
 * @see questionnaire.jsp
 */

@WebServlet("/ShowQuestions")
public class ShowQuestions extends HttpServlet {
	
	/**
	 * Identifier that ensures same version used for serialization and
	 * deserialization by JVM.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Data Access Object initialization for candidates table.
	 * Utilizes Candidate and Dao_candidate classes.
	 */
	private Dao_question dao=null;
	
	
	/**
	 * Object initialization method for Dao_candidate.
	 * User/pass: pena/kukkuu
	 */
	@Override
	public void init() {
		dao=new Dao_question("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
       
    /**
     * Constructor initializing ShowQuestions
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestions() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * HTTP Get method utilizing Question class instance: list, and Dao_Question class to read all questions
	 * from questions table and pack them into attributes of list, which is passed on to "questionnaire.jsp"
	 * as "questionlist" to be used in the survery.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @throws ServletException | IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Question> list=null;
		
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to the database");
			list=dao.readAllQuestion();
			System.out.println("Q-List: " + list);
			Question q = list.get(0);//
			
			System.out.println("Question id: " + q.getId());//
		}
		else{
			System.out.println("No connection to database");
		}
		
		request.setAttribute("questionlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/questionnaire.jsp");
		rd.forward(request, response);
	}
	
}

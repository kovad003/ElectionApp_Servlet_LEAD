
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_question;
import data.Question;

/**
 * Servlet implementation class AdminAddCandidate
 */
@WebServlet("/AdminAddQuestion")
public class AdminAddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_question  dao_question=null;
	
	@Override
	public void init() {

		dao_question=new Dao_question("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Qnumber = request.getParameter("Qnumber");
		

		Question question = new Question();
		question.setQuestion("Question");
		
		
		System.out.println(question.getQuestion() );
		
		if(dao_question.getConnection())
		{
			System.out.println("Successfully connected to the database");
			dao_question.insertQuestion(question);
			System.out.println("Candidate Profile: " + question);	
		}
		else
		{
			System.out.println("No connection to database");
		}
		
	}

}

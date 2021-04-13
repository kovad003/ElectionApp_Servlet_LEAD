
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_newquestion;
import data.Question;

/**
 * Servlet implementation class AdminAddCandidate
 */
@WebServlet("/AdminAddQuestion")
public class AdminAddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_newquestion  Dao_question=null;
	
	@Override
	public void init() {

		Dao_question=new Dao_newquestion("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
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

		Question question = new Question();
		question.setQuestion(request.getParameter("NEW_QUESTION"));
		
		
		System.out.println(question.getQuestion() );
		
		if(Dao_question.getConnection())
		{
			System.out.println("Successfully connected to the database");
			Dao_question.insertNewQuestion(question);
			System.out.println("Candidate Profile: " + question);	
		}
		else
		{
			System.out.println("No connection to database");
		}
		
		response.sendRedirect("/adminNewQuestions.jsp");  
		
//		RequestDispatcher rd=request.getRequestDispatcher("/AdminNewQuestions"); // will forwad you back to the previous page to chekc new data.
//		 	rd.forward(request, response);
		
	}

}

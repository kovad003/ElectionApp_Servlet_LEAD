

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_question;
import data.Candidate;
import data.Question;

/**
 * Servlet implementation class ShowQuestions
 */
@WebServlet("/ShowQuestions")
public class ShowQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_question dao=null;
	
	@Override
	public void init() {
		dao=new Dao_question("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestions() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
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
		else
		{
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/questionnaire.jsp");
		rd.forward(request, response);
	}
}

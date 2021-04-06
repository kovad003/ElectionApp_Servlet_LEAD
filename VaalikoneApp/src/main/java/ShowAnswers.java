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
import data.Question;

/**
 * Servlet implementation class ShowAnswers
 */
@WebServlet("/ShowAnswers")
public class ShowAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao_answer dao=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@Override
	public void init() {
		dao = new Dao_answer("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
	
    public ShowAnswers() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Answer> list=null;
		if(dao.getConnection())
		{
			System.out.println("Servlet doGet connected to the database");
			list=dao.readAllAnswer();
			System.out.println("List: " + list);
		}
		else
		{
			System.out.println("doGet has no connection to database");
		}
		request.setAttribute("answerlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/survey.jsp");
		rd.forward(request, response);
	}


}

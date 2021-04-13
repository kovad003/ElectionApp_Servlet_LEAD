

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_question;
import data.Question;

/**
 * Servlet implementation class AdminDeleteNewQuestion
 */
@WebServlet("/AdminDeleteNewQuestion")
public class AdminDeleteNewQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteNewQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String qId = request.getParameter("QID");
		
//		<<< Debugging Messages >>>
		System.out.println("QID for delete: " + qId);
		
		if(Dao_question.getConnection())
		{
			System.out.println("Successfully connected to the database");
			Dao_question.deleteNewQuestion(qId);
		}
		else
		{
			System.out.println("No connection to database");
		}
		
//		RequestDispatcher rd = request.getRequestDispatcher("/");
//		rd.forward(request, response);
		
//		RequestDispatcher rd=request.getRequestDispatcher("/AdminNewQuestions"); // will forwad you back to the previous page to chekc new data.
//		 	rd.forward(request, response);
		
	}

}

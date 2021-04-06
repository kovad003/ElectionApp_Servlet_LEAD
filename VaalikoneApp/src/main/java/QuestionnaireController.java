

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Question;

/**
 * Servlet implementation class QuestionnaireController
 */
@WebServlet("/QuestionnaireController")
public class QuestionnaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionnaireController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
    	Question q=questionList.get(0);
    	System.out.println(q.getId()+") "+q.getQuestion());
    	
    	request.getRequestDispatcher("/survey.jsp").forward(request, response);
	}

}

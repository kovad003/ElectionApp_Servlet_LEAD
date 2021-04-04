

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("answer:" + request.getParameter("select")); // get user selection from survey.jsp 
		String answer = request.getParameter("select");
		if(answer == null) // in case of no selection
		{
			answer = "0";
		}
		
		
		request.setAttribute("user_answer", answer); // "Collecting" user selection from survey.jsp
		RequestDispatcher view = getServletContext().getRequestDispatcher("/survey.jsp");
		    view.forward(request, response); // "Forwarding Data back to survey.jsp **
		
	    // TODO Servlet url is displayed after forward
		// TODO Get the questions from the DB **
		
	}

}



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
		
		
		
		
		
		/*
		//Will update the question counter from ShowQuestion
		//TODO we need next() and prev() methods in Questions so we can go back and forth in the list of questions
		int counter = (Integer)request.getAttribute("counter");
		counter++;
		System.out.println("counter is: " + counter);
		request.setAttribute("counter", counter);
		
		//Will selcet the next question from the ArrayList
		ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
    	Question q=questionList.get(counter-1); // starts with 0th element
    	
    	ArrayList<Question> singleQuestion = new ArrayList<Question>();
    	singleQuestion.add(q);
    	
    	System.out.println("Question object selected: " + questionList.get(counter-1));
    	System.out.println("Question selected: " + q.getId()+") "+q.getQuestion());
 
    	request.setAttribute("single_question", singleQuestion);
    	//request.setAttribute("question_id", q.getId());
    	//request.setAttribute("question_text", q.getQuestion());
    	
    	
    	//Will redirect us to the survey.jsp page
    	response.sendRedirect("/survey.jsp");
		    	
		    	
		    	
		    	//Will send the next question back to the survey.jsp file
		    	//request.getRequestDispatcher("/survey.jsp").forward(request, response);
		    	
		    	 */
		    	
	}

}

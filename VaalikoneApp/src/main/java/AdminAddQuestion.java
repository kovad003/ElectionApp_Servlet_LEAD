
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_question;
import data.Question;

/**
 * Date: April 16, 2021
 * Servlet implementation class AdminAddQuestion used for adding new questions
 * 
 * @version 3.0
 * @author HAMK's Finest
 */

@WebServlet("/AdminAddQuestion")
public class AdminAddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Dao_question: This Data Access Object class contains methods that work in conjunction with the Question class.
	 * It establishes a connection with the electionmachine DB and its methods allow for the performing of CRUD operations on said data through the utilization of attributes from the aforementioned class.
	 */
	private Dao_question  Dao_question=null;
	
	
	/**
     * init method
     * String based parameterized constructor for Dao_question class.
     */
	@Override
	public void init() {

		Dao_question=new Dao_question("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddQuestion() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * doPost method
	 * @throws ServletException, IOException
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/**
	 *   question object create from the Question class
	 */		Question question = new Question();
		/**	
		 * request: an HttpServletRequest object that contains the request the client has made of the servlet
		 * setQuestion: question attribute setter
		 * getParameter: Returns the value of a request parameter as a String,or null if the parameter does not exist
		 */
		question.setQuestion(request.getParameter("NEW_QUESTION"));
		
		
		System.out.println(question.getQuestion() );
		
		/**
		 * Dao_question: This Data Access Object class contains methods that work in conjunction with the Question class.It establishes a connection with the electionmachine DB and its methods allow for the performing of CRUD operations on said data through the utilization of attributes from the aforementioned class.
		 * insertNewQuestion: CRUD method utilizes Question class to insert new question value into thenew_questions DB. Attribute is loaded with new questions, and used to pass value to DB with conn connection.
		 * sendRedirect: Sends a temporary redirect response to the client using the specified redirect location URL and clears the buffer
		 * getConnection: Method attempts to establish a DB connection based on supplied attributes if one doesnot exist already. Method requires JDBC driver
		 */
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
		
		response.sendRedirect("/AdminNewQuestions");  
			
	}

}

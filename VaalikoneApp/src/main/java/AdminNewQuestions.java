
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
 * Date: April 16, 2021
 * Servlet implementation class AdminNewQuestions.New questions can be added to the application.
 * 
 * @version 3.0
 * @author HAMK's Finest
 */
@WebServlet("/AdminNewQuestions")
public class AdminNewQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Dao_question: This Data Access Object class contains methods that work in conjunction with the Question class.
	 */
	private Dao_question dao_question=null;

	/**
     * init method
     * String based parameterized constructor for Dao_question class.
     */
	@Override
	public void init() {
		dao_question=new Dao_question("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
	}
	    
    /**
     * @see HttpServlet#HttpServlet()
     * AdminNewQuestions: CONSTRUCTOR
     */
    public AdminNewQuestions() { // CONSTRUCTOR
        super();
    }

	/**
	 * doGet method: Called by the server (via the service method) to allow a servlet to handle a GET request. 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
  
    		/**
    		 * Question: Class
    		 */
    		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		//String sql = request.getParameter("NEWQUESTION");
       	
    	/**
    	* newQuestionsList: Array list that the new questions are going to be stored
		*/
    		ArrayList <Question> newQuestionsList = new ArrayList<Question>();
    	/**	
   		 * getConnection: Method attempts to establish a DB connection based on supplied attributes if one doesnot exist already. Method requires JDBC driver
		 */
    		if(dao_question.getConnection())
    		{
    		System.out.println("Successfully connected to the database");
    		newQuestionsList = dao_question.readNewQuestions();
    		System.out.println(" new questions data: " + newQuestionsList);
    		}
    		else
    		{
    		System.out.println("Unable to fetch data from database!");
    		}
    		
    		request.setAttribute("newQuestionsList", newQuestionsList); // Going to store arraylist as an attribute so we can acces it on the jsp page
    		
    		/**
    		 * RequestDispatcher: Defines an object that receives requests from the clientand sends them to any resource 
    		 * request: an HttpServletRequest object thatcontains the request the client has madeof the servlet
    		 * response: an HttpServletResponse object thatcontains the response the servlet sendsto the client
    		 */
    		RequestDispatcher rd=request.getRequestDispatcher("/adminNewQuestions.jsp"); // will forwad arraylist to the jsp page
   		 	rd.forward(request, response);
	
    		}

}
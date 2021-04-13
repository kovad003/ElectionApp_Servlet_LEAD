

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
 * Servlet implementation class AdminNewQuestions
 */
@WebServlet("/AdminNewQuestions")
public class AdminNewQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;
private Dao_question dao_question=null;
	
	@Override
	public void init() {
		dao_question=new Dao_question("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNewQuestions() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
    		
    		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		//String sql = request.getParameter("NEWQUESTION");

    		ArrayList <Question> newQuestionsList = new ArrayList<Question>();
    			
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
    		
    		RequestDispatcher rd=request.getRequestDispatcher("/adminNewQuestions.jsp"); // will forwad arraylist to the jsp page
   		 	rd.forward(request, response);
    		
    		
    	/*
    		if(dao_question.getConnection())
    		{
    		System.out.println("Successfully connected to the database");
    		dao_question.insertQuestion(sql);
    		System.out.println(sql + " successfully inserted into new_questions");
    		}
    		else
    		{
    		System.out.println(sql + " not inserted");
    		}
    		
    		 RequestDispatcher rd=request.getRequestDispatcher("/adminNewQuestions.jsp");
    		 rd.forward(request, response);
    		
    	*/	
    		}
   }
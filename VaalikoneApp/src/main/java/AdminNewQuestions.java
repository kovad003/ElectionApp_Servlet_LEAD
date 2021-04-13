

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_newquestion;
import dao.Dao_question;
import data.Question;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminNewQuestions
 */
@WebServlet("/AdminNewQuestions")
public class AdminNewQuestions extends HttpServlet {
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
    public AdminNewQuestions() { // CONSTRUCTOR, leave it here
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  
    		
    		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String sql = request.getParameter("NEWQUESTION");

    		if(dao.getConnection())
    		{
    		System.out.println("Successfully connected to the database");
    		dao.insertQuestion(sql);
    		System.out.println(sql + " successfully inserted into new_questions");
    		}
    		else
    		{
    		System.out.println(sql + " not inserted");
    		}
    		
    		 RequestDispatcher rd=request.getRequestDispatcher("/adminNewQuestions.jsp");
    		 rd.forward(request, response);
    		}
    		}
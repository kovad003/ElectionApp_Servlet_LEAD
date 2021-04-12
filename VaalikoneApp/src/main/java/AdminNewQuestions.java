

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
		ArrayList<Question> list=null;
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to the database");
			list=dao.readNewQuestions();
			System.out.println("Que_List: " + list);
			
			for (int i = 0; i < list.size(); i++) {
				Question c = list.get(i);//		
				System.out.println("QuestionNumber: " + c.getQuestion() );//
			}
			
		}
		else
		{
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/AdminUpdateNewQuestions.jsp");
		rd.forward(request, response);
	}
}

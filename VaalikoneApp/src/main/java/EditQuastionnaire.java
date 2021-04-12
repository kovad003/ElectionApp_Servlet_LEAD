

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_qanswer;
import data.QAnswer;

/**
 * Servlet implementation class EditQuastionnaire
 */
@WebServlet("/EditQuastionnaire")
public class EditQuastionnaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_qanswer dao_qanswer=null;
	
	@Override
	public void init() {

		dao_qanswer=new Dao_qanswer("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuastionnaire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cId = "2"; // Have to be replaced with login ID
		
		ArrayList<QAnswer> answerList = new ArrayList<QAnswer>();
		if(dao_qanswer.getConnection())
		{
			System.out.println("Successfully connected to the database");
			answerList = dao_qanswer.readAnswersForCandidate(cId);
			System.out.println("Candidate Profile: " + answerList);
			System.out.println("QA data was fetched for CID: " + answerList.get(0).getCId() + " - " + answerList.get(0).getQTxt());
		}
		else
		{
			System.out.println("No connection to database");
		}
		
		request.setAttribute("answerList", answerList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/updateQuestionnaire.jsp");
		rd.forward(request, response);
		
	}

}

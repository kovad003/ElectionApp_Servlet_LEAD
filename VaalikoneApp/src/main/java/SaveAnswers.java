

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_qanswer;
import data.QAnswer;

/**
 * Servlet implementation class SaveAnswers
 */
@WebServlet("/SaveAnswers")
public class SaveAnswers extends HttpServlet {
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
    public SaveAnswers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		*********************************************************************************************************************************************
//		*********** GET CANDIDATE SELECTIONS/ANSWERS ************************************************************************************************
//		*********************************************************************************************************************************************			
		
//		Getting answers:
		@SuppressWarnings("unchecked") // Because of the type casting. => Havent casused any isseu yet!
		ArrayList<QAnswer> selectionList = (ArrayList<QAnswer>) request.getAttribute("selectionList");
		
//		Saving Data to DB:
		if(dao_qanswer.getConnection())
		{
//			Successful connection!
			System.out.println("Successfully connected to the database");
			
//			Check if there is any user answer in the DB:
			String c_id = Integer.toString(selectionList.get(0).getCId());
			boolean emptyTable = dao_qanswer.readAnswersForCandidate(c_id).isEmpty();
			
			if(emptyTable) { //If there are no questions stored => insert new ones.
				dao_qanswer.insertAllAnswer(selectionList);
				System.out.println("Answer_List: " + selectionList);
			}
			else if(!emptyTable) {
				dao_qanswer.deleteAnswers(c_id);
				dao_qanswer.insertAllAnswer(selectionList);
			}
//			
			response.sendRedirect("/candidatePortal.jsp");
			
			

//			<<< Debugging Messages >>>
//			for (int i = 0; i < answerList.size(); i++) {		
//				QAnswer a = answerList.get(i);
//				a.getAnswer();
//				System.out.println("Candidate ID: " + a.getCId());
//				System.out.println("Question ID: " + a.getQId());
//				System.out.println("Answer : " + a.getAnswer());
//			}
		}
		else
		{
			System.out.println("No connection to database");
		}

	}

}

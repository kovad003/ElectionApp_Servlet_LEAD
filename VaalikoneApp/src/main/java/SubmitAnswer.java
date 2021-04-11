
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.QAnswer;

/**
 * Servlet implementation class SubmitAnswer
 */
@WebServlet("/SubmitAnswer")
public class SubmitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	@Override
	public void init() {
		
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		**********************************************************************************************************************************************
//		**************** GET CLIENT SELECTIONS *******************************************************************************************************
//		**********************************************************************************************************************************************
		
		ArrayList<QAnswer> selectionList= new ArrayList<QAnswer>(); // Empty ArrayList for the client's answers.
		
		for (int i = 1; i <= selectionList.size()+1; i++) {
			QAnswer qans = new QAnswer();
			String questionText = request.getParameter("question_text" + i);
			String selected = request.getParameter("selected" + i); // The client's selections will be saved and stored in QAnswer objects.

//			<<< Debugging Messages >>>
//			System.out.println("Q" + i + ", SELECTED by client: " + selected);
//			System.out.println("Q" + i + ", QUESTION TEXT: " + questionText);
			
			if (selected != null) {
				qans.setQId(i);
				qans.setQTxt(questionText);
				qans.setAnswer(selected);
				selectionList.add(qans);
			}	
		}
//		<<< Debugging Messages >>>
//		for(int i = 0; i < selectionList.size(); i++)
//		{
//			System.out.println("QID: " + selectionList.get(i).getQId() + " - Answer: " + selectionList.get(i).getAnswer()
//					+ " - QText: " +  selectionList.get(i).getQTxt());
//		}
		
//		**********************************************************************************************************************************************
//		**************** SENDING DATA TO EVALUATE QUASTIONNAIRE **************************************************************************************
//		**********************************************************************************************************************************************
		
		request.setAttribute("selectionList", selectionList);
		
//		ServletContext sc = request.getServletContext();
//	    sc.setAttribute("selectionList", selectionList);

//		IF U ARE LOGGED IN AS A CANDIDATE
//		RequestDispatcher rd = request.getRequestDispatcher("/SaveAnswers");
//		rd.forward(request, response);
		
//		IF U ARE LOGGED IN AS ARE A VOTER / REGULAR USER
		RequestDispatcher rd = request.getRequestDispatcher("/FindMatchingCandidates");
		rd.forward(request, response);
	}
}
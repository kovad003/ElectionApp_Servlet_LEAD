
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.QAnswer;

/**
 * Servlet implementation class SubmitAnswer.
 * Will collect questionnaire answers from both voters and candidates.
 * Data is collected from the (ShowQuestions => )questionnaire.jsp page
 * @see webapp.questionnaire.jsp
 * 
 * @author HAMK's Finest
 */
@WebServlet("/SubmitAnswer")
public class SubmitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * No Dao object required here, since this servlet only makes a decision on how to "deal" with the qui answers.
	 */
	@Override
	public void init() {
		
	}
       
    /**
     * Construcor
     * @see HttpServlet#HttpServlet()
     */
    public SubmitAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Will check if youa are logged in as a candidate or you are a regular user (potential voter).
	 * Candidate answers will be sent to the SaveAnswers servlet so the date can be stored in the databse.
	 * @see SaveAnswers.java
	 * Voter answers will be sent to the FindMatchingCandidates servlet, it will not be stored.
	 * @see FindMatchingCandidates.java
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		**********************************************************************************************************************************************
//		**************** CHECK COOKIES FOR LOGIN DATA ************************************************************************************************
//		**********************************************************************************************************************************************
		
		boolean isCandidate = false;;
		String id = null;
		
		Cookie[] login = request.getCookies();
		if(login !=null){
			for(Cookie i : login){
				if(i.getName().equals("user")) {
					isCandidate = true;
					id = i.getValue();
					System.out.println("login cookie: " + id);
					System.out.println("Candidate?: " + isCandidate);
					}
			}
		}
		
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
				System.out.println("CID: " +id);
				if(isCandidate) { qans.setCId(id); } // Candidate answers will be saved in DB => C_ID is required.
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

//		Integer.valueOf(id);

//		IF U ARE LOGGED IN AS A CANDIDATE
		if (isCandidate) {
			RequestDispatcher rd = request.getRequestDispatcher("/SaveAnswers");
			rd.forward(request, response);
			
		}
//		IF U ARE LOGGED IN AS ARE A VOTER / REGULAR USER
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/FindMatchingCandidates");
			rd.forward(request, response);
			}
	}
}
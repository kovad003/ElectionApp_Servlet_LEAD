
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_candidate;
import dao.Dao_qanswer;
import data.Candidate;
import data.QAnswer;

/**
 * Servlet implementation class SubmitAnswer
 */
@WebServlet("/SubmitAnswer")
public class SubmitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_qanswer dao_qanswer=null;
	private Dao_candidate dao_candidate=null;
	
	@Override
	public void init() {
		dao_qanswer=new Dao_qanswer("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
		dao_candidate=new Dao_candidate("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
		System.out.println("");
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
		String questionText;
		String selected;
		ArrayList<QAnswer> selectionList= new ArrayList<QAnswer>(); // Empty ArrayList for the client's answers.
		
		for (int i = 1; i <= selectionList.size()+1; i++) { // Will "grab" each answer from jsp page.
			QAnswer s = new QAnswer(); // Has to be placed inside the for loop.
			questionText = request.getParameter("question_text" + i);
			selected = request.getParameter("selected" + i); // The client's selections will be saved and stored in QAnswer objects.
			System.out.println("Q" + i + ", SELECTED by client: " + selected);
			System.out.println("Q" + i + ", QUESTION TEXT: " + questionText);
			if(selected!=null)
			{
				s.setQId(i);
				s.setAnswer(selected);
				s.setQTxt(questionText);
				selectionList.add(s);
				
//				<<< Debugging Messages >>>
//				System.out.println(i + " - " + selected);
//				System.out.println("Object: " + s);
//				System.out.println("List: " + selectionList);
//				System.out.println("Client-QID: " + s.getQId() + " - Client-Answ: " + s.getAnswer());		
			}	
		}
		
//		*********************************************************************************************************************************************
//		*********** GET CANDIDATE SELECTIONS/ANSWERS ************************************************************************************************
//		*********************************************************************************************************************************************
		ArrayList<QAnswer> answerList=null;
		if(dao_qanswer.getConnection())
		{
			System.out.println("Successfully connected to the database");
			answerList=dao_qanswer.readAllAnswer();
			System.out.println("Answer_List: " + answerList);
	
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
		
//		*********************************************************************************************************************************************
//		************ GET ALL CANDIDATE PROFILE ******************************************************************************************************
//		*********************************************************************************************************************************************	
		ArrayList<Candidate> candidateProfileStacked=null;
		if(dao_candidate.getConnection())
		{
			System.out.println("Successfully connected to the database");
			candidateProfileStacked=dao_candidate.readAllCandidate();
			System.out.println("Can_List: " + candidateProfileStacked);
			
//			<<< Debugging Messages >>> 		
//			for (int i = 0; i < candidateList.size(); i++) {
//				Candidate c = candidateList.get(i);//		
//				System.out.println("Candidate name: " + c.getFName() + " " + c.getSName());
//				System.out.println("location: " + c.getLocation() );
//			}	
		}
		else
		{
			System.out.println("No connection to database");
		}

//		*********************************************************************************************************************************************
//		************ PREPARE QUESTIONNAIRE RESULT****************************************************************************************************
//		*********************************************************************************************************************************************	
		ArrayList<QAnswer> answerListScored = scoreStackedData(answerList, selectionList); //Will produce a "stacked" ArrayList containing all the QA objects with individual score values.
		ArrayList<QAnswer> scoreBoard = findBestCnds(answerListScored);
		
		int cndIdPole = getCndIdFromScoreBoard(1, scoreBoard);
		int cndIdSecond = getCndIdFromScoreBoard(2, scoreBoard);
		int cndIdThird = getCndIdFromScoreBoard(3, scoreBoard);
		
		ArrayList<QAnswer> result_1st = sliceFromStacked(cndIdPole, answerListScored);
		ArrayList<QAnswer> result_2nd = sliceFromStacked(cndIdSecond, answerListScored);
		ArrayList<QAnswer> result_3rd = sliceFromStacked(cndIdThird, answerListScored);
		
//		<<< Debugging Messages >>> 	
//		System.out.println("Top1 CID: " + cndIdPole);
//		System.out.println("Top1 CID: " + cndIdSecond);
//		System.out.println("Top1 CID: " + cndIdThird);
		
//		*********************************************************************************************************************************************
//		************ PREPARE TOP CANDIDATE PROFILES *************************************************************************************************
//		*********************************************************************************************************************************************	

		Candidate profile_1st = returnCndProfile(cndIdPole, candidateProfileStacked);
		Candidate profile_2nd = returnCndProfile(cndIdSecond, candidateProfileStacked);
		Candidate profile_3rd = returnCndProfile(cndIdThird, candidateProfileStacked);
		
		
//		*********************************************************************************************************************************************
//		************ SENDING DATA TO THE JSP PAGE ***************************************************************************************************
//		*********************************************************************************************************************************************
		
		request.setAttribute("result_1st", result_1st);
		request.setAttribute("result_2nd", result_2nd);
		request.setAttribute("result_3rd", result_3rd);
		
		request.setAttribute("profile_1st", profile_1st);
		request.setAttribute("profile_2nd", profile_2nd);
		request.setAttribute("profile_3rd", profile_3rd);
		
		RequestDispatcher rd=request.getRequestDispatcher("/myCandidate.jsp");
		rd.forward(request, response);
	}
	
	
//	************************************************************************************************************************************************************	
//	************************************************************************************************************************************************************
//	****************************** CUSTOM METHODS **************************************************************************************************************
//	************************************************************************************************************************************************************
//	************************************************************************************************************************************************************

	public ArrayList<QAnswer> scoreStackedData(ArrayList<QAnswer> answerList, ArrayList<QAnswer> selectionList)
	{
		ArrayList<QAnswer> answerListScored= new ArrayList<QAnswer>(); // Will be returned at the end.
		ListIterator<QAnswer> iteratorCnd = answerList.listIterator(); // Will iterate through the ArrayList.
		ListIterator<QAnswer> iteratorClnt = selectionList.listIterator(); // Will iterate through the ArrayList.
		
		int cumulativeScore = 0;
		while (iteratorCnd.hasNext()) {
//			############ ITERATION #############
			QAnswer cnd = new QAnswer();
			cnd = iteratorCnd.next(); // Will select the next object in the ArrayList and assign it to QAnswer object.
			
			QAnswer clnt = new QAnswer();
			if (iteratorClnt.hasNext()) {
				clnt = iteratorClnt.next(); // Will select the next object in the ArrayList and assign it to QAnswer object.
			}
			else
			{
				iteratorClnt = selectionList.listIterator(); // Will reset the iterator <= answerList is the "stacked" QAnswer ArrayList with all the Q/A data given by the candidates.
				clnt = iteratorClnt.next(); // Afterreset we continue the assessment.
				
				cumulativeScore = 0; // Will reset value for nect candidate.
			}
			
			if(cnd.getQId() == clnt.getQId()) { // Checks if question IDs are matching or not (Data integrity error!) 	
//				############ SCORING #############
				int score = Math.abs(cnd.getAnswer() - clnt.getAnswer());
				cnd.setScore(score); // Will store the absolut value of the diff between 2 answer values. => SCORE
				
				cumulativeScore = cumulativeScore + score; // Will calculate a cumulative score.
				if(clnt.getQId() == selectionList.size()) {cnd.setTotalScore(cumulativeScore);} // Cumulative score is the total score (ONLY!) for last QA object.
				else {cnd.setTotalScore(-1);}
				
//				############ ADDING QUESTION TEXT #############
				cnd.setQTxt(clnt.getQTxt());
				
//				############ POPULATING ARRAYLIST #############
				answerListScored.add(cnd); // Adding QA object to ArrayList.
			}
			else {
				System.out.println("Data integrity error at scoreStacked()! Question IDs are not matching.");
			}	
		}
//		<<< Debugging Messages >>> 		
//		for (int i = 0; i < answerListScored.size(); i++) {
//			System.out.println("scoring results: " + "CID: " + answerListScored.get(i).getCId() + 
//					", QID: " + answerListScored.get(i).getQId() + ", Score: " + answerListScored.get(i).getScore() + 
//					", Total score: " + answerListScored.get(i).getTotalScore() + ", Q-TXT: " + answerListScored.get(i).getQTxt());}
		
		return answerListScored;		
	}
	
	public ArrayList<QAnswer> findBestCnds(ArrayList<QAnswer> scoredStackedData)
	{	
		ArrayList<QAnswer> cndScoreBoard = new ArrayList<QAnswer>();// Will be returned at the end.
		ArrayList<QAnswer> scoredStack = scoredStackedData; 
		ListIterator<QAnswer> iterator = scoredStack.listIterator(); // Will iterate through the ArrayList.
		
//		############ DROP FALSE DATA #############			
		while(iterator.hasNext()) // Will remove "junk" (false) total score data (-1).
		{
			QAnswer object = new QAnswer();
			object = iterator.next();
			if(object.getTotalScore() >= 0) {
				cndScoreBoard.add(object);
			}
			else {
//				<<< Debugging Messages >>> 	
//				System.out.println("False data removed: total_score = -1");
			}
		}

//		############ SORTING BASED ON TOTAL SCORE #############	
        Collections.sort(cndScoreBoard, new Comparator<QAnswer>() { // Will organise elements into ascending order.
            @Override public int compare(QAnswer o1, QAnswer o2) {
                return o1.getTotalScore() - o2.getTotalScore(); }}); 
        
//		<<< Debugging Messages >>> 		
		for (int i = 0; i < cndScoreBoard.size(); i++) {
			System.out.println("scoring results: " + "CID: " + cndScoreBoard.get(i).getCId() + 
					", Total score: " + cndScoreBoard.get(i).getTotalScore());}
	
		return cndScoreBoard;
	}
	
	
	public int getCndIdFromScoreBoard(int rankAchieved, ArrayList<QAnswer> scoreBoard)
	{
		ArrayList<QAnswer> scBoard = scoreBoard;
		
		int ranking = rankAchieved -1;
		int candidateId;
		
		candidateId = scBoard.get(ranking).getCId();	
		
		return candidateId;	
	}
	
	
	public ArrayList<QAnswer> sliceFromStacked(int candidateId, ArrayList<QAnswer> scoredStackedData)
	{
		int cndId = candidateId;
		ArrayList<QAnswer> result = new ArrayList<QAnswer>();
		ArrayList<QAnswer> scoredStackedArrLi = scoredStackedData; 
		ListIterator<QAnswer> iterator = scoredStackedArrLi.listIterator(); // Will reset iterator.
		
		while(iterator.hasNext()) {
			QAnswer object = new QAnswer();
			object = iterator.next();
			
			if(object.getCId() == cndId) {
				result.add(object);
			}
		}
		
//		<<< Debugging Messages >>> 		
		for (int i = 0; i < result.size(); i++) {
			System.out.println("Cnd data sliced: " + "CID: " + result.get(i).getCId() + 
					", QID: " + result.get(i).getQId() + ", Score: " + result.get(i).getScore() + 
					", Total score: " + result.get(i).getTotalScore() + ", Q-TXT: " + result.get(i).getQTxt());}
		
		return result;
	}
	
	
	public Candidate returnCndProfile(int candidateId, ArrayList<Candidate> candidateProfileStacked)
	{
		int cndId = candidateId;
//		ArrayList<Candidate> profile = new ArrayList<Candidate>();
		ArrayList<Candidate> cndProfileStck = candidateProfileStacked; 
		ListIterator<Candidate> iterator = cndProfileStck.listIterator();
		
		Candidate profile = new Candidate();
		
		while(iterator.hasNext()) {
			Candidate temporary = new Candidate();
			temporary = iterator.next();
			
			if(temporary.getId() == cndId) {
				profile = temporary;
			}
		}	
		
			System.out.println("Candidate Profile: " + "CID: " + profile.getId() + " - Fname: " + profile.getFName());

		return profile;	
	}
}

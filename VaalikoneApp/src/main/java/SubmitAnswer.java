
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

import dao.Dao_qanswer;
import data.QAnswer;

/**
 * Servlet implementation class SubmitAnswer
 */
@WebServlet("/SubmitAnswer")
public class SubmitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao_qanswer dao=null;
	
	@Override
	public void init() {
		dao=new Dao_qanswer("jdbc:mysql://localhost:3306/electionmachine", "pena", "kukkuu");
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
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to the database");
			answerList=dao.readAllAnswer();
			System.out.println("Answer_List: " + answerList);
			
			for (int i = 0; i < answerList.size(); i++) {		
				QAnswer a = answerList.get(i);
				a.getAnswer();
				
//				<<< Debugging Messages >>>
//				System.out.println("Candidate ID: " + a.getCId());
//				System.out.println("Question ID: " + a.getQId());
//				System.out.println("Answer : " + a.getAnswer());
			}	
		}
		else
		{
			System.out.println("No connection to database");
		}

		
//		*********************************************************************************************************************************************
//		************ COMPARE CLIENT WITH CANDIDATES *************************************************************************************************
//		*********************************************************************************************************************************************	
		ArrayList<QAnswer> answerListScored = scoreStackedData(answerList, selectionList); //Will produce a "stacked" ArrayList containing all the QA objects with individual score values.
		ArrayList<QAnswer> scoreBoard = findBestCnds(answerListScored);
		ArrayList<QAnswer> result1 = sliceFromStacked(0, scoreBoard, answerListScored);
		ArrayList<QAnswer> result2 = sliceFromStacked(1, scoreBoard, answerListScored);
		ArrayList<QAnswer> result3 = sliceFromStacked(2, scoreBoard, answerListScored);

		
//		*********************************************************************************************************************************************
//		************ SENDING DATA TO THE JSP PAGE *************************************************************************************************
//		*********************************************************************************************************************************************

		request.setAttribute("topCnd_1", result1);
		request.setAttribute("topCnd_2", result2);
		request.setAttribute("topCnd_3", result3);
		
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
		ArrayList<QAnswer> cndsToSlice = new ArrayList<QAnswer>();// Will be returned at the end.
		ArrayList<QAnswer> stackedArrLi = scoredStackedData; 
		ListIterator<QAnswer> iterator = stackedArrLi.listIterator(); // Will iterate through the ArrayList.
		
//		############ DROP FALSE DATA #############			
		while(iterator.hasNext()) // Will remove "junk" (false) total score data (-1).
		{
			QAnswer object = new QAnswer();
			object = iterator.next();
			if(object.getTotalScore() >= 0) {
				cndsToSlice.add(object);
			}
			else {
//				<<< Debugging Messages >>> 	
//				System.out.println("False data removed: total_score = -1");
			}
		}

//		############ SORTING BASED ON TOTAL SCORE #############	
        Collections.sort(cndsToSlice, new Comparator<QAnswer>() { // Will organise elements into ascending order.
            @Override public int compare(QAnswer o1, QAnswer o2) {
                return o1.getTotalScore() - o2.getTotalScore(); }}); 
        
//		<<< Debugging Messages >>> 		
		for (int i = 0; i < cndsToSlice.size(); i++) {
			System.out.println("scoring results: " + "CID: " + cndsToSlice.get(i).getCId() + 
					", Total score: " + cndsToSlice.get(i).getTotalScore());}
	
		return cndsToSlice;
	}
	
	
	public ArrayList<QAnswer> sliceFromStacked(int rankAchieved, ArrayList<QAnswer> scoreBoard, ArrayList<QAnswer> scoredStackedData)
	{
		int ranking = rankAchieved;
		ArrayList<QAnswer> resultsArrLi = new ArrayList<QAnswer>();
		ArrayList<QAnswer> scores = scoreBoard;
		ArrayList<QAnswer> scoredStackedArrLi = scoredStackedData; 
		ListIterator<QAnswer> iterator = scoredStackedArrLi.listIterator(); // Will reset iterator.
		
		while(iterator.hasNext()) {
			QAnswer object = new QAnswer();
			object = iterator.next();
			
			if(object.getCId() == scores.get(ranking).getCId()) {
				resultsArrLi.add(object);
			}
		}
		
//		<<< Debugging Messages >>> 		
		for (int i = 0; i < resultsArrLi.size(); i++) {
			System.out.println("Cnd data sliced: " + "CID: " + resultsArrLi.get(i).getCId() + 
					", QID: " + resultsArrLi.get(i).getQId() + ", Score: " + resultsArrLi.get(i).getScore() + 
					", Total score: " + resultsArrLi.get(i).getTotalScore() + ", Q-TXT: " + resultsArrLi.get(i).getQTxt());}
		
		return resultsArrLi;
	}
	
	
/*	
	public int[] findTopCandidates(ArrayList<QAnswer> answerList, ArrayList<QAnswer> selectionList)
	{
		ArrayList<QAnswer> RankedArrList = new ArrayList<QAnswer>();
		ArrayList<QAnswer> candidateScoredArrLi = new ArrayList<QAnswer>();
		
		
		Set<Integer> avlblCID = listAvlblCandidates(selectionList, answerList); // Will return a SET with the available Candidate IDs (CID)		
        Iterator<Integer> iterator = avlblCID.iterator(); // Creating an iterator object.
//		<<< Debugging Messages >>>
//      System.out.println("The iterator values are: "); // Displaying the values after iterating through the iterator

        while (iterator.hasNext()) {
        	Integer myInteger = iterator.next();
            int c_id = myInteger.intValue();
            System.out.println(c_id);
            
            candidateScoredArrLi = scoringCandidate(c_id, answerList, selectionList);
            QAnswer lastItem = candidateScoredArrLi.get(candidateScoredArrLi.size() - 1);
            
            RankedArrList.add(lastItem);

            lastItem.getTotalScore();
            lastItem.getAnswer();
            
            System.out.println("Score: " + lastItem.getTotalScore());
        }

        Collections.sort(RankedArrList, new Comparator<QAnswer>() { // Will organise elements into ascending order.
            @Override public int compare(QAnswer o1, QAnswer o2) {
                return o1.getTotalScore() - o2.getTotalScore(); }}); 
        
        int top_3[] = new int[RankedArrList.size()]; // Top 3 candidate ID (CID) will be returned in an array. 
		for(int i=0; i < RankedArrList.size(); i++){			
			top_3[i] = RankedArrList.get(i).getCId();
			
//			<<< Debugging Messages >>>   	  
//			System.out.println("CID: " + RankedArrList.get(i).getCId() + "Total: " + RankedArrList.get(i).getTotalScore() );
		  }
		return top_3;  
	}
	
	
	
//	Will score the chosen candidate (based on the c_id or CID) from the stacked ArrayList of candidate objects.
//	An ArrayList will be returned containing the relevant data for the candidate, including the totalscore.
//	############## IMPORTANT NOTE!!! Only use the last element of the AL to get the total score ###############
	public ArrayList<QAnswer> scoringCandidate(int c_id, ArrayList<QAnswer> answerList, ArrayList<QAnswer> selectionList)
	{
		int id_num = c_id; // c_id have to be initialised as a new integer. If c_id is used as a condition in the control flow " == " will re-assign its value => Error!
		ArrayList<QAnswer> candidateScoredArrLi = new ArrayList<QAnswer>(); // Will be returned at the end.
		ListIterator<QAnswer> iterator = answerList.listIterator(); // Will iterate through the ArrayList.
		ListIterator<QAnswer> iterator2 = selectionList.listIterator(); // Will iterate through the ArrayList.

//		<<< Debugging Messages >>>
//		System.out.println("answerList: " + answerList);
//		System.out.println("iterator: " + iterator);
		
		int totalScore = 0; // Has to be initialised outside while loop!
		while(iterator.hasNext())
		{
			int score = 0; // Will be reseted every turn.
			QAnswer candidateSingle = iterator.next(); // Will select the next object -first, when we start the iteration- in the ArrayList. 
//			Will create an empty object for the candidate, which will be amended with relevant data.
			
//			<<< Debugging Messages >>>
//			System.out.println("c_id: " + id_num +  " CID: " + candidateSingle.getCId());
			if (id_num == candidateSingle.getCId()) { // Will amend QAnswer objects with attributes.
				candidateSingle.getCId();
				candidateSingle.getQId();
				int answerCnddt = candidateSingle.getAnswer();
				
				// Scoring system based on client's data
				if (iterator2.hasNext()) {
					QAnswer client = iterator2.next(); // Will select the next object -first, when we start the iteration- in the ArrayList. Will create an empty object for the client, which will be amended with relevant data.
					client.getQId();
					int answerClnt = client.getAnswer();
					
					score = Math.abs(answerClnt - answerCnddt); // We use the absolute value of the difference.
					candidateSingle.setScore(score);
					totalScore = totalScore + score;
					candidateSingle.setTotalScore(totalScore); // Only use the last object of the ArrayList to check the total score, it grows as the iteration goes!
					candidateSingle.setTotalScoreAsInteger(totalScore);
				}
				else
				{
					System.out.println("No user selection!");
				}
				
				// ARRAYLIST:
				candidateScoredArrLi.add(candidateSingle); // Will add the QAnswer object to the ArrayList

//				<<< Debugging Messages >>>
//				System.out.println("iterator2.hasNext(): " + iterator2.hasNext());
//				System.out.println("CID: " + candidateSingle.getCId() + " - QID: " + 
//				candidateSingle.getQId() + " - A: " + candidateSingle.getAnswer());
//				System.out.println("Score: " + score);
			}
		}
//		<<< Debugging Messages >>>
		System.out.println("Total: " + totalScore);
		return candidateScoredArrLi;
	}

//	Will extract the data of the chosen candidate (based on the c_id or CID) from the stacked ArrayList into a separate ArrayList.
//	An ArrayList will be returned containing the relevant data for the candidate.
	public ArrayList<QAnswer> extractCandidate(int c_id, ArrayList<QAnswer> answerList)
	{
		int id_num = c_id; // c_id have to be initialised as a new integer. If c_id is used as a condition in the control flow " == " will re-assign its value => Error!
		ArrayList<QAnswer> candidateSingleArrList = new ArrayList<QAnswer>(); // Will be returned at the end.
		ListIterator<QAnswer> iterator = answerList.listIterator(); // Will iterate through the ArrayList.

//		<<< Debugging Messages >>>
//		System.out.println("answerList: " + answerList);
//		System.out.println("iterator: " + iterator);
		
		while(iterator.hasNext())
		{
			QAnswer candidateSingle = iterator.next(); // Will select the next object -first, when we start the iteration- in the ArrayList. 
//			Will create an empty object for the candidate, which will be amended with relevant data.
			
//			<<< Debugging Messages >>>
//			System.out.println("c_id: " + id_num +  " CID: " + candidateSingle.getCId());
			if (id_num == candidateSingle.getCId()) { // Will amend QAnswer objects with attributes.
				candidateSingle.getCId();
				candidateSingle.getQId();
				candidateSingle.getAnswer();
				
				candidateSingleArrList.add(candidateSingle); // Will add the QAnswer object to the ArrayList

//				<<< Debugging Messages >>>
//				System.out.println("CID: " + candidateSingle.getCId() + " - QID: " + 
//				candidateSingle.getQId() + " - A: " + candidateSingle.getAnswer());
			}
		}
		return candidateSingleArrList;
	}
	
//	Functions as a "filter". The SET will collect unique candidate IDs from the stacked ArrayList.
//	You can use this method to check which CIDs were taken out from the DB.
//	By using an iterator with this function you can use it for candidate data extraction.
	public Set<Integer> listAvlblCandidates(ArrayList<QAnswer> selectionList, ArrayList<QAnswer> answerList)
	{
		Set<Integer> avlblCID = new HashSet<Integer>(); // Will be used as a "filer" to create a set of unique CIDs from repetative data set.
		ListIterator<QAnswer> candidateIterator = answerList.listIterator();
		while(candidateIterator.hasNext())
		{
			QAnswer candidate = candidateIterator.next();			
			avlblCID.add(candidate.getCId()); // Will add the occuring CIDs to a set (no duplicates allowed!)	
		}
		System.out.println("Available CIDs: " + avlblCID);
		return avlblCID;
	}
*/	
}

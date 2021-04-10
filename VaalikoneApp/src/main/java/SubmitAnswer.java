
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

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
		String selected;
		ArrayList<QAnswer> selectionList= new ArrayList<QAnswer>(); // Empty ArrayList for the client's answers.
		
		for (int i = 1; i <= selectionList.size()+1; i++) { // Will "grab" each answer from jsp page.
			QAnswer s = new QAnswer(); // Has to be placed inside the for loop.
			selected = request.getParameter("selected" + i); // The client's selections will be saved and stored in QAnswer objects.
			System.out.println("Q" + i + ", SELECTED by client: " + selected);
			if(selected!=null)
			{
				s.setQId(i);
				s.setAnswer(selected);
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

		int[] topCandidates = findTopCandidates(answerList, selectionList);
		
		for (int i = 0; i < topCandidates.length; i++) {
			
			extractCandidate(topCandidates[i], answerList);
			System.out.println("");
		}
		
//		*********************************************************************************************************************************************
//		************ SENDING DATA TO THE JSP PAGE *************************************************************************************************
//		*********************************************************************************************************************************************
		
		request.setAttribute("topCnd_1", scoringCandidate(1, answerList, selectionList));
		
		RequestDispatcher rd=request.getRequestDispatcher("/myCandidate.jsp");
		rd.forward(request, response);
		
	}
	
	
//	************************************************************************************************************************************************************	
//	************************************************************************************************************************************************************
//	****************************** CUSTOM METHODS **************************************************************************************************************
//	************************************************************************************************************************************************************
//	************************************************************************************************************************************************************
	
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
}

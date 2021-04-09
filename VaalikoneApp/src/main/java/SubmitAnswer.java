
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

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
		
		for (int i = 1; i < selectionList.size()+2; i++) { // Will "grab" each answer from jsp page.
			QAnswer s = new QAnswer(); // Has to be placed inside the for loop.
			selected = request.getParameter("selected" + i); // The client's selections will be saved and stored in QAnswer objects.
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

		Set<Integer> avlblCID = listAvlblCandidates(selectionList, answerList); // Will return a SET with the available Candidate IDs (CID)	
		
        Iterator<Integer> iterator = avlblCID.iterator(); // Creating an iterator
  
        System.out.println("The iterator values are: "); // Displaying the values after iterating through the iterator

        while (iterator.hasNext()) {

        	Integer myInteger = iterator.next();
            int c_id = myInteger.intValue();
            System.out.println(c_id);
        	extractCandidate(c_id, answerList);
        }
	}
	
	
//	************************************************************************************************************************************************************	
//	************************************************************************************************************************************************************
//	****************************** CUSTOM METHODS **************************************************************************************************************
//	************************************************************************************************************************************************************
//	************************************************************************************************************************************************************
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
			QAnswer candidateSingle = iterator.next();
			//System.out.println("c_id: " + c_id +  " CID: " + candidateSingle.getCId());
			if (id_num == candidateSingle.getCId()) { // Will amend QAnswer objects with attributes.
				candidateSingle.getCId();
				candidateSingle.getQId();
				candidateSingle.getAnswer();
				
				candidateSingleArrList.add(candidateSingle);

//				<<< Debugging Messages >>>
//				System.out.println("CID: " + candidateSingle.getCId() + " - QID: " + 
//				candidateSingle.getQId() + " - A: " + candidateSingle.getAnswer());
			}
			else if (id_num < candidateSingle.getCId()) // It will prevent exit!
			{
//				<<< Debugging Messages >>>
				//System.out.println("c_id < CID");
			}
			else if (id_num > candidateSingle.getCId()) // It will prevent exit!
			{
//				<<< Debugging Messages >>>
				//System.out.println("c_id > CID"); 
			}	
		}
		return candidateSingleArrList;
	}
	
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

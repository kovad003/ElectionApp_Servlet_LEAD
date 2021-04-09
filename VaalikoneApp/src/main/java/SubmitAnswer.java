
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
		ArrayList<QAnswer> selectionList= new ArrayList<QAnswer>(); // How to creat DAO?
		for (int i = 1; i < selectionList.size()+2; i++) {
			QAnswer s = new QAnswer(); // has to be placed inside the for loop
			selected = request.getParameter("selected" + i);
			if(selected!=null)
			{
				s.setQId(i);
				s.setAnswer(selected);
				selectionList.add(s);
				
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
				
//				System.out.println("Candidate ID: " + a.getCId());
//				System.out.println("Question ID: " + a.getQId());
//				System.out.println("Answer : " + a.getAnswer());
			}	
		}
		else
		{
			System.out.println("No connection to database");
		}
		/*
		for (int i = 0; i < selectionList.size(); i++) {
			System.out.println("print: " + selectionList.get(i).getQId());	
		}
		*/
		
//		*********************************************************************************************************************************************
//		************ COMPARE CLIENT WITH CANDIDATES *************************************************************************************************
//		*********************************************************************************************************************************************

		listAvlblCandidates(selectionList, answerList); // Will return a SET with the available Candidate IDs (CID)	
		
		extractCandidate(1, answerList); // Will return an arrayList filled with data for the given CID.
		
		

	}
	
//	************************************************************************************************************************************************************
//	****************************** CUSTOM METHODS **************************************************************************************************************
//	************************************************************************************************************************************************************
	public ArrayList<QAnswer> extractCandidate(int c_id, ArrayList<QAnswer> answerList)
	{
		ArrayList<QAnswer> candidateSingleArrList = new ArrayList<QAnswer>();
		ListIterator<QAnswer> candidateIterator = answerList.listIterator();
		candidateIterator = answerList.listIterator(); // iterator has to be reseted
		
		boolean exit = false;
		while(candidateIterator.hasNext() && !exit)
		{
			QAnswer candidateSingle = candidateIterator.next();
			if (c_id == candidateSingle.getCId()) {
				candidateSingle.getCId();
				candidateSingle.getQId();
				candidateSingle.getAnswer();
				
				candidateSingleArrList.add(candidateSingle);
				
				System.out.println("CID: " + candidateSingle.getCId() + " - QID: " + candidateSingle.getQId() + " - A: " + candidateSingle.getAnswer());
			}
			else
			{	
				exit = true;
				candidateSingle = candidateIterator.previous();
			}	
		}
		return candidateSingleArrList;
	}
	
	public Set<Integer> listAvlblCandidates(ArrayList<QAnswer> selectionList, ArrayList<QAnswer> answerList)
	{
		Set<Integer> avlblCID = new HashSet<Integer>();
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

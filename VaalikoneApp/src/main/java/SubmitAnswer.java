
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

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
		// *******************************************************
		// GET CLIENT SELECTIONS
		// *******************************************************
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
		
		// *******************************************************
		// GET CANDIDATE SELECTIONS/ANSWERS
		// *******************************************************
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
		
		// *******************************************************
		// COMPARE CLIENT WITH CANDIDATES
		// *******************************************************

		ListIterator<QAnswer> clientIterator = selectionList.listIterator();
		ListIterator<QAnswer> candidateIterator = answerList.listIterator();
		
		// Results will be stored in an arraylist
		ArrayList<QAnswer> results = null;
		
		
		int num = 1;
		
		while(candidateIterator.hasNext())
		{
			QAnswer candidateSingle = candidateIterator.next();
			if (num == candidateSingle.getCId()) {
				candidateSingle.getCId();
				candidateSingle.getQId();
				candidateSingle.getAnswer();
				
				System.out.println("CID: " + candidateSingle.getCId() + " - QID: " + candidateSingle.getQId() + " - A: " + candidateSingle.getAnswer());
			}
			else
			{
				candidateSingle = candidateIterator.previous();
				num++;
			}	
		}
				
		/*
		int score = 0; // Initialising score variable
		while (candidateIterator.hasNext() && clientIterator.hasNext()) {
			QAnswer candidate = candidateIterator.next();
			int can_ans = candidate.getAnswer();
			
			QAnswer client = clientIterator.next();
			int cli_ans = client.getAnswer();
			
			// Calculating score
    		score = score + Math.abs(can_ans - cli_ans);
//    		System.out.println("***cli: " + cli);
//    		System.out.println("cli.getAnswer(): " + cliAns);
    		System.out.println("Score:" + score);
    		
    		// Save and reset score
    		if (!clientIterator.hasNext()) {
    			QAnswer result = new QAnswer();
    			result.setCId(candidate.getCId());
    			result.setScore(score);
    			System.out.println("CID: " + result.getCId() + "Score: " + result.getScore());
    			
    			clientIterator = selectionList.listIterator();
    			score = 0;
			}
	
		}
		*/
		
		
		
/*
		ListIterator<QAnswer> clientIterator = selectionList.listIterator();
		ListIterator<QAnswer> candidateIterator = answerList.listIterator();

		int score = 0; // Initialising score variable
		while (candidateIterator.hasNext() && clientIterator.hasNext()) {
			QAnswer candidate = candidateIterator.next();
			int can_ans = candidate.getAnswer();
			
			QAnswer client = clientIterator.next();
			int cli_ans = client.getAnswer();
			
			// Calculating score
    		score = score + Math.abs(can_ans - cli_ans);
//    		System.out.println("***cli: " + cli);
//    		System.out.println("cli.getAnswer(): " + cliAns);
    		System.out.println("Score:" + score);
    		
    		// Save and reset score
    		if (!clientIterator.hasNext()) {
    			QAnswer result = new QAnswer();
    			result.setCId(candidate.getCId());
    			result.setScore(score);
    			System.out.println("CID: " + result.getCId() + "Score: " + result.getScore());
    			
    			clientIterator = selectionList.listIterator();
    			score = 0;
			}
	
		}
*/
	}
	
}

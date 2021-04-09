
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
		
		
		
		
		/*		
        int score = 0; //will be returned as total score for each candidate
//        System.out.println("hasnext: " + candidateIterator.hasNext());
	
		ListIterator<QAnswer> clientIterator = selectionList.listIterator();
		ListIterator<QAnswer> candidateIterator = answerList.listIterator();
		
		QAnswer cli;
		int cliAns = 0;
		
        while (candidateIterator.hasNext()) {
        	
            QAnswer can = candidateIterator.next();
            // Taking candidates answer
            int canAns = can.getAnswer();
            
//          System.out.println("Value is : " + can);
          System.out.println("CID:" + can.getCId());
          System.out.println("QID:" + can.getQId());
//          System.out.println("Answer:" + canAns);

            if (clientIterator.hasNext()) {
            	// Taking Client's answer
            	cli = clientIterator.next();
        		cliAns = cli.getAnswer();
			}
            else
            {
            	clientIterator = selectionList.listIterator();
            	score = 0;
            }
            
    		// Calculating score
    		score = score + Math.abs(canAns - cliAns);
//    		System.out.println("***cli: " + cli);
//    		System.out.println("cli.getAnswer(): " + cliAns);
    		System.out.println("Score:" + score);

             
        }
		*/
		/*
		int i = 1; //index
		int avlblCans = 0;
        boolean iterate = true;
        int score = 0; //will be returned as total score for each candidate
//        System.out.println("hasnext: " + candidateIterator.hasNext());
	
		ListIterator<QAnswer> clientIterator = selectionList.listIterator();
		ListIterator<QAnswer> candidateIterator = answerList.listIterator();
		ListIterator<QAnswer> avlblCansIterator = answerList.listIterator();
		
		while (avlblCansIterator.hasNext()) {
			QAnswer can = avlblCansIterator.next();
			avlblCans = can.getCId();	
		}
		System.out.println("total num of available candidates: " + avlblCans);
 
        while (candidateIterator.hasNext() && iterate) {
            QAnswer can = candidateIterator.next();
            int canAns = can.getAnswer();
//            System.out.println("Value is : " + can);
            System.out.println("CID:" + can.getCId());
            System.out.println("QID:" + can.getQId());
//            System.out.println("Answer:" + canAns);
 
            if(can.getCId() == i)
            {
            	QAnswer cli = clientIterator.next();
        		int cliAns = cli.getAnswer();
        		score = score + Math.abs(canAns - cliAns);
//        		System.out.println("***cli: " + cli);
//        		System.out.println("cli.getAnswer(): " + cliAns);
        		System.out.println("Score:" + score);
            }
            else
            {
            	//iterate = false;
            	System.out.println("Score:" + score);
            	i++;
            	score = 0;
            	clientIterator = selectionList.listIterator(); // will reset the iterator
            	System.out.println("Iterator has been reseted");
            	
            }  
        }
*/
        /*
        List<QAnswer> answerListSingle = answerList.subList(0, 18);
        System.out.println("answerListSingle: " + answerListSingle);
        ListIterator<QAnswer> iteratorS = answerListSingle.listIterator();
        System.out.println("hasnext " + iteratorS.hasNext());
        System.out.println("\nanswerListSingle:\n");
        while (iteratorS.hasNext()) {
        	System.out.println("dasdasdas");
            QAnswer can = candidateIterator.next();
            System.out.println("Value is : " + can);
            System.out.println("CID:" + can.getCId());
            System.out.println("QID:" + can.getQId());
            System.out.println("Answer:" + can.getAnswer());

        }
		*/
		/*
		System.out.println("***********************************");
		System.out.println("************* FOR LOOP ************");
		int currentCID; //will be initialised in the for loop
		int junctionCID = answerList.get(0).getCId(); //will be initialised with the CID of the first candidate
		int selCounter = 0; // have to be the same as int i (for loop)
		for (int i = 0; i <= answerList.size(); i++) {
			QAnswer can = answerList.get(i); // candidate's answer
			QAnswer cli = selectionList.get(selCounter); // client's answer
			System.out.println("slectList: " + selectionList);
			System.out.println("Candidate-Obj: " + can);
			System.out.println("Client-Obj: " + cli);
			System.out.println("------------------------------");
			
			if (selCounter < selectionList.size()) {
				System.out.println("selCounter: " + selCounter);
				selCounter++; //increases selCounter
				System.out.println("selCounter was set to: " + selCounter);
			}
			else
			{
				selCounter = 0; //Reset the counter for the client's answer arraylist
				System.out.println("selCounter is reseted to: " + selCounter);
			}
			
			currentCID = can.getCId();
			System.out.println("currentCID => " + junctionCID);
			
			System.out.println("InspectCID => " + junctionCID);
			if (currentCID == junctionCID) {
				System.out.println("if statement");
				
				int canCID = can.getCId();
				int canQID = can.getQId();
				int canAns = can.getAnswer();
				int cliQID = cli.getQId();
				int cliAns = cli.getAnswer();
				
				System.out.println("Candidate-CID: " + canCID);
				System.out.println("Candidate-QID: " + canQID);
				System.out.println("Candidate-Answ: " + canAns);
				System.out.println("------------------------------");
				System.out.println("Client-QID: " + cliQID);
				System.out.println("Client-Answ: " + cliAns);
				System.out.println("------------------------------");
				
				int score;
				score = Math.abs(canAns - cliAns);
				System.out.println("Score: " + score);
				System.out.println("==============================");
			}
			else {
				junctionCID = currentCID;
				System.out.println("junctionCID was changed to " + junctionCID);
				System.out.println("==============================");
			}
		}
		*/
	}
	
}



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao_qanswer;
import dao.Dao_question;
import data.QAnswer;
import data.Question;

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
		
		Map <Integer, Integer> answerMap = new HashMap <Integer, Integer>(); //Data pair will be stored in this map
		// Usually it is better to handle such data as String however in the DB these data is used as PK so it must be Int
		String str = "selected";
		String answer;
		
		int q_id = 0; //first question_id will be 1
		do
		{
			q_id++; // q_id is used to index the selections
			System.out.println("q_id = " + q_id);
			
			str="selected" + Integer.toString(q_id); // selected1, selected2, selected#...
			System.out.println("Looking for q_id: " + str);
			
			answer = request.getParameter(str); //get selected# param
			System.out.println("q_id: " + q_id + " - answer: " + answer);
			
			if(answer != null)
			{
				answerMap.put(q_id, Integer.valueOf(answer)); //will add items to the HashMap
			}
			
		}while(answer != null);
		System.out.println(answerMap);
		/*
		ArrayList<QAnswer> list=request.getAttribute(name);
		if(dao.getConnection())
		{
			System.out.println("Successfully connected to the database");
			list=dao.insertAnswer(a);
			
			
			list=dao.readAllQuestion();
			System.out.println("List: " + list);
		}
		else
		{
			System.out.println("No connection to database");
		}
		request.setAttribute("questionlist", list);

*/
	}

}

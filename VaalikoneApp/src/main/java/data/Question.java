package data;


/**
 * The Question class houses attributes matching all columns of the
 * electionmachine.questions table. Instances of the class function
 * in conjunction with the matching Dao class and it's CRUD methods.
 * Class only contains setters/getters.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Question {
	
	/**
	 * int value of id matches QUESTION_ID column from electionmachine.questions table.
	 */
	private int id;
	/**
	 * String value question matches QUESTION column from electionmachine.questions table.
	 */
	private String question;
	
	
	/**
	 * String based parameterized constructor for Question class matching 
	 * columns of electionmachine.questions table.
	 * 
	 * @param id takes String arg of id for QUESTION_ID from/into electionmachine.questions.
	 * @param question takes String arg of question for QUESTION from/into electionmachine.questions.
	 */
	public Question(String id, String question) {
		setId(id);
		this.question=question;
	}
	
	
	/**
	 * Default constructor for Question class. All attributes null.
	 */
	public Question() {
		System.out.println("Question() constructor");
	}
	
	
	/* #################################################
	 * #############   GETTERS / SETTERS   #############
	 * #################################################*/	
	
	/**
	 * id attribute getter.
	 * @return int id for CANDIDATE_ID in questions table.
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * id attribute setter.
	 * @param id takes int id for CANDIDATE_ID in questions table.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * id attribute setter.
	 * @param id takes String arg for CANDIDATE_ID in questions table.
	 * @throws NumberFormatException | NullPointerException
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	
	
	/**
	 * question attribute getter.
	 * @return question String for QUESTION in questions table.
	 */
	public String getQuestion() {
		return question;
	}
	
	
	/**
	 * question attribute setter.
	 * @param question takes String arg for QUESTION in questions table.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
}

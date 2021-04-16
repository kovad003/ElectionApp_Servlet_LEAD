package data;

/**
 * The Answer class houses attributes matching all columns of the
 * electionmachine.answers table. Instances of the class function
 * in conjunction with the matching Dao class and it's CRUD methods.
 * Class only contains setters/getters.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Answer {
	
	/**
	 * int value matching CANDIDATE_ID column for electionmachine.answers table
	 */
	private int CANDIDATE_ID;
	/**
	 * int value matching QUESTION_ID column for electionmachine.answers table
	 */
	private int QUESTION_ID;
	/**
	 * int value matching ANSWER column for electionmachine.answers table
	 */
	private int ANSWER;
	
	
	/**
	 * String based parameterized constructor for Answer class matching
	 * columns of electionmachine.answers table
	 * 
	 * @param CANDIDATE_ID takes String arg of CANDIDATE_ID from/into electionmachine.answers
	 * @param QUESTION_ID takes String arg of QUESTION_ID from/into electionmachine.answers
	 * @param ANSWER takes String arg of ANSWER from/into electionmachine.answers
	 */
	public Answer(String CANDIDATE_ID, String QUESTION_ID, String ANSWER) {
		setCANDIDATE_ID(CANDIDATE_ID);
		setQUESTION_ID(QUESTION_ID);
		setANSWER(ANSWER);
	}
	
	
	/**
	 * Integer based parameterized constructor for Answer class matching
	 * columns of electionmachine.answers table
	 * 
	 * @param CANDIDATE_ID takes int arg of CANDIDATE_ID from/into electionmachine.answers
	 * @param QUESTION_ID takes int arg of QUESTION_ID from/into electionmachine.answers
	 * @param ANSWER takes int arg of ANSWER from/into electionmachine.answers
	 */
	public Answer(int CANDIDATE_ID, int QUESTION_ID, int ANSWER) {
		setCANDIDATE_ID(CANDIDATE_ID);
		setQUESTION_ID(QUESTION_ID);
		setANSWER(ANSWER);
	}
	
	
	/**
	 * Default constructor for Answer class. All attributes null.
	 */
	public Answer() {
		System.out.println("Answer() constructor");	
	}
	

	/* #################################################
	 * #############   GETTERS / SETTERS   #############
	 * #################################################*/
	
	/**
	 * CANDIDAT_ID attribute getter.
	 * @return int CANDIDAT_ID for answering candidate's ID in DB.
	 */
	public int getCANDIDATE_ID() {
		return CANDIDATE_ID;
	}

	/**
	 * CANDIDAT_ID attribute setter.
	 * @param CANDIDATE_ID takes int CANDIDAT_ID for answering candidate's ID in DB.
	 */
	public void setCANDIDATE_ID(int CANDIDATE_ID) {
		this.CANDIDATE_ID = CANDIDATE_ID;
	}
	
	/**
	 * CANDIDAT_ID attribute setter.
	 * @param CANDIDATE_ID takes String CANDIDAT_ID for answering candidate's ID in DB.
	 * @throws NumberFormatException | NullPointerException.
	 */
	public void setCANDIDATE_ID(String CANDIDATE_ID) {
		try {
			this.CANDIDATE_ID = Integer.parseInt(CANDIDATE_ID);
		}catch(NumberFormatException | NullPointerException e) {
		}
	}

	/**
	 * QUESTION_ID attribute getter.
	 * @return int QUESTION_ID identifying question being answered in DB.
	 */
	public int getQUESTION_ID() {
		return QUESTION_ID;
	}

	/**
	 * QUESTION_ID attribute setter.
	 * @param QUESTION_ID takes QUESTION_ID for question being answered in DB.
	 */
	public void setQUESTION_ID(int QUESTION_ID) {
		this.QUESTION_ID = QUESTION_ID;
	}
	
	/**
	 * QUESTION_ID attribute setter.
	 * @param QUESTION_ID takes QUESTION_ID for question being answered in DB.
	 * @throws NumberFormatException | NullPointerException.
	 */
	public void setQUESTION_ID(String QUESTION_ID) {
		try {
			this.QUESTION_ID = Integer.parseInt(QUESTION_ID);
		}catch(NumberFormatException | NullPointerException e) {
		}
	}

	/**
	 * ANSWER attribute getter.
	 * @return int ANSWER for value between 1-5 as answer to survey questions.
	 */
	public int getANSWER() {
		return ANSWER;
	}

	/**
	 * ANSWER attribute setter.
	 * @param ANSWER takes int ANSWER for value between 1-5 as answer to survey questions.
	 */
	public void setANSWER(int ANSWER) {
		this.ANSWER = ANSWER;
	}
	
	/**
	 * ANSWER attribute setter.
	 * @param ANSWER takes String ANSWER for value between 1-5 as answer to survey questions.
	 */
	public void setANSWER(String ANSWER) {
		try {
			this.ANSWER = Integer.parseInt(ANSWER);
		}catch(NumberFormatException | NullPointerException e) {
		}
	}
	
}

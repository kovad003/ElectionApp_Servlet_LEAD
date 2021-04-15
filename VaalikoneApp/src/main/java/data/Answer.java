package data;

/**
 * @author HAMK's Fin
 *
 */
public class Answer {
	
	/*
	 * Instances used as arraylists to house politicians answers from
	 * electionmachine.answers with columns as attributes of instance.
	 * 
	 * -= CONSTRUCTORS =-
	 * 	  1) default:
	 * 			-> takes no args
	 * 			-> all attribs set to null
	 * 	  2) param.ized:
	 * 			-> all 3 attrib take params in order:
	 * 			   CANDIDATE_ID, QUESTION_ID, ANSWER
	 * 			   from electionmachine.answers table
	 */
	
	/**
	 * 
	 */
	private int CANDIDATE_ID;
	private int QUESTION_ID;
	private int ANSWER;
	
	
	/**
	 * @param CANDIDATE_ID explain candidateid 
	 * @param QUESTION_ID
	 * @param ANSWER
	 */
	public Answer(String CANDIDATE_ID, String QUESTION_ID, String ANSWER) {
		setCANDIDATE_ID(CANDIDATE_ID);
		setQUESTION_ID(QUESTION_ID);
		setANSWER(ANSWER);
	}
	
	public Answer() {
		System.out.println("Answer() constructor");	
	}
	

	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	public int getCANDIDATE_ID() {
		return CANDIDATE_ID;
	}

	public void setCANDIDATE_ID(int CANDIDATE_ID) {
		this.CANDIDATE_ID = CANDIDATE_ID;
	}
	
	public void setCANDIDATE_ID(String CANDIDATE_ID) {
		try {
			this.CANDIDATE_ID = Integer.parseInt(CANDIDATE_ID);
		}catch(NumberFormatException | NullPointerException e) {
		}
	}

	public int getQUESTION_ID() {
		return QUESTION_ID;
	}

	public void setQUESTION_ID(int QUESTION_ID) {
		this.QUESTION_ID = QUESTION_ID;
	}
	
	public void setQUESTION_ID(String QUESTION_ID) {
		try {
			this.QUESTION_ID = Integer.parseInt(QUESTION_ID);
		}catch(NumberFormatException | NullPointerException e) {
		}
	}

	public int getANSWER() {
		return ANSWER;
	}

	public void setANSWER(int ANSWER) {
		this.ANSWER = ANSWER;
	}
	
	public void setANSWER(String ANSWER) {
		try {
			this.ANSWER = Integer.parseInt(ANSWER);
		}catch(NumberFormatException | NullPointerException e) {
		}
	}

	
	/***************************************************
	 ********************   METHODS   ******************
	 ***************************************************/
	
	
	
}

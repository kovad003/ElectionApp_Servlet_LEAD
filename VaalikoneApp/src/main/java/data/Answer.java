package data;

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
	
	private String CANDIDATE_ID;
	private String QUESTION_ID;
	private String ANSWER;
	
	
	public Answer() {
		this.CANDIDATE_ID = null;
		this.QUESTION_ID = null;
		this.ANSWER = null;	
	}
	
	public Answer(String CANDIDATE_ID, String QUESTION_ID, String ANSWER) {
		this.CANDIDATE_ID = CANDIDATE_ID;
		this.QUESTION_ID = QUESTION_ID;
		this.ANSWER = ANSWER;
	}
	

	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	public String getCANDIDATE_ID() {
		return CANDIDATE_ID;
	}

	public void setCANDIDATE_ID(String CANDIDATE_ID) {
		CANDIDATE_ID = CANDIDATE_ID;
	}

	public String getQUESTION_ID() {
		return QUESTION_ID;
	}

	public void setQUESTION_ID(String QUESTION_ID) {
		QUESTION_ID = QUESTION_ID;
	}

	public String getANSWER() {
		return ANSWER;
	}

	public void setANSWER(String ANSWER) {
		ANSWER = ANSWER;
	}

	
	/***************************************************
	 ********************   METHODS   ******************
	 ***************************************************/
	
	
	
}

package data;

/**
 * The QAnswer class houses attributes matching all columns of the
 * electionmachine.answers table. Instances of the class function
 * in conjunction with the matching Dao class and it's CRUD methods.
 * Class only contains setters/getters.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 * 
 */

public class QAnswer {
	/**
	 * int value representing the CANDIDATE_ID column for electionmachine.answers table
	 */
	private int cId;
	
	/**
	 * int value matching QUESTION_ID column for electionmachine.answers table
	 */
	private int qId;
	
	/**
	 * int value matching ANSWER column for electionmachine.answers table
	 */
	private int answer;
	
	/**
	 * int value matching the QUESTION column for electionmachine.questions table
	 */
	private String questionTxt;
	
	/**
	 * int value which is gained by comparing the voter and candidate answer. Will be used to calculate the total score.
	 */
	private int score;
	
	/**
	 * int value which is gained by adding up all the score values, 
	 * will be attached to the last QAnswer object of the ArrayList containing a specific candidate's answers.
	 * For technical reasons other QAnswer entites, which are before the last one may amended with -1 value so
	 * they can be ignored when you want to select the actual total score value.
	 */
	private int totalScore;
	
	/**
	 * Used as the previuos attribute, however instead if int, the INTEGER type was utilized.
	 */
	private Integer totalScoreInteger;

	
//	 *************************************************************************************************
//	 ******************** CONSTRUCTERS ***************************************************************
//	 *************************************************************************************************
	
	/**
	 * PARAMETERISED CONSTRUCTOR method for the QAnswer entity.
	 * Will take the most frequently used arg so the object can be amended instantly.
	 * @param can_id will amend the object with the CANDIDATE_ID property.
	 * @param quest_id will amend the object with the QUESTION_ID property.
	 * @param will amend the object with the QUESTION (text) property.
	 */
	public QAnswer(int can_id, int quest_id, int answer) {
		setCId(can_id);
		setQId(quest_id);
		this.answer=answer;
	}
	
	
	/**
	 * DEFAULT CONSTRUCTOR
	 * Creates an empty object of QAnswer type, so it can be amended with the desired attributes using the setters. 
	 */
	public QAnswer() {
//		System.out.println("QAnswer()");	
	}
	
//	 *************************************************************************************************
//	 ******************** SETTERS ********************************************************************
//	 *************************************************************************************************	
	
	/**
	 * Will amend the object with the CANDIDATE_ID (cId) property.
	 * @param cId takes an int for the CANDIDATE_ID.
	 */
	public void setCId(int cId) {
		this.cId = cId;	
	}

	/**
	 * Will amend the object with the CANDIDATE_ID (cId) property.
	 * @param cId takes a String for the CANDIDATE_ID and converts it to Integer type.
	 */
	public void setCId(String cId) {
		this.cId = Integer.valueOf(cId);
		
	}
	
	/**
	 * Will amend the object with the QUESTION_ID (qId) property.
	 * @param id takes an int for the QUESTION_ID.
	 */
	public void setQId(int id) {
		//System.out.println("setId(int id)");
		this.qId = id;
	}
	
	/**
	 * Will amend the object with the QUESTION_ID (qId) property.
	 * @param id takes a String for the QUESTION_ID and converts it to Integer type.
	 */	
	public void setQId(String id) {
		//System.out.println("setId(String id)");
		this.qId = Integer.parseInt(id);
	}
	
	/**
	 * Will amend the object with the ANSWER (answer) property.
	 * @param answer takes an int for the ANSWER (1-5) value.
	 */	
	public void setAnswer(int answer) {
		//System.out.println("setAnswer(String answer)");
		this.answer = answer;
	}
	
	/**
	 * Will amend the object with the ANSWER (answer) property.
	 * @param answer takes an String for the ANSWER (1-5) value and converts it to Integer type.
	 */	
	public void setAnswer(String answer) {
		//System.out.println("setAnswer(String answer)");
		this.answer = Integer.parseInt(answer);
	}
	
	/**
	 * Will amend the object with the score property.
	 * @param score takes an int type for the score variable, it is used when the voter answer values are compared to the candidate answer values.
	 */	
	public void setScore(int score) {
		//System.out.println("setAnswer(String answer)");
		this.score = score;
	}
	
	/**
	 * Will amend the object with the totalScore property.
	 * @param totalScore takes an int type for the score variable, it is the sum of all the score values, and attached to the very last QAnswer object of the ArrayList.
	 */	
	public void setTotalScore(int totalScore) { // Has to be calculated in the Servlet by summing each score.
		this.totalScore = totalScore; // Should be added to the last CANDIDATE object of the ArrayList.
	}
	
	/**
	 * Will amend the object with the totalScore property.
	 * @param totalScore takes an int type for the score variable and converts it to type Integer.
	 */	
	public void setTotalScoreAsInteger(int totalScore) { 
		this.totalScoreInteger = Integer.valueOf(totalScore);
	}
	
	/**
	 * Will amend the object with the QTxt property.
	 * @param questionText takes a String, which represents the questio text for a certain QUESTION_ID.
	 */
	public void setQTxt(String questionText) {
		this.questionTxt = questionText;	
	}
	
	
//	 *************************************************************************************************
//	 ******************** GETTERS ********************************************************************
//	 *************************************************************************************************
	
	/**
	 * @return the ANSWER (answer) property of the QAnswer object.
	 */	
	public int getAnswer() {
		//System.out.println("getAnswer()");
		return answer;
	}
	
	/**
	 * @return the CANDIDATE_ID (cId) property of the QAnswer object.
	 */	
	public int getCId() {
		return cId;	
	}
	
	/**
	 * @return the QUESTION_ID (qId) property of the QAnswer object.
	 */	
	public int getQId() {
		return qId;	
	}
	
	/**
	 * @return the score property of the QAnswer object.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * @return the totalScore property of the QAnswer object.
	 */	
	public int getTotalScore() { // Should be stored in the last CANDIDATE object of the ArrayList.
		return totalScore; 
	}
	
	/**
	 *@return the totalScore property of the QAnswer object as an Integer.
	 */	
	public int getTotalScoreAsInteger() { 
		return totalScoreInteger; 
	}
	
	/**
	 * @return the questionTxt property of the QAnswer object.
	 */	
	public String getQTxt() {
		return questionTxt;	
	}

}

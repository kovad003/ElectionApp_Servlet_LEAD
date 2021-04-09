package data;

public class QAnswer {
	private int cId;
	private int qId;
	private int answer;
	private int score;
	private int totalScore;
	
//	 *************************************************************************************************
//	 ******************** CONSTRUCTERS ***************************************************************
//	 *************************************************************************************************
	public QAnswer(int can_id, int quest_id, int answer) {
		setCId(can_id);
		setQId(quest_id);
		this.answer=answer;
	}
	public QAnswer() {
//		System.out.println("QAnswer()");	
	}
	
//	 *************************************************************************************************
//	 ******************** SETTERS ********************************************************************
//	 *************************************************************************************************	
	public void setCId(int cId) {
		this.cId = cId;	
	}
	public void setQId(int id) {
		//System.out.println("setId(int id)");
		this.qId = id;
	}
	public void setQId(String id) {
		//System.out.println("setId(String id)");
		this.qId = Integer.parseInt(id);
	}
	public void setAnswer(int answer) {
		//System.out.println("setAnswer(String answer)");
		this.answer = answer;
	}
	public void setAnswer(String answer) {
		//System.out.println("setAnswer(String answer)");
		this.answer = Integer.parseInt(answer);
	}
	public void setScore(int score) {
		//System.out.println("setAnswer(String answer)");
		this.score = score;
	}
	public void setTotalScore(int totalScore) { // Has to be calculated in the Servlet by summing each score.
		this.totalScore = totalScore; // Should be added to the last CANDIDATE object of the ArrayList.
	}
	
//	 *************************************************************************************************
//	 ******************** GETTERS ********************************************************************
//	 *************************************************************************************************
	public int getAnswer() {
		//System.out.println("getAnswer()");
		return answer;
	}
	public int getCId() {
		return cId;	
	}
	public int getQId() {
		return qId;	
	}
	public int getScore() {
		return score;
	}
	public int getTotalScore() { // Should be stored in the last CANDIDATE object of the ArrayList.
		return totalScore; 
	}
	
//	 *************************************************************************************************
//	 ******************** CUSTOM *********************************************************************
//	 *************************************************************************************************
	
//	Currently empty

}

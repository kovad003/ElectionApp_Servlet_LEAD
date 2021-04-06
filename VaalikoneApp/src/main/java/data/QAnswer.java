package data;

import java.util.HashMap;
import java.util.Map;

public class QAnswer {
	private int id;
	private int answer;
	public QAnswer(String id, int answer) {
		setId(id);
		this.answer=answer;
	}
	public QAnswer() {
		Map <Integer, Integer> answerMap = new HashMap <Integer, Integer>();
		System.out.println("QAnswer()");
		
	}
	
	public int getId() {
		//System.out.println("getId()");
		return id;
	}
	public void setId(int id) {
		//System.out.println("setId(int id)");
		this.id = id;
	}
	public void setId(String id) {
		//System.out.println("setId(String id)");
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	public int getAnswer() {
		//System.out.println("getAnswer()");
		return answer;
	}
	public void setAnswer(int answer) {
		//System.out.println("setAnswer(String answer)");
		this.answer = answer;
	}

}

package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import org.apache.commons.logging.impl.AvalonLogger;

public class QAnswer {
	private int cId;
	private int qId;
	private int answer;
	private int score;
	public QAnswer(int can_id, int quest_id, int answer) {
		setCId(can_id);
		setQId(quest_id);
		this.answer=answer;
	}
	public QAnswer() {
		System.out.println("QAnswer()");
		
	}
	
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
	
	// ***************************************************
	// ******************** GETTERS **********************
	// ***************************************************
	
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
	
	// ***************************************************
	// ******************** CUSTOM ***********************
	// ***************************************************
	
	public int findBestMatch(ArrayList<QAnswer> selectionList, ArrayList<QAnswer> answerList)
	{
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
//            System.out.println("CID:" + can.getCId());
//            System.out.println("QID:" + can.getQId());
//            System.out.println("Answer:" + canAns);
 
            if(can.getCId() == 1)
            {
            	QAnswer cli = clientIterator.next();
        		int cliAns = cli.getAnswer();
        		score = score + Math.abs(canAns - cliAns);
//        		System.out.println("***cli: " + cli);
//        		System.out.println("cli.getAnswer(): " + cliAns);
            }
            else
            {
            	iterate = false;
            	System.out.println("Score:" + score);
            	this.score = score;
            }  
        }
		return score;
	}

}

package data;

/**
 * @author dblin
 *
 */

public class Question {
	
	/**
	 * 
	 */
	private int id;
	/**
	 * 
	 */
	private String question;
	
	
	/**
	 * @param id
	 * @param question
	 */
	public Question(String id, String question) {
		setId(id);
		this.question=question;
	}
	
	
	/**
	 * 
	 */
	public Question() {
		System.out.println("Question() constructor");
		
		
	}
	/**
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	
	
	/**
	 * @return
	 */
	public String getQuestion() {
		return question;
	}
	
	
	/**
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	
}

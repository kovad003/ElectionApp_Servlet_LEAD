package data;

public class Question {
	private int id;
	private String question;
	public Question(String id, String question) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.question=question;
	}
	public Question() {
		System.out.println("Question() constructor");
		
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
	public String getQuestion() {
		//System.out.println("getQuestion()");
		return question;
	}
	public void setQuestion(String question) {
		//System.out.println("setQuestion(String question)");
		this.question = question;
	}
	
}


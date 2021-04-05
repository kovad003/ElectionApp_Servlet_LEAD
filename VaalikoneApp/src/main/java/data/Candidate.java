package data;

public class Candidate {
	private int id;
	private String candidate;
	private String candidatelocation;
	public Candidate(String id, String candidate) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.candidate=candidate;
	}
	public Candidate() {
		System.out.println("Candidate() constructor");
		
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
	public String getCandidate() {
		//System.out.println("getQuestion()");
		return candidate;
	}
	public void setCandidate(String candidate) {
		//System.out.println("setQuestion(String question)");
		this.candidate = candidate;
		
	}
/**	public void setCandidateLocation(String candidatelocation) {
		this.candidatelocation = candidatelocation;
		
	}
	public int getCandidateLocation() {
		// TODO Auto-generated method stub
		return id;
} */	
	
		
	
}


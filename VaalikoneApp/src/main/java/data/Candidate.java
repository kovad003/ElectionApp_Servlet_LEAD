package data;

public class Candidate {
	
	private int id;
	private String party;
	private String location;
	private int age;
	private String reason;
	private String goals;
	private String profession;
	private String fName;
	private String sName;
	
	public Candidate(String id, String party) {
		setId(id);
		this.party=party;
	}
	public Candidate() {
		System.out.println("Candidate() constructor");		
	}
	
	// **********************************
	// *********** SETTERS **************
	// **********************************
	
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
	public void setParty(String candidate) {
		//System.out.println("setQuestion(String question)");
		this.party = candidate;	
	}
	public void setSName(String sName) { //propeety name in JSP (JSTL lib) will be c.SName
		this.sName = sName;	
	}
	public void setFName(String fName) { //propeety name in JSP (JSTL lib) will be c.FName
		this.fName = fName;	
	}
	public void setLocation(String location) {
		this.location = location;	
	}
	public void setAge(int age) {
		this.age = age;	
	}
	public void setReason(String reason) {
		this.reason = reason;		
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public void setProfession(String profession) {
		this.profession = profession;		
	}
	
	
	
	// **********************************
	// *********** GETTERS **************
	// **********************************
	
	public int getId() {
		return id;
	}
	public String getParty() {
		return party;
	}
	public String getSName() {
		return sName;
	}
	public String getFName() {
		return fName;
	}
	public String getLocation() {
		return location;		
	}
	public int getAge() {
		return age;	
	}
	public String getReason() {
		return reason;	
	}
	public String getGoals() {
		return goals;
	}
	public String getProfession() {
		return profession;
	}	
}


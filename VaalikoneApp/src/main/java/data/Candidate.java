package data;

public class Candidate {
	
	/*
	 * Instances used as arraylists to house politicians answers from
	 * electionmachine.answers with columns as attributes of instance.
	 * 
	 * -= CONSTRUCTORS =-
	 * 
	 * 	  1) param.ized: String
	 * 			-> all parameters are Strings, attributes also set to String
	 * 			-> matching columns of electionmachine.caindidates table
	 * 
	 * 	  2) param.ized: int + String
	 * 			-> int field parameters in MySQL table are int, String fields are 
	 *             String, attributes also set to String
	 * 			-> matching columns of electionmachine.caindidates table
	 * 
	 * 	  3) default:
	 * 			-> takes no args
	 * 			-> all attribs set to null
	 */
	
	private int id;
	private String party;
	private String location;
	private int age;
	private String reason;
	private String goals;
	private String profession;
	private String fName;
	private String sName;
	private String USERNAME;
	private String PASSWORD;
	
	
	public Candidate(String id, String sName, String fName, String party, String location, String age, String reason, 
			String goals, String profession, String USERNAME, String PASSWORD) {
		setId(id);
		this.sName=sName;
		this.fName=fName;
		this.party=party;
		this.location=location;
		setAge(age);
		this.reason=reason;
		this.goals=goals;
		this.profession=profession;
		this.USERNAME=USERNAME;
		this.PASSWORD=PASSWORD;	
	}
	
	public Candidate(int id, String sName, String fName, String party, String location, int age, String reason, 
			String goals, String profession, String USERNAME, String PASSWORD) {
		setId(id);
		this.sName=sName;
		this.fName=fName;
		this.party=party;
		this.location=location;
		setAge(age);
		this.reason=reason;
		this.goals=goals;
		this.profession=profession;
		this.USERNAME=USERNAME;
		this.PASSWORD=PASSWORD;	
	}
	
	public Candidate() {
		System.out.println("Candidate() default constructor");		
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
	public void setAge(String age) {
		//System.out.println("setId(String id)");
		try {
			this.age = Integer.parseInt(age);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}	
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
	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;		
	}
	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;		
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
	public String getUSERNAME() {
		return USERNAME;		
	}
	public String getPASSWORD() {
		return PASSWORD;		
	}
}


package data;

/**
 * The Candidate class houses attributes matching all columns of the
 * electionmachine.candidates table. Instances of the class function
 * in conjunction with the matching Dao class and it's CRUD methods.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

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
	
	
	/**
	 * int value matching CANDIDATE_ID column from electionmachine.candidates table
	 */
	private int id;
	/**
	 * String value matching PARTY column from electionmachine.candidates table
	 */
	private String party;
	/**
	 * String value matching LOCATION column from electionmachine.candidates table
	 */
	private String location;
	/**
	 * String value matching AGE column from electionmachine.candidates table
	 */
	private int age;
	/**
	 * String value matching REASON_FOR_RUNNING column from electionmachine.candidates table
	 */
	private String reason;
	/**
	 * String value matching AIMS_AND_GOALS column from electionmachine.candidates table
	 */
	private String goals;
	/**
	 * String value matching PROFESSION column from electionmachine.candidates table
	 */
	private String profession;
	/**
	 * String value matching FIRSTNAME column from electionmachine.candidates table
	 */
	private String fName;
	/**
	 * String value matching SURNAME column from electionmachine.candidates table
	 */
	private String sName;
	/**
	 * String value matching USERNAME column from electionmachine.candidates table
	 */
	private String USERNAME;
	/**
	 * String value matching PASSWORD column from electionmachine.candidates table
	 */
	private String PASSWORD;
	
	
	/**
	 * String based parameterized constructor for Candidate class matching 
	 * columns of electionmachine.caindidates table
	 * 
	 * @param id takes String arg of CANDIDATE_ID from/into electionmachine.caindidates
	 * @param sName takes String arg of SURNAME from/into electionmachine.caindidates
	 * @param fName takes String arg of FIRSTNAME from/into electionmachine.caindidates
	 * @param party takes String arg of PARTY from/into electionmachine.caindidates
	 * @param location takes String arg of LOCATION from/into electionmachine.caindidates
	 * @param age takes String arg of AGE from/into electionmachine.caindidates
	 * @param reason takes String arg of REASON_FOR_RUNNING from/into electionmachine.caindidates
	 * @param goals takes String arg of AIMS_AND_GOALS from/into electionmachine.caindidates
	 * @param profession takes String arg of PROFESSION from/into electionmachine.caindidates
	 * @param USERNAME takes String arg of USERNAME from/into electionmachine.caindidates
	 * @param PASSWORD takes String arg of PASSWORD from/into electionmachine.caindidates
	 */
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
	
	/**
	 * @param id
	 * @param sName
	 * @param fName
	 * @param party
	 * @param location
	 * @param age
	 * @param reason
	 * @param goals
	 * @param profession
	 * @param USERNAME
	 * @param PASSWORD
	 */
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
	
	/**
	 * 
	 */
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


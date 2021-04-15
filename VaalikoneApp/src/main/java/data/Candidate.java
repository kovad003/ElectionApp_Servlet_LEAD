package data;

/**
 * The Candidate class houses attributes matching all columns of the
 * electionmachine.candidates table. Instances of the class function
 * in conjunction with the matching Dao class and it's CRUD methods.
 * Class only contains setters/getters.
 * 
 * @version 3.0
 * @author HAMK's Finest
 * Date: April 14, 2021
 */

public class Candidate {
	
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
	 * String + int based parameterized constructor for Candidate class matching 
	 * columns of electionmachine.caindidates table
	 * 
	 * @param id takes int arg of CANDIDATE_ID from/into electionmachine.caindidates
	 * @param sName takes String arg of SURNAME from/into electionmachine.caindidates
	 * @param fName takes String arg of FIRSTNAME from/into electionmachine.caindidates
	 * @param party takes String arg of PARTY from/into electionmachine.caindidates
	 * @param location takes String arg of LOCATION from/into electionmachine.caindidates
	 * @param age takes int arg of AGE from/into electionmachine.caindidates
	 * @param reason takes String arg of REASON_FOR_RUNNING from/into electionmachine.caindidates
	 * @param goals takes String arg of AIMS_AND_GOALS from/into electionmachine.caindidates
	 * @param profession takes String arg of PROFESSION from/into electionmachine.caindidates
	 * @param USERNAME takes String arg of USERNAME from/into electionmachine.caindidates
	 * @param PASSWORD takes String arg of PASSWORD from/into electionmachine.caindidates
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
	 * Default constructor for Candidate class. All attributes null.
	 */
	public Candidate() {
		System.out.println("Candidate() default constructor");		
	}
	
	
	/***************************************************
	 ***************   GETTERS / SETTERS   *************
	 ***************************************************/
	
	/**
	 * id attribute getter.
	 * @return int id
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * Setter for id attribute
	 * @param id takes int id as arg.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * Setter for id attribute.
	 * @param id takes String as arg.
	 * @throws NumberFormatException | NullPointerException
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	
	
	/**
	 * party attribute getter.
	 * @return String candidate's political party.
	 */
	public String getParty() {
		return party;
	}
	
	
	/**
	 * party attribute setter.
	 * @param candidate takes String party for candidate's political party.
	 */
	public void setParty(String party) {
		this.party = party;	
	}
	
	
	/**
	 * sName attribute getter. 
	 * @return String sName for candidate's surname.
	 */
	public String getSName() {
		return sName;
	}
	
	
	/**
	 * sName attribute setter.
	 * Property name in JSP (JSTL lib) is c.SName.
	 * @param sName takes String sName for candidate's surname.
	 */
	public void setSName(String sName) { 
		this.sName = sName;	
	}
	
	
	/**
	 * fName attribute getter.
	 * @return String fName for candidate's first name.
	 */
	public String getFName() {
		return fName;
	}
	
	
	/**
	 * fname attribute setter.
	 * Property name in JSP (JSTL lib) is c.FName.
	 * @param fName takes String fName for candidate's first name.
	 */
	public void setFName(String fName) { 
		this.fName = fName;	
	}
	
	
	/**
	 * location attribute getter.
	 * @return String location for candidate's operating location.
	 */
	public String getLocation() {
		return location;		
	}
	
	
	/**
	 * location attribute setter.
	 * @param location takes String location for candidate's operating location.
	 */
	public void setLocation(String location) {
		this.location = location;	
	}
	
	
	/**
	 * age attribute getter.
	 * @return int age for candidate's age.
	 */
	public int getAge() {
		return age;	
	}
	
	
	/**
	 * age attribute setter. Takes int and sets attribute in int.
	 * @param age takes int age for candidate's age.
	 */
	public void setAge(int age) {
		this.age = age;	
	}
	
	
	/**
	 * age attribute setter. Takes String and sets attribute in int.
	 * @param age takes String age for candidate's age.
	 * @throws NumberFormatException | NullPointerException
	 */
	public void setAge(String age) {
		try {
			this.age = Integer.parseInt(age);
		}
		catch(NumberFormatException | NullPointerException e) {
		}	
	}
	
	
	/**
	 * reason attribute getter.
	 * @return String reason for candidate's reason for running.
	 */
	public String getReason() {
		return reason;	
	}
	
	
	/**
	 * reason attribute setter.
	 * @param reason takes String reason for candidate's reason for running.
	 */
	public void setReason(String reason) {
		this.reason = reason;		
	}
	
	
	/**
	 * goals attribute getter.
	 * @return String goals for candidate's goals (political aspirations).
	 */
	public String getGoals() {
		return goals;
	}
	
	
	/**
	 * goals attribute setter.
	 * @param goals takes String goals for candidate's goals (political aspirations).
	 */
	public void setGoals(String goals) {
		this.goals = goals;
	}
	
	
	/**
	 * profession attribute getter.
	 * @return String profession for candidate's profession.
	 */
	public String getProfession() {
		return profession;
	}
	
	
	/**
	 * profession attribute setter.
	 * @param profession takes String profession for candidate's profession.
	 */
	public void setProfession(String profession) {
		this.profession = profession;		
	}
	
	
	/**
	 * USERNAME attribute getter.
	 * @return String USERNAME for candidate's username.
	 */
	public String getUSERNAME() {
		return USERNAME;		
	}
	
	
	/**
	 * USERNAME attribute setter.
	 * @param USERNAME takes String USERNAME for Candidate's username.
	 */
	public void setUSERNAME(String USERNAME) {
		this.USERNAME = USERNAME;		
	}
	
	
	/**
	 * PASSWORD attribute getter.
	 * @return String PASSWORD for Candidate's password.
	 */
	public String getPASSWORD() {
		return PASSWORD;		
	}
	
	
	/**
	 * PASSWORD attribute setter.
	 * @param PASSWORD takes String PASSWORD for Candidate's password.
	 */
	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;		
	}
}

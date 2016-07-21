/**
The Educational Class
A child class for the Software.java class. It holds all of the fields and methods from 
Software and additionally holds the subject matter and skill level for education.

@author Grace D'Amico
*/
public class Educational extends Software {
	private String subject;
	private String level;
	
	/**
	No-args constructor
	*/
	public Educational() {
		super();
		subject = "";
		level = "";
	}
	
	/**
	Initialize the fields
	@param n Name of the software
	@param p Price of the software
	@param q Quantity of the software in stock
	@param c Company producing the software
	@param s Subject being taught
	@param l Level of education
	*/
	public Educational(String n, double p, int q, SoftwareHouse c, String s, String l) {
		super(n, p, q, c);
		subject = s;
		level = l;
	}
	
	/**
	Copy Constructor
	@param e The object to copy
	*/
	public Educational(Educational e) {
		super(e);
		subject = e.subject;
		level = e.level;
	}
	
	/**
	Mutator method to set the subject
	@param s Subject being taught
	*/
	public void setSubject(String s) {
		if (subject.equals("Health") || subject.equals("Literature") || 
		subject.equals("Math") || subject.equals("Science") || subject.equals(
		"Social Studies")) {
			subject = s;
		}
		else {
			throw new IllegalArgumentException("Subject is not valid.");
		}
	}
	
	/**
	Accessor method for the subject
	@return subject Subject being taught
	*/
	public String getSubject() {
		return subject;
	}
	
	/**
	Mutator method for level of education
	@param l Level of education 
	*/
	public void setLevel(String l) {
		if (level.equals("Kindergarden") || level.equals("Elementary") || 
		level.equals("Middle School") || level.equals("High School") || 
		level.equals("College")) {
			level = l;
		}
		else {
			throw new IllegalArgumentException("Education level is not valid.");
		}
	}
	
	/* 
	Accessor method for the level of education
	@return level Level of education
	*/
	public String getLevel() {
		return level;
	}

}
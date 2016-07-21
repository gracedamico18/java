/**
The Business Class
A child class for the Software.java class. It holds all of the fields and methods from 
Software and additionally holds the kind of software required for business.

@author Grace D'Amico
*/
public class Business extends Software {
	private String softwareType;
	
	/**
	* No-args construtor
	*/
	public Business() {
		super();
		softwareType = "";
	}
	
	/**
	* Initialize the fields
	* @param n The name of the software
	* @param p The price of the software
	* @param q The quantity of software in stock
	* @param c The company developing the software
	* @param sT The software type
	*/
	public Business(String n, double p, int q, SoftwareHouse c, String sT) {
		super(n, p, q, c);
		softwareType = sT;
	}
	
	/**
	* Copy construtor
	* @param b The business object to copy
	*/
	public Business(Business b) {
		super(b);
		softwareType = b.softwareType;
	}
	
	/**
	* Mutator method for the software type
	* @param sT The software type
	*/
	public void setSoftwareType(String sT) {
		softwareType = sT;
	}
	
	/**
	* Accessor method for the software type
	* @return softwareType The type of software.
	*/
	public String getSoftwareType() {
		return softwareType;
	}	
		
}
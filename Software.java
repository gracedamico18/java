/**
 * The Software class.
 * This stores all of the information relevant for representing general software.
 * 
 * @author Michael Lipschultz
 */
public class Software
{
    private String name;
    private double price;
    private int quantity;
    private SoftwareHouse company;
    
    /**
     * No-args constructor
     */
    public Software()
    {
        name = ""; //setName("");
        price = 0; //setPrice(0);
        quantity = 0; //setQuantity(0);
        company = new SoftwareHouse(); //setSoftwareHouse(new SoftwareHouse());
    }
    
    /**
     * Initialize the fields
     * @param name Software name
     * @param price Price of software (must be positive)
     * @param quantity Amount of product in stock (must be positive)
     * @param company The software house that produces the software
     */
    public Software(String name, double price, int quantity, SoftwareHouse company)
    {
        setName(name);			
        setPrice(price);
        setQuantity(quantity);
        setSoftwareHouse(company);
    }
    
    /**
     * The copy constructor
     * @param software The object to copy.
     */
    public Software(Software software)
    {
    	setName(software.getName());		
    	setPrice(software.getPrice());
    	setQuantity(software.getQuantity());
    	setSoftwareHouse(software.getSoftwareHouse());
    }
    
    /**
     * Mutator method for the software's name.
     * @param name Name of the software
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Mutator method for the software's price.
     * @param price Price of the software
     */
    public void setPrice(double price)
    {	//should be void not boolean
        if (price < 0) {
        	throw new IllegalArgumentException("Price must be positive.");
        }
        this.price = price;
    }
    
    /**
     * Mutator method for the software's quantity.
     * @param quantity Quantity of the software
     */
    public void setQuantity(int quantity)
    {	//should be void not boolean
        if (quantity < 0) {
        	throw new IllegalArgumentException("Quantity must be positive."); 
        }
        this.quantity = quantity;
    }
    
    /**
     * Mutator method for the company producing the software.
     * @param company Company producing the software
     */
    public void setSoftwareHouse(SoftwareHouse c)
    {	//change param to c for clarity
        company = new SoftwareHouse(c);
    }
    
    /**
     * Accessor method for the software's name.
     * @return The name of the software.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Accessor method for the software's price.
     * @return The price of the software.
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * Accessor method for the software's quantity.
     * @return Amount of the software in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * Accessor method for the company producing the software.
     * @return The company producing the software.
     */
    public SoftwareHouse getSoftwareHouse()
    {	//Company should be SoftwareHouse because thats what we are returning
        return new SoftwareHouse(company);
    }
    
    /**
     * The equals method.
     * @param software A software object to compare against
     * @return Returns true if they are equal and false if they are not.
     */
    public boolean equals(Software software)
    {
        if(name.equalsIgnoreCase(software.name))
            return true;
        else
            return false;
    }
    
    /**
     * toString method.
     * @return A string containing the Software's information
     */
    public String toString()
    {
        String str;
        String stringPrice = Double.toString(price);
        String stringQuantity = Integer.toString(quantity);
        str = "Name: "+name+
                "\nPrice: $"+stringPrice+
                "\nQuantity: "+stringQuantity+"\n"+company.toString();
                //take out "\nCompany: \n" because this already prints
        		
        return str;
    }
}
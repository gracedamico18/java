/**
Lab 8
@author Grace D'Amico

The class Crop sets, gets, compares, and prints the name of the crop, the amount of crop 
that has grown (yield), and the price of how much one kilogram of the crop is selling for.
This class is executed through the CropDriver.java program.
*/
public class Crop {
	//Crop corn = new Crop("Corn", 5000, 0.25);
	//fields
	private String name;
	private int yield;
	private double price;
	
	/**
	Initializer construtor that assigns values to each field (name, yield, and price)
	@param name Name of the crop
	@param yield How much of the crop has grown
	@param price How much one kilogram is selling for
	*/
	public Crop(String name, int yield, double price) {
		setName(name);
		setYield(yield);
		setPrice(price);
	}
	
	/**
	Copy constructor that makes a duplicate of a crop object.
	@param crop The crop that will be duplicated.
	*/
	public Crop(Crop crop) {
		name = crop.getName();
		yield = crop.getYield();
		price = crop.getPrice();
	}
	
	/**
	No-args constructor that initializes the name, yield, and price to default values.
	*/
	public Crop() {
		name = "";
		yield = 0;
		price = 0;
	}
	
	/**
	Assigns the field name to the String n.
	@param n The new name string.
	*/
	public void setName(String n) {
		name = n;
	}
	
	/**
	Assigns the field yield to the variable y and validates y.
	@param y The new yield variable.
	*/
	public void setYield(int y) {
		if (y <= 0) {
			IllegalArgumentException iae = new IllegalArgumentException(
			"Yield must be positive.");
			throw iae;
		}
		yield = y;
	}
	
	/**
	Assigns the field price to the variable p and validates p.
	@param p The new price variable.
	*/
	public void setPrice(double p) {
		if (p <= 0) {
			IllegalArgumentException iae = new IllegalArgumentException(
			"Price must be positive.");
			throw iae;
		}
		price = p;
	}
	
	/**
	Gets the name of the crop.
	@return name of the crop
	*/
	public String getName() {
		return name;
	}
	
	/**
	Gets the yield amount of the crop.
	@return yield value
	*/
	public int getYield() {
		return yield;
	}
	
	/**
	Gets price per kilogram of the crop
	@return price of the crop
	*/
	public double getPrice() {
		return price;
	}
	
	/**
	Compares two crop objects for equal names.
	@param crop Crop object being compared
	@return true if the names of the crops are the same
	*/
	public boolean equals(Crop crop) {
		if (name.equalsIgnoreCase(crop.getName())) 
			return true;
		else 
			return false;
	}
	
	/**
	Compares String name of a crop to an object's name of a crop.
	@param cropName String stating the name of the crop
	@return true if the names of the crops are the same
	*/
	public boolean equals(String cropName) {
		if (name.equalsIgnoreCase(cropName))
			return true;
		else 
			return false;
	}
	
	/**
	States the name, yield, and price of a crop.
	@return String Labels name, yield, and price of a specific crop.
	*/
	public String toString(){
		return "Crop: name = "+name+", yield = "+yield+", price = $"+price;
	}
	
}
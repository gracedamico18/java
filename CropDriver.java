/**
Lab 8
@author Grace D'Amico

This program executes the Crop.java class. Three objects are created
containing the name, yield amount, and price per kilogram of a crop.
The values stored in these objects are printed to the user through the toString() 
method in the Crop.java class. The objects are then compared using equals
and printed to the user if the crops are equal.
*/
public class CropDriver {
	public static void main (String [] args) {
	
	Crop corn = new Crop("Corn", 5000, 0.25);
	System.out.println(corn.toString());
	
	Crop wheat = new Crop("Wheat", 8000, 0.003);
	System.out.println(wheat.toString());
	
	Crop corn1 = new Crop("Corn", 5500, 0.25);
	System.out.println(corn1.toString());
			
	if (corn.equals(wheat)) 
		System.out.println("The first and second crops are equal.");
	
	if (corn.equals(corn1)) 
		System.out.println("The first and third crops are equal.");
		
	}
}
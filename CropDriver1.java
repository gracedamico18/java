public class CropDriver1 {
	public static void main (String [] args) {
	
	Crop corn = new Crop("Green Beans", 5500, 0.55);
	System.out.println(corn.toString());
	
	Crop wheat = new Crop("Tomatos", 3000, 0.003);
	System.out.println(wheat.toString());
	
	Crop corn1 = new Crop("Corn", 100, 0.11);
	System.out.println(corn1.toString());
			
	if (corn.equals(wheat)) 
		System.out.println("The first and second crops are equal.");
	
	if (corn.equals(corn1)) 
		System.out.println("The first and third crops are equal.");
		
	}
}
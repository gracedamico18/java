public class Methods {
//order of methods does not matter. main method could be at the end of code
	
	public static void main (String[] args) {
		System.out.println("Before method call.");
		displayMessage("Grace");							
			//calling method to execute
			//in () would be parameter list that needs to pass through to method to 
			//execute properly
		System.out.println("After method call.");
	}
	
	public static void displayMessage(String name) {		
		//void = does not return a value
		System.out.println("Hello, " + name);
	}
}
public class SoftwareDriver {
	public static void main (String [] args) {
	
	SoftwareHouse sh1 = new SoftwareHouse("Google", "123 Main St", "Los Angeles", "California", "12345");
	Software soft = new Software("Microsoft Word", 200.50, 2, sh1);
	
	System.out.println(soft.toString());
	
	
	}

}
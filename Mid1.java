/**
Grace D'Amico 
Test Version A
Right Circular Cone

*/
import java.util.Scanner;
import java.util.InputMismatchException;

public class Midterm1 {
	public static void main (String [] args) {
	
	double radius = 0;
	double height = 0;
	boolean invalid;
	
	Scanner kb = new Scanner(System.in);
	System.out.print("Enter the radius: ");
	
	do {
		try {
			radius = kb.nextDouble();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter a number! ");
			kb.next();
			invalid = true;
		}
		while (radius <= 0) {
			System.out.print("Please enter a positive radius value: ");
			radius = kb.nextDouble();
		}
	}while(invalid);
	
	do {
		try {
			height = kb.nextDouble();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter a number! ");
			kb.next();
			invalid = true;
		}
		while (height <= 0) {
			System.out.print("Please enter a positive height value: ");
			height = kb.nextDouble();
		}
	}while(invalid);
		
	double volume = pi*(radius)^2*(height/3);
	System.out.println("The volume of the right circular cone is "+volume+".");
	
	
	
	
	}
}
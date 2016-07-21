/**
Grace D'Amico
Midterm Version A
Digital Root

*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Midterm2 {
	public static void main (String [] args) {
	
	Scanner keyboard = new Scanner(System.in);
	
	boolean invalid;
	int input = 0;
	int sumOfDigits = 0;
	
	System.out.print("Enter a number: ");
	do {
		try {
			input = keyboard.nextInt();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter an integer! ");
			keyboard.next();
			invalid = true;
		}
	}while (invalid);
	
	while (input <= 0) {
		System.out.print("Please enter a positive number: ");
		input = keyboard.nextInt();
	}
	
	while (input > 9) {
		
		
	}
	
	System.out.println("The digital root of "+input+" is "+root+".");
	
	}
}

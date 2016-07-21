/**
Grace D'Amico 
Test Version A
Right Circular Cone

This program calculates the volume of a right circular cone. Volume = pi*radius^2*(height/3).
The program prompts the user for radius and height values. If the user enters a non-numeric
value, the program will prompt the user to enter a number. If the user enters a negative number,
the program will ask the user for a positive number. The program will continue to ask for 
valid inputs until valid inputs are received. With valid inputs given, the program will 
output the calculated volume of the right circular cone rounded to 4 decimal places.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.text.DecimalFormat;

public class Midterm1 {
	public static void main (String [] args) {
	Scanner keyboard = new Scanner(System.in);
	DecimalFormat fmt4Dec = new DecimalFormat("0.0000");

	boolean invalid;
	double radius = 0;
	double height = 0;
	
	//validates radius input
	System.out.print("Enter the radius: ");	
	do {
		try {
			radius = keyboard.nextDouble();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter a number! ");
			keyboard.next();
			invalid = true;
		}
	}while (invalid);
	
	while (radius <= 0)	{
		System.out.print("Please enter a positive radius value: ");
		radius = keyboard.nextDouble();
	}
	
	//validates height input
	System.out.print("Enter the height: ");	
	do {
		try {
			height = keyboard.nextDouble();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter a number! ");
			keyboard.next();
			invalid = true;
		}
		
	}while (invalid);
	
	while (height <= 0)	{
		System.out.print("Please enter a positive height value: ");
		height = keyboard.nextDouble();
	}	
	
	//calculates the volume
	double volume = Math.PI*Math.pow(radius, 2)*(height/3);
	System.out.println("The volume of the right circular cone is "+fmt4Dec.format(volume)+".");
	
	}
}
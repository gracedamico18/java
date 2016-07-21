/**
Package A: For $9.95 per month, 10 hours of access provided. Additional hours are 
$2.00 per hour.
Package B: For $13.95 per month, 20 hours of access are provided. Additional hours are 
$1.00 per hour.
Package C: For $19.95 per month, access is unlimited.

The program prompts the user to enter the package they have subscribed to and how many 
hours of internet they used in one month. Then the program will calculate the monthly 
bill based off of their package subscription and hours of internet use. The program will 
then output the total monthly charge in the form of a dollar amount.

If the user inputs any invalid data, the program will ask for a new input.
*/

import java.util.Scanner;
import java.text.NumberFormat;

public  class Lab3
{
	public static void main (String[] args)
	{
	Scanner keyboard = new Scanner(System.in);
	NumberFormat fmtCurr = NumberFormat.getCurrencyInstance();
	
	//Initialize letter strings 
	String letterA = "a";
	String letterB = "b";
	String letterC = "c";
	
	//Gets package input from user
	System.out.print("What package have you subscribed to? ");
	String letter = keyboard.nextLine();
	
	//validates package input 
	while (!(letter.equalsIgnoreCase(letterA) || letter.equalsIgnoreCase(letterB) || letter.equalsIgnoreCase(letterC)))
		{
		System.out.print("Please enter a valid package letter: ");
		letter = keyboard.nextLine();
		}
	
	//Gets hour input from user
	System.out.print("How many hours did you use? ");
	double hours = keyboard.nextDouble();
	
	//validates hour input
		while (hours < 0)
			{
			System.out.print("Please enter a positive number of hours: ");
			hours = keyboard.nextDouble();
			}
	
	//calculates monthly bill based on package letter
	double charge = 0;
	if (letter.equalsIgnoreCase("a"))
		{
		if (hours > 10)
			charge = 9.95 + 2 * (hours - 10);
		else
			charge = 9.95;
		}
	if (letter.equalsIgnoreCase("b"))
		{
		if (hours > 20)
			charge = 13.95 + (hours - 20);
		else
			charge = 13.95;
		}
	if (letter.equalsIgnoreCase("c"))
		charge = 19.95;
	
	//outputs monthly bill amount
	System.out.println("Your total charge is " + fmtCurr.format(charge) + ".");
	
	}
	
}
/**
Package A: For $9.95 per month, 10 hours of access provided. Additional hours are 
$2.00 per hour.
Package B: For $13.95 per month, 20 hours of access are provided. Additional hours are 
$1.00 per hour.
Package C: For $19.95 per month, access is unlimited.

The program prompts the user to enter the package they have subscribed to and how many 
hours of internet they used in one month. Then the program will calculate the monthly 
bill based off of their package subscription and hours of internet use. The program will 
then output the total monthly charge in the form of a dollar amount. The package letter,
hours used, and monthly charge will be saved in either a file that the user creates or
a file that has already been created. 

If the user inputs any invalid data, the program will ask for a new input.
*/

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.text.DecimalFormat;
import java.lang.NullPointerException;
import java.util.NoSuchElementException;
import java.io.*;

public  class Lab5
{
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		NumberFormat fmtCurr = NumberFormat.getCurrencyInstance();
		DecimalFormat fmt2Dec = new DecimalFormat("0.00");
		
		boolean invalid;
		double averageHours = 0;
		double averagePaid = 0;
		double totalPaid = 0;	
		double charge = 0;
		double hours = 0;
		double totalHours = 0;
		double hoursPrinted = 0;
		double chargePrinted = 0;
		int numOfHourInputs = 0;
		int numOfCharges = 0;
		
		System.out.print("Data file of prior internet usage: ");
		String dataFile = keyboard.nextLine();

		File inFile = new File(dataFile);
		Scanner openFile = null; 
		FileWriter writeFile = null; 	
		PrintWriter outputFile = null;	

		//exception handling
		try {
			openFile = new Scanner(inFile);
			invalid = false; }
		catch (FileNotFoundException fnfe) {
			System.out.print("No such file exists; creating it.\n");
			invalid = true; }
		catch (NullPointerException npe) {
			invalid = true; }
		
		try {
			writeFile = new FileWriter(dataFile, true);
			invalid = false; }
		catch (IOException ioe) {
			invalid = true; }
	
		try {
			outputFile = new PrintWriter(writeFile);
			invalid = false; }
		catch (NullPointerException npe) {
			invalid = true; }
			
		if(openFile != null) {
			
			try {
				while (openFile.hasNext()) {
					String token = openFile.next();
					if (openFile.hasNextDouble()) {
						totalHours += openFile.nextDouble();
						numOfHourInputs++;
					}
					if (openFile.hasNextDouble()) {
						totalPaid += openFile.nextDouble();
						numOfCharges++;
					}
				}
			}
			finally {
				openFile.close();
			}
			
			averageHours = (totalHours/numOfHourInputs);
			averagePaid = (totalPaid/numOfCharges);
				
			System.out.println("Usage history: ");
			System.out.println("  Average Hours Used: " + fmt2Dec.format(averageHours));
			System.out.println("  Average Paid: " + fmtCurr.format(averagePaid));
			System.out.println("  Total Paid: " + fmtCurr.format(totalPaid));
		} //end of if(inFile.exists())
		
		//Initialize letter strings 
		String letterA = "a";
		String letterB = "b";
		String letterC = "c";

		//Gets package input from user
		System.out.print("\nWhat package have you subscribed to? ");
		String letter = keyboard.nextLine();

		//validates package input 
		while (!(letter.equalsIgnoreCase(letterA) || letter.equalsIgnoreCase(letterB) || letter.equalsIgnoreCase(letterC)))	{
			System.out.print("Please enter a valid package letter: ");
			letter = keyboard.nextLine();
		}

		//receives and validates hour input
		do {
			System.out.print("How many hours did you use? ");
			try {
				hours = keyboard.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				keyboard.next();
				invalid = true;
			}
			while (hours < 0)	{
				System.out.print("Please enter a positive number of hours: ");
				hours = keyboard.nextDouble();
			}
		}while (invalid);
		
		//calculates monthly bill based on package letter
		if (letter.equalsIgnoreCase("a")) {
			if (hours > 10)
				charge = 9.95 + 2 * (hours - 10);
			else
				charge = 9.95;
		}
		if (letter.equalsIgnoreCase("b")) {
			if (hours > 20)
				charge = 13.95 + (hours - 20);
			else
				charge = 13.95;
		}
		if (letter.equalsIgnoreCase("c"))
			charge = 19.95;
		
		outputFile.println(letter + "  " + hours + "  " + charge);
		
		//outputs monthly bill amount
		System.out.println("Your total charge is " + fmtCurr.format(charge) + ".");
		
		outputFile.close();	
		
	} //end of main method
}
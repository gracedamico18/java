/**
Determine whether a one-way street in New York City is eastbound or westbound. 
Even-numbered streets are eastbound and odd-numbered streets are westbound. This program 
asks the user for an integer (between 1 and 155) and displays whether the street is 
eastbound or westbound.
*/

import java.util.Scanner;

public class Lab4_2 {
    public static void main(String[] args) {
       Scanner kb = new Scanner(System.in);
       int moreDirections = 0;
	do
	{
        //get street number
        System.out.print("Please enter the number for a one-way street in NYC: ");
        int street = kb.nextInt();
        while (street < 1 || street > 155) {
            //invalid, street must be between 1 and 155
            System.out.println("The street number must be between 1 and 155.");
            System.out.print("Please enter the number for a one-way street in NYC: ");
            street = kb.nextInt();
        }
        
        //is street number even or odd?
        if (street % 2 == 0) {
            System.out.println("It is eastbound.");
        }
        else {
            System.out.println("It is westbound.");}
		
		System.out.print("To get another direction of a street, please press 1. ");
		System.out.print("If finished, enter any other key: ");
		moreDirections = kb.nextInt();
	}while (moreDirections == 1);
		
		if (moreDirections != 1)
			System.exit(0);
    }
}
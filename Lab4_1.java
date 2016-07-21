/**
This program asks the user to input the number of times he or she would like to flip a 
coin. The program generates a random number (either 0 or 1) and if that number is a 0, 
then the result of the coin flip is heads. The number of heads is added up and displayed
to the user as output.
*/

import java.util.Random;
import java.util.Scanner;

public class Lab4_1
{
	public static void main (String [] args) 
	{
		Random flip = new Random();
		Scanner keyboard = new Scanner(System.in);
		int result = 0;
		int heads = 0;
		
		//enter coin flips
		System.out.print("How many times should I flip a coin? ");
		int coinFlips = keyboard.nextInt();
			while (coinFlips <= 0)
			{	System.out.print("Please enter a positive number of coin flips: ");
				coinFlips = keyboard.nextInt();
			}
		
		//evaluate heads or tails
		for (int i = 0; i < coinFlips; i++)
		{	
			result = flip.nextInt(2);
			if(result == 0)
			{	heads++;
			}
		}
	System.out.println("Done. Heads showed up " + heads + " times.");	
	}
}
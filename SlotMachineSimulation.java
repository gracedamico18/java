/* Grace D'Amico
CS 0007
Assignment 4 */

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class SlotMachineSimulation
{
	public static void main (String[] args) throws IOException
	{
	
		//welcome message
		System.out.println("Welcome to the Slot Machine Simulator!\n");
		System.out.println("Actions: ");
		System.out.println("1. Start a new game");
		System.out.println("2. View scores");
		System.out.println("3. Exit");
		
		Scanner keyboard = new Scanner(System.in);
		
		int action;
		System.out.print("Please select an action: ");
		action = keyboard.nextInt();
		
		//if user enters a number other than 1, 2, or 3
		if (action < 1 || action > 3)
			do
			{
				System.out.print("\nInvalid input. Please select an action: ");
				action = keyboard.nextInt();
			} while (action < 1 || action > 3);
		
		double currentMoney = 100.00;
		double currentBet = 0;
		String name = "";
		
		//simulation for the slot machine
		if (action == 1) 
		{
			//welcome header
			Scanner keyb = new Scanner (System.in);
			System.out.print("Before the game begins, please enter your name: ");
			name = keyb.nextLine();
			System.out.print("\nGame start! You will begin with $100.00. ");
			System.out.print("Enter a negative value to quit the game. Good luck, " + name + "!\n");
		do 
		{	//start of loop for simulation
			System.out.printf("You currently have: $%.2f\n", currentMoney);
			System.out.print("How much would you like to bet? ");
			currentBet = keyboard.nextDouble();
		
			//if user enters a number greater than current total
			if (currentBet > currentMoney)
				do
				{
					System.out.print("Your bet is greater than your current total. Please enter a valid amount. ");
					currentBet = keyboard.nextDouble();
				} while (currentBet > currentMoney);
		
			//saving game in scores.txt file
			if (currentBet < 0)
			{
				FileWriter fwriter = new FileWriter("scores.txt", true);
				PrintWriter outputFile = new PrintWriter(fwriter);
				outputFile.printf(name + "             " + "$%.2f", currentMoney, "\n");
				outputFile.println(" ");
				outputFile.close();
				System.out.println("Game over! Your score has been written to scores.txt, " + name + "!");
				return;
			}
		
			//random simulation
			System.out.println("--------------------------");
			int fruitNumber = -1;
			int fruitNumber2 = -1;
			int fruitNumber3 = -1;
		
				Random fruit = new Random();
				fruitNumber = fruit.nextInt(6);
				String spin1 = " ";
				String spin2 = " ";
				String spin3 = " ";
			
				if (fruitNumber == 0)
					spin1 = "Cherries  ";
				if (fruitNumber == 1)
					spin1 = "Oranges  ";
				if (fruitNumber == 2)
					spin1 = "Plums  ";
				if (fruitNumber == 3)
					spin1 = "Bells  ";
				if (fruitNumber == 4)
					spin1 = "Melons  ";
				if (fruitNumber == 5)
					spin1 = "Bars  ";
			
				Random fruit2 = new Random();
				fruitNumber2 = fruit2.nextInt(6);
				
				if (fruitNumber2 == 0)
					spin2 = "Cherries  ";
				if (fruitNumber2 == 1)
					spin2 = "Oranges  ";
				if (fruitNumber2 == 2)
					spin2 = "Plums  ";
				if (fruitNumber2 == 3)
					spin2 = "Bells  ";
				if (fruitNumber2 == 4)
					spin2 = "Melons  ";
				if (fruitNumber2 == 5)
					spin2 = "Bars  ";
			
				Random fruit3 = new Random();
				fruitNumber3 = fruit3.nextInt(6);
				
				if (fruitNumber3 == 0)
					spin3 = "Cherries  ";
				if (fruitNumber3 == 1)
					spin3 = "Oranges  ";
				if (fruitNumber3 == 2)
					spin3 = "Plums  ";
				if (fruitNumber3 == 3)
					spin3 = "Bells  ";
				if (fruitNumber3 == 4)
					spin3 = "Melons  ";
				if (fruitNumber3 == 5)
					spin3 = "Bars  ";
				
				System.out.print(spin1);
				System.out.print(spin2);
				System.out.print(spin3);
		
			System.out.println("\n--------------------------");
		
			//computing matches and rewards then evaluating current money
			int matches = 0;
			double reward = 0.0;
		
			if (spin1 == spin2 || spin2 == spin3 || spin3 == spin1)
				{
					matches = 1;
					reward = 2 * currentBet;
					currentMoney += reward;
				}
			if (spin1 == spin2 && spin2 == spin3 && spin3 == spin1)
				{
					matches = 2;
					reward = 3 * currentBet;
					currentMoney += reward;
				}
			if (spin1 != spin2 && spin2 != spin3 && spin3 != spin1)
				{
					matches = 0;
					reward = 0.0;
					currentMoney -= currentBet;
				}
			
			System.out.print("Number of matches: " + matches);
			System.out.printf(". You win: $%.2f\n", reward);
		
			if (currentMoney <= 0)
				System.out.println("Game over!");
		
		} while (currentMoney > 0);	
		
		} //action 1 end
			
		if (action == 2)
		{	
			//if file does not exist
			File file = new File ("scores.txt");
			if (!file.exists())
				{
				System.out.println("There are no scores to display at this time!");
				System.exit(-1);
				}
		
			System.out.println("Name              Score");
			System.out.println("----              -----");
			Scanner inputFile = new Scanner(file);
	
		//reading file
		while (inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			System.out.println(line);
		}
			inputFile.close();
		}
		
		//action 3 - ending game
		if (action == 3)
		{
			System.out.println("Goodbye!");
			return;
		}
		
	} //end of main method
}
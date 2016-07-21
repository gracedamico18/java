/**
This program tracks a company's inventory. The products the company buys and 
sells, the quantity of each, and their prices are stored in a file. The 
program asks the user for the input filename and loads that file. The user
is presented with a menu containing each product, their quantity and price,
and an option to exit the program. The user then can select one of the 
products, and the program will present to them another menu which gives 
them the option to sell, buy, or change the price of the product they 
selected. If the user wants to sell more product than is in stock or spend
more money than the company has, they will be warned and asked if they still
want to proceed. The current balance, quantity, and price of a product will
be displayed to the user when selling, buying, or changing the price of that
product. The final balance, quantity, and price of each product will be 
saved in the file created at the beginning of the program.
*/

import java.util.*;
import java.text.DecimalFormat;
import java.io.*;

public class PP1
{
	public static void main (String[]args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		DecimalFormat fmt2Dec = new DecimalFormat("$0.00");
		
		boolean invalid;
		int choice = -1;
		double currentBalance = 3000.00;
		int currentQuantityLamp = 400;
		double currentPriceLamp = 15.30;
		int currentQuantityChair = 250;
		double currentPriceChair = 19.95;
		int currentQuantityDesk = 300;
		double currentPriceDesk = 95.00;
		
		int lampsToSell = 0;
		int lampsToBuy = 0;
		double pricePerLamp = 0;
		double newLampPrice = 0;
		
		int chairsToSell = 0;
		int chairsToBuy = 0;
		double pricePerChair = 0;
		double newChairPrice = 0;
		
		int desksToSell = 0;
		int desksToBuy = 0;
		double pricePerDesk = 0;
		double newDeskPrice = 0;
		
		System.out.print("Please enter input filename: ");
		String fileName = keyboard.nextLine();
			
		PrintWriter inventoryNew = new PrintWriter(fileName);
		do
		{	
			//main menu
			System.out.println("Current balance: " + fmt2Dec.format(currentBalance));
			System.out.println("1. Lamps	(" +currentQuantityLamp+ " at "+fmt2Dec.format(currentPriceLamp)+")");
			System.out.println("2. Chairs	(" +currentQuantityChair+ " at "+fmt2Dec.format(currentPriceChair)+")");
			System.out.println("3. Desks	(" +currentQuantityDesk+ " at "+fmt2Dec.format(currentPriceDesk)+")");
			System.out.println("0. Exit");
			
			//invalid choice
			do {
			try {
				System.out.print("Please enter choice: ");
				choice = keyboard.nextInt();
				invalid = false; }
			catch (InputMismatchException ime) {
				System.out.print("Must be an integer! ");
				keyboard.next();
				invalid = true; }
			} while (invalid);
			
			while (choice < 0 || choice > 3) {
				System.out.print("Must enter a number 0 - 3! ");
				choice = keyboard.nextInt(); } 
			
			if (choice == 0) {
			//save data in inventory.dat
				inventoryNew.println("\n" + currentBalance);
				inventoryNew.println("Lamps " + currentPriceLamp + " " + currentQuantityLamp);
				inventoryNew.println("Chairs " + currentPriceChair + " " + currentQuantityChair);
				inventoryNew.println("Desks " + currentPriceDesk + " " + currentQuantityDesk);
				inventoryNew.close();
				System.exit(0);
			}
			
		//LAMPS	
		if (choice == 1)
		{ 
			while (choice != 0)
			{	System.out.println("-----------------------------------");
				System.out.println("Current balance: " + fmt2Dec.format(currentBalance));
				System.out.println("Current quantity: " + currentQuantityLamp);
				System.out.println("Current price: " + fmt2Dec.format(currentPriceLamp));
				System.out.println("1. Sell Lamps");
				System.out.println("2. Buy Lamps");
				System.out.println("3. Change price");
				System.out.println("0. Return to main menu");
				
			//invalid choice
			do {
			try {
				System.out.print("Please enter choice: ");
				choice = keyboard.nextInt();
				invalid = false; }
			catch (InputMismatchException ime) {
				System.out.print("Must be an integer! ");
				keyboard.next();
				invalid = true; }
			while (choice < 0 || choice > 3) {
				System.out.print("Must enter a number 0 - 3! ");
				choice = keyboard.nextInt(); } 
			} while (invalid);
			
				if (choice == 1)
				{	//sell lamps
					do {
						try {
							System.out.print("\nAmount to sell (current quantity: " + currentQuantityLamp
							+ "): ");
							lampsToSell = keyboard.nextInt();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be an integer! ");
							keyboard.next();
							invalid = true; }
						while (lampsToSell < 0) {
							System.out.print("Please enter a positive number of lamps to sell: ");
							lampsToSell = keyboard.nextInt();	}
					} while (invalid);
						
					
					if (currentQuantityLamp < lampsToSell)
					{	Scanner keyBoard = new Scanner(System.in);
						System.out.print("Warning: Selling more than is in stock!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						String proceedOn = keyBoard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceedOn)))
							System.exit(0);
					}	
					currentBalance = currentBalance + (lampsToSell * currentPriceLamp);
					currentQuantityLamp = currentQuantityLamp - lampsToSell;
				} //end sell lamps
				
		
				if (choice == 2)
				{	//buy lamps
					do {
					System.out.print("\nAmount to buy: ");
					try {
						lampsToBuy = keyboard.nextInt();
						invalid = false; }
					catch (InputMismatchException ime) {
						System.out.print("Must be an integer! ");
						keyboard.next();
						invalid = true; }
					while (lampsToBuy < 0)
					{	System.out.print("Please enter a positive number of lamps to buy: ");
						lampsToBuy = keyboard.nextInt();
						}
					} while (invalid);
					
					do {
						System.out.print("Price per item: ");
					try {
						pricePerLamp = keyboard.nextDouble();
						invalid = false; }
					catch (InputMismatchException ime) {
						System.out.print("Must be an integer! ");
						keyboard.next();
						invalid = true; }
					while (pricePerLamp < 0)
					{	System.out.print("Please enter a positive price: ");
						pricePerLamp = keyboard.nextDouble();
						}
					} while (invalid);
					
					if (pricePerLamp*lampsToBuy > currentBalance)
					{	Scanner keyBoard = new Scanner(System.in);
						System.out.print("Warning: Spending more money than the company has!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						String proceedOn = keyBoard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceedOn)))
							System.exit(0);
					}
					
					currentBalance = currentBalance - (lampsToBuy * pricePerLamp);
					currentQuantityLamp = currentQuantityLamp + lampsToBuy;
					} //end buy lamps
		
				if (choice == 3)
				{	//change price of lamps	
					do {
					try {
						System.out.print("\nNew price: ");
						newLampPrice = keyboard.nextDouble();
						invalid = false; }
					catch (InputMismatchException ime) {
						System.out.print("Must be a number! ");
						keyboard.next();
						invalid = true; }
					while (newLampPrice < 0)
							{	System.out.print("Please enter a positive price: ");
							newLampPrice = keyboard.nextDouble(); }
					} while (invalid);
					currentPriceLamp = newLampPrice;
					
					} //end price change
			}
		} //END LAMPS
		
		//CHAIRS
	if (choice == 2)
	{				
		while (choice != 0)
		{	System.out.println("-----------------------------------");
			System.out.println("Current balance: " + fmt2Dec.format(currentBalance));
			System.out.println("Current quantity: " + currentQuantityChair);
			System.out.println("Current price: " + fmt2Dec.format(currentPriceChair));
			System.out.println("1. Sell Chairs");
			System.out.println("2. Buy Chairs");
			System.out.println("3. Change price");
			System.out.println("0. Return to main menu");
				
				//invalid choice
			do {
			try {
				System.out.print("Please enter choice: ");
				choice = keyboard.nextInt();
				invalid = false; }
			catch (InputMismatchException ime) {
				System.out.print("Must be an integer! ");
				keyboard.next();
				invalid = true; }
			while (choice < 0 || choice > 3) {
				System.out.print("Must enter a number 0 - 3! ");
				choice = keyboard.nextInt(); } 
			} while (invalid);
			
				if (choice == 1)
				{	//sell chairs
					do {
						System.out.print("Amount to sell (current quantity: " + currentQuantityChair
						+ "): ");
						try{
							chairsToSell = keyboard.nextInt();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be a number! ");
							keyboard.next();
							invalid = true; }
						while (chairsToSell < 0)
							{	System.out.print("Please enter a positive number of chairs to sell: ");
							chairsToSell = keyboard.nextInt(); }
					}while (invalid);
					
					if (currentQuantityChair < chairsToSell)
					{	Scanner keyBoard = new Scanner(System.in);
						System.out.print("Warning: Selling more than is in stock!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						String proceedOn = keyBoard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceedOn)))
							System.exit(0);
					}
					currentBalance = currentBalance + (chairsToSell * currentPriceChair);
					currentQuantityChair = currentQuantityChair - chairsToSell;
	
				} //end sell chairs
		
				if (choice == 2)
				{	//buy chairs
					do {
						System.out.print("\nAmount to buy: ");
						try{
							chairsToBuy = keyboard.nextInt();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be a number! ");
							keyboard.next();
							invalid = true; }
						while (chairsToBuy < 0)
							{ System.out.print("Please enter a positive number of chairs to buy: ");
							chairsToBuy = keyboard.nextInt(); }
					}while (invalid);
					
					do {
						System.out.print("Price per item: ");
						try{
							pricePerChair = keyboard.nextDouble();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be a number! ");
							keyboard.next();
							invalid = true; }
						while (pricePerChair < 0)
							{	System.out.print("Please enter a positive price: ");
							pricePerChair = keyboard.nextDouble(); }
					}while (invalid);
					
					if (pricePerChair*chairsToBuy > currentBalance)
					{	Scanner keyBoard = new Scanner(System.in);
						System.out.print("Warning: Spending more money than the company has!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						String proceedOn = keyBoard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceedOn)))
							System.exit(0);
					}
					
					currentBalance = currentBalance - (chairsToBuy * pricePerChair);
					currentQuantityChair = currentQuantityChair + chairsToBuy;
					} //end buy chairs
		
				if (choice == 3)
				{	//change price of chairs
					do {
						System.out.print("\nNew price: ");
						try{
							newChairPrice = keyboard.nextDouble();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be a number! ");
							keyboard.next();
							invalid = true; }
						while (newChairPrice < 0)
							{	System.out.print("Please enter a positive price: ");
							newChairPrice = keyboard.nextDouble(); }
					}while (invalid);
					
					currentPriceChair = newChairPrice;
					} //end price change
			}
	} //END CHAIRS
		
		//DESKS
	if (choice == 3)
	{	
		while (choice != 0) {
			System.out.println("-----------------------------------");
			System.out.println("Current balance: " + fmt2Dec.format(currentBalance));
			System.out.println("Current quantity: " + currentQuantityDesk);
			System.out.println("Current price: " + fmt2Dec.format(currentPriceDesk));
			System.out.println("1. Sell Desks");
			System.out.println("2. Buy Desks");
			System.out.println("3. Change price");
			System.out.println("0. Return to main menu");
			
			//invalid choice
			do {
				System.out.print("Please enter choice: ");
				try {
					choice = keyboard.nextInt();
					invalid = false; }
				catch (InputMismatchException ime) {
					System.out.print("Must be an integer! ");
					keyboard.next();
					invalid = true; }
				while (choice < 0 || choice > 3) {
					System.out.print("Must enter a number 0 - 3! ");
					choice = keyboard.nextInt(); } 
			} while (invalid);
				
				if (choice == 1)
				{	//sell desks
					do {
						System.out.print("Amount to sell (current quantity: " + currentQuantityDesk
						+ "): ");
						try{
							desksToSell = keyboard.nextInt();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be a number! ");
							keyboard.next();
							invalid = true; }
						while (desksToSell < 0)
							{	System.out.print("Please enter a positive number of desks to sell: ");
							desksToSell = keyboard.nextInt(); }
					}while (invalid);
					
					
			
					if (currentQuantityDesk < desksToSell)
					{	Scanner keyBoard = new Scanner(System.in);
						System.out.print("Warning: Selling more than is in stock!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						String proceedOn = keyBoard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceedOn)))
							System.exit(0);
					}					
					currentBalance = currentBalance + (desksToSell * currentPriceDesk);
					currentQuantityDesk = currentQuantityDesk - desksToSell;
				} //end sell desks
		
				if (choice == 2)
				{	//buy desks
					do {
						System.out.print("\nAmount to buy: ");
						try {
							desksToBuy = keyboard.nextInt();
							invalid = false;}
						catch (InputMismatchException ime) {
							System.out.println("Must enter a number!");
							keyboard.next();
							invalid = true;}
						while (desksToBuy < 0)
						{	System.out.print("Please enter a positive number of desks to buy: ");
							desksToBuy = keyboard.nextInt();}
					}while (invalid);

					do {
						System.out.print("Price per item: ");
						try {
							pricePerDesk = keyboard.nextDouble();
							invalid = false;
						}
						catch (InputMismatchException ime) {
							System.out.println("Must enter a number!");
							keyboard.next();
							invalid = true;
						}
						while (pricePerDesk < 0)
						{	System.out.print("Please enter a positive price: ");
							pricePerDesk = keyboard.nextDouble();}
					}while (invalid);

					if (pricePerDesk*desksToBuy > currentBalance)
					{	Scanner keyBoard = new Scanner(System.in);
						System.out.print("Warning: Spending more money than the company has!\n");
						System.out.print("Do you wish to proceed (yes or no)? ");
						String proceedOn = keyBoard.nextLine();
						String answerProceed = "yes";
						if (!(answerProceed.equalsIgnoreCase(proceedOn)))
							System.exit(0);
					}
					currentBalance = currentBalance - (desksToBuy * pricePerDesk);
					currentQuantityDesk = currentQuantityDesk + desksToBuy;
					} //end buy desks
		
				if (choice == 3)
				{	//change price of desks
					do {
						System.out.print("\nNew price: ");
						try{
							newDeskPrice = keyboard.nextDouble();
							invalid = false; }
						catch (InputMismatchException ime) {
							System.out.print("Must be a number! ");
							keyboard.next();
							invalid = true; }
						while (newDeskPrice < 0)
							{	System.out.print("Please enter a positive price: ");
							newDeskPrice = keyboard.nextDouble(); }
					}while (invalid);
					currentPriceDesk = newDeskPrice;
					} //end price change
			}	
		} //END DESKS
	
	} while (choice >= 0 && choice <= 3);
	//end of simulation

	} //end of main method
} //end of class
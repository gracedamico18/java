/* Grace D'Amico
CS 0007
Assignment 2 */

import java.util.Scanner;
import java.util.Random;

public class CoffeeShopSalesSimulator
{
	public static void main(String[] args)
	{
	//Variables defined
	int hours, item, quantity, numCustomers, continueSim;
	double salesGoal, itemPrice, totalCost = -1;
	double coffeeSales = 0, latteSales = 0, cappSales = 0;
	double espressoSales = 0, totalSales = 0;
	String itemName = "";
	
	//More variables defined
	final double COFFEE_PRICE = 1.50;
	final double LATTE_PRICE = 3.50;
	final double CAPPUCCINO_PRICE = 3.25;
	final double ESPRESSO_PRICE = 2.00;
	
	Scanner keyboard = new Scanner(System.in);
	Random randomGenerator = new Random();
	
	//Opening message
	System.out.println("Welcome to the Coffee-Shop-Sales Simulator!");
	
	do
		{
		//Reassigning variables to zero
		coffeeSales = 0; 
		latteSales = 0; 
		cappSales = 0;
		espressoSales = 0; 
		totalSales = 0;
		
		//Getting user input
		System.out.print("\nPlease enter the number of hours: ");
		hours = keyboard.nextInt();
	
		System.out.print("\nPlease enter the sales goal without dollar sign (e.g. 250.00): ");
		salesGoal = keyboard.nextDouble();
		
		//Starting simulation
		System.out.println("---Simulation Start---");
	
		numCustomers = 4 * hours;
	
			//for loop used to do simulation
			for (int i = 1; i <= numCustomers; i++)
			{
				//Generating random numbers for simulation
				item = randomGenerator.nextInt(4)+1;
				quantity = randomGenerator.nextInt(5)+1;
		
				switch (item)
				{ 
					//Each case is for a different item that could be ordered
	 				case 1:
		 			itemName = "Coffee";
				 	totalCost = COFFEE_PRICE * quantity;
				 	coffeeSales += totalCost;
		 			break;
	 	
				 	case 2:
		 			itemName = "Latte";
		 			totalCost = LATTE_PRICE * quantity;
		 			latteSales += totalCost;
			 		break;
	 	
				 	case 3:
		 			itemName = "Cappuccino";
	 				totalCost = CAPPUCCINO_PRICE * quantity;
	 				cappSales += totalCost;
		 			break;
	 	
				 	case 4:
				 	itemName = "Espresso";
		 			totalCost = ESPRESSO_PRICE * quantity;
		 			espressoSales += totalCost;
	 				break;
	 			}//end of switch
	 	
	 		//Printing out each simulated purchase
			System.out.println("\nCustomer " + i);
			System.out.println("Item purchased: " + itemName);
			System.out.println("Quantity purchased: " + quantity);
		 	System.out.printf("Total Cost: $%.2f \n", totalCost);
	 		System.out.println("");
	 		
	 		totalSales = coffeeSales + latteSales + cappSales + espressoSales;
		
		}//end of for loop
		
			System.out.println("---Simulation End---");
		 	
		 	//Printing out total sales for each item purchased
			System.out.println("Aggregate Sales Report\n");
			System.out.printf("%-15s%-15s%15s%17s%15s", "Coffee Sales", "Latte Sales", "Cappuccino Sales", "Espresso Sales", "Total Sales");
			System.out.println("");
			System.out.printf("%-15s%-15s%15s%17s%15s", "------------", "-----------", "----------------", "--------------", "-----------");
			System.out.println("\n");	
			System.out.printf("$%10.2f$%13.2f$%19.2f$%15.2f$%15.2f", coffeeSales, latteSales, cappSales, espressoSales, totalSales);
		 	System.out.println("\n");	 
		 	
		 	//Printing if sales goal was achieved or not
		 	if (totalSales >= salesGoal)
		 		System.out.printf("The sales goal of $%.2f was achieved!\n", salesGoal);
		 		
		 	if (totalSales < salesGoal)
		 		System.out.printf("The sales goal of $%.2f was not achieved.\n", salesGoal);	 	
		 	
		 	//Statement used to run another simulation or to end the simulation
		 	System.out.print("\nEnter 1 to run another simulation or 0 to exit: ");
			continueSim = keyboard.nextInt();
			
			//Goodbye statements
			if (continueSim != 0 && continueSim != 1)
				do
				{
					System.out.println("Invalid input.");
					System.out.print("Enter 1 to run another simulation or 0 to exit: ");
					continueSim = keyboard.nextInt();
				} while (continueSim != 0 && continueSim != 1);				
				
			if (continueSim == 0)
				{
				System.out.println("Goodbye!");
				}
				
		} while (continueSim == 1); 
			//end of do-while loop
		
	}
	
}		 
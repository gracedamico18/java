/* Grace D'Amico
	CS 0007
	Assignment 3 */

import java.util.Scanner;

public class CoffeeShopWithMethods
{
	public static void main(String[] args)
	{	//main method
		displayMenu();
	}
	
	public static void displayMenu()
	{	//outputs menu to the screen
		//states goodbye to the user
		
		String username;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your name: ");
		username = keyboard.nextLine();
	
		System.out.println("\nWelcome to The Java Byte Code Coffee Shop, " + username + "!");
		System.out.println("Here is our menu: \n");
		System.out.println("1. Coffee      $1.50");
		System.out.println("2. Latte       $3.50");
		System.out.println("3. Cappuccino  $3.25");
		System.out.println("4. Espresso    $2.00\n");
		
		getItemNumber();		
		System.out.println("\nThank you, " + username + "! Please stop by again!\n");
	}
	
	public static int getItemNumber()
	{	//prompts user to enter item number
		//returns user input
		
		int item_number = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the item number: ");
		item_number = keyboard.nextInt();

		getQuantity(item_number);
		return item_number;
	}
	
	public static double getQuantity(int item_number)
	{	//prompts user to enter quantity, returns user input
		
		double quantity = 0;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the quantity: ");
		quantity = keyboard.nextDouble();
		
		computeSubTotal(item_number, quantity);
		return quantity;
	}

	public static double computeSubTotal(int item_number, double quantity)
	{	//takes item number and quantity and returns subtotal 
		//(product of price and quantity)
		
		double pretotal = 0;
		double subtotal = 0;
		
		if (item_number == 1)
			pretotal = 1.50;
		else if (item_number == 2)
			pretotal = 3.50;
		else if (item_number == 3)
			pretotal = 3.25;
		else if (item_number == 4)
			pretotal = 2.00;
		
		double n = 0;
		n = quantity;
		subtotal = pretotal * n;
			
		discountCheck(subtotal);
		return subtotal;
	}
	
	public static boolean discountCheck(double subtotal)
	{	//takes subtotal and returns true if user earned discount or false
		
		if (subtotal >= 10)
			{
				computeDiscount(subtotal);
				return true;
			}
		else
			{
				computePriceAfterDiscount(subtotal, 0);
				return false;
			}
	}
	
	public static double computeDiscount(double subtotal)
	{	//takes subtotal and returns dollar amount of discount earned
	
		double discount = 0;

		discount = 0.10 * subtotal;
		
		computePriceAfterDiscount(subtotal, discount);
		return discount;
	}
	
	public static double computePriceAfterDiscount(double subtotal, double discount)
	{ //takes subtotal and discount and returns price after discount
		
		double p_a_d = 0;
		p_a_d = subtotal - discount;
		
		computeTax(p_a_d, discount, subtotal);
		return p_a_d;
	}
	
	public static double computeTax(double p_a_d, double discount, double subtotal)
	{	//takes prices after discount is applied and returns the tax amount
	
		double taxamount = 0;
		
		taxamount = 0.07 * p_a_d;
		
		computeTotal(p_a_d, taxamount, discount, subtotal);
		return taxamount;
	}
	
	public static double computeTotal(double p_a_d, double taxamount, double discount, double subtotal)
	{	//takes prices after discount and tax amount and returns the final total
		double finalcost = 0;
		finalcost = p_a_d + taxamount;
		
		displayOutput(subtotal, discount, p_a_d, taxamount, finalcost);
		
		return finalcost;
	}
	
	public static void displayOutput(double subtotal, double discount, double p_a_d, double taxamount, double finalcost)
	{	//displays lines of output to the user
	
		System.out.printf("\nTotal before tax and discount is: $%.2f \n", subtotal);
		System.out.printf("\nDiscount is: $%.2f \n", discount);
		System.out.printf("\nPrice after discount is: $%.2f \n", p_a_d);
		System.out.printf("\nTax: $%.2f \n", taxamount);
		System.out.printf("\nTotal: $%.2f \n", finalcost);
	}
}
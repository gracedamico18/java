/* Grace D'Amico
	CS 0007
	Assignment 1 */

import java.util.Scanner;

public class CoffeeShop
{
	public static void main(String[] args)
	{
	
	//Variables
	String username; 
	final double item_number;
	double quantity;
	double pretotal = -1; 
	double total = -1;
	double discount = 0;
	double price_after_discount;
	final double taxamount;
	double finalcost;
	
	
	//Create scanner object
	Scanner keyboard = new Scanner(System.in);
	
	
	//User enter name
	System.out.print("Please enter your name: ");
	
	
	//Get user info
	username = keyboard.nextLine();
	
	
	//Welcome and menu info
	System.out.println("\nWelcome to The Java Byte Code Coffee Shop, " + username + "!");
	System.out.println("Here is our menu: \n");
	System.out.println("1. Coffee      $1.50");
	System.out.println("2. Latte       $3.50");
	System.out.println("3. Cappuccino  $3.25");
	System.out.println("4. Espresso    $2.00\n");
	
	
	//User enter the item to purchase
	System.out.print("Please enter the item number: ");
	
	item_number = keyboard.nextDouble();
	
	
	//User enter quantity of item
	System.out.print("Please enter the quantity: ");
	
	quantity = keyboard.nextDouble();
	
	
	//Programming amounts of items and quantities
	if (item_number == 1)
		pretotal = 1.50;
	
	else if (item_number == 2)
		pretotal = 3.50;
		
	else if (item_number == 3)
		pretotal = 3.25;
	
	else if (item_number == 4)
		pretotal = 2.00;
	
	
	if (quantity == 1)
		total = pretotal;
		
	else if (quantity == 2)
		total = pretotal * 2;
		
	else if (quantity == 3)
		total = pretotal * 3;
		
	else if (quantity == 4)
		total = pretotal * 4;
		
	else if (quantity == 5)
		total = pretotal * 5;
		
	else if (quantity == 6)
		total = pretotal * 6;
		
	else if (quantity == 7)
		total = pretotal * 7;
		
	else if (quantity == 8)
		total = pretotal * 8;
		
	else if (quantity == 9)
		total = pretotal * 9;
		
	else if (quantity == 10)
		total = pretotal * 10;
		
		
	//Total before tax and discount
	System.out.printf("\nTotal before tax and discount is: $%.2f \n", total);
	
	
	//Calculate discount
	if (total >= 10)
		discount = 0.10 * total;
		
	System.out.printf("\nDiscount is: $%.2f \n", discount);
	
	
	//Calculate price after discount
	price_after_discount = total - discount;
	System.out.printf("\nPrice after discount is: $%.2f \n", price_after_discount);
	
	
	//Calculate tax amount
	taxamount = 0.07 * price_after_discount;
	System.out.printf("\nTax: $%.2f \n", taxamount);
	
	
	//Calculate final cost 
	finalcost = taxamount + price_after_discount;
	System.out.printf("\nTotal: $%.2f \n", finalcost);
	
	
	//Goodbye to user
	System.out.println("\nThank you, " + username + "! Please stop by again!\n");
	
	}
	
}


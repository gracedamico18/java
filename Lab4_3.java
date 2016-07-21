/**
This program generates the floor of a logarithm based on two inputs from the user. 
The user must enter an integer value greater than one for the base of the logarithm 
and x (a variable). 

When x is divided by the base(b), the quotient is evaluated and stored. When 
the quotient is greater than or equal to the base, the quotient is then divided by 
the base until the quotient is less than the base. The number of divisions executed is
stored and displayed as the floor of the logarithm.
*/

import java.util.Scanner;

public class Lab4_3
{
	public static void main (String [] args) 
	{
		Scanner keyboard = new Scanner(System.in);
	
		System.out.print("Please enter an integer value for 'b': ");
		int b = keyboard.nextInt();
		
		//b is invalid
		while (b <= 1) {
			System.out.print("Please enter a value for 'b' that is greater than 1: ");
			b = keyboard.nextInt(); 
			}
		
		System.out.print("Please enter an integer value for 'x': ");
		int x = keyboard.nextInt();
		
		//x is invalid
		while (x <= 1) {
			System.out.print("Please enter a value for 'x' that is greater than 1: ");
			x = keyboard.nextInt(); 
			}
			
		int quotient = 0;
		int completedDivisions = 1;
		quotient = x / b;
		
		//evaluate the divisions
			while (quotient >= b) {
				quotient = quotient / b; 
				completedDivisions = completedDivisions + 1; 
				}
		
		System.out.println("The floor of the logarithm, y, is: " + completedDivisions);
	}
}
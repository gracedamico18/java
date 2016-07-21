import java.util.Scanner;
import java.util.InputMismatchException;

public class Division {
	public static void main (String[] args) {
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter numerator: ");
	boolean invalid;
	double num = 0;
	double denom = 0;
	do {
		try{
			num = keyboard.nextDouble();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter an integer! ");
			keyboard.next();
			invalid = true;
		}
	} while (invalid);
	
	System.out.print("Enter denominator: ");
	do{
		try{
			denom = keyboard.nextDouble();
			invalid = false;
		}
		catch (InputMismatchException ime) {
			System.out.print("Must enter an integer! ");
			keyboard.next();
			invalid = true;
		}
	}while(invalid);
	
	double result = num/denom;
	int quotient = (int)result;
	int remainder = (int)num % (int)denom;
	System.out.println("After dividing, result is " +result+ "; the quotient is "+
		quotient+" and the remainder is "+remainder+".");
	}
}
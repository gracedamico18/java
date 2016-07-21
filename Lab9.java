/**
Lab 9 
@author Grace D'Amico
This program creates an ArrayList based on the user's input. The program will 
prompt the user to enter the size of the ArrayList. The user will then be prompted 
to input what he or she would like to save in this ArrayList. The user is then 
prompted to enter what string he or she would like to search for within the ArrayList.
If the string searched is saved in the array twice or more, the last occurrence of 
this string will be deleted from the ArrayList. The final data saved in the ArrayList
will be shown to the user.
*/
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Lab9 {
	public static void main (String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean invalid; 
		int size = 0;
		String stringPrompt = "Please enter a string to be saved into the array: ";
		
		System.out.print("How many strings would you like to be entered "+
		"into the program? ");
		do {	
			try {
				size = kb.nextInt();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.print("Must enter a number! ");
				kb.next();
				invalid = true;
			}
		}while (invalid);
		
		while (size <= 0) {
			try {
				System.out.print("Please enter a positive number of strings: ");
				size = kb.nextInt();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must be a number! ");
				kb.next();
				invalid = true;
			}
		} 
		
		//saves ArrayList returned from the getStrings method in a new variable
		ArrayList<String> arrayReference = getStrings(size, stringPrompt);
		
		System.out.print("What string would you like to search for? ");
		String searchString = kb.next();
		
		//removes last occurrence of string searched
		int count = countValues(arrayReference, searchString);
		if (count >= 2) {
			arrayReference.remove(arrayReference.lastIndexOf(searchString));
		}		
		
		System.out.println("The Array List: "+arrayReference);
	} //end main method
	
/**
getStrings method creates the ArrayList, prompts the user to enter strings to be saved 
into the ArrayList, and then saves this data.
@param size Size of the ArrayList specified by the user
@param stringPrompt A string printed to the user that prompts the user to enter a string
to be saved in the ArrayList
@return strArray The ArrayList created and filled with data
*/		
	public static ArrayList<String> getStrings(int size, String stringPrompt) {
		ArrayList<String> strArray = new ArrayList<String>();
		Scanner kb = new Scanner(System.in);
		
		//adds strings entered by user into ArrayList
		for (int i = 0; i < size; i++) {
			System.out.print(stringPrompt);
			String stringSaved = kb.next();
			strArray.add(stringSaved);
		}
		return strArray;
	} //end of getStrings

/**	
countValues method counts the amount of times the string searched by the user appears in
the ArrayList. 
@param arrayCounted The ArrayList created and filled with data
@param search The string searched by the user, so that the amount of times it is saved 
in the ArrayList is recorded.
@return values The amount of times the string searched appears in the ArrayList
*/	
	public static int countValues(ArrayList<String> arrayCounted, String search) {
		int values = 0;
		int i = 0;
		//counts times searched string appears in ArrayList
		while(i < arrayCounted.size()) {
			if (arrayCounted.get(i).equals(search))
				values++;
			i++;
		}
		return values;
	} //end of countValues
}
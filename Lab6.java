/** 
Grace D'Amico 
Lab6
This program contains the use of 3 methods. The first method asks the user to input a
number and will continue to ask the user for a number if the input is not a valid number.
The main method will print the number inputed back to the user. The second method gets a 
filename from the user and continues to ask for a filename if the filename inputed does 
not exist. The third method opens the file and outputs the number of lines in the file to 
the user.
*/

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class Lab6 {
	public static void main (String[] args) throws FileNotFoundException, IOException {
		final int LOWER_BOUND = 0;
		final int UPPER_BOUND = 100;
		
		double num = getValidNumber(LOWER_BOUND, UPPER_BOUND);
		System.out.println("The value of num is " + num + ".");

		String filename = getFilename();
		int numLines = countFileLines(filename);
		System.out.println("The file "+filename+" has "+numLines+" lines.");
	}//end main 
	
	/**
	 *  This method asks the user to input a number between 0 and 100. If the input is 
	 *  invalid, the program will continue the request until it receives a valid number.
	 *  @param lowerBound The lower bound of the number request(0).
	 *  @param upperBound The upper bound of the number request(100).
	 *  @return number The valid number inputed by the user.
	*/
	public static double getValidNumber(double lowerBound, double upperBound) {
		Scanner keyboard = new Scanner(System.in);
		double number = 0;
		boolean invalid;
		
		System.out.print("Please enter a number: ");
		do {
			try {
				number = keyboard.nextDouble(); 
				invalid = false; 
			}
			catch (InputMismatchException ime) {
				System.out.print("Must enter a number! ");
				keyboard.next();
				invalid = true; 
			}
		} while (invalid);
		
		while (number < lowerBound || number > upperBound){
			System.out.print("Please enter a number within the bounds: ");
			do {
				try{
					number = keyboard.nextDouble();
					invalid = false;
				}
				catch (InputMismatchException ime){
					System.out.print("Must enter a number! ");
					keyboard.next();
					invalid = true;
				}
			} while (invalid);
		}		
		return number;
	} //end valid number
	
	/**
	 *  This method gets a filename from the user and continues to ask for a filename if 
	 *  the filename inputed does not exist.
	 *  NO parameters necessary.
	 *  @return filename The existing file that the user inputed.
	*/
	public static String getFilename() {
		boolean invalid;
		String filename = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter a filename: ");
		filename = keyboard.nextLine();
		File inFile = new File(filename);
		
		//validates filename
		while (!(inFile.exists())) {
			System.out.print("Please enter a filename that exists: ");
			filename = keyboard.nextLine(); 
			inFile = new File(filename);
		}
		return filename;
	}//end filename
	
	/**
	 *  This method opens the file inputed during getFilename() and outputs the number 
	 *  of lines in the file.
	 *  @param filename The existing file that the user inputed in getFilename().
	 *  @return lines The number of lines in the file.
	*/
	public static int countFileLines(String filename) throws FileNotFoundException, IOException {
		boolean invalid;
		File inFile = new File(filename);
		Scanner openFile = new Scanner(filename);
		FileInputStream inputStream = new FileInputStream(filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		int lines = 0;
		String line;
		//read lines in file
		while ((line = reader.readLine()) != null) {	
			lines++;	
		}
		openFile.close();
		return lines;
	}//end filelines
} //end class

/**
Grace D'Amico
Midterm Version A
Person's Information

This program records the name of a person and the names of their parents and saves this
information in a file. The program asks the user for a filename. If that file exists, 
the program loads the file and prints to the user all of the names of the person, mother,
and father in the file. The user is then asked to enter the names of a person, mother, 
and father. If the file does not exist, the user is prompted to enter the names of the 
person, mother, and father. The program then ends, and records the names entered by the 
user into the file, which was entered earlier in the program. 
*/

import java.util.Scanner;
import java.io.*;

public class MidtermID {
	public static void main (String[] args) throws FileNotFoundException, IOException {

	Scanner keyboard = new Scanner(System.in);
	System.out.print("Input filename: ");
	String filename = keyboard.nextLine();
	
	//if file exists, print names to screen
	File file = new File(filename);
	if (file.exists()){
		Scanner infile = new Scanner(file);
		String person = "";
		String mother = "";
		String father = "";
		while (infile.hasNext()) {
			person = infile.next();
			mother = infile.next();
			father = infile.next();
		System.out.println(person+" has a mother named "+mother+" and a father named "+father+".");
		}
		infile.close();
	}
	
	//user enters names
	System.out.print("\nName of Person: ");
	String person = keyboard.nextLine();
	System.out.print("Name of Mother: ");
	String mother = keyboard.nextLine();
	System.out.print("Name of Father: ");
	String father = keyboard.nextLine();
	
	//print names just entered into file
	FileWriter fw = new FileWriter(filename, true);
	PrintWriter pw = new PrintWriter(fw);
	pw.println(person+" "+mother+" "+father);
	pw.close();
	
	}
}
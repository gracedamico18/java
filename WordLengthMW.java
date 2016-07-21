//Ask the user for a word. Save the word and its length to a file (of the user’s choosing).
//If that file already exists, tell them how many words are in that file and the total length of all the words. If that file doesn’t exist, create it and save the word and length to the file.
/**
* (javadoc)
* dont need obvious documentation like (asks user for filename) like system.out.println(...);
*want to keep append to file doc and //read in word to infile.next();
*/

import java.util.Scanner;
import java.io.*; //(use this for File and FNFE)

public class WordLengthMW {
	public static void main (String[] args) throws FileNotFoundException, IOException {

	Scanner kb = new Scanner(System.in);
	System.out.print("Please enter a word: ");

	String input = kb.next();
	kb.nextLine();	//skips over enter key after entering word

	System.out.print("Filename: ");
	String filename = kb.nextLine();

	//does file exist?
	File file = new File(filename);
	if (file.exists()) {
		Scanner infile = new Scanner(file);
		int count = 0;
		int totalLength = 0;
		while (infile.hasNext()){ 	//.hasNextLine gives no such element exception
			infile.next();
			totalLength += infile.nextInt();
			count +=1;
		}
		System.out.println("The file has " + count + " words with a total length of " + 
		totalLength + " characters.");
		infile.close();
	}
	
	//append to file: word and length		
	FileWriter fw = new FileWriter(filename, true);
	PrintWriter pw = new PrintWriter(fw); //use to write to (append)
	pw.println(input+" "+input.length());

	//close printwriter
	pw.close();
	}
}

		
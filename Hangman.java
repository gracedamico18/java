/**
Hangman Project 2
@author Grace D'Amico

This program follows the game of Hangman. Hangman is a word guessing game. There are slots
presented to the user, which represent the letters of the word or phrase. The user has 
8 trys to guess the letters in the word. If the user runs out of guesses, they lose the 
game. If the entire word is revealed and no slots are left, the user has won the game.
The word being guessed comes from an input file determined by the user. If the file called
does not exist, the user will be asked for a valid file until one is given. 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Hangman {

	public static void main (String[] args) throws FileNotFoundException {

		Scanner kb = new Scanner(System.in);
		boolean invalid;
		int numberWrong = 0;
		System.out.println("Welcome to Hangman!"); 
		
		//File validation
		System.out.print("Please enter the filename to begin: ");
		String filename = kb.nextLine();
		File inFile = new File(filename);
		while (!(inFile.exists())) {
			System.out.print("Please enter a filename that exists: ");
			filename = kb.nextLine();
			inFile = new File(filename);
		}
		Scanner openFile = new Scanner(inFile); 
		String word = openFile.nextLine();
		openFile.close();
		
		ArrayList<Character> wrongLetters = new ArrayList<Character>();
		
		//Create StringBuilder to display to the user dashes or correct guesses
		StringBuilder wordPrint = new StringBuilder(" ");
		wordPrint.setLength(word.length());
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ' ') {
				wordPrint.setCharAt(i, ' ');
			}
			else {
				wordPrint.setCharAt(i, '-');
			}
		}
		
		int wordIndex = 0;
		boolean found = false;
		
		//Game Simulation
		while (numberWrong < 8) {
			System.out.print(wordPrint);
			System.out.print("\nWrong guesses ("+numberWrong+"/8): "+wrongLetters);
			System.out.print("\nGuess: ");
			String guess = kb.next();
			char letterGuess = guess.charAt(0);
			
			if((wordPrint.indexOf(guess) != -1) || (wrongLetters.indexOf(letterGuess) != -1)){
				System.out.println("You already guessed \'"+letterGuess+"\'!");
			}
			
			//Guessed the correct letter and display will be updated
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == letterGuess) {
					wordPrint.setCharAt(i, letterGuess);
					found = true;
				}
				else {
					wordIndex++;
				}
			}			
			
			//Guessed a character not in the word or phrase
			if(word.indexOf(guess) == -1 && ((wordPrint.indexOf(guess) == -1) && 
			(wrongLetters.indexOf(letterGuess) == -1))) {
				numberWrong++;
				wrongLetters.add(letterGuess);
			}
			
			if(wordPrint.indexOf("-") == -1) {
				System.out.println("\nCongratulations, you won!");
				System.exit(0);
			}
		} 

		System.out.print("\nSorry, you lost the game. The correct word or phrase was: ");
		System.out.println("\n"+word);
	}
}
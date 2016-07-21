/**
Grace D'Amico
Test Version B
Population Methods

This program calculates the new population, rate of growth, and periodicity of a 
particular strain of bacteria. This bacteria was placed in an environment containing
ultraviolet radiation, which plays a part in the periodic pattern of the population.
The program retrieves the starting population, hours since the start of the 
experiment, and the intensity of radiation from the user. This data is then used to
calculate the new population growth based on the starting population and hours past
since the starting population was recorded. The growth rate is also calculated using 
the starting population and hours from the start. The periodic pattern of the 
fluctuating population (due to radiation) is calculated using hours and intensity 
of the radiation.
*/
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class PopulationMethods {
	/*
	Main Method - calls all of the other methods and saves their return value (if
	the methods have one) into a reference variable.
	*/
	public static void main (String[] args) {
		double startPopulationVar = startingPopulation(0, true);
		double hoursVar = hoursSinceStart(0, true);
		double intensityVar = radiationIntensity(0, true);
		newPopAndRate(startPopulationVar, hoursVar);
		period(hoursVar, intensityVar);
	} 
	
	/*
	The startingPopulation method prompts the user to enter a valid starting population
	amount. If the user enters a non-numeric value or a number less than or equal
	to zero, the user will be prompted to give a valid input until he or she does 
	so. 
	@param population The starting population that will be inputted by the user.
	@param invalid The boolean value to work the try-catch block.
	@return population The starting population inputted by the user
	*/
	public static double startingPopulation(double population, boolean invalid){
		Scanner kb = new Scanner(System.in);
		do {
			System.out.print("Enter starting population (must be positive): ");
			try {
				population = kb.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				kb.next();
				invalid = true;
			}
		}while (invalid);
		
		while (population <= 0) {
			System.out.print("Please enter a positive starting population: ");
			try {
				population = kb.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				kb.next();
				invalid = true;
			}
		}
		return population;
	} 
	
	/*
	The hoursSinceStart method prompts the user to enter the amount of hours that
	have passed since the starting population amount was taken. If the user enters
	any invalid input (non-numeric value or less than or equal to zero), then he
	or she will be prompted to enter a new value until one is received.
	@param hours The hours that have been passed since the start of the experiment.
	@param invalid The boolean value to work the try-catch block.
	@return hours The number of hours that the user entered since the starting 
		population was counted.
	*/
	public static double hoursSinceStart(double hours, boolean invalid) {
		Scanner kb = new Scanner(System.in);
		do {
			System.out.print("Enter hours since start (must be positive): ");
			try {
				hours = kb.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				kb.next();
				invalid = true;
			}	
		}while (invalid);
			
		while (hours <= 0) {
			System.out.print("Please enter a positive number of hours: ");
			try {
				hours = kb.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				kb.next();
				invalid = true;
			}
		}
		return hours;
	} 

	/*
	The radiationIntensity method prompts the user to enter the intensity of the 
	radiation placed in the environment. If the user enters an invalid value, such
	as a non-numeric value or an intensity less than or equal to zero, then the user
	will continue to be prompted until the program receives a valid input.
	@param intensity The intensity of the ultraviolet radiation placed on the 
	environment, which will be entered by the user.
	@param invalid The boolean value to work the try-catch block.
	@return intensity The intensity of the radiation specified by the user.
	*/
	public static double radiationIntensity(double intensity, boolean invalid) {
		Scanner kb = new Scanner(System.in);		
		do {
			System.out.print("Enter radiation intensity (must be positive): ");
			try {
				intensity = kb.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				kb.next();
				invalid = true;
			}	
		}while (invalid);
		
		while (intensity <= 0) {
			System.out.print("Please enter a positive intensity: ");
			try {
				intensity = kb.nextDouble();
				invalid = false;
			}
			catch (InputMismatchException ime) {
				System.out.println("Must enter a number!");
				kb.next();
				invalid = true;
			}
		}
		return intensity;
	} 
	
	/*
	The newPopAndRate method takes the starting population and hours to calculate 
	the new population and rate of growth after a certain amount of time.
	@param p The starting population value inputted by the user.
	@param h The amount of hours since the beginning of the experiment which was 
	inputted by the user.
	*/
	public static void newPopAndRate(double p, double h) {
		DecimalFormat fmt2Dec = new DecimalFormat("0.00");
		for (int i = 0; i <= h; i++) {
			double newPop = p * Math.pow(1.48, i);
			double rate = p * i * Math.pow(1.48, i-1);
			System.out.println("At hour = "+i+", population = "+fmt2Dec.format(newPop)
			+" and rate = "+fmt2Dec.format(rate)+".");
		}
	} 
	
	/*
	The period method takes the hours and radiation intensity to calculate the periodicity.
	@param h Hours since the beginning of the experiment, which was specified by the user.
	@param i Intensity of the radiation placed on the environment, which was specified
	by the user.
	*/
	public static void period(double h, double i) {
		DecimalFormat fmt2Dec = new DecimalFormat("0.00");
		double period = (((2*Math.PI)/3)*h*(i/7.8));
		System.out.println("At hour = "+h+", the period = "+fmt2Dec.format(period)+".");
	} 
	
} //end program

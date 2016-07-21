/**
Lab 7 Driver
@author Grace D'Amico
This program allows the RightTriangle class to be executed. The first line
of the program creates a triangle object called 'rightT' which sets the 
fields legA to 5 and legB to 10. The getHypotenuse() method is called and 
calculates the hypotenuse based on the legs being set to 5 and 10. The
getPerimeter() method is called and calculates the perimeter of the triangle
by adding the two legs (5 and 10) to the hypotenuse which was just calculated.
The program then outputs to the user the calculated hypotenuse and perimeter.
*/
public class RightTriangleDriver {
	public static void main (String[] args) {
	
	RightTriangle rightT = new RightTriangle(5, 10);
	
	System.out.println("The hypotenuse is " + rightT.getHypotenuse() + ".");
	System.out.println("The perimeter is " + rightT.getPerimeter() + ".");
	}
}
/**
Lab 7
@author Grace D'Amico

This class called RightTriangle uses methods to set, get, and calculate the 
components of a right triangle. The program named 'RightTriangleDriver.java'
allows this program to be run. Three fields are created called legA, legB, and 
hypotenuse. These legA and legB fields can be set to specific values using the
RightTriangleDriver program. Constructors are used to set default values.
Three methods are created to set the legA, legB, and hypotenuse values. There
are 4 get methods. Two get methods retrieve the legA and legB values to 
calculate the hypotenuse and perimeter. LegA and legB values are returned. The 
other two get methods calculate the hypotenuse and perimeter and return those 
values.
*/
public class RightTriangle {
	
	//fields
	private double legA = 0;
	private double legB = 0;	
	private double hypotenuse;
	
	//initializer constructor
	public RightTriangle (double legA, double legB) {
		setLegA(legA);
		setLegB(legB);
	}
	
	//copy constructor
	public RightTriangle(RightTriangle rightTriangle) {
		double legA = rightTriangle.getLegA();
		double legB = rightTriangle.getLegB();
	}
	
	//no-args constructor
	public RightTriangle() {
		legA = 0;
		legB = 0;
	}
	
	/**
	This method assigns the field legA to the variable a. It also ensures that
	a is valid.
	@param a The variable that legA is set to.
	*/
	public void setLegA(double a) {
		if (a <= 0) {
			IllegalArgumentException iae = new IllegalArgumentException("Leg A"+
			" must be positive.");
			throw iae;
		}
		legA = a;
	}
	
	/**
	This method assigns the field legB to the variable b. It also ensures that
	b is valid.
	@param b The variable that legB is set to.
	*/
	public void setLegB(double b) {
		if (b <= 0) {
			IllegalArgumentException iae = new IllegalArgumentException("Leg B"+
			" must be positive.");
			throw iae;
		}
		legB = b;
	}
	
	/**
	This method assigns the field hypotenuse to the variable h.
	@param h The variable that hypotenuse is set to.
	*/
	public void setHypotenuse(double h) {
		hypotenuse = h;
	}
	
	/**
	This method retrieves the value of the legA field.
	@return legA The value of legA of the right triangle.
	*/
	public double getLegA() {
		return legA;
	}
	
	/**
	This method retrieves the value of the legB field.
	@return legB The value of legB of the right triangle.
	*/
	public double getLegB() {
		return legB;
	}
	
	/**
	This method calculates the value of the hypotenuse field using legA and legB.
	@return hypotenuse The length of the hypotenuse of the right triangle.
	*/
	public double getHypotenuse() {
		hypotenuse = Math.hypot(legA, legB);
		return hypotenuse;
	}
	
	/**
	This method calculates the perimeter of the right triangle using legA, legB,
	and the hypotenuse calculated in the getHypotenuse() method.
	@return legA+legB+hypotenuse The perimeter of the right triangle.
	*/
	public double getPerimeter() {
		return (legA + legB + hypotenuse);
	}
}
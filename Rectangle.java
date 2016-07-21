public class Rectangle
{
	private int length;				//this is the data
	private int width;				//by using "private" makes it secret
	//private int area;				//dont want to have area as one data piece
									//could cause logic error
	
	public Rectangle(int len, int w)
	{
		length = len;
		width = w;
	}




	public void setLength(int len)	//setters or mutators
	{								//dont use "static" keyword!!!
		if (len < 1)
		{
			System.out.println("Invalid value for length. Setting length to 1");
			length = 1;
		}
		else 
			length = len;
	}
	
	public void setWidth(int wid)
	{
		if (wid < 1)
			width = 1;
		else 
			width = wid;
	}
	
	public int getLength()			//return and access fields called getters or accessors
	{
		return length;
	}
	
	public int getWidth()
	{
		return width;
	}								//this has class defined^^^
			
	public int getArea()			//creates width on demand 
	{								//without creating own area data
		return length * width;		//which prevents logic error by the user
	}						
	
	
	//TO STRING METHOD!
	public String toString()
	{
		String rectangleString;
		rectangleString = "Length = " + length + "\n" + "Width = " + width;
		
		return rectangleString;
	}
}

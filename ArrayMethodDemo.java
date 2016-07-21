public class ArrayMethodDemo
{
	public static void main (String[] args)
	{
		int[] myArray = createArray(100);
		int arraySum = computeSum(myArray);
		
		System.out.println("The sum of the elements is: " + arraySum);
	}
	
	public static int[] createArray(int n)		//int n makes case more general
	{
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++)
			array[i] = i + 1;					//this is too complicated - dont do this
												//array [0] = 1;
		return array;							//array [1] = 2;
	}
	
	
	public static int computeSum(int[] a)
	{											//since dont know length of a
		int sum = 0;							//dont use this
												//sum = a[0] + a[1] + a[2];
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		
		return sum;
	}	
	
	public static int findInteger (int[] array, int element)
	{
		int index = 0;
		boolean found = false;					//KNOW THIS FOR FINAL EXAM!
		
		while (!found && (index < array.length))	
		{
			if(array[index] == element)
				found = true;
			else 
				index++;
		}
		
		if (!found)
			index = -1;
				
		return index;
	}
}
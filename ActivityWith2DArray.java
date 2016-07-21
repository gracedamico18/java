public class ActivityWith2DArray
{
	public static void main(String[] args)
	{
		int[][] tableOfNums = { {1,2,3,4,5},
								{6,7,8,9,10} };
		int sum = 0;
		double average = 0.0;
		
		for (int row = 0; row < tableOfNums.length; row++)
			for (int col = 0; col < tableofNums[row].length; col++)
				System.out.println(tableOfNums[row][col]);
				
		for (int row = 0; row < tableOfNums.length; row++)
			for (int col = 0; col < tableofNums[row].length; col++)		
				sum += tableOfNums[row][col];
		// dont need curly braces for the 'for' loops
		
		average = sum / (tableOfNums.length * tableOfNums[0].length);
	}
}
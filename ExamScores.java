public class ExamScores {
	public static void main(String[] args)
	{
		double[] score = { 98.0, 91.0, 84.5, 62.5, 25.0}; 
		
		/*double score1 = 98.0;
		double score2 = 91.0;
		double score3 = 84.5;
		double score4 = 62.5;
		double score5 = 25.0;*/
		double average = 0.0;
		double scoreSum = 0.0;
		
		
		System.out.println("\nThe exam scores are:");
		
		for (int i = 0; i < score.length; i++)
			System.out.printf("%.2f\n", score[i]);
		
		for (int j = 0; j < score.length; j++)
			scoreSum += score[j];
			
		/*System.out.printf("%.2f\n", score1);
		System.out.printf("%.2f\n", score2);
		System.out.printf("%.2f\n", score3);
		System.out.printf("%.2f\n", score4);
		System.out.printf("%.2f\n", score5);*/
		
		//average = (score[0] + score[1] + score3 + score4 + score5) / 5;
		average = scoreSum / score.length;
		
		System.out.println();
		System.out.printf("The average of the scores is: %.2f\n", average);
	}
}
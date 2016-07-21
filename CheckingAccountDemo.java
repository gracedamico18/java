public class CheckingAccountDemo
{
	public static void main (String[] args)
	{
		CheckingAccount myAccount = new CheckingAccount(350.0);
		
		myAccount.deposit(20.0);
		
		if (myAccount.withdraw(100.0))
			System.out.println("Withdrawal was successful.");
		else 
			System.out.println("withdrawal was not successful.");
		
		System.out.printf("Current balance is: $%.2f\n" + myAccount.getBalance());
		
	}
}


//KNOW FOR FINAL EXAM!!!!
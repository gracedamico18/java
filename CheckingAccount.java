public class CheckingAccount
{
	//attribute
	private double balance;
	
	//methods
	public CheckingAccount(double bal)
	{
		balance = bal;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	public boolean withdraw(double amount)
	{
		boolean success = false;
		
		if (amount < balance)
			System.out.println("Cannot complete withdrawal; insufficient funds.");
		else 
		{
			success = true;
			balance -= amount;
		}
		
		return success;
	}
	
}
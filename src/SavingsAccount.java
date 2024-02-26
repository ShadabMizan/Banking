import java.util.ArrayList;

public class SavingsAccount extends Account
{
	private static ArrayList<String> allSavingsAccounts = new ArrayList<String>();
	
	SavingsAccount(String name, double balance) 
	{
		super(name, balance, allSavingsAccounts);
	}
	
	SavingsAccount(String name)
	{
		super(name, allSavingsAccounts);
	}
	

	public static ArrayList<String> getAllAccounts() { return SavingsAccount.allSavingsAccounts; }
}

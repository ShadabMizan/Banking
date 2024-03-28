package Logic;
import java.util.ArrayList;

public class CheckingAccount extends Account
{
	private static ArrayList<CheckingAccount> allCheckingAccounts = new ArrayList<CheckingAccount>();
	
	public CheckingAccount(String name, double balance) 
	{
		super(name, balance);
		CheckingAccount.allCheckingAccounts.add(this);
	}
	
	public CheckingAccount(String name)
	{
		super(name);
		CheckingAccount.allCheckingAccounts.add(this);
	}
	
	public static ArrayList<CheckingAccount> getAllAccounts() { return CheckingAccount.allCheckingAccounts; }
	
	public CheckingAccount eTransfer(CheckingAccount receiver, double amount)
	{
		this.withdraw(amount);
		receiver.deposit(amount);	
		return this;
	}	
}

import java.util.ArrayList;

public class CheckingAccount extends Account
{
	private static ArrayList<String> allCheckingAccounts = new ArrayList<String>();

	CheckingAccount(String name, double balance) {
		super(name, balance, allCheckingAccounts);
	}
	
	CheckingAccount(String name)
	{
		super(name, allCheckingAccounts);
	}
	
	public static ArrayList<String> getAllAccounts() { return CheckingAccount.allCheckingAccounts; }
	
	public CheckingAccount eTransfer(CheckingAccount receiver, double amount)
	{
		this.withdraw(amount);
		receiver.deposit(amount);	
		return this;
	}	
}

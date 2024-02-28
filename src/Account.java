import java.util.ArrayList;

public class Account 
{
	private String name;
	private double balance;
	
	// I am treating the names of Accounts as their ID; there can only be one name in the database.
	private static ArrayList<String> allGeneralAccounts = new ArrayList<String>();
	
	// Initialize a General Account with a name and some starting balance
	Account(String name, double balance)
	{
		setName(name, Account.allGeneralAccounts);
		setBalance(balance);
	}
	
	// Initialize a General Account with a name and empty balance
	Account(String name)
	{
		setName(name, allGeneralAccounts);
		setBalance(0.00);
	}
	
	// Constructors used by child classes
	Account(String name, double balance, ArrayList<String> accountSet)
	{
		setName(name, accountSet);
		setBalance(balance);
	}
	
	Account(String name, ArrayList<String> accountSet)
	{
		setName(name, accountSet);
		setBalance(0.00);
	}

	// Used to create an Account for the first time
	protected void setName(String nameCandidate, ArrayList<String> accountSet)
	{
		boolean uniqueName = true;
		
		if(accountSet.contains(nameCandidate))
		{
			uniqueName = false;
			String error = "An account under "+nameCandidate+" already exists, could not create an account";
			throw new IllegalArgumentException(error);
		}
		
		if (uniqueName)
		{
			accountSet.add(nameCandidate);
			this.name = nameCandidate;
		}
	}

	// Retrieve an Account name
	public String getName() { return this.name; }
	
	// Setter for account balance, meant to be used once by constructor.
	protected void setBalance(double balance) 
	{
		String error = balance+" is an invalid value for an account, could not create an account for "+this.getName();
		this.balance = verifiedAmount(balance, error);
	}
	
	// Verify an amount to be non negative and two decimal places.
	protected double verifiedAmount(double amount, String errorMsg)
	{
		if (amount >= 0.00)
		{
			int temp = (int)(amount * 100);
			amount = ((double)(temp))/100; // ensure two decimal places
			return amount;
		} else 
		{
			throw new IllegalArgumentException(errorMsg);
		}
	}
	
	// Retrieve account balance;
	public double getBalance() { return verifiedAmount(this.balance,"Could not retrieve balance"); }
	
	@Override 
	// Override for toString() called by System.out.println(); 
	public String toString() { return "Name: "+this.getName()+"\nBalance: "+this.getBalance()+"\n";	}
	
	// Retrieve all general accounts created.
	public static ArrayList<String> getAllAccounts() { return Account.allGeneralAccounts; }
	
	// Deposit money into the account
	public Account deposit(double balance) 
	{
		String error = balance+" is an invalid amount. Did not deposit into "+this.getName()+"\n";
		this.balance += verifiedAmount(balance, error);
		return this;
	}
	
	// Withdraw money from an Account
	public Account withdraw(double balance)
	{
		String error = "Could not withdraw "+balance+" from "+this.getName()+". ";
		
		// Check if there are sufficient funds in the Account
		if (this.getBalance() - balance >= 0.00) 
		{ 
			error += "Invalid value.\n"; 
			this.balance -= verifiedAmount(balance, error);
		} else 
		{
			error += "Insufficient account balance"; 
			throw new IllegalArgumentException(error);
		}
		
		return this;
	}
	
	// Transfer funds between two accounts
	public Account internalTransfer(Account receiver, double amount)
	{
		if (receiver.getName() == this.getName())
		{
			this.withdraw(amount);
			receiver.deposit(amount);
		} else 
		{
			String error = "Transfer to "+receiver.getName()+" is not internal. Could not complete transaction.";
			throw new IllegalArgumentException(error);
		}
		return this;
	}
	
}
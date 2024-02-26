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
		if (balance >= 0.00)
		{
			int temp = (int)(balance * 100);
			this.balance = ((double)(temp))/100; // ensure two decimal places
		} else 
		{
			String error = balance+" is an invalid value for an account, could not create an account for "+this.getName();
			throw new IllegalArgumentException(error);
		}
	}
	
	// Retrieve account balance;
	public double getBalance() { return this.balance; }
	
	@Override 
	// Override for toString() called by System.out.println(); 
	public String toString() { return "Name: "+this.getName()+"\nBalance: "+this.getBalance()+"\n";	}
	
	
	public static ArrayList<String> getAllAccounts() { return Account.allGeneralAccounts; }
}
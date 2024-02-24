import java.util.ArrayList;
import java.util.Collections;

public class Account 
{
	private String name;
	private double balance;
	private static ArrayList<String> activeAccounts = new ArrayList<String>();
	
	// Initialize an Account with a name and some starting balance
	Account(String name, double balance)
	{
		setName(name);
		setBalance(balance);
	}
	
	// Initialize an Account with an empty balance
	Account(String name)
	{
		setName(name);
		setBalance(0.00f);
	}

	// Retrieve names of all accounts made
	public static ArrayList<String> getActiveAccounts()
	{
		return activeAccounts;
	}
	
	// Insert a new account name in alphabetical position.
	private static void addNewActiveAccount(String newAccountName)
	{
		// binary search returns (-index + 1) of where the value may have been inserted if it were found in the array 
        int index = Collections.binarySearch(activeAccounts, newAccountName);
        if (index < 0) 
        {
            index = -index - 1; // Insertion point
        }
        activeAccounts.add(index, newAccountName);
	}
	
	// Retrieve an Account name
	public String getName() 
	{
		return name;
	}

	// Setter for account name, meant to be used once by the constructor
	private void setName(String nameCandidate) 
	{
		boolean uniqueName = true;
		
		// Try to reduce time complexity of this, since activeAccounts is sorted.
		for (String name : activeAccounts)
		{
			if (nameCandidate == name)
			{
				uniqueName = false;
				String error = "An account under "+nameCandidate+" already exists, could not create an account";
				throw new IllegalArgumentException(error);
			}
		}
		if (uniqueName)
		{
			addNewActiveAccount(nameCandidate); // Add the name in an alphabetically ordered manner
			this.name = nameCandidate;
		}
	}

	// Retrieve account balance;
	public double getBalance() {
		return balance;
	}
	
	// Setter for account balance, meant to be used once by constructor.
	private void setBalance(double balance) {
		if (balance >= 0.00f)
		{
			int temp = (int)(balance * 100);
			this.balance = ((double)(temp))/100; // ensure two decimal places
		} else 
		{
			String error = balance+" is an invalid value for an account, could not create an account for "+this.name;
			throw new IllegalArgumentException(error);
		}
	}
	
	@Override 
	// Override for toString() called by System.out.println(); 
	public String toString()
	{
		return "Name: "+this.name+"\nBalance: "+this.balance+"\n";
	}
}

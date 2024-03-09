import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class ClientAccount 
{
	protected static HashMap<Integer, ClientAccount> allClientAccounts = new HashMap<Integer, ClientAccount>();
	
	protected String name;
	protected double totalBalance;
	
	protected CheckingAccount checking;
	protected SavingsAccount savings;
	
	private final int ID;
	
	// Start an account with both a checking and savings account
	ClientAccount(SavingsAccount savings, CheckingAccount checking) 
	{
		this.ID = setID();
		setAccounts(savings, checking);	
		setName();
		updateTotalBalance();
	}
	
	// Start an Account with just a savings account
	ClientAccount(SavingsAccount savings) 
	{
		this.ID = setID();
		setAccounts(savings, null);
		setName();
		updateTotalBalance();
	}
	
	// Start an account with just a checking account
	ClientAccount(CheckingAccount checking) 
	{
		this.ID = setID();
		setAccounts(null, checking);
		setName();
		updateTotalBalance();
	}
	
	// Create a unique ID for every Account object
	private int setID()
	{
		// Generate a 6 digit random integer ID
		Random random = new Random();
		int idLength = 8;
		int tempID = 0;
		
		// Iterate until a unique random integer ID is made.
		while (true)
		{
			for (int i = 0; i < idLength; i++) { tempID += random.nextInt(10) * Math.pow(10, idLength - i); }
			
			// Ensure 6 digits
			if (tempID >= Math.pow(10, idLength)) { tempID /= 10; }
			
			// Check for uniqueness
			if (allClientAccounts.keySet().contains(tempID))
			{
				tempID = 0;
			} else 
			{
				break;
			}
				
		}
		
		// Register object into database
		allClientAccounts.put(tempID, this);
		
		return tempID;	
	}
	
	// Retrieve ID number
	int getID() { return this.ID; }
	
	// View all client IDs ever made. All should be unique
	public static Set<Integer> getAllClientIDs() { return allClientAccounts.keySet(); }
	
	// View all client Accounts
	public static Collection<ClientAccount> getAllClientAccounts() { return allClientAccounts.values(); }
	
	// Setter for Accounts
	private void setAccounts(SavingsAccount savings, CheckingAccount checking)
	{
		// Set savings account only
		if (checking == null)
		{
			if (this.checking == null || this.checking.getName() == savings.getName())
			{
				this.savings = savings;
			} else 
			{
				String error = "Name does not match with the checking account's name, "+this.getCheckingAccount().getName()+"\n";
				throw new IllegalArgumentException(error);
			}
		} 
		// Set Checking account only
		else if (savings == null)
		{
			if (this.savings == null || this.savings.getName() == checking.getName())
			{
				this.checking = checking;
			} else 
			{
				String error = "Name does not match with the checking account's name, "+this.getCheckingAccount().getName()+"\n";
				throw new IllegalArgumentException(error);
			}
		} 
		// Set both Checking and Savings accounts
		else 
		{
			this.savings = savings;
			this.checking = checking;
		}
	}
	
	// Getter for Accounts
	public CheckingAccount getCheckingAccount() { return this.checking; }
	public SavingsAccount getSavingsAccount() { return this.savings; }
	
	private void setName()
	{
		try {
			this.name = this.savings.getName();
		} catch (Exception e) {}
		
		try {
			this.name = this.checking.getName();
		} catch (Exception e) {}
	}
	
	public String getName() { return this.name; }
	
	
	public double getSavingsBalance() 
	{
		if (this.savings != null)
		{
			return this.savings.getBalance(); 
		} else 
		{
			return 0;
		}
	}
	
	public double getCheckingBalance() 
	{
		if (this.checking != null)
		{
			return this.checking.getBalance(); 
		} else 
		{
			return 0;
		}
	}
	
	private void updateTotalBalance()
	{
		this.totalBalance = this.getSavingsBalance() + this.getCheckingBalance();
	}
		
	public double getTotalBalance() 
	{
		// Update Total balance whenever you want to use it.
		updateTotalBalance();
		return this.totalBalance; 
	}
	
//	@Override
//	public String toString()
//	{
//		return "Name: "+this.getName()+"\nID: "+this.getID()+"\nTotal Balance: "+this.getTotalBalance()+"\n";
//	}
	
	public String print()
	{
		return "ID: "+this.getID()+"\nName: "+this.getName()+"\nChecking Balance: "+this.getCheckingBalance()+"\nSavings Balance: "+this.getSavingsBalance()+"\nTotal Balance: "+this.getTotalBalance()+"\n";
	}
}

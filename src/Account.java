public class Account 
{
	protected String name;
	protected double balance;
	
	// Initialize a General Account with a name and some starting balance
	Account(String name, double balance)
	{
		setName(name);
		setBalance(balance);
	}
	
	// Initialize a General Account with a name and empty balance
	Account(String name)
	{
		setName(name);
		setBalance(0.00);
	}

	// Used to create an Account for the first time
	protected void setName(String name) { this.name = name; }

	// Retrieve an Account name
	public String getName() { return this.name; }
	
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
	
	// Verify an amount to be non-negative and at any precision.
	protected double verifiedAmount(double amount, String errorMsg, int precision)
	{
		if (amount >= 0.00)
		{
			int temp = (int)(amount * Math.pow(10,precision));
			amount = ((double)(temp))/Math.pow(10,precision); // ensure two decimal places
			return amount;
		} else 
		{
			throw new IllegalArgumentException(errorMsg);
		}
	}
	
	// Setter for account balance, meant to be used once by constructor.
	protected void setBalance(double balance) 
	{
		String error = balance+" is an invalid value for an account, could not create an account for "+this.getName();
		this.balance = verifiedAmount(balance, error);
	}
	
	// Retrieve account balance;
	public double getBalance() { return verifiedAmount(this.balance,"Could not retrieve balance"); }
	
//	@Override 
//	// Override for toString() called by System.out.println(); 
//	public String toString() { return "Name: "+this.getName()+"\nBalance: "+this.getBalance()+"\n";	}
	
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
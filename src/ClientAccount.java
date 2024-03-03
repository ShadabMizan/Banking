import java.util.ArrayList;
import java.util.Random;

public class ClientAccount 
{
	protected static ArrayList<Integer> allClientIDs = new ArrayList<Integer>();
	protected String name;
	protected double totalBalance;
	
	protected CheckingAccount checking;
	protected SavingsAccount savings;
	
	private final int ID;
	
	ClientAccount(SavingsAccount savings, CheckingAccount checking) 
	{
		this.ID = setID();
		setName(savings, checking);
		setTotalBalance(savings, checking);
	}
	
	ClientAccount(SavingsAccount savings) 
	{
		this.ID = setID();
		setName(savings, null);
		setTotalBalance(savings, checking);
	}
	
	ClientAccount(CheckingAccount checking) 
	{
		this.ID = setID();
		setName(null, checking);
		setTotalBalance(savings, checking);
	}
	
	private int setID()
	{
		// Generate a 6 digit random integer ID
		Random random = new Random();
		int idLength = 6;
		int tempID = 0;
		
		// Iterate until a unique random integer ID is made.
		while (true)
		{
			for (int i = 0; i < idLength; i++) { tempID += random.nextInt(10) * Math.pow(10, idLength - i); }
			
			if (tempID >= 1000000) { tempID /= 10; }
			
			// Check for uniqueness
			if (allClientIDs.contains(tempID)) { 
				tempID = 0; 
			} else { 
				break; 
			}
		}
		
		return tempID;	
	}
	
	// Retrieve ID number
	int getID() { return this.ID; }
	
	// View all client IDs ever made. All should be unique
	public static ArrayList<Integer> getAllClientIDs() { return allClientIDs; }
	
	// Setter given that client initializes with both a savings and checking account
	private void setName(SavingsAccount savings, CheckingAccount checking)
	{
		// Deal with only checking account passed
		if (savings == null)
		{
			if (this.savings == null) { 
				this.name = checking.name;
			} else {
				if (this.savings.name == checking.name) {
					this.name = checking.name;
				} else {
					String error = "A savings account under this client has a different name than this checking account. Could not create client account.\n";
					throw new IllegalArgumentException(error);
				}
			}
		}
		
		// Deal with only savings account passed
		else if (checking == null)
		{
			if (this.checking == null) {
				this.name = savings.name;
			} else {
				if (this.checking.name == savings.name) {
					this.name = savings.name;
				} else {
					String error = "A checking account under this client has a different name than this savings account. Could not create client account.\n";
					throw new IllegalArgumentException(error);
				}
			}
		}
		
		// Deal with both savings and checking accounts passed
		else 
		{
			if (savings.name == checking.name) {
				this.name = savings.name;
			} else {
				String error = "Accounts are not under the same name. Could not create Client Account.\n";
				throw new IllegalArgumentException(error);
			}
		}

	}
	
	public String getName() { return this.name; }
	
	private void setTotalBalance(SavingsAccount savings, CheckingAccount checking)
	{
		double balance = 0;
		
		try {
			balance += savings.getBalance();
		} catch (Exception e) {
			balance += 0;
		}
		
		try {
			balance += checking.getBalance();
		} catch (Exception e) {
			balance += 0;
		}
		
		this.totalBalance = balance;
	}
	
	public double getTotalBalance() { return this.totalBalance; }
	
	@Override
	public String toString()
	{
		return "Name: "+this.getName()+"\nID: "+this.getID()+"\nTotal Balance: "+this.getTotalBalance()+"\n";
		
	}
}

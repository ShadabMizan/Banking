import java.util.ArrayList;

public class SavingsAccount extends Account
{
	private static ArrayList<String> allSavingsAccounts = new ArrayList<String>();
	private InterestPeriods interestPeriod;
	private double interestRate = 0;
	
	SavingsAccount(String name, double balance, InterestPeriods periodType) 
	{
		super(name, balance, allSavingsAccounts);
		setInterestPeriod(periodType);
	}
	
	SavingsAccount(String name, InterestPeriods periodType)
	{
		super(name, allSavingsAccounts);
		setInterestPeriod(periodType);
	}
	
	SavingsAccount(String name, double balance)
	{
		super(name, balance, allSavingsAccounts);
	}
	
	SavingsAccount(String name)
	{
		super(name, allSavingsAccounts);
	}

	public static ArrayList<String> getAllAccounts() { return SavingsAccount.allSavingsAccounts; }
	
	public enum InterestPeriods
	{
		DAILY,
		WEEKLY,
		BIWEEKLY,
		MONTHLY,
		QUARTERLY,
		YEARLY,
	};
	
	// Calculate compound interest
	private double calculateInterest(double initial, double rate, InterestPeriods type, double years)
	{
		if (years > 0)
		{
			int n = 1;
			switch(type)
			{
			case DAILY:
				n = 365;
				break;
			case WEEKLY:
				n = 54;
				break;
			case BIWEEKLY:
				n = 27;
				break;
			case MONTHLY:
				n = 12;
				break;
			case QUARTERLY:
				n = 4;
				break;
			case YEARLY:
				n = 1;
				break;
			}
			
			return initial * Math.pow((1 + (rate)/n), (n*years));	
		} else 
		{
			String error = "Cannot apply "+years+" years as a period to gain interest";
			throw new IllegalArgumentException(error);
		}
		
	}
	
	public double accumulateInterest(double years)
	{
		double prevBalance = this.getBalance();
		
		// Verify that the account has an interest period and rate set up.
		if (this.getInterestPeriod() == null)
		{
			String error = this.getName()+" does not have an Interest Period set up. Cannot accumulate interest.\n";
			throw new IllegalArgumentException(error);
		} else if (this.getInterestRate() == 0)
		{
			String error = this.getName()+" does not have an Interest Rate set up. Cannot accumulate interest.\n";
			throw new IllegalArgumentException(error);
		}
		
		this.balance += calculateInterest(this.getBalance(), interestRate, this.getInterestPeriod(), years);
		
		// Return how much the client makes out of the interest
		return this.getBalance() - prevBalance;
	}

	private void setInterestPeriod(InterestPeriods interestPeriod) { this.interestPeriod = interestPeriod; }
	
	public InterestPeriods getInterestPeriod() { return this.interestPeriod; }
	
	public void setInterestRate(double newRate)
	{
		String error = "Could not set the interest rate of "+this.getName()+" to "+newRate+"\n";
		verifiedAmount(newRate, error, 4); // an interest rate will be kept accurate to 4 decimal places.
	}
	public double getInterestRate() { return this.interestRate; }
}


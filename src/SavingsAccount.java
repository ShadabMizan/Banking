import java.util.ArrayList;

public class SavingsAccount extends Account
{
	private static ArrayList<SavingsAccount> allSavingsAccounts = new ArrayList<SavingsAccount>();
	
	private InterestPeriods interestPeriod = null;
	private double interestRate = 0;
		
	SavingsAccount(String name, double balance)
	{
		super(name, balance);
		SavingsAccount.allSavingsAccounts.add(this);
	}
	
	SavingsAccount(String name)
	{
		super(name);
		SavingsAccount.allSavingsAccounts.add(this);
	}

	public static ArrayList<SavingsAccount> getAllAccounts() { return SavingsAccount.allSavingsAccounts; }
	
	public static enum InterestPeriods
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
		// Check if account is legible for interest by checking if the account's interest rate and period are set.
		if (rate == 0)
		{
			String error = "Interest rate has not been set for "+this.getName()+"'s SavingsAccount.";
			throw new IllegalArgumentException(error);
		} else if(type == null)
		{
			String error = "Interest period has not been set for "+this.getName()+"'s SavingsAccount.";
			throw new IllegalArgumentException(error);
		} else 
		{
			// Check if the year amount is valid
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
	}
	
	public double accumulateInterest(double years)
	{
		double prevBalance = this.getBalance();
		this.balance += calculateInterest(this.getBalance(), interestRate, this.getInterestPeriod(), years);
		
		// Return how much the client makes out of the interest
		return this.getBalance() - prevBalance;
	}

	public void setInterestPeriod(InterestPeriods interestPeriod) { this.interestPeriod = interestPeriod; }
	
	public InterestPeriods getInterestPeriod() { return this.interestPeriod; }
	
	public void setInterestRate(double newRate)
	{
		String error = "Could not set the interest rate of "+this.getName()+" to "+newRate+"\n";
		verifiedAmount(newRate, error, 4); // an interest rate will be kept accurate to 4 decimal places.
	}
	
	public double getInterestRate() { return this.interestRate; }
}


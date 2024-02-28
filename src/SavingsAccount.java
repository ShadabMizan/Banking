import java.util.ArrayList;

public class SavingsAccount extends Account
{
	private static ArrayList<String> allSavingsAccounts = new ArrayList<String>();
	private InterestPeriods interestPeriod;
	private double interestRate = 0.05;
	
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
	
	public double gainInterest(double years)
	{
		double prevBalance = this.getBalance();
		this.balance += calculateInterest(this.getBalance(), interestRate, this.getInterestPeriod(), years);
		
		return this.getBalance() - prevBalance;
	}

	private void setInterestPeriod(InterestPeriods interestPeriod) { this.interestPeriod = interestPeriod; }
	
	public InterestPeriods getInterestPeriod() { return this.interestPeriod; }
}


public class Main 
{
	public static void main(String[] args) 
	{
		Account kassandra = new Account("Kassandra", 310.50);
		CheckingAccount markos = new CheckingAccount("Markos", 50.00);
		SavingsAccount kass = new SavingsAccount("Kassandra", 80, SavingsAccount.InterestPeriods.MONTHLY);
		
		System.out.println(kass.gainInterest(5));
		System.out.println(kass);
	}
}

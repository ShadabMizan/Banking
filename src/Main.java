public class Main 
{
	public static void main(String[] args) 
	{
		// Savings Account
		SavingsAccount kassandra = new SavingsAccount("Kassandra", 98.75);
		
		// General Accounts
		Account alexios = new Account("Alexios", 9.87);	
		Account kass = new Account("Kassandra", 78.32);
		
		// Checking Accounts
		CheckingAccount kassy = new CheckingAccount("Kassandra", 1009.75);
		CheckingAccount markos = new CheckingAccount("Markos", 80.00);
		
		// Verify that only one name can exist
		try 
		{
			CheckingAccount mark = new CheckingAccount("Markos", 9.72);
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		// Successfully create multiple accounts of Kassandra, all a different object though
		System.out.println(kass);
		System.out.println(kassandra);
		System.out.println(kassy);
		
		// View the data sets of each object
		System.out.println(Account.getAllAccounts());
		System.out.println(SavingsAccount.getAllAccounts());
		System.out.println(CheckingAccount.getAllAccounts());
	}
}

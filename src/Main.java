public class Main 
{
	public static void main(String[] args) 
	{
		SavingsAccount markosSavings = new SavingsAccount("Markos", 200.98);
		CheckingAccount markosChecking = new CheckingAccount("Markos", 540.56);
		
		ClientAccount markos = new ClientAccount(markosSavings, markosChecking);
		
		System.out.println(markos);
		
	}
}

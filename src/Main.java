public class Main 
{
	public static void main(String[] args) 
	{
		Account kassandra = new Account("Kassandra", 30.50);
		CheckingAccount markos = new CheckingAccount("Markos", 50.00);
		
//		markos.withdraw(90.00).deposit(80.00);
		
		
		try {
			kassandra.internalTransfer(markos, 89);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(markos);
		System.out.println(kassandra);
	}
}

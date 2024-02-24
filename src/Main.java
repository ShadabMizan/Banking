public class Main {

	public static void main(String[] args) 
	{
		Account kassandra = new Account("Kassandra", 891.7687123);
		Account phoibe = new Account("Phoibe", 9.00);
		Account alexios = new Account("Alexios", 999.54);
		
		// Display sorted array
		System.out.println(Account.getActiveAccounts());
		
		// Display Kassandra's bank account 
		System.out.println(kassandra);
		
		// Example exceptions for invalid accounts:
		try {
			Account myrinne = new Account("Myrinne", -87.21);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Account kass = new Account("Kassandra", 12.80);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

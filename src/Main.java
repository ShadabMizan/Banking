import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{	
		bankProgram();
	}
	
	public static void bankProgram()
	{
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		String options =
				"1. Create an empty account\n"+
				"2. Create an account with a starting balance\n"+
				"3. View all accounts\n"+
				"\n"+
				"-1: exit\n";
		
		
		while (choice != -1)
		{
			System.out.println(options);
			choice = scanner.nextInt();	
			
			
			String name;
			double savingsBalance;
			double checkingBalance;
			
			switch(choice)
			{
			case 1:
				System.out.print("\nEnter a name: ");
				name = scanner.next();
				
				ClientAccount account1 = new ClientAccount(new SavingsAccount(name), new CheckingAccount(name));
				System.out.println("Your account ID is "+account1.getID()+". Use this to interact with your account.");
				break;
			case 2:
				System.out.print("\nEnter a name: ");
				name = scanner.next();
				
				System.out.print("\nBalance for Savings: ");
				savingsBalance = scanner.nextDouble();
				
				System.out.print("\nBalance for Checking: ");
				checkingBalance = scanner.nextDouble();
				
				ClientAccount account2 = new ClientAccount(new SavingsAccount(name, savingsBalance), new CheckingAccount(name, checkingBalance));
				System.out.println("Your account ID is "+account2.getID()+". Use this to interact with your account.\n");
				break;
			case 3:
				printAllClientAccounts();
				break;
			}
		}
		
		scanner.close();
	}
	
	public static ArrayList<ClientAccount> printAllClientAccounts()
	{
		ArrayList<ClientAccount> accountList = new ArrayList<ClientAccount>();
		int i = 0;
		for (ClientAccount account : ClientAccount.getAllClientAccounts())
		{
			System.out.println((i+1)+".\n"+account.print());
			System.out.println();
			accountList.add(account);
			i++;
		}
		
		return accountList;
	}
}

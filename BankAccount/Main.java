package BankAccount;

public class Main {

	public static void main(String[] args) {
		final int SIZE = 5;
		Account[] account = new Account[SIZE];
		int counter = 1;
		double newBalance = 0;
		for (int i = 0; i < SIZE; i++)
		{
			account[i] = new Account(1000 * (counter), 1000 * (counter++), 0.03);
			account[i].withdraw(500.00);
			account[i].deposit(1000.00);
		}

		System.out.printf("%15s%20s%20s%15s%25s\n", "Account Number", "Initial Balance", "Monthly Interest", "Balance", "Date Created");

		for (int i = 0; i < SIZE; i++) {
			newBalance = account[i].getBalance() + account[i].getMonthlyInterest();
			System.out.printf("%15d%20.2f%20.2f%15f%42s\n", account[i].getId(), account[i].getBalance(), account[i].getMonthlyInterest(), newBalance, account[i].getDateCreated());
			account[i].setbalance(newBalance);
		}
	
	}
}
package BankAccount;

public class Account {

	private int id; // Variable represents account id.
	private double balance = 0, // Variable represents account balance.
			AnnualInterestRate = 0;
	private java.util.Date dateCreated;

	// -------------------------------------------------------------------------------------------
	public Account() {
		dateCreated = new java.util.Date();
	}

	// -------------------------------------------------------------------------------------------
	public Account(int id, double balance, double AnnualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.AnnualInterestRate = AnnualInterestRate;
		dateCreated = new java.util.Date(); //this dateCreated was not initialized in constructor
	}

	// -------------------------------------------------------------------------------------------
	public void setId(int id) {this.id = id;}

	public void setbalance(double balance) {this.balance = balance;}

	public void setAnnualInterestRate(int AnnualInterestRate) {this.AnnualInterestRate = AnnualInterestRate;}

	public void withdraw(double amount) {balance = balance - amount;}

	public void deposit(double amount) {balance = balance + amount;}

	public int getId() {return id;}

	public double getBalance() {return balance;}

	public double getAnnualInterestRate() {return (AnnualInterestRate / 100);}

	public double getMonthlyInterestRate() {return (getAnnualInterestRate() / 12);}
	
	public double getMonthlyInterest() {return (balance * getMonthlyInterestRate());}

	public String getDateCreated() {return dateCreated.toString();}

};

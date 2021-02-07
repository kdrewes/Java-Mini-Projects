/*
 Financial Application: compare loans with various interest rates
 
 Write a program that lets the user enter the loans amounts and loan period in 
 number of years and displays the monthly and total payments for each (annual) 
 interest rate starting from 5% to 8% with an increment of 1/8.  
 For the formula to computer monthly payment:
 
 monthlyPayment = (loanAmount * monthlyInterestRate) / 1-(1/(1+monthlyInterestRate)^numberOfYears*12);

 The program must be done utilizing JOptionPanedialogs to get the user's inputs,
 confirm the information, and print ou the loan amount.
 */
package LabExercise2;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class LabExercise2 
{
	private static final String JOptionPain = null;
	
	public static void main(String[] args) 
	{
	
		int confirm,
			years;
		double amount;
		
		DecimalFormat dec = new DecimalFormat("#,###,##0.000"); 
	    DecimalFormat dec2 = new DecimalFormat("#,###,##0.00");
		
		do
		{
		 
		String string_amount = JOptionPane.showInputDialog("Please enter loan amount: $");
	    amount = Double.parseDouble(string_amount);
		String string_years = JOptionPane.showInputDialog("\nPlease enter loan period (years): ");
		years = Integer.parseInt(string_years);
		confirm = JOptionPane.showConfirmDialog(null,"The loan amount is $"+ dec2.format(amount) + " and the loan during is "+ years + " year(s) " + "\nContinue?","Lab Exercise 2", JOptionPane.YES_NO_OPTION);

		if(confirm == JOptionPane.NO_OPTION) {JOptionPane.showMessageDialog(null,"\nBack to main menu");}
		}while(confirm == JOptionPane.NO_OPTION);
		
		String results = String.format("%25s", "Interest Rate(%) ") + String.format("%25s","Monthly Payment($)") + String.format("%25s", "Total Payment(%)");
		results += "\n";
		double monthly_payment, 
			   interest_rate, 
			   total_payment,
			   i = 5.0;
		
		 while(i<=8.0)
		 {
			 interest_rate = i / 1200; 
			 monthly_payment = (amount * interest_rate) / (1-1/Math.pow(1+interest_rate,years*12));
			 total_payment = monthly_payment * years * 12;
			 	
			results += String.format("%25s", dec.format(i)) + String.format("%22s", "$" + dec2.format(monthly_payment)) + String.format("%45s", "$" + dec2.format(total_payment));
			results += "\n";
			 i = i + 0.125;
		 }
		 
		 JOptionPane.showMessageDialog(null,results);
			 
			 
		 }

}

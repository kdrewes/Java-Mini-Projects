/*
Write a program that plays the popular scissor-rock-paper game (A scissor can cut a paper
a rock can knock a scissor, and a paper can wrap a rock.  The program randomly
generates a number 0,1,2 
0 = scissor
1 = rock
2 = paper

as the computers choice.  The program prompts the user to enter a number 0,1, or 2 and displays
messages indicating whether the user or the computer wins, loses or draws their choice.  
The program will the user continuously play until  either the user or the computer wins a
total three times.
 */
package RockPaperScissors;
import java.util.Scanner;
public class RockPaperScissors 
{
	public static int Computer()
	{
		int comp = (int)(Math.random() * 3);
		return comp;
	}
	//-------------------------------------------------------------------------
	public static void Input()
	{
		Scanner Obj = new Scanner(System.in);
		
		int win = 0, // represents wins
			loss = 0; // represents losses	
		
		while(win<3 || loss<3)
		{
		System.out.println("\nPlease enter your choice - \nscissor (0), rock (1), paper (2): ");
		int user = Obj.nextInt();
		
		while(user < 0 || user > 2)
		{
			user = 0;
			System.out.println("Invalid entry, please re-enter\nscissor (0), rock (1), paper (2): ");
			user = Obj.nextInt();
		}

		int comp = Computer();

			String rock = "rock",
				   paper = "paper",
				   scissors = "scissors",
				   choice = null; //User to determine the name of item that was selected if there is a draw.	
			
			if (user == comp) 
			{
				switch(user)
				{
				case 0:  choice = "scissors"; break;
				case 1:  choice = "rock"; break;
				case 2:  choice = "paper"; break;
				}
				
				System.out.println("\nDraw!  You and the computer both\nchose " 
				+ choice + " please go again.");
			}
			
			else if((win<3 || loss < 3))
			{
			switch(user)
			{
			case 0://if user is scissors
			{
				System.out.println("\nYou chose scissors.");
				
				if(comp==2)
				{
					++win;
					System.out.println("\nComputer chose " + paper
					+ "\n\nYou Win" + "\n\nYou - " + win + " | Computer - " 
				    + loss); 	
				}
				if(comp==1)
				{
					++loss;
					System.out.println("\nComputer chose " + rock
					+ "\n\nYou Lose" + "\n\nYou - " + win + " | Computer - " 
					+ loss);
				}
				break;
			}
			case 1://if user is rock
			{
				System.out.println("\nYou chose rock.");
				
				if(comp==0)
				{
					++win;
					System.out.println("\nComputer chose " + scissors
					+ "\n\nYou Win" + "\n\nYou - " + win + " | Computer - " 
					+ loss); 
				}
				if(comp==2)
				{
					++loss;
					System.out.println("\nComputer chose " + paper
					+ "\n\nYou Lose" + "\n\nYou - " + win + " | Computer - " 
					+ loss); 
				}
				break;
			}
			case 2://if user is paper
			{
				System.out.println("\nYou chose paper.");
				if(comp==1)
				{
					++win;
					System.out.println("\nComputer chose " + rock
					+ "\n\nYou Win" + "\n\nYou - " + win + " | Computer - " 
					+ loss);
				}
				if(comp==0)
				{
					++loss;
					System.out.println("\nComputer chose " + scissors
					+ "\n\nYou Lose" + "\n\nYou - " + win + " | Computer - " 
					+ loss);
				}
				break;
			}
			}
			}
			
			if(win == 3 || loss == 3) 
			{
				if(win==3) {System.out.println("\nCongratulations! You win.\n");}
				else {System.out.println("\nComputer wins, thank you for playing.\n");}
			}
		}
	}
	public static void main(String[] args){Input();}
}




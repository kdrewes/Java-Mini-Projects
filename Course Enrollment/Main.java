/*
 Assignment 5 - Kyle Drewes - 1224159
 Revise the course class as follows: (Don't use ArrayList)
 The array size is fixed in Listing 10.6 Improve addStudent 
 method to automatically increase the array size by creating 
 a new larger array and copying the contents of the current
 array to it.  (default capacity = 16, increased the size of
 array to the double if necessary).
 
 -Implement the dropStudent method.  If the student to be dropped can't be found, do nothing.
 
 -Add the instructer's information into the class.
 
 -Add a method, clear(), removes all students from the course.
 
 -Add a method,print(), displays course information with the Course Name, instructor's name,
 the number of students enrolled, and the list of students' names.
 
 Refer to the updated UML diagram.
 
 Write a test program that creates a course with default capacity,
 
 adds twenty students, removes three, adds another two, then calls print()
 method to display the course info.  Call clear() and display the course info again.
 */
package Course;
import java.util.Scanner;
public class Main
{

	public static void main(String[] args) 
	{
		Course school= new Course("COMSC255: Programming with Java","Laura Lo");
		Scanner input = new Scanner(System.in);
		
		int option;
		String student_name;
		
		do
		{
			System.out.print("------------------------ Menu ---------------------------\n");
			System.out.print("1) Add Student" + "\t\t\t2) Drop Student\n" );
			System.out.print("3) Print" + "\t\t\t4) Exit\n" );
			
			System.out.print("\nSelect Option (1-4): ");
			option = input.nextInt();
			input.nextLine();
		switch(option)
		{
		case 1:
			System.out.print("\n-------------------- Add Student ----------------------\n");
			System.out.print("Student Name: ");
			String student = input.nextLine();
			school.addStudent(student);
			break;
		case 2:
			System.out.print("\n-------------------- Drop Student ----------------------\n");
			System.out.print("Student Name: ");
			student = input.nextLine();
			school.dropStudent(student);
			break;
		case 3:
			school.Print();
			break;
		case 4:
			System.exit(0);
		default:
			System.out.print("\nInvalid entry");
		}
		}while(option!=4);
	
	}

}

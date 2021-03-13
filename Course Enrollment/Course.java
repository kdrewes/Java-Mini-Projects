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

public class Course 
{
 private String courseName;
 private String instructor;
 private String [] studentList;
 private int capacity;
 private int numberOfStudents;
 
 public Course() 
 {
	 numberOfStudents = 0;
	 capacity = 16;
	 courseName = "COMSC255: Programming with Java";
	 instructor = "Lauro Lo";
	 studentList = new String[16];
 }
 public Course(String courseName) 
 {
	 this.courseName = courseName;
	 capacity = 16;
	 instructor = "Lauro Lo";
	 studentList = new String[16];
 }
 public Course(String courseName, String instructor)
 {
	 this.courseName = courseName; 
	 this.instructor = instructor;
	 capacity = 16;
	 studentList = new String[16];
 }
 public String getCourseName() {return courseName;}
 public void setInstructor(String instructor) {this.instructor = instructor;}
 public String getInstructor() {return instructor;}
 
 public void addStudent(String student)
 {
	if(numberOfStudents<capacity)
	{
		studentList[numberOfStudents] = student;
		numberOfStudents++;
		 System.out.printf("\n" + student + " was added into " + courseName + "\n\n");
	}
	else
	{
		String [] temporaryList = new String[capacity*2];
		for(int i = 0; i < studentList.length; i++){temporaryList[i] = studentList[i];}
		temporaryList[numberOfStudents] = student;
		studentList =  temporaryList;
		numberOfStudents++;
		System.out.printf(student + " was added into " + courseName );
	}
 }
 public void dropStudent(String student)
 {
	 int index = -1; //Used to determine the array index of student the user wishes to drop
	 	 
	 for(int i = 0; i < studentList.length; i++) {if(studentList[i].equalsIgnoreCase(student)) {index = i; break;}}
	 
	 if(numberOfStudents>0)
	 {
	 if(index!=-1)
	 {
	 String [] temp = new String[studentList.length-1];
	 for(int i = 0, j = 0; i < studentList.length; i++){ if(i!=index){temp[j++] = studentList[i];}}
	 studentList = temp;
	 numberOfStudents--; 
	 System.out.printf("\n" + student + " has been removed from " + courseName + "\n");
	 }
	 else {System.out.printf("\nThere are currently no students with the name. " + student + " found\n");}
	 }
	 else if(numberOfStudents==0) {System.out.printf("\nThere are currently no students.\n");} 
 }
 public int getNumberOfStudents() {return numberOfStudents;}
 public void Print()
 {
	System.out.print("------------------------- Print ------------------------------\n");
	System.out.println("\nCourse Name: " + courseName );
 	System.out.println("\nInstructor Name: " + instructor );
 	System.out.println("\nThere is(are) " + numberOfStudents + " student(s) enrolled.");
 	
 	 System.out.print("\n--------------------- Students ---------------------------\n\n");
	 for(int i = 0; i < numberOfStudents; i++) {System.out.print(studentList[i] + " is currently enrolled in " + courseName + "\n\n");}
 }
 public void clear(){studentList = new String [capacity];}
}

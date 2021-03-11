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
	 instructor = "Laura Lo";
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
		 
		 System.out.printf("\n" + student + " was added into " + courseName );
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
	 int found = -1;
	 
	 if(numberOfStudents>0)
	 {
		 for(int i = 0; i < numberOfStudents; i++)
		 {
		 if(studentList[i].equalsIgnoreCase(student))
		 {
		 found = i;
		 System.out.print("\n" + student + " has been dropped from " + getCourseName() + "\n");
		 for(int x = i; x < numberOfStudents; x++){studentList[x] = studentList[x+1];}
		 numberOfStudents = numberOfStudents - 1;
		 }
	 }
		 
	 }
	 else if(numberOfStudents==0) {System.out.printf("\nThere are currently no students.\n");}
	 if(found==-1)  {System.out.printf("\nThere are currently no students with the name. " + student + " found\n");}
	 
 }
 
 public int getNumberOfStudents() {return numberOfStudents;}
 public void Print()
 {
	 for(int i = 0; i < numberOfStudents; i++) {System.out.print(studentList[i] + " was added into " + courseName + " \n");}
	System.out.println();
	System.out.println("--------------------------------------------------------");
	System.out.println("\nCourse Name: " + courseName );
 	System.out.println("\nInstructor Name: " + instructor );
 	System.out.println("\nThere is(are) " + numberOfStudents + " student(s) enrolled.");
 	System.out.println("\nThe list of students:\n");
 	for(int i = 0; i< numberOfStudents; i++) {System.out.println(studentList[i]+ " ");}
 	System.out.println("\nStudents' list after call clear().");
 	System.out.println("\n--------------------------------------------------------");
 	System.out.println("\nCourse Name: " + courseName );
 	System.out.println("\nInstructor Name: " + instructor );
 	System.out.println("\nThere is(are) " + numberOfStudents + " student(s) enrolled.");
 }
 public void clear(){studentList=null;}
}

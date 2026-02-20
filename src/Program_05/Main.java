package Program_05;

import java.util.Scanner;

interface Personal{
	void personalDetails(String name, int age);
}

interface Official {
	void officialDetails(String desgination, String department);
}

class Employee implements Personal, Official{
	
	String Name, Designation, Department;
	int Age;
	
	public void personalDetails(String name, int age) {
		this.Name = name;
		this.Age = age;
	}
	
	public void officialDetails(String designation, String department) {
		this.Designation = designation;
		this.Department = department;
	}
	
	public void display(){
		System.out.println("Name: " +Name);
		System.out.println("Age: " +Age);
		System.out.println("Designation: " +Designation);
		System.out.println("Department: " +Department);
	}
}

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String name, designation, department;
		int age, choice = 0;
		
		Employee obj = new Employee();
		
		do {
			System.out.println("Enter 1 to submit Personal Details");
			System.out.println("Enter 2 to submit Official Details");
			System.out.println("Enter 3 to Display the Details");
			System.out.println("Enter 4 to Exit");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1:
					System.out.println("Enter the Name: ");
					name = sc.next();
					
					System.out.println("Enter the age: ");
					age = sc.nextInt();
										
					obj.personalDetails(name, age);
                    System.out.println("Personal details saved.");
					
					break;
				
				case 2:
					System.out.println("Enter the designation: ");
					designation = sc.next();
					
					System.out.println("Enter the department: ");
					department = sc.next();
					
					
					obj.officialDetails(designation, department);
                    System.out.println("Official details saved.");

					
					break;
					
				case 3:
                    System.out.println("The entire details saved are: ");
                    obj.display();
					
					break;
					
				case 4:
					System.out.println("Thank you for using. Exiting....");
					
					break;
					
				default:
					System.out.println("Enter a valid choice.");
					
					break;
			}
		
		} while (choice != 4);
		
		sc.close();
	}
}

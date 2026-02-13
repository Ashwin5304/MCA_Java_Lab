import java.util.Scanner;

class InvalidAgeException extends Exception{
	InvalidAgeException (String msg) {
		super(msg);
	}
}


public class Main {
	
	public static void validateAge (int age) throws InvalidAgeException{
		if (age < 18) {
			throw new InvalidAgeException ("Age must be greater than 18\n");
		}
		
		System.out.println("Age is valid");
	}
	
	public static void division (int divident, int divisor) {
		if (divisor == 0) {
			throw new ArithmeticException ("Divsor should be greater than 0\n");
		}
		
		System.out.println("Result = " +(divident/divisor));
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int age, choice = 0, divisor, divident;
		
		do {
			System.out.println("Press 1 for Invalid Age Checker");
			System.out.println("Press 2 for Invalid Division Checker");
			System.out.println("Press 3 to Exit\n");
			
			try {
				choice = sc.nextInt();
				switch (choice) {
				
					case 1:
						System.out.println("Enter the age: ");
						age = sc.nextInt();
						
						validateAge(age);
						
						break;
					
					case 2:
						System.out.println("Enter the divident: ");
						divident  = sc.nextInt();
						
						System.out.println("Enter the divisor: ");
						divisor  = sc.nextInt();
						
						division(divident, divisor);
						
						break;
						
					case 3:
						System.out.println("Thank You. Exiting...");
						
						break;
						
					
					default:
						System.out.println("Please enter a valid number");
						
						break;
				
				}
			
			} catch (InvalidAgeException e){
				System.out.println(e.getMessage());
				
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
				
			}	
		} while(choice != 3);
		
		sc.close();
	}
}


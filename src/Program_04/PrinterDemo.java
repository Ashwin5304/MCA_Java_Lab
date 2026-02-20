package Program_04;

import java.util.Scanner;

abstract class Printer {
	abstract void configuration();
	abstract void display();
}

class DotMatrix extends Printer {
	public void configuration() {
		System.out.println("\nconf of dot");
	}
	
	public void display() {
		System.out.println("disp of dot\n");
	}
}

class LaserJet extends Printer {
	public void configuration() {
		System.out.println("\nconf of laser");
	}
	
	public void display() {
		System.out.println("disp of laser\n");
	}
}

public class PrinterDemo {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice;
		Printer p;
		
		do {
			System.out.println("Press 1 to Display and Configuration of DotMatrix");
			System.out.println("Press 2 to Display and Configuration of LaserJet");
			System.out.println("Press 3 to Exit ");
			
			choice = sc.nextInt();
			switch(choice) {
				
				case 1:
					p = new DotMatrix();
					p.display();
					p.configuration();
					break;
						
				case 2:
					p = new LaserJet();
					p.display();
					p.configuration();
					break;
					
				case 3:
					System.out.println("Thanks you. Exiting...");
				
					
				default: 
					System.out.println("Enter a valid choice");
			}
		} while (choice != 3);
		
		sc.close();
	}		
}
import java.util.Scanner;

class Calc {

    // Static Variables
    static int num1;
    static int num2;

    // Instance Variables
    private int a;
    private int b;


    // Parameterized Constructor
    public Calc(int a, int b) {
        this.a = a;   // using 'this'
        this.b = b;
    }

    public int Add() {
        return this.a + this.b;
    }

    public int Sub() {
        return this.a - this.b;
    }

    public int Mul() {
        return this.a * this.b;
    }

    public double Div() {
        if (this.b == 0) {
            System.out.println("Error: Can't be divided by 0");
            return 0;
        }
        return (double) this.a / this.b;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter value for number 1: ");
            Calc.num1 = sc.nextInt();

            System.out.print("Enter value for number 2: ");
            Calc.num2 = sc.nextInt();

            Calc cal = new Calc(Calc.num1, Calc.num2);

            System.out.println("\n--- Calculator ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Result: " + cal.Add());
                    break;

                case 2:
                    System.out.println("Result: " + cal.Sub());
                    break;

                case 3:
                    System.out.println("Result: " + cal.Mul());
                    break;

                case 4:
                    System.out.println("Result: " + cal.Div());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
            sc.close();
        }
    }
}
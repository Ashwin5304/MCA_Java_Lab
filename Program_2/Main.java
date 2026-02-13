import java.util.*;

class BankAccount {

    String name;
    int accountNumber;
    double balance;

    // Static variable to track total accounts
    static int totalAccounts = 0;

    // Default constructor
    BankAccount() {
        name = "Unknown";
        accountNumber = 0;
        balance = 0.0;
        totalAccounts++;
    }

    // Parameterized constructor
    BankAccount(String name, int accNo, double balance) {
        this.name = name;
        this.accountNumber = accNo;
        this.balance = balance;
        totalAccounts++;
    }

    // Deposit method (method overloading)
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " amount deposited successfully.");
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println(amount + " amount deposited (int).");
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println(amount + " amount withdrawn successfully.");
        }
    }

    // Display account details
    void display() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    // Static method to display total accounts created
    static void showTotalAccounts() {
        System.out.println("\nTotal accounts created: " + totalAccounts);
    }
}

public class Main {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        BankAccount obj = null;
        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Show Total Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Account Number: ");
                    int acc = sc.nextInt();

                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();

                    obj = new BankAccount(name, acc, bal);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    if (obj != null) {
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        obj.deposit(dep);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 3:
                    if (obj != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        obj.withdraw(wd);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 4:
                    if (obj != null) {
                        System.out.println("Current Balance: " + obj.balance);
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 5:
                    if (obj != null) {
                        obj.display();
                    } else {
                        System.out.println("Create account first!");
                    }
                    break;

                case 6:
                    BankAccount.showTotalAccounts();
                    break;

                case 7:
                    System.out.println("Thank you for using the bank!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}
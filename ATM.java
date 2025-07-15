import java.util.Scanner;

interface Account {
    public void getBalance();
    public void deposit(int amount);
    public void withdrawal(int amount);
}

class SavingsAccount implements Account {
    private double balance = 10000; // Initial balance
    private final int MIN_WITHDRAW_UNIT = 100;

    @Override
    public void getBalance() {
        System.out.println("A/C Balance: ₹" + balance);
    }

    @Override
    public void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive amount to deposit.");
            return;
        }
        balance += amount;
        System.out.println("You have credited an amount of ₹" + amount + " to your account.");
        System.out.println("A/C Balance: ₹" + balance);
    }

    @Override
    public void withdrawal(int amount) {
        if (amount <= 0) {
            System.out.println("Please enter a positive amount to withdraw.");
            return;
        }

        if (amount <= balance) {
            if (amount % MIN_WITHDRAW_UNIT == 0) {
                balance -= amount;
                System.out.println("You have withdrawn an amount of ₹" + amount + " from your account.");
                System.out.println("A/C Balance: ₹" + balance);
            } else {
                System.out.println("Please enter the amount in multiples of ₹" + MIN_WITHDRAW_UNIT);
            }
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        SavingsAccount myAccount = new SavingsAccount();

        System.out.println("===================================");
        System.out.println("   Welcome to Sample Bank ATM");
        System.out.println("===================================");

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scr.nextInt();

            switch (choice) {
                case 1:
                    myAccount.getBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    int d_amount = scr.nextInt();
                    myAccount.deposit(d_amount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    int w_amount = scr.nextInt();
                    myAccount.withdrawal(w_amount);
                    break;
                case 4:
                    System.out.println("Thank you for using Sample Bank ATM. Have a nice day!");
                    scr.close();
                    System.exit(0); // Exit gracefully
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

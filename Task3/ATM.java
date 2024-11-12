import java.util.Scanner;

public class ATM {
    UserAccountBalance u = new UserAccountBalance();
    Scanner sc = new Scanner(System.in);

    void showServices() {
        System.out.println("Welcome To ATM");
        System.out.println("----------------");
        System.out.println("Our Services");
        System.out.println("------------");
        System.out.println("1. Withdraw Cash.");
        System.out.println("2. Deposit Amount.");
        System.out.println("3. Check Balance.");
        System.out.println("4. Exit.");
        System.out.print("Enter Option: ");
        int opt = sc.nextInt();
        switch (opt) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                exit();
                return;
            default:
                System.out.println("Invalid option. Please try again.");
                System.out.println();
                showServices();
                break;
        }
    }

    void withdraw() {
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        double currentBalance = u.getAccountBalance();
        if (amount <= currentBalance) {
            u.setAccountBalance(currentBalance - amount);
            System.out.println("Withdraw Successful.");
            System.out.print("Would You Like To Display Balance Amount Yes/No: ");
            String res = sc.next();
            if (res.equalsIgnoreCase("yes")) {
                checkBalance();
            } else {
                System.out.println("Thank You Visit Again.");
            }
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    void deposit() {
        System.out.print("Enter Amount: ");
        double deposit = sc.nextDouble();
        if (deposit > 0) {
            double currentBalance = u.getAccountBalance();
            u.setAccountBalance(currentBalance + deposit);
            System.out.println("Deposit Successful!");
            System.out.print("Would You Like To Display Balance Yes/No: ");
            String res = sc.next();
            if (res.equalsIgnoreCase("yes")) {
                checkBalance();
            } else {
                System.out.println("Thank You Visit Again.");
            }
        } else {
            System.out.println("Enter valid Amount.");
        }
    }

    void checkBalance() {
        System.out.println("Your Balance Is: " + u.getAccountBalance());
        exit();
    }

    void exit() {
        System.out.println("Thank You Visit Again.");
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.showServices();
    }
}

class UserAccountBalance {
    private double accountBalance = 1000;

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
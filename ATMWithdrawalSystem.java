import java.util.Scanner;

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    String accountHolderName;
    double accountBalance;

    Account(String name, double balance) {
        accountHolderName = name;
        accountBalance = balance;
    }

    void withdraw(double amount)
            throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive");
        }

        if (amount > accountBalance) {
            throw new InsufficientBalanceException(
                "Insufficient Balance");
        }

        accountBalance -= amount;
        System.out.println("Withdrawal successful.");
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Account a = new Account("Rahul", 10000);

        System.out.print("Enter withdrawal amount: ");
        double amount = sc.nextDouble();

        try {
            a.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(
                "Remaining Balance: " + a.accountBalance);
            sc.close();
        }
    }
}

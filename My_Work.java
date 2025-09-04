// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. Current balance: " + balance);
    }

    // Withdraw method with custom exception
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal failed! Not enough balance.");
        }
        balance -= amount;
        System.out.println(amount + " withdrawn. Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

// Main class
public class My_Work {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Amit", 5000);

        account.deposit(2000);

        try {
            account.withdraw(3000); // यह सही होगा
            account.withdraw(5000); // यहाँ exception आएगी
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}

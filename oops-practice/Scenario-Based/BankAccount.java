public class BankAccount {
    private final String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New balance: " + balance);
    }

    // Withdraw money with overdraft prevention
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New balance: " + balance);
        }
    }

    // Check balance
    public double checkBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC123", 1000.0);

        System.out.println("Account: " + acc.getAccountNumber());
        System.out.println("Initial balance: " + acc.checkBalance());

        acc.deposit(500);      // balance = 1500
        acc.withdraw(200);     
        acc.withdraw(2000);    

        System.out.println("Final balance: " + acc.checkBalance());
    }
}


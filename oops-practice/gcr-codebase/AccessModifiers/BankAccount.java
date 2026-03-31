// Base class
class BankAccount {
    // Access modifiers as required
    public String accountNumber;     // public
    protected String accountHolder;  // protected
    private double balance;          // private

    // Constructor
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter for balance
    public double getBalance() {
        return balance;
    }

    // Public setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Public method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
        System.out.println("---------------------------");
    }
}

// Subclass to demonstrate access to accountNumber and accountHolder
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Can access public accountNumber and protected accountHolder directly
    public void displaySavingsDetails() {
        System.out.println("Savings Account Number : " + accountNumber);  // public
        System.out.println("Savings Account Holder : " + accountHolder); // protected
        System.out.println("Balance                : " + getBalance());
        System.out.println("Interest Rate          : " + interestRate + "%");
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC1001", "Rohan", 15000.0);
        acc.displayAccountDetails();

        SavingsAccount savAcc = new SavingsAccount("SAV2001", "Kiran", 25000.0, 5.5);
        savAcc.displaySavingsDetails();

        // Modify balance using public setter
        savAcc.setBalance(30000.0);
        savAcc.displaySavingsDetails();
    }
}

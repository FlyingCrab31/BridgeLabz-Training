// Loanable interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class with encapsulation
abstract class BankAccount {
    final private String accountNumber;
    final private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters (no public setter for accountNumber to keep it immutable)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Protected setter for subclasses, not for outsiders
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Concrete deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " to " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Concrete withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid amount");
        }
    }

    // Abstract interest calculation
    public abstract double calculateInterest();
}

// SavingsAccount with interest rate
class SavingsAccount extends BankAccount implements Loanable {
    final private double interestRate; // yearly in %

    public SavingsAccount(String accNo, String name, double balance, double interestRate) {
        super(accNo, name, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        System.out.println("Savings interest for " + getAccountNumber() + ": " + interest);
        return interest;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("SavingsAccount " + getAccountNumber() +
                           " applied for loan of " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        // simple rule: eligible if balance >= 20% of requested loan (dummy logic)
        boolean eligible = getBalance() >= 10000;
        System.out.println("SavingsAccount " + getAccountNumber() +
                           " loan eligible: " + eligible);
        return eligible;
    }
}

// CurrentAccount with overdraft
class CurrentAccount extends BankAccount implements Loanable {
    final private double overdraftLimit;

    public CurrentAccount(String accNo, String name, double balance, double overdraftLimit) {
        super(accNo, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        // allow overdraft up to limit
        if (amount > 0 && amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew " + amount + " (with overdraft) from " + getAccountNumber());
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount");
        }
    }

    @Override
    public double calculateInterest() {
        // assume no interest for current accounts
        System.out.println("CurrentAccount " + getAccountNumber() + " has no interest");
        return 0.0;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("CurrentAccount " + getAccountNumber() +
                           " applied for loan of " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        // simple rule: eligible if overdraftLimit is high enough (dummy logic)
        boolean eligible = overdraftLimit >= 5000;
        System.out.println("CurrentAccount " + getAccountNumber() +
                           " loan eligible: " + eligible);
        return eligible;
    }
}

// Demo class
public class BankingSystemDemo {
    public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SA001", "Alice", 20000, 4.5);
        BankAccount acc2 = new CurrentAccount("CA001", "Bob", 5000, 10000);

        // Encapsulation: access via getters, not fields
        System.out.println(acc1.getHolderName() + " balance: " + acc1.getBalance());
        System.out.println(acc2.getHolderName() + " balance: " + acc2.getBalance());

        // Polymorphism: same reference type, different behavior
        BankAccount[] accounts = { acc1, acc2 };
        for (BankAccount acc : accounts) {
            acc.deposit(1000);
            acc.withdraw(2000);
            double interest = acc.calculateInterest(); // dynamic dispatch
            acc.deposit(interest);
            System.out.println("Updated balance of " + acc.getAccountNumber() +
                               ": " + acc.getBalance());
            System.out.println("--------------------");
        }

        // Loanable polymorphism
        Loanable loanAcc1 = (Loanable) acc1;
        Loanable loanAcc2 = (Loanable) acc2;

        loanAcc1.applyForLoan(50000);
        loanAcc1.calculateLoanEligibility();

        loanAcc2.applyForLoan(75000);
        loanAcc2.calculateLoanEligibility();
    }
}

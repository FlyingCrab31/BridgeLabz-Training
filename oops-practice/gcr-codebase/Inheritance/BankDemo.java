class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance       : " + balance);
    }
}
class SavingsAccount extends BankAccount {
    private final double interestRate;   // in percentage, e.g., 4.5

    public SavingsAccount(String accountNumber, double balance,
                          double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type  : Savings Account");
        System.out.println("Interest Rate : " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private final double withdrawalLimit;  // per day, for example

    public CheckingAccount(String accountNumber, double balance,
                           double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayAccountType() {
        System.out.println("Account Type     : Checking Account");
        System.out.println("Withdrawal Limit : " + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    private final  int tenureMonths;     // lock-in period
    private final double interestRate;  // fixed deposit rate

    public FixedDepositAccount(String accountNumber, double balance,
                               int tenureMonths, double interestRate) {
        super(accountNumber, balance);
        this.tenureMonths = tenureMonths;
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.println("Account Type  : Fixed Deposit Account");
        System.out.println("Tenure (months): " + tenureMonths);
        System.out.println("Interest Rate : " + interestRate + "%");
    }
}
public class BankDemo {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA101", 15000.0, 4.5);
        CheckingAccount ca = new CheckingAccount("CA201", 8000.0, 20000.0);
        FixedDepositAccount fda = new FixedDepositAccount("FD301", 50000.0, 12, 6.75);

        sa.displayDetails();
        sa.displayAccountType();

        System.out.println();

        ca.displayDetails();
        ca.displayAccountType();

        System.out.println();

        fda.displayDetails();
        fda.displayAccountType();
    }
}



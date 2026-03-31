package BankAccountHeirarchy;

abstract class BankAccount {
    private final String accountNumber;
    private final double balance;

    protected BankAccount(String accountNumber, double balance) {
        // basic null check to keep core data valid
        if (accountNumber == null) {
            throw new IllegalArgumentException("accountNumber cannot be null");
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // polymorphic fee calculation
    public abstract double calculateFee();
}

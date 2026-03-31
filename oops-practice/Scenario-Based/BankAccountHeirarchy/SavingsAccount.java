package BankAccountHeirarchy;

final class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        // 0.5% of balance → 0.005 * balance
        // Uses primitive double only, no extra objects.
        return getBalance() * 0.005;
    }
}

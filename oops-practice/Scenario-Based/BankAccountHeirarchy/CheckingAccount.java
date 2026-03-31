package BankAccountHeirarchy;

final class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public double calculateFee() {
        double bal = getBalance();    // local primitive for slight perf gain
        if (bal < 1000.0) {
            return 1.0;               // flat fee
        }
        return 0.0;
    }
}

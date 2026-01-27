package bankaccount;

public class BankAccount{

    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public void withdrawl(double amount) throws InsufficientBalanceException{

        if(amount <0){
            throw new IllegalArgumentException("Invalid amount!");
        }

        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance = balance-amount;
        System.out.println("Withdrawl successful");
        System.out.println("New balance: " + balance);
    }
}
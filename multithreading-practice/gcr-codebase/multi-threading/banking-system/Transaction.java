import java.time.LocalDateTime;

public class Transaction implements Runnable{

    
    private BankAccount account;

    
    private String customerName;
    private int amount;

     public Transaction(BankAccount account, String customerName, int amount) {
        this.account = account;

        this.customerName = customerName;

        this.amount = amount;
    }

    @Override

    public void run(){
        System.out.println("Thread state befor processing ["+ Thread.currentThread().getName() + "]: " +
                Thread.currentThread().getState());

        LocalDateTime time = LocalDateTime.now();

        boolean success = account.withdraw(customerName, amount);

        System.out.println("[" + customerName + "] Time: " + time +
                " | Status: " + (success ? "SUCCESS" : "FAILED"));
    }
}
public class BankAccount{

    
    private int balance=10000;

    
    public synchronized boolean withdraw(String customer, int amount){
        System.out.println("["+customer+"] Attempting to withdraw "+amount );

        if(balance>=amount){
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            balance=balance-amount;
            System.out.println("Transaction successful: "+customer+", Amount: " + amount +
                    ", Balance: " + balance);

                    return true;
        }else{
            System.out.println("Transaction failed: " + customer +
                    ", Insufficient Balance");
            return false;
        }


    }

    public int getBalance(){
        return balance;
    }
}
public class BankingMain{
    public static void main(String args[]){

        
        BankAccount account=new BankAccount();

        
        Thread t1=new Thread(
            new Transaction(account, "Customer-1", 3000),
            "Customer-1"
        );
         Thread t2=new Thread(
            new Transaction(account, "Customer-3", 4000),
            "Customer-2"
        );
         Thread t3=new Thread(
            new Transaction(account, "Customer-3", 2000),
            "Customer-3"
        );
         Thread t4=new Thread(
            new Transaction(account, "Customer-4", 5000),
            "Customer-4"
        );
         Thread t5=new Thread(
            new Transaction(account, "Customer-5", 3500),
            "Customer-5"
        );

        System.out.println("Thread states before start: ");
        System.out.println(t1.getName()+": "+t1.getState());
        System.out.println(t2.getName()+": "+t2.getState());
        System.out.println(t3.getName()+": "+t3.getState());
        System.out.println(t4.getName()+": "+t4.getState());
        System.out.println(t5.getName()+": "+t5.getState());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
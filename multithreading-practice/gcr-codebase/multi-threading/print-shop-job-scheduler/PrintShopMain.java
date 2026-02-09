public class PrintShopMain{

    
    public static void main(String args[]) throws InterruptedException{

        long startTime=System.currentTimeMillis();

        
         System.out.println("Starting print jobs...");

         PrintJob j1=new PrintJob("Job1",10,5);
         PrintJob j2=new PrintJob("Job2",5,8);
         PrintJob j3=new PrintJob("Job3",15,3);
         PrintJob j4=new PrintJob("Job4",8,6);
         PrintJob j5=new PrintJob("Job5",12,7);


         Thread t1 = new Thread(j1, "Printer-Job1");
         Thread t2 = new Thread(j2, "Printer-Job2");
         Thread t3 = new Thread(j3, "Printer-Job3");
         Thread t4 = new Thread(j4, "Printer-Job4");
         Thread t5 = new Thread(j5, "Printer-Job5");

          t1.setPriority(j1.getPriority());
           t2.setPriority(j2.getPriority());
            t3.setPriority(j3.getPriority());
             t4.setPriority(j4.getPriority());
              t5.setPriority(j5.getPriority());

              t1.start();
              t2.start();
              t3.start();
              t4.start();
              t5.start();

              t1.join();
              t2.join();
              t3.join();
              t4.join();
              t5.join();

              long endTime = System.currentTimeMillis();
                System.out.println("\nAll jobs completed in "+(endTime-startTime)+" ms");
    
    }

}
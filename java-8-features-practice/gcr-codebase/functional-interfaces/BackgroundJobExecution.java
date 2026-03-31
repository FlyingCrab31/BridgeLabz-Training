import java.util.*;

public class BackgroundJobExecution{

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of steps for background task: ");
        int steps=sc.nextInt();

        Runnable task=()->
        {
            System.out.println("Background task started...");
            for(int i=1;i<=steps;i++){
                System.out.println("Processing step "+i);
            }
            System.out.println("Task completed");
        };

        Thread thread=new Thread(task);

        thread.start();
        System.out.println("Main thread continues...");

    }
}
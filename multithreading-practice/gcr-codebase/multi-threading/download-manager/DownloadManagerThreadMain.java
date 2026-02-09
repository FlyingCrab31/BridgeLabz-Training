import java.util.*;
public class DownloadManagerThreadMain{

    
    public static void main(String args[]) throws InterruptedException{

        
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 3 file name to download: ");
        System.out.println("File 1: ");
         String file1 = sc.nextLine();


        System.out.print("File 2: ");
        String file2 = sc.nextLine();


        System.out.print("File 3: ");
        String file3 = sc.nextLine();

        FileDownloadThread t1=new FileDownloadThread(file1);
         FileDownloadThread t2=new FileDownloadThread(file2);
          FileDownloadThread t3=new FileDownloadThread(file3);

          t1.start();
           t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            System.out.println("All downloads completed");

    }
}
import java.util.*;
public class FileDownloadThread extends Thread{

    
    private String filename;

    
    public FileDownloadThread(String filename){
        this.filename=filename;
    }

    @Override

    public void run(){
        Random random=new Random();

        for(int progress =0;progress<=100;progress=progress+25){
            try{
                Thread.sleep(random.nextInt(500)+200);

            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("["+Thread.currentThread().getName()+"] Downloading "+filename+": "+progress+"%");
        }
    }
}
public class TaskRunner extends Thread{
    public TaskRunner(String name){
        super(name);
    }

    
    @Override
    

    public void run(){
        for(int i=0;i<1000000;i++){
            Math.sqrt(i);
        }

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class TaskService{

    @LogExecutionTime
    public void fastTask(){
        for(int i = 0; i<100000; i++){

        }
    }

    @LogExecutionTime

    public void slowTask(){
       try{
        Thread.sleep(500);
       }catch(InterruptedException e){
        e.printStackTrace();
       }
    
    }

    public void normalTask(){
        System.out.println("Normal task");
    }
}
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;


public class StateMonitor extends Thread{

    
    private Thread[] threads;
    private Map<String,Integer> stateCount=new HashMap<>();

    public StateMonitor(Thread[] threads){
        this.threads=threads;
    }


    @Override

    public void run(){
        boolean allTerminated=false;

        while(!allTerminated){
            allTerminated=true;


            for(Thread t:threads){
                Thread.State state=t.getState();
                String time=LocalTime.now().toString();

                System.out.println("[Monitor] "+t.getName()+" is in "+state+" state at "+time);

                stateCount.put(t.getName(),
            stateCount.getOrDefault(t.getName(),0)+1);

            if(state !=Thread.State.TERMINATED){
                allTerminated = false;
            }
            }

            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

        }

         
        for (Map.Entry<String, Integer> entry : stateCount.entrySet()) {
            
            System.out.println("Summary: " + entry.getKey() +
                    " state checks observed: " + entry.getValue());
        }
    }
}
public class Chef extends Thread{
    private String dish;
    private int totalTime;

    
    
    public Chef(String chefName,String dish, int totalTime){
        super(chefName);
        this.dish = dish;
        this.totalTime = totalTime;
    }
        @Override

        public void run(){
            System.out.println(getName()+" started preparing "+dish);

            int[] progress={25,50,75,100};
            int sleepTime=totalTime/progress.length;

            for(int p:progress){
                try{
                    Thread.sleep(sleepTime);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

               System.out.println(getName() + " preparing " + dish +
                    ": " + p + "% complete");
        }

        System.out.println(getName() + " finished preparing " + dish);
                
            }
        }


    

public class TaskManager{

    @ImportantMethod

    public void performTask() {
        System.out.println("Task is being performed");
    }

    @ImportantMethod(level = "MEDIUM")
    public void reviewTask(){
        System.out.println("Task is being reviewed");
    
    }

    public void minorTask(){
        System.out.println("Minor task is being performed");
    
    }

}
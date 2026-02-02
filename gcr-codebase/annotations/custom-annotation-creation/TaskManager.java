public class TaskManager{

    @TaskInformation(priority = "High", assignedTo = "Rishabh",status = "In Progress")
    public void performTask(){
        System.out.println("Performing task...");
    
    }

    @TaskInformation(priority = "Medium", assignedTo="Surya",status="Pending")
    public void reviewTask(){
        System.out.println("Reviewing task");
    
    }

    public void addTask(String taskName, String priority, String assignedTo, String status){
        System.out.println("Adding task: " + taskName);
        System.out.println("Priority: " + priority);
        System.out.println("Assigned to: " + assignedTo);
        System.out.println("Status: " + status);
        System.out.println();
    

    }


}
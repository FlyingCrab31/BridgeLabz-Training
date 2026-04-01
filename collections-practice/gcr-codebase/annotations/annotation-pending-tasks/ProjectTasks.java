public class ProjectTasks{

    @Todo(task = "Complete project documentation", assignedTo = "Riddhi")
    public void completeDocumentation() {
       System.out.println("Documentation completed");
    
    }

     @Todo(task = "Login Feature Implementation", assignedTo = "Surya", priority = "High")
     public void loginFeature(){
        System.out.println("Login feature pending...");
     
     }
      @Todo(task = "Creating User dashboard", assignedTo = "Ritika")
     public void userDashBoard(){
        System.out.println("User Dashboard Pending...");
     
     }

     public void completedFeature(){
        System.out.println("Feature completed successfully...");
     }

}
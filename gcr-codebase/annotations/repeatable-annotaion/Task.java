public class Task{

    @BugReport(description = "Bug 1: Login Page not working")
    @BugReport(description = "Bug 2:  UI unresponsive")
    public void executeTask() {
        System.out.println("Executing task...");
    }
}
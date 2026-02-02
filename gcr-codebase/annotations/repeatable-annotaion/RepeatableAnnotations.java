import java.lang.reflect.Method;

public class RepeatableAnnotations{

    public static void main(String[] args) throws Exception{
        Task task=new Task();
        Method method=Task.class.getMethod("executeTask");

        BugReport[] bugReports=method.getAnnotationsByType(BugReport.class);

        System.out.println("Bug Reports:");
        for(BugReport bugReport:bugReports){
            System.out.println(" - "+bugReport.description());
        }

        method.invoke(task);
    
    


    }
}
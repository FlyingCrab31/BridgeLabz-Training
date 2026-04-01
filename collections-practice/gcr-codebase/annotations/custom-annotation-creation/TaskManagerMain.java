import java.lang.reflect.Method;
import java.util.*;

public class TaskManagerMain {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        TaskManager manager = new TaskManager();

        Method[] methods = TaskManager.class.getDeclaredMethods();
        System.out.println("Available methods:");
        for(Method method : methods){
            if(method.isAnnotationPresent(TaskInformation.class)){
                TaskInformation info = method.getAnnotation(TaskInformation.class);
                System.out.println("Method: "+method.getName());
                System.out.println("Priority: " + info.priority());
                System.out.println("Assigned to: " + info.assignedTo());
                System.out.println("Status: " + info.status());
                method.invoke(manager);
                System.out.println();
            }

            }

            System.out.println("Enter number of tasks: ");
            int numTasks = sc.nextInt();
            sc.nextLine();

            for(int i = 0; i < numTasks; i++){
                System.out.println("Enter task name: ");
                String taskName = sc.nextLine();

                System.out.println("Enter priority: ");
                String priority = sc.nextLine();

                System.out.println("Enter assigned to: ");
                String assignedTo = sc.nextLine();

                System.out.println("Enter status: ");
                String status = sc.nextLine();

                manager.addTask(taskName, priority, assignedTo, status);
            }





    }
}


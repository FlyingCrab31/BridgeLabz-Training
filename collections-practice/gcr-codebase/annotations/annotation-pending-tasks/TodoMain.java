import java.lang.reflect.Method;

public class TodoMain{

    public static void main(String args[]) throws Exception{
        ProjectTasks project = new ProjectTasks();

        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        for(Method method:methods){
            if(method.isAnnotationPresent(Todo.class)){
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method Name: "+method.getName());
                System.out.println("Task: "+todo.task());
                System.out.println("Assigned To: "+todo.assignedTo());
                System.out.println("Priority: "+todo.priority());
                System.out.println();

                method.invoke(project);
                System.out.println();
            }

        }
    
    }
}
import java.lang.reflect.Method;

public class LogExecutionMain{
    public static void main(String[] args) throws Exception {
        TaskService service = new TaskService();
        Method[] methods = TaskService.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long start = System.nanoTime();
                
                method.invoke(service);
                
                long end = System.nanoTime();
                System.out.println("Method " + method.getName() + " executed in: " + (end - start) + " ns");
            } else {
                method.invoke(service);
            }
        }
    }

}
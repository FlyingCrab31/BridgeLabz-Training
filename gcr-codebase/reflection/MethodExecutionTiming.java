
/*Method Execution Timing: Use Reflection to measure the execution time of methods in a given class dynamically.*/
import java.lang.reflect.Method;

public class MethodExecutionTiming {

    public void task() throws InterruptedException {
        Thread.sleep(400);
    }

    public static void main(String[] args) throws Exception {

        MethodExecutionTiming obj = new MethodExecutionTiming();
        Method m = MethodExecutionTiming.class.getMethod("task");

        long start = System.currentTimeMillis();
        m.invoke(obj);
        long end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start) + " ms");
    }
}


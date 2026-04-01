/*Custom Logging Proxy Using Reflection: Implement a Dynamic Proxy that intercepts method calls on an interface (e.g., Greeting.sayHello()) and logs the method name before executing it.
 */
import java.lang.reflect.*;

public class LoggingProxyUsingReflection{

    interface Greeting {
        void sayHello();
    }

    static class GreetingImpl implements Greeting {
        public void sayHello() {
            System.out.println("Hello!");
        }
    }

    public static void main(String[] args) {

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                (p, m, a) -> {
                    System.out.println("Calling: " + m.getName());
                    return m.invoke(new GreetingImpl(), a);
                });

        proxy.sayHello();
    }
}

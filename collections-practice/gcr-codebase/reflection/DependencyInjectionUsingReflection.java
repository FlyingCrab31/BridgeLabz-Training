
/*Dependency Injection using Reflection: Implement a simple DI container that scans classes with @Inject annotation and injects dependencies dynamically.
 */
import java.lang.annotation.*;
import java.lang.reflect.Field;

public class DependencyInjectionUsingReflection {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Inject {}

    static class Service {
        void work() { System.out.println("Service working"); }
    }

    static class Client {
        @Inject
        Service service;
    }

    public static void main(String[] args) throws Exception {

        Client c = new Client();

        for (Field f : Client.class.getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(c, f.getType().getDeclaredConstructor().newInstance());
            }
        }
        c.service.work();
    }
}

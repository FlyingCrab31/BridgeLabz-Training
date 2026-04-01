import java.lang.reflect.Method;

public class ImportantMethodMain{
    public static void main(String[] args) throws Exception{
        TaskManager manager=new TaskManager();
        Method[] methods=TaskManager.class.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod importantMethod = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Level: " + importantMethod.level() );
                method.invoke(manager);
                System.out.println();
            }
        }
    }

}
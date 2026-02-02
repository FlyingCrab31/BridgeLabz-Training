import java.lang.reflect.Method;

public class CacheMain{
    public static void main(String args[]) throws Exception{
        MathsService service = new MathsService();
        Method method = MathsService.class.getMethod("factorial",int.class);
        System.out.println(CacheManager.invoke(service, method, 5));
        System.out.println(CacheManager.invoke(service, method, 5));
        System.out.println(CacheManager.invoke(service, method, 6));
        System.out.println(CacheManager.invoke(service, method, 6));

    }
}
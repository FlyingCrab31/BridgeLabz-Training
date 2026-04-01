import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheManager{

    private static final Map<String,Object> cache=new HashMap<>();
    public static Object invoke(Object target, Method method, Object... args)throws Exception{

        String key = method.getName()+"_"+args[0];
        if(method.isAnnotationPresent(CacheResult.class )){
            if(cache.containsKey(key)){
                 System.out.println("Returning cached result for " + key);
                return cache.get(key);
            }
        Object result = method.invoke(target,args);
        cache.put(key,result);
        return result;
        
        }
        return method.invoke(target,args);
    
    }

}

/*Create a Custom Object Mapper: Implement a method toObject(Class<T> clazz, Map<String, Object> properties) that uses Reflection to set field values from a given Map.
 */

import java.lang.reflect.Field;
import java.util.*;

public class CustomObjectMapper {

    static class Student {
        public int id;
        public String name;
    }

    public static <T> T toObject(Class<T> clazz, Map<String,Object> map)
            throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();
        for (String key : map.keySet()) {
            Field f = clazz.getDeclaredField(key);
            f.setAccessible(true);
            f.set(obj, map.get(key));
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {

        Map<String,Object> data = new HashMap<>();
        data.put("id", 1);
        data.put("name", "Anushka");

        Student s = toObject(Student.class, data);
        System.out.println(s.id + " " + s.name);
    }
}

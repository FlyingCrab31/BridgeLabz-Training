
/*Generate a JSON Representation: Write a program that converts an object to a JSON-like string using Reflection by inspecting its fields and values.
 */
import java.lang.reflect.Field;

public class JsonGeneratorDemo {

    static class Student {
        int id = 1;
        String name = "Neha";
    }

    public static void main(String[] args) throws Exception {

        Student s = new Student();
        StringBuilder json = new StringBuilder("{");

        for (Field f : s.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            json.append("\"").append(f.getName()).append("\":\"")
                .append(f.get(s)).append("\",");
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");

        System.out.println(json);
    }
}


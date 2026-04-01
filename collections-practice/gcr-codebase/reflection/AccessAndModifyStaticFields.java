/*Access and Modify Static Fields: Create a Configuration class with a private static field API_KEY. Use Reflection to modify its value and print it.
 */

import java.lang.reflect.Field;

public class AccessAndModifyStaticFields {

    static class Configuration {
        private static String API_KEY = "OLD_KEY";
    }

    public static void main(String[] args) throws Exception {

        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);
        f.set(null, "NEW_KEY");

        System.out.println("API_KEY updated");
    }
}


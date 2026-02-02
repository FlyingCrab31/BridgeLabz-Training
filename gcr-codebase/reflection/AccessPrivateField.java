/*Access Private Field: Create a class Person with a private field age. Use Reflection to modify and retrieve its value.
 */

import java.lang.reflect.Field;

public class AccessPrivateField {

    static class Person {
        private int age = 20;
    }

    public static void main(String[] args) throws Exception {

        Person p = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        field.set(p, 25);
        System.out.println("Age = " + field.get(p));
    }
}

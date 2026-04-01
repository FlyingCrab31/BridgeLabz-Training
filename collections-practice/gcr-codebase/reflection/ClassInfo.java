
/*Get Class Information: Write a program to accept a class name as input and display its methods, fields, and constructors using Reflection. */
import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = sc.nextLine();

        Class<?> clazz = Class.forName(className);

        System.out.println("\nFields:");
        for (Field f : clazz.getDeclaredFields())
            System.out.println(f);

        System.out.println("\nConstructors:");
        for (Constructor<?> c : clazz.getDeclaredConstructors())
            System.out.println(c);

        System.out.println("\nMethods:");
        for (Method m : clazz.getDeclaredMethods())
            System.out.println(m);
    }
}

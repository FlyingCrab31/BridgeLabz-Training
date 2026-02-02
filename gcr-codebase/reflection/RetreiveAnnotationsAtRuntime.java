
/*Retrieve Annotations at Runtime: Create a custom annotation @Author(name="Author Name"). Apply it to a class and use Reflection to retrieve and display the annotation value at runtime.
 */
import java.lang.annotation.*;

public class RetreiveAnnotationsAtRuntime {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Author {
        String name();
    }

    @Author(name = "Anushka")
    static class Book {}

    public static void main(String[] args) {
        Author a = Book.class.getAnnotation(Author.class);
        System.out.println("Author: " + a.name());
    }
}

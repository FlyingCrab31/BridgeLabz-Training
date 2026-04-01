
/*Dynamic Method Invocation: Define a class MathOperations with multiple public methods (add, subtract, multiply). Use Reflection to dynamically call any method based on user input.
 */
import java.lang.reflect.Method;
import java.util.Scanner;
public class DynamicMethodInvocation {
    static class MathOperations{
        public int add(int a , int b ){
            return  a+b;
        }
        public int subtract(int a , int b){
            return a-b;
        }
        public int multiply(int a, int b){
            return a*b;

        }
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Method Name : ");
            String name = sc.next();

            MathOperations obj = new MathOperations();
            Method method = MathOperations.class.getMethod(name, int.class, int.class);

            System.out.println("Result = " + method.invoke(obj, 10, 5));

            
        }
    }
    
}

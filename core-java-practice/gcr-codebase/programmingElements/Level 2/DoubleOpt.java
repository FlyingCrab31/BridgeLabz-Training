import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Double a = sc.nextDouble();

        Double b = sc.nextDouble();

        Double c = sc.nextDouble();
        
        Double result1 = a + b * c;
        Double result2 = a * b + c;
        Double result3 = c + a / b;
        Double result4 = a % b + c;

        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);
    }
}

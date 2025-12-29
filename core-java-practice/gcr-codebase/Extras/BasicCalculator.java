import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Choose operation: +  -  *  /");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+' -> System.out.println("Result: " + add(a, b));
            case '-' -> System.out.println("Result: " + subtract(a, b));
            case '*' -> System.out.println("Result: " + multiply(a, b));
            case '/' -> {
                if (b == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    System.out.println("Result: " + divide(a, b));
                }
            }
            default -> System.out.println("Invalid operation.");
        }
    }

    static double add(double x, double y) { return x + y; }
    static double subtract(double x, double y) { return x - y; }
    static double multiply(double x, double y) { return x * y; }
    static double divide(double x, double y) { return x / y; }
}

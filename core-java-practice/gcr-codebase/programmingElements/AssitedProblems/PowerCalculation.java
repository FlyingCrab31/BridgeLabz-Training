import java.util.Scanner;

// Program to calculate power using Math.pow()
public class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking base input
        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        // Taking exponent input
        System.out.print("Enter exponent: ");
        double exponent = sc.nextDouble();

        // Power calculation
        double result = Math.pow(base, exponent);

        // Printing result
        System.out.println("Result: " + result);

        sc.close();
    }
}

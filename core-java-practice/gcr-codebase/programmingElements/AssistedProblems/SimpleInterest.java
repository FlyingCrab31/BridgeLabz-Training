import java.util.Scanner;

// Program to calculate simple interest
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking principal input
        System.out.print("Enter Principal: ");
        double principal = sc.nextDouble();

        // Taking rate input
        System.out.print("Enter Rate of Interest: ");
        double rate = sc.nextDouble();

        // Taking time input
        System.out.print("Enter Time: ");
        double time = sc.nextDouble();

        // Simple Interest formula
        double simpleInterest = (principal * rate * time) / 100;

        // Printing result
        System.out.println("Simple Interest: " + simpleInterest);

        sc.close();
    }
}

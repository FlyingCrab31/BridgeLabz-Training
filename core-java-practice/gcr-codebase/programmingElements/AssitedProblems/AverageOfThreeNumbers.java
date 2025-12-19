import java.util.Scanner;

// Program to calculate average of three numbers
public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking three numbers as input
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter third number: ");
        double num3 = sc.nextDouble();

        // Calculating average
        double average = (num1 + num2 + num3) / 3;

        // Printing result
        System.out.println("Average: " + average);

        sc.close();
    }
}

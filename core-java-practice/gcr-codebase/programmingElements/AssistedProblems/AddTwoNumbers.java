import java.util.Scanner;

// Program to add two numbers
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking first number as input
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        // Taking second number as input
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Calculating sum
        int sum = num1 + num2;

        // Printing result
        System.out.println("Sum = " + sum);

        sc.close();
    }
}

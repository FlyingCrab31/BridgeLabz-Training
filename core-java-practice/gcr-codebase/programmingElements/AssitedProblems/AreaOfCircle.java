import java.util.Scanner;

// Program to calculate area of a circle
public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking radius input
        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();

        // Area formula
        double area = Math.PI * radius * radius;

        // Printing result
        System.out.println("Area of the circle: " + area);

        sc.close();
    }
}

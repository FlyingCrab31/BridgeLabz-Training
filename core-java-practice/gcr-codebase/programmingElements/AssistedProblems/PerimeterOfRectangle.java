import java.util.Scanner;

// Program to calculate perimeter of a rectangle
public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking length input
        System.out.print("Enter length: ");
        double length = sc.nextDouble();

        // Taking width input
        System.out.print("Enter width: ");
        double width = sc.nextDouble();

        // Perimeter formula
        double perimeter = 2 * (length + width);

        // Printing result
        System.out.println("Perimeter of the rectangle: " + perimeter);

        sc.close();
    }
}

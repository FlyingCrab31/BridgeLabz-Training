import java.util.Scanner;

// Program to convert Celsius to Fahrenheit
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking Celsius input
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        // Conversion formula
        double fahrenheit = (celsius * 9 / 5) + 32;

        // Printing result
        System.out.println("Temperature in Fahrenheit: " + fahrenheit);

        sc.close();
    }
}

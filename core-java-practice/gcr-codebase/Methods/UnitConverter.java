import java.util.Scanner;

public class UnitConverter{
    // Method to convert kilometers to miles
    public static double convertKmToMiles(double km){
        return km * 0.621371;
    }
    public static double convertMilesToKm(double Miles){
        return Miles / 0.621371;
    }
    public static double convertMetersToFeet(double m)  {
        return m * 3.28084;

    }
    public static double convertFeetToMeters(double feet) {
        return feet / 3.28084;
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter distance in kilometers:");
        double km = sc.nextDouble();
        System.out.printf("%.2f kilometers is equal to %.2f miles.\n", km, convertKmToMiles(km));

        System.out.println("Enter distance in miles:");
        double miles = sc.nextDouble();
        System.out.printf("%.2f miles is equal to %.2f kilometers.\n", miles, convertMilesToKm(miles));

        System.out.println("Enter distance in meters:");
        double meters = sc.nextDouble();
        System.out.printf("%.2f meters is equal to %.2f feet.\n", meters, convertMetersToFeet(meters));

        System.out.println("Enter distance in feet:");
        double feet = sc.nextDouble();
        System.out.printf("%.2f feet is equal to %.2f meters.\n", feet, convertFeetToMeters(feet));
    }
}
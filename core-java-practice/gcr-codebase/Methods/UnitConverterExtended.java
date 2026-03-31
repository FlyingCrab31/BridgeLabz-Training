import java.util.Scanner;

public class UnitConverterExtended{
    public static double convertYardsToFeet(double yards) {
        return yards * 3.0;
    }
    public static double convertFeetToYards(double Feet){
        return Feet / 3.0;
    }
    //Method to convert meters to inches and return the value
    public static double convertMetersToInches(double meters) {
        return meters * 39.3701;
    }
    //Method to convert inches to meters and return the value
    public static double convertInchesToMeters(double inches) {
        return inches / 39.3701;
    }
    //Method to convert Inches to centimeters and return the value
    public static double convertInchesToCentimeters(double inches) {
        return inches * 2.54;
    }
    public static double convertFarhenheitToCelsius(double farhenheit){
        return (farhenheit - 32) * 5.0 / 9.0;
    }
    public static double convertCelsiusToFarhenheit(double celsius){
        return (celsius * 9.0 / 5.0) + 32;
    }
    //Method to convert pounds to kilograms and return the value
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }
    //Method to convert kilograms to pounds and return the value
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms / 0.453592;
    }
    //Method to convert gallons to liters and return the value.
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }
    //Method to convert liters to gallons and return the value.
    public static double convertLitersToGallons(double liters) {
        return liters / 3.78541;
    }
    //Main method to test the conversion methods
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter yards to convert to feet: ");
        double yards = scanner.nextDouble();
        System.out.println(yards + " yards = " + convertYardsToFeet(yards) + " feet");

        System.out.print("Enter feet to convert to yards: ");
        double feet = scanner.nextDouble();
        System.out.println(feet + " feet = " + convertFeetToYards(feet) + " yards");

        System.out.print("Enter meters to convert to inches: ");
        double meters = scanner.nextDouble();
        System.out.println(meters + " meters = " + convertMetersToInches(meters) + " inches");

        System.out.print("Enter inches to convert to meters: ");
        double inches = scanner.nextDouble();
        System.out.println(inches + " inches = " + convertInchesToMeters(inches) + " meters");

        System.out.print("Enter inches to convert to centimeters: ");
        inches = scanner.nextDouble();
        System.out.println(inches + " inches = " + convertInchesToCentimeters(inches) + " centimeters");

        System.out.print("Enter Fahrenheit to convert to Celsius: ");
        double fahrenheit = scanner.nextDouble();
        System.out.println(fahrenheit + " °F = " + convertFarhenheitToCelsius(fahrenheit) + " °C");

        System.out.print("Enter Celsius to convert to Fahrenheit: ");
        double celsius = scanner.nextDouble();
        System.out.println(celsius + " °C = " + convertCelsiusToFarhenheit(celsius) + " °F");

        System.out.print("Enter pounds to convert to kilograms: ");
        double pounds = scanner.nextDouble();
        System.out.println(pounds + " pounds = " + convertPoundsToKilograms(pounds) + " kilograms");

        System.out.print("Enter kilograms to convert to pounds: ");
        double kilograms = scanner.nextDouble();
        System.out.println(kilograms + " kilograms = " + convertKilogramsToPounds(kilograms) + " pounds");

        System.out.print("Enter gallons to convert to liters: ");
        double gallons = scanner.nextDouble();
        System.out.println(gallons + " gallons = " + convertGallonsToLiters(gallons) + " liters");

        System.out.print("Enter liters to convert to gallons: ");


}
}
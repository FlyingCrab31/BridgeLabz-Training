import java.util.Scanner;

public class WindChillTemp{

    // Method to calculate wind chill temperature
    private static double calculateWindChill(double temperature, double windSpeed){
        double windChill = 35.74 + (0.6215 * temperature) - (35.75 * Math.pow(windSpeed, 0.16)) + (0.4275 * temperature * Math.pow(windSpeed, 0.16));
        return windChill;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double temperature = sc.nextDouble();
        double windSpeed = sc.nextDouble();
        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("Wind Chill Temperature: %.2f\n", windChill);
    }
}   
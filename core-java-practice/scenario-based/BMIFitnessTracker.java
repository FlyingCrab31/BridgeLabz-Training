import java.util.Scanner;

public class BMIFitnessTracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println(" Maya's BMI Fitness Tracker ");
        
        // height in meters...
        System.out.print("Enter your height (in meters): ");
        double height = scanner.nextDouble();
        
        // weight in kilograms
        System.out.print("Enter your weight (in kilograms): ");
        double weight = scanner.nextDouble();
        
        // Calculate BMI using the formula...
        double bmi = weight / (height * height);
        
        // Display BMI value till 2 decimals...
        System.out.printf("Your BMI: %.2f", bmi);
        
        // BMI Categories defined :
        
        if (bmi < 18.5) {
            System.out.println(" Underweight");
        } 
        else if (bmi >= 18.5 && bmi < 25) {
            System.out.println(" Normal");
        } 
        else {
            System.out.println(" Overweight");
        }
        
        scanner.close();
    }
}

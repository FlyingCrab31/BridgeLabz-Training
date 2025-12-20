import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // a. Take input for number of persons
        System.out.print("Enter number of persons: ");
        int numPersons = sc.nextInt();
        
        // b. Create arrays to store weight, height, BMI, and status
        double[] weights = new double[numPersons];
        double[] heights = new double[numPersons];
        double[] bmis = new double[numPersons];
        String[] statuses = new String[numPersons];
        
        // c. Take input for weight and height
        for (int i = 0; i < numPersons; i++) {
            System.out.println("Person " + (i + 1) + ":");
            System.out.print("  Enter weight (in kg): ");
            weights[i] = sc.nextDouble();
            
            System.out.print("  Enter height (in meters): ");
            heights[i] = sc.nextDouble();
        }
        
        // d. Calculate BMI and determine status
        for (int i = 0; i < numPersons; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);
            
            // f. Determine status based on BMI
            if (bmis[i] < 18.5) {
                statuses[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] < 25) {
                statuses[i] = "Normal Weight";
            } else if (bmis[i] >= 25 && bmis[i] < 30) {
                statuses[i] = "Overweight";
            } else {
                statuses[i] = "Obese";
            }
        }
        
        // e. Display results
        System.out.println(" BMI REPORT ");
        System.out.printf("%-8s %-10s %-10s %-10s %-15s%n",
                         "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < numPersons; i++) {
            System.out.printf("%-8d %-10.2f %-10.2f %-10.2f %-15s", 
                             (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
        }
        
        sc.close();
    }
}
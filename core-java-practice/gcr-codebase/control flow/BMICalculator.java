import java.util.Scanner;

class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double weight = sc.nextDouble();  // in kg
        double heightCm = sc.nextDouble();  // in cm
        
        double heightM = heightCm / 100.0;  // convert cm to meter
        double bmi = weight / (heightM * heightM);

        String status;
        
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            status = "Normal weight";
        } else if (bmi >= 25.0 && bmi < 29.9) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        System.out.println("BMI: " + bmi);
        System.out.println("Status: " + status);

        sc.close();
    }
}

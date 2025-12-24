import java.util.Scanner;

public class BMICalculator {

    // weight (kg), height (cm) -> BMI
    public static double calculateBMI(double weightKg, double heightCm) {
        double heightMeters = heightCm / 100.0;
        return weightKg / (heightMeters * heightMeters);
    }

    // simple BMI status method (adjust ranges as per your figure)
    public static String findBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void fillBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            data[i][2] = calculateBMI(weight, height);
        }
    }

    public static String[] generateBMIStatusArray(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            status[i] = findBMIStatus(data[i][2]);
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // [10][3] -> 0: weight, 1: height(cm), 2: BMI
        double[][] members = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) of member " + (i + 1) + ": ");
            members[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) of member " + (i + 1) + ": ");
            members[i][1] = sc.nextDouble();
        }

        fillBMI(members);
        String[] status = generateBMIStatusArray(members);

        System.out.println("\nMember\tWeight(kg)\tHeight(cm)\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s%n",
                    (i + 1), members[i][0], members[i][1], members[i][2], status[i]);
        }

        sc.close();
    }
}

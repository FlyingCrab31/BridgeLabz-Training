import java.util.Scanner;

class BMICalculator {

    public static double[][] readHeightWeight(Scanner sc, int n) {
        double[][] hw = new double[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("Person " + (i + 1));
            System.out.print("Enter weight (kg): ");
            hw[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm): ");
            hw[i][1] = sc.nextDouble();
        }
        return hw;
    }

    public static String[][] computeBMIAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        String[][] result = new String[1][4];
        result[0][0] = String.format("%.2f", heightCm);
        result[0][1] = String.format("%.2f", weight);
        result[0][2] = String.format("%.2f", bmi);
        result[0][3] = status;
        return result;
    }

    public static String[][] buildBMIReport(double[][] hw) {
        String[][] report = new String[hw.length][4];
        for (int i = 0; i < hw.length; i++) {
            String[][] r = computeBMIAndStatus(hw[i][0], hw[i][1]);
            report[i] = r[0];
        }
        return report;
    }

    public static void printReport(String[][] report) {
        System.out.printf("%-8s %-8s %-8s %-12s%n", "Height", "Weight", "BMI", "Status");
        for (String[] row : report) {
            System.out.printf("%-8s %-8s %-8s %-12s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[][] hw = readHeightWeight(sc, n);
        String[][] report = buildBMIReport(hw);
        printReport(report);
        sc.close();
    }
}

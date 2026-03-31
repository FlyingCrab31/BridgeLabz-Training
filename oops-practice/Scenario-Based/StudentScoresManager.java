import java.util.Scanner;

public class StudentScoresManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        // Read valid number of students
        while (true) {
            System.out.print("Enter number of students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) break;
                System.out.println("Number of students must be positive.");
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // clear invalid token
            }
        }

        double[] scores = new double[n];

        // Read scores with validation (no negatives, numeric only)
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                if (sc.hasNextDouble()) {
                    double s = sc.nextDouble();
                    if (s < 0) {
                        System.out.println("Score cannot be negative. Try again.");
                    } else {
                        scores[i] = s;
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numeric score.");
                    sc.next(); // clear invalid token
                }
            }
        }

        sc.close();

        // Calculate average, highest, lowest
        double sum = 0;
        double max = scores[0];
        double min = scores[0];

        for (double s : scores) {
            sum += s;
            if (s > max) max = s;
            if (s < min) min = s;
        }

        double avg = sum / n;

        System.out.println("\nAverage score: " + avg);
        System.out.println("Highest score: " + max);
        System.out.println("Lowest score : " + min);

        // Scores above average
        System.out.println("\nScores above average:");
        boolean anyAbove = false;
        for (double s : scores) {
            if (s > avg) {
                System.out.println(s);
                anyAbove = true;
            }
        }
        if (!anyAbove) {
            System.out.println("No scores above average.");
        }
    }
}

import java.util.Scanner;

public class StudentScorecard {
    
    // Method to generate random 2-digit scores for Physics, Chemistry, Math
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // 3 subjects: PCM
        
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 91) + 10; // 10 to 100
            }
        }
        
        return scores;
    }
    
    // Method to calculate total, average, and percentage
    public static double[][] calculateResults(int[][] scores) {
        int numStudents = scores.length;
        double[][] results = new double[numStudents][3]; // [total][average][percentage]
        
        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            
            double average = (double) total / 3;
            double percentage = (total / 300.0) * 100;
            
            // Round to 2 decimal places using Math.round()
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;
            
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        
        return results;
    }
    
    // Method to display scorecard
    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("\n===== Student Scorecard =====");
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\t\tPercentage");
        System.out.println("");
        
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            
            // Print scores for Physics, Chemistry, Math
            for (int j = 0; j < 3; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            
            // Print results using \t for tabular format
            System.out.printf("%.0f\t%.2f\t\t%.2f%%\n", 
                             results[i][0], results[i][1], results[i][2]);
        }
        
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        
        // Generate random scores for PCM
        int[][] scores = generateScores(numStudents);
        
        // Calculate total, average, and percentage
        double[][] results = calculateResults(scores);
        
        // Display scorecard in tabular format
        displayScorecard(scores, results);
        
        sc.close();
    }
}

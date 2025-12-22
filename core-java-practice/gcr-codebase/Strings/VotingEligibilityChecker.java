import java.util.Scanner;

public class VotingEligibilityChecker {
    
    // Method to generate random ages for students
    public static int[] generateStudentAges(int numberOfStudents) {
        int[] ages = new int[numberOfStudents];
        
        for (int i = 0; i < numberOfStudents; i++) {
            // Generate random 2-digit age (10 to 99)
            ages[i] = (int)(Math.random() * 90) + 10;
        }
        
        return ages;
    }
    
    // Method to check voting eligibility and create 2D result array
    public static String[][] checkVotingEligibility(int[] ages) {
        int studentCount = ages.length;
        String[][] eligibilityData = new String[studentCount][2];
        
        for (int i = 0; i < studentCount; i++) {
            int age = ages[i];
            
            // Store the age as a string
            eligibilityData[i][0] = String.valueOf(age);
            
            // Check eligibility
            if (age < 0) {
                // Negative age is invalid
                eligibilityData[i][1] = "Cannot Vote (Invalid Age)";
            } else if (age >= 18) {
                // Eligible to vote
                eligibilityData[i][1] = "Can Vote";
            } else {
                // Too young to vote
                eligibilityData[i][1] = "Cannot Vote (Too Young)";
            }
        }
        
        return eligibilityData;
    }
    
    // Method to display results in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("\n+----------+----------+----------------------------+");
        System.out.println("| Student  |   Age    |     Voting Eligibility     |");
        System.out.println("+----------+----------+----------------------------+");
        
        for (int i = 0; i < data.length; i++) {
            String age = data[i][0];
            String eligibility = data[i][1];
            
            System.out.printf("| %8d | %8s | %-26s |\n", (i + 1), age, eligibility);
        }
        
        System.out.println("+----------+----------+----------------------------+");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        
        // Generate random ages
        int[] studentAges = generateStudentAges(numberOfStudents);
        
        // Check voting eligibility
        String[][] eligibilityResults = checkVotingEligibility(studentAges);
        
        // Display results
        System.out.println("\n=== Student Voting Eligibility Report ===");
        displayTable(eligibilityResults);
        
        // Calculate and display statistics
        int canVote = 0;
        int cannotVote = 0;
        
        for (int i = 0; i < eligibilityResults.length; i++) {
            if (eligibilityResults[i][1].equals("Can Vote")) {
                canVote++;
            } else {
                cannotVote++;
            }
        }
        
        System.out.println("\n--- Statistics ---");
        System.out.println("Students who can vote: " + canVote);
        System.out.println("Students who cannot vote: " + cannotVote);
        System.out.printf("Percentage eligible: %.2f%%\n", (canVote * 100.0 / numberOfStudents));
        
        scanner.close();
    }
}

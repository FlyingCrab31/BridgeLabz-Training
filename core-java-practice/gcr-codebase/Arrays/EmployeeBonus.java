import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // b. Define double arrays for salary and years of service
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonusAmount = new double[10];
        double[] newSalary = new double[10];
        
        // c. Variables to store totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        
        // d. Input loop with validation
        for (int i = 0; i < 10; i++) {
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print("Enter salary for employee " + (i + 1) + ": ");
                if (sc.hasNextDouble()) {
                    salary[i] = sc.nextDouble();
                    if (salary[i] > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Salary must be positive. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.nextLine(); // Clear invalid input
                    i--; // Decrement to retry this employee
                    break;
                }
            }
            
            if (!validInput) continue;
            
            validInput = false;
            while (!validInput) {
                System.out.print("Enter years of service for employee " + (i + 1) + ": ");
                if (sc.hasNextDouble()) {
                    yearsOfService[i] = sc.nextDouble();
                    if (yearsOfService[i] >= 0) {
                        validInput = true;
                    } else {
                        System.out.println("Years of service cannot be negative. Try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.nextLine(); // Clear invalid input
                    i--; // Decrement to retry this employee
                    break;
                }
            }
        }
        
        // e. Calculate bonus, new salary, and totals
        for (int i = 0; i < 10; i++) {
            // a. Bonus: 5% if years >= 5, else 2%
            if (yearsOfService[i] >= 5) {
                bonusAmount[i] = salary[i] * 0.05;
            } else {
                bonusAmount[i] = salary[i] * 0.02;
            }
            
            newSalary[i] = salary[i] + bonusAmount[i];
            totalBonus += bonusAmount[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        
        // f. Print results
        System.out.println(" BONUS REPORT ");
        System.out.println("Total Old Salary: $" + totalOldSalary);
        System.out.println("Total Bonus Payout: $" + totalBonus);
        System.out.println("Total New Salary: $" + totalNewSalary);
        
        sc.close();
    }
}
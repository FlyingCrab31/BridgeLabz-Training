import java.util.*;

class EmployeeWageComputation {

    // Constants - UC 2
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;
    
    // UC 3
    public static final int PART_TIME_HOURS = 8;
    
    // UC 5
    public static final int WORKING_DAYS_PER_MONTH = 20;
    
    // UC 6
    public static final int MAX_WORKING_HOURS = 100;
    public static final int MAX_WORKING_DAYS = 20;

    private Scanner scanner;

    // Constructor
    public EmployeeWageComputation() {
        scanner = new Scanner(System.in);
    }

    // UC 1: Check Employee is Present or Absent (User Input)
    public boolean isEmployeePresent() {
        System.out.print("Is employee present? (1 = Present, 0 = Absent): ");
        int attendance = scanner.nextInt();
        return attendance == 1;
    }

    // UC 2: Calculate Daily Employee Wage (Full Day)
    public int calculateDailyWage() {
        return FULL_DAY_HOURS * WAGE_PER_HOUR;
    }

    // UC 3: Add Part time Employee & Wage
    public int calculatePartTimeWage() {
        return PART_TIME_HOURS * WAGE_PER_HOUR;
    }

    // UC 4: Solving using Switch Case Statement (User Input)
    public int getWorkingHours() {
        System.out.print("Enter employee type (0 = Absent, 1 = Full Time, 2 = Part Time): ");
        int empType = scanner.nextInt();
        int hours;
        
        switch (empType) {
            case 1 -> {
                hours = FULL_DAY_HOURS;
                System.out.println("Employee is Full Time");
            }
            case 2 -> {
                hours = PART_TIME_HOURS;
                System.out.println("Employee is Part Time");
            }
            default -> {
                hours = 0;
                System.out.println("Employee is Absent");
            }
        }
        return hours;
    }

    // UC 5: Calculate Wages for a Month (User Input for each day)
    public int calculateMonthlyWage() {
        int totalWage = 0;
        System.out.println("\n--- Calculating Monthly Wage ---");
        
        for (int day = 1; day <= WORKING_DAYS_PER_MONTH; day++) {
            System.out.println("\nDay " + day + ":");
            int hours = getWorkingHours();
            int dailyWage = hours * WAGE_PER_HOUR;
            totalWage += dailyWage;
            System.out.println("Hours = " + hours + ", Daily Wage = " + dailyWage);
        }
        return totalWage;
    }

    // UC 6: Calculate Wages till condition (User Input)
    public int calculateWageTillCondition() {
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;
        
        System.out.println("\n--- Calculating Wage Till Condition ---");
        System.out.println("(Max " + MAX_WORKING_HOURS + " hours or " + MAX_WORKING_DAYS + " days)");
        
        while (totalHours < MAX_WORKING_HOURS && totalDays < MAX_WORKING_DAYS) {
            totalDays++;
            System.out.println("\nDay " + totalDays + ":");
            int hours = getWorkingHours();
            
            if (totalHours + hours > MAX_WORKING_HOURS) {
                System.out.println("Max hours would be exceeded! Stopping.");
                break;
            }
            
            totalHours += hours;
            int dailyWage = hours * WAGE_PER_HOUR;
            totalWage += dailyWage;
            
            System.out.println("Total Hours so far: " + totalHours + ", Wage earned today: " + dailyWage);
            
            // Ask if user wants to continue
            if (totalHours < MAX_WORKING_HOURS && totalDays < MAX_WORKING_DAYS) {
                System.out.print("Continue to next day? (1 = Yes, 0 = No): ");
                int cont = scanner.nextInt();
                if (cont != 1) {
                    break;
                }
            }
        }
        
        System.out.println("\nTotal Working Days: " + totalDays);
        System.out.println("Total Working Hours: " + totalHours);
        return totalWage;
    }

    public static void main(String[] args) {
        
        // START - Display Welcome Message
        System.out.println("Welcome to Employee Wage Computation Program on Master Branch");        
        EmployeeWageComputation emp = new EmployeeWageComputation();
        Scanner mainScanner = new Scanner(System.in);
        
        // UC 1: Check if employee is present
        System.out.println("UC 1: Check Employee Attendance");
        boolean isPresent = emp.isEmployeePresent();
        System.out.println("Employee is " + (isPresent ? "Present" : "Absent"));
        
        // UC 2: Calculate Daily Wage
        System.out.println("\nUC 2: Calculate Daily Employee Wage");
        int dailyWage = emp.calculateDailyWage();
        System.out.println("Daily Wage (Full Time): " + dailyWage);
        
        // UC 3: Part Time Wage
        System.out.println("\nUC 3: Add Part Time Employee & Wage");
        int partTimeWage = emp.calculatePartTimeWage();
        System.out.println("Part Time Wage: " + partTimeWage);
        
        // UC 4: Using Switch Case
        System.out.println("\nUC 4: Solving using Switch Case Statement");
        int hours = emp.getWorkingHours();
        System.out.println("Working Hours: " + hours);
        
        // Ask user which UC to run
        System.out.println("Choose an option:");
        System.out.println("5 - Calculate Monthly Wage (UC 5)");
        System.out.println("6 - Calculate Wage Till Condition (UC 6)");
        System.out.print("Enter your choice: ");
        int choice = mainScanner.nextInt();
        
        if (choice == 5) {
            // UC 5: Monthly Wage
            System.out.println("\nUC 5: Calculate Wages for a Month");
            int monthlyWage = emp.calculateMonthlyWage();
            System.out.println("\nTotal Monthly Wage: " + monthlyWage);
        } else if (choice == 6) {
            // UC 6: Wage till condition
            System.out.println("\nUC 6: Calculate Wages till condition reached");
            int totalWage = emp.calculateWageTillCondition();
            System.out.println("\nTotal Wage: " + totalWage);
        }
        
        System.out.println("Thank You");
        
        mainScanner.close();
    }
}

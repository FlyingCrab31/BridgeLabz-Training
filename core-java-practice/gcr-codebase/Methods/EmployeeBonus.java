public class EmployeeBonus {
    
    // Method to generate salary and years of service for employees
    public static int[][] generateEmployeeData(int numEmployees) {
        int[][] data = new int[numEmployees][2];
        
        for (int i = 0; i < numEmployees; i++) {
            // Generate 5-digit salary (10000 to 99999)
            data[i][0] = (int) (Math.random() * 90000) + 10000;
            
            // Generate years of service (1 to 10 years)
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        
        return data;
    }
    
    // Method to calculate new salary and bonus
    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        int numEmployees = employeeData.length;
        double[][] result = new double[numEmployees][2]; // [new salary][bonus]
        
        for (int i = 0; i < numEmployees; i++) {
            int salary = employeeData[i][0];
            int years = employeeData[i][1];
            
            double bonusPercent;
            if (years > 5) {
                bonusPercent = 0.05; // 5%
            } else {
                bonusPercent = 0.02; // 2%
            }
            
            double bonus = salary * bonusPercent;
            double newSalary = salary + bonus;
            
            result[i][0] = newSalary;
            result[i][1] = bonus;
        }
        
        return result;
    }
    
    // Method to calculate totals
    public static void displaySummary(int[][] employeeData, double[][] bonusData) {
        System.out.println("\n Employee Bonus Report ");
        System.out.println("Emp\tOld Salary\tYears\tBonus\t\tNew Salary");
        System.out.println("");
        
        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;
        
        for (int i = 0; i < employeeData.length; i++) {
            int oldSalary = employeeData[i][0];
            int years = employeeData[i][1];
            double newSalary = bonusData[i][0];
            double bonus = bonusData[i][1];
            
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%.2f\n", 
                             (i+1), oldSalary, years, bonus, newSalary);
            
            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;
        }
        
        System.out.println("");
        System.out.printf("Total\t%.2f\t\t\t%.2f\t\t%.2f\n", 
                         totalOldSalary, totalBonus, totalNewSalary);
    }
    
    public static void main(String[] args) {
        int numEmployees = 10;
        
        // Generate employee data
        int[][] employeeData = generateEmployeeData(numEmployees);
        
        // Calculate bonus and new salary
        double[][] bonusData = calculateBonusAndNewSalary(employeeData);
        
        // Display summary
        displaySummary(employeeData, bonusData);
    }
}

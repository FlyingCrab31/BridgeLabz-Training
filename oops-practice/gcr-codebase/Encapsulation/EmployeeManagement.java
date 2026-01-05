import java.util.ArrayList;
import java.util.List;

// Department interface
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract Employee class
abstract class Employee {
    private final int employeeId;
    private final String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method: display details (uses polymorphism)
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Calculated Salary: " + calculateSalary());
    }
}


class FullTimeEmployee extends Employee implements Department {
    private double monthlySalary;
    private String department;

    public FullTimeEmployee(int employeeId, String name, double monthlySalary) {
        super(employeeId, name, monthlySalary);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary; // fixed salary
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
        setBaseSalary(monthlySalary);
    }

    // Department implementation
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + (department == null ? "Not Assigned" : department);
    }

    // Optionally override displayDetails to include department
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getDepartmentDetails());
    }
}


class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name,
                            int hoursWorked, double hourlyRate) {
        super(employeeId, name, hourlyRate);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate; // based on work hours
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        setBaseSalary(hourlyRate);
    }

    // Department implementation
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + (department == null ? "Not Assigned" : department);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(getDepartmentDetails());
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {

        FullTimeEmployee e1 = new FullTimeEmployee(1, "Alice", 50000);
        PartTimeEmployee e2 = new PartTimeEmployee(2, "Bob", 80, 400);
        FullTimeEmployee e3 = new FullTimeEmployee(3, "Charlie", 70000);

        // Assign departments via interface behavior
        e1.assignDepartment("HR");
        e2.assignDepartment("Support");
        e3.assignDepartment("Development");

        // Polymorphic list
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        // Process using Employee reference (polymorphism)
        for (Employee emp : employees) {
            System.out.println("----- Employee -----");
            emp.displayDetails();  // calls overridden version in subclass
            System.out.println();
        }
    }
}


// Base class
class Employee {
    // Access modifiers as required
    public int employeeID;      // public
    protected String department; // protected
    private double salary;       // private

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Optional: getter for salary
    public double getSalary() {
        return salary;
    }

    // Display details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID : " + employeeID);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
        System.out.println("---------------------------");
    }
}

// Subclass to access employeeID and department
class Manager extends Employee {
    String teamName;

    Manager(int employeeID, String department, double salary, String teamName) {
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    public void displayManagerDetails() {
        // Accessing public and protected members from superclass
        System.out.println("Manager ID   : " + employeeID);   // public
        System.out.println("Department   : " + department);   // protected
        System.out.println("Team Name    : " + teamName);
        System.out.println("Salary       : " + getSalary());
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Employee emp = new Employee(101, "HR", 40000.0);
        emp.displayEmployeeDetails();

        Manager mgr = new Manager(201, "IT", 70000.0, "Backend Team");
        mgr.displayManagerDetails();

        // Modify salary using public method
        mgr.setSalary(75000.0);
        mgr.displayManagerDetails();
    }
}

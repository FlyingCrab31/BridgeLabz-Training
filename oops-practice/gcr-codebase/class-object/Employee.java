class Employee {
    String name;
    int id;
    double salary;

    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        // Create object
        Employee emp = new Employee();

        // Initialize data
        emp.name = "Rohan";
        emp.id = 1;
        emp.salary = 500000;

        // Display details
        emp.displayDetails();
    }
}

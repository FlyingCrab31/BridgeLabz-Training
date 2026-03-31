package EmployeeManagement;

abstract class Employee {
    private final String name;
    private final double salary;

    protected Employee(String name, double salary) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public abstract double getBonus();
}

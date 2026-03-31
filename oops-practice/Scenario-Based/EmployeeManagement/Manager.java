package EmployeeManagement;

final class Manager extends Employee {
    // cache computed bonus
    private final double bonus;

    public Manager(String name, double salary) {
        super(name, salary);
        // 10% of salary
        this.bonus = salary * 0.10;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}
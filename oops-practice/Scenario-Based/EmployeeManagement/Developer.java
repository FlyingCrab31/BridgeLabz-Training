package EmployeeManagement;

final class Developer extends Employee {
    // cache computed bonus
    private final double bonus;

    public Developer(String name, double salary) {
        super(name, salary);
        // 5% if salary > 50000, else 0
        this.bonus = (salary > 50000.0) ? salary * 0.05 : 0.0;
    }

    @Override
    public double getBonus() {
        return bonus;
    }
}

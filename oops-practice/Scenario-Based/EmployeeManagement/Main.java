package EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 80000);
        System.out.printf("%.2f%n", manager.getBonus());      // 8000.00

        Employee dev1 = new Developer("Bob", 60000);
        System.out.printf("%.2f%n", dev1.getBonus());         // 3000.00

        Employee dev2 = new Developer("Charlie", 40000);
        System.out.printf("%.2f%n", dev2.getBonus());         // 0.00
    }
}

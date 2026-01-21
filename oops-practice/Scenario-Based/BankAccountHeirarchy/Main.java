package BankAccountHeirarchy;

public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee());  // 5.00

        BankAccount savings2 = new SavingsAccount("S1", 500.0);
        System.out.printf("%.2f%n", savings2.calculateFee()); // 2.50

        BankAccount checking1 = new CheckingAccount("C1", 1500.0);
        System.out.printf("%.2f%n", checking1.calculateFee()); // 0.00

        BankAccount checking2 = new CheckingAccount("C2", 500.0);
        System.out.printf("%.2f%n", checking2.calculateFee()); // 1.00
    }
}

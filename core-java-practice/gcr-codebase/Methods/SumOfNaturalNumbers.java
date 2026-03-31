import java.util.Scanner;
public class SumOfNaturalNumbers {
    // Method to find the sum of n natural numbers using recursion
    public static int sumOfNaturalNumbers(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumOfNaturalNumbers(n - 1);
    }
    // Method to find the sum of n natural numbers using Formula.
    public static int sumOfNaturalNumbersFormula(int n) {
        return n * (n + 1) / 2;
    }
    // Main method to compare both methods
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sumRecursive = sumOfNaturalNumbers(n);
        int sumFormula = sumOfNaturalNumbersFormula(n);

        System.out.println("Sum using Recursion: " + sumRecursive);
        System.out.println("Sum using Formula: " + sumFormula);
    }
    
}
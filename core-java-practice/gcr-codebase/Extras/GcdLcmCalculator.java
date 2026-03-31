import java.util.Scanner;

public class GcdLcmCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        int gcd = gcd(a, b);
        int lcm = lcm(a, b, gcd);

        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
    }

    static int gcd(int a, int b) { // Euclidean algorithm [web:55]
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    static int lcm(int a, int b, int gcd) {
        return Math.abs(a * b) / gcd;
    }
}

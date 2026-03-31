public class UtilityMath {

    // Factorial of n (returns -1 for negative numbers)
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Check if n is prime (returns false for n <= 1 and negatives)
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // GCD of a and b using Euclidean algorithm
    public static int gcd(int a, int b) {
        // Handle negative numbers: GCD is usually taken as non-negative
        a = Math.abs(a);
        b = Math.abs(b);

        // If both are zero, GCD is undefined; return 0 by convention
        if (a == 0 && b == 0) {
            System.out.println("GCD is not defined for (0, 0). Returning 0 by convention.");
            return 0;
        }

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // nth Fibonacci (0-based: fib(0)=0, fib(1)=1)
    // Returns -1 for negative n
    public static long fibonacci(int n) {
        if (n < 0) {
            System.out.println("Fibonacci is not defined for negative indices.");
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long prev = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // Simple test in main
    public static void main(String[] args) {
        System.out.println("Factorial tests:");
        System.out.println("factorial(-3) = " + factorial(-3)); // edge: negative
        System.out.println("factorial(0)  = " + factorial(0));  // edge: 0
        System.out.println("factorial(1)  = " + factorial(1));  // edge: 1
        System.out.println("factorial(5)  = " + factorial(5));

        System.out.println("\nPrime tests:");
        System.out.println("isPrime(-5) = " + isPrime(-5)); // false
        System.out.println("isPrime(0)  = " + isPrime(0));  // false
        System.out.println("isPrime(1)  = " + isPrime(1));  // false
        System.out.println("isPrime(2)  = " + isPrime(2));  // true
        System.out.println("isPrime(17) = " + isPrime(17)); // true
        System.out.println("isPrime(18) = " + isPrime(18)); // false

        System.out.println("\nGCD tests:");
        System.out.println("gcd(0, 0)    = " + gcd(0, 0));     // edge: both zero
        System.out.println("gcd(0, 5)    = " + gcd(0, 5));     // 5
        System.out.println("gcd(12, 18)  = " + gcd(12, 18));   // 6
        System.out.println("gcd(-24, 18) = " + gcd(-24, 18));  // 6

        System.out.println("\nFibonacci tests :");
        System.out.println("fibonacci(-1) = " + fibonacci(-1)); // edge: negative
        System.out.println("fibonacci(0)  = " + fibonacci(0));  // 0
        System.out.println("fibonacci(1)  = " + fibonacci(1));  // 1
        System.out.println("fibonacci(2)  = " + fibonacci(2));  // 1
        System.out.println("fibonacci(5)  = " + fibonacci(5));  // 5
        System.out.println("fibonacci(10) = " + fibonacci(10)); // 55
    }
}

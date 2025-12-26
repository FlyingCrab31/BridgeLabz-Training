public class NumberChecker6 {
    
    // Method to find sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    
    // Method to check if perfect number
    public static boolean isPerfect(int number) {
        return sumOfProperDivisors(number) == number;
    }
    
    // Method to check if abundant number
    public static boolean isAbundant(int number) {
        return sumOfProperDivisors(number) > number;
    }
    
    // Method to check if deficient number
    public static boolean isDeficient(int number) {
        return sumOfProperDivisors(number) < number;
    }
    
    // Method to find factorial
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    // Method to check if strong number
    public static boolean isStrong(int number) {
        int sum = 0;
        int original = number;
        while (number != 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) {
        int number = 28;
        
        System.out.println("Is Perfect Number: " + isPerfect(number));
        System.out.println("Is Abundant Number: " + isAbundant(number));
        System.out.println("Is Deficient Number: " + isDeficient(number));
        System.out.println("Is Strong Number: " + isStrong(number));
    }
}

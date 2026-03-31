public class NumberChecker3 {
    
    // Method to find count of digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
    
    // Method to store digits in array
    public static int[] getDigits(int number, int count) {
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }
    
    // Method to find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }
    
    // Method to find sum of squares of digits
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], 2);
        }
        return sum;
    }
    
    // Method to check if number is Harshad number
    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }
    
    // Method to find frequency of each digit
    public static int[][] findFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        
        // Initialize frequency array
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i; // digit
            frequency[i][1] = 0; // frequency
        }
        
        // Count frequency
        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]][1]++;
        }
        
        return frequency;
    }
    
    public static void main(String[] args) {
        int number = 21;
        int count = countDigits(number);
        int[] digits = getDigits(number, count);
        
        System.out.println("Number: " + number);
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Is Harshad Number: " + isHarshad(number, digits));
        
        System.out.println("\nDigit Frequency:");
        int[][] freq = findFrequency(digits);
        for (int i = 0; i < 10; i++) {
            if (freq[i][1] > 0) {
                System.out.println("Digit " + freq[i][0] + ": " + freq[i][1] + " times");
            }
        }
    }
}

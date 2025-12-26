public class NumberChecker2 {
    
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
    
    // Method to check if number is duck number
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
    }
    
    // Method to check if number is armstrong number
    public static boolean isArmstrong(int[] digits) {
        int sum = 0;
        int power = digits.length;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], power);
        }
        
        // Reconstruct original number
        int original = 0;
        for (int i = 0; i < digits.length; i++) {
            original = original * 10 + digits[i];
        }
        
        return sum == original;
    }
    
    // Method to find largest and second largest
    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
    
    // Method to find smallest and second smallest
    public static void findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < smallest) {
                secondSmallest = smallest;
                smallest = digits[i];
            } else if (digits[i] < secondSmallest && digits[i] != smallest) {
                secondSmallest = digits[i];
            }
        }
        
        System.out.println("Smallest digit: " + smallest);
        System.out.println("Second smallest digit: " + secondSmallest);
    }
    
    public static void main(String[] args) {
        int number = 153;
        int count = countDigits(number);
        int[] digits = getDigits(number, count);
        
        System.out.println("Number: " + number);
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrong(digits));
        findLargestAndSecondLargest(digits);
        findSmallestAndSecondSmallest(digits);
    }
}

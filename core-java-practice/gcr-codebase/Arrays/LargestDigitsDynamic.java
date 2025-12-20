import java.util.Scanner;

class LargestDigitsDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // a. Take user input for a number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        
        // b. Create array to store digits (initial size 10)
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        
        // d-f. Extract digits from the number with dynamic resizing
        while (number != 0) {
            // f. If index equals maxDigit, increase array size
            if (index == maxDigit) {
                maxDigit += 10; // Increase size by 10
                
                // Create temp array and copy elements
                int[] tempDigits = new int[maxDigit];
                for (int i = 0; i < index; i++) {
                    tempDigits[i] = digits[i];
                }
                digits = tempDigits; // Assign temp back to digits
            }
            
            digits[index] = (int)(number % 10);
            number /= 10;
            index++;
        }
        
        int digitCount = index; // Actual number of digits stored
        
        // g. Initialize variables for largest and second largest
        int largest = -1;
        int secondLargest = -1;
        
        // h. Find largest and second largest digit
        for (int i = 0; i < digitCount; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        
        // i. Display results
        System.out.println(" RESULT");
        System.out.println("Largest Digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second Largest Digit: " + secondLargest);
        } else {
            System.out.println("Second Largest Digit: Not found (only one unique digit)");
        }
        
        sc.close();
    }
}
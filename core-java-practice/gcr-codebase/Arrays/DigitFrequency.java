import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner input = new Scanner(System.in);

        // Take the input for a number
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Validate the user input number, if negative state invalid and exit
        if (number < 0) {
            System.err.println("Invalid number.");
            input.close();
            return;
        }

        // Special case: if number is 0, directly handle and exit
        if (number == 0) {
            int[] frequency = new int[10];
            frequency[0] = 1;

            System.out.println("\nDigit frequencies:");
            for (int d = 0; d < frequency.length; d++) {
                System.out.println("Digit " + d + " -> " + frequency[d]);
            }

            input.close();
            return;
        }

        // Find the count of digits in the number
        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        // Find the digits in the number and save them in an array
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Define a frequency array of size 10
        int[] frequency = new int[10]; // all initialized to 0

        // Loop through the digits array and increase the frequency of each digit
        for (int i = 0; i < digits.length; i++) {
            int d = digits[i];    // d is between 0 and 9
            frequency[d]++;
        }

        // Display the frequency of each digit in the number
        System.out.println("\nDigit frequencies:");
        for (int d = 0; d < frequency.length; d++) {
            System.out.println("Digit " + d + " -> " + frequency[d]);
        }

        // Close the Scanner object
        input.close();
    }
}

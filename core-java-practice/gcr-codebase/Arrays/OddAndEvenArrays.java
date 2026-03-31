import java.util.Scanner;

public class OddAndEvenArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get an integer input and validate natural number
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.err.println("Invalid input. Please enter a natural number (> 0).");
            return;
        }

        // Create arrays for even and odd numbers with size...
        int size = number / 2 + 1;
        int[] evenNumbers = new int[size];
        int[] oddNumbers = new int[size];

        // Index variables for even and odd
        int evenIndex = 0;
        int oddIndex = 0;

        // Loop from 1 to number and store odd/even in respective arrays
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd and even numbers arrays using indexes
        System.out.println("\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        System.out.println();
        sc.close();
    }
}

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take user input for a positive integer
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.err.println("Invalid input. Please enter a positive integer.");
            return;
        }

        // Create a String Array to save the results
        String[] results = new String[number];

        // Loop from 1 to number and apply FizzBuzz logic
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                // Multiple of both 3 and 5
                results[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                // Multiple of 3
                results[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                // Multiple of 5
                results[i - 1] = "Buzz";
            } else {
                // Not a multiple of 3 or 5, save the number
                results[i - 1] = String.valueOf(i);
            }
        }

        // Loop again to display the results based on index position
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + (i + 1) + " = " + results[i]);
        }

        sc.close();
    }
}

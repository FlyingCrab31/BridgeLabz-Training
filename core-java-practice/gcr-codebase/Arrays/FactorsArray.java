import java.util.Scanner;

public class FactorsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take the input for a number
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        // Initially: maxFactor, factors array, and index variable
        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        // Find the factors and store them in the array
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {        // i is a factor
                // If array is full, increase its size
                if (index == maxFactor) {
                    // Resize: double maxFactor, copy to temp, then reassign
                    maxFactor *= 2;
                    int[] temp = new int[maxFactor];
                    for (int j = 0; j < index; j++) {
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index] = i;
                index++;
            }
        }

        // Display the factors
        System.out.println("\nFactors of " + num + ":");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}

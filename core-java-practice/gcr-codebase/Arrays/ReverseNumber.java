import java.util.Scanner;

class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // a. Take user input for a number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();
        
        // b. Find the count of digits in the number
        long tempNum = number;
        int digitCount = 0;
        
        while (tempNum != 0) {
            digitCount++;
            tempNum /= 10;
        }
        
        // c. Find the digits and save them in an array
        int[] digits = new int[digitCount];
        tempNum = number;
        int index = 0;
        
        while (tempNum != 0) {
            digits[index] = (int)(tempNum % 10);
            tempNum /= 10;
            index++;
        }
        
        // d. Create an array to store digits in reverse order
        int[] reversedDigits = new int[digitCount];
        
        for (int i = 0; i < digitCount; i++) {
            reversedDigits[i] = digits[digitCount - 1 - i];
        }
        
        // e. Display the reversed number
        System.out.print("Reversed Number: ");
        for (int i = 0; i < digitCount; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();
        
        sc.close();
    }
}
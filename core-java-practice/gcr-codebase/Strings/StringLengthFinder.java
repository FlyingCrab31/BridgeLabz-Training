import java.util.Scanner;

public class StringLengthFinder {
    
    // Method to calculate string length without using length()
    public static int findStringLength(String text) {
        int count = 0;
        try {
            // Keep counting characters until we hit an exception
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // When we go past the end, we know the length
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String userInput = scanner.next();
        
        // Get length using our custom method
        int customLength = findStringLength(userInput);
        
        // Compare with built-in method
        int builtInLength = userInput.length();
        
        System.out.println("\nResults:");
        System.out.println("Length using custom method: " + customLength);
        System.out.println("Length using built-in method: " + builtInLength);
        
        scanner.close();
    }
}

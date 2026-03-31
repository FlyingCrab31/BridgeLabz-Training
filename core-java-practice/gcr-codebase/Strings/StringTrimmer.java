import java.util.Scanner;

public class StringTrimmer {
    
    // Method to find the trim points (start and end) for a string
    public static int[] findTrimPoints(String text) {
        int length = getStringLength(text);
        
        // Find the starting point (first non-space character)
        int startPoint = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ') {
                startPoint = i;
                break;
            }
        }
        
        // Find the ending point (last non-space character)
        int endPoint = length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                endPoint = i;
                break;
            }
        }
        
        // Return both points in an array
        return new int[]{startPoint, endPoint + 1}; // +1 because end is exclusive
    }
    
    // Method to get string length without using length()
    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Reached the end
        }
        return count;
    }
    
    // Method to create a substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }
    
    // Method to compare two strings character by character
    public static boolean compareStrings(String str1, String str2) {
        int len1 = getStringLength(str1);
        int len2 = getStringLength(str2);
        
        // If lengths are different, strings are not equal
        if (len1 != len2) {
            return false;
        }
        
        // Compare each character
        for (int i = 0; i < len1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string with spaces: ");
        String userInput = scanner.nextLine();
        
        // Trim using our custom method
        int[] trimPoints = findTrimPoints(userInput);
        String customTrimmed = createSubstring(userInput, trimPoints[0], trimPoints[1]);
        
        // Trim using built-in method
        String builtInTrimmed = userInput.trim();
        
        // Compare both results
        boolean areEqual = compareStrings(customTrimmed, builtInTrimmed);
        
        // Display results
        System.out.println("\n--- Trim Results ---");
        System.out.println("Original string: \"" + userInput + "\"");
        System.out.println("Custom trimmed: \"" + customTrimmed + "\"");
        System.out.println("Built-in trimmed: \"" + builtInTrimmed + "\"");
        System.out.println("\nAre both results equal? " + areEqual);
        
        scanner.close();
    }
}

import java.util.Scanner;

class UppercaseConverter {
    
    // Method to convert text to uppercase using charAt() and ASCII logic
    public static String convertToUppercase(String text) {
        String result = "";
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            // Check if character is lowercase (ASCII 'a' = 97, 'z' = 122)
            if (ch >= 'a' && ch <= 'z') {
                // Convert to uppercase by subtracting 32
                char upperChar = (char)(ch - 32);
                result += upperChar;
            } else {
                // Keep the character as is (already uppercase or not a letter)
                result += ch;
            }
        }
        
        return result;
    }
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take user input
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        // Convert using user-defined method
        String uppercaseManual = convertToUppercase(text);
        
        // Convert using built-in toUpperCase()
        String uppercaseBuiltIn = text.toUpperCase();
        
        // Compare both results
        boolean areEqual = compareStrings(uppercaseManual, uppercaseBuiltIn);
        
        // Display results
        System.out.println("\nOriginal text: " + text);
        System.out.println("Uppercase using user-defined method: " + uppercaseManual);
        System.out.println("Uppercase using toUpperCase(): " + uppercaseBuiltIn);
        System.out.println("\nAre both results equal? " + areEqual);
        
        sc.close();
    }
}

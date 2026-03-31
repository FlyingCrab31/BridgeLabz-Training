import java.util.Scanner;

class LowercaseConverter {
    
    // Method to convert text to lowercase using charAt() and ASCII logic
    public static String convertToLowercase(String text) {
        String result = "";
        
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            
            // Check if character is uppercase (ASCII 'A' = 65, 'Z' = 90)
            if (ch >= 'A' && ch <= 'Z') {
                // Convert to lowercase by adding 32
                char lowerChar = (char)(ch + 32);
                result += lowerChar;
            } else {
                // Keep the character as is (already lowercase or not a letter)
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
        String lowercaseManual = convertToLowercase(text);
        
        // Convert using built-in toLowerCase()
        String lowercaseBuiltIn = text.toLowerCase();
        
        // Compare both results
        boolean areEqual = compareStrings(lowercaseManual, lowercaseBuiltIn);
        
        // Display results
        System.out.println("\nOriginal text: " + text);
        System.out.println("Lowercase using user-defined method: " + lowercaseManual);
        System.out.println("Lowercase using toLowerCase(): " + lowercaseBuiltIn);
        System.out.println("\nAre both results equal? " + areEqual);
        
        sc.close();
    }
}

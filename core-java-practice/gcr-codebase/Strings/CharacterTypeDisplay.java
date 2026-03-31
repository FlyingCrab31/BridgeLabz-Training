import java.util.Scanner;

public class CharacterTypeDisplay {
    
    // Method to check if a character is vowel, consonant, or not a letter
    public static String identifyCharacter(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32);  // Add 32 to convert uppercase to lowercase
        }
        
        // Check if it's not a letter
        if (ch < 'a' || ch > 'z') {
            return "Not a Letter";
        }
        
        // Check if it's a vowel
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }
        
        // Otherwise, it's a consonant
        return "Consonant";
    }
    
    // Method to analyze string and create 2D array of characters and their types
    public static String[][] analyzeCharacters(String text) {
        // First, find the length of the string without using length()
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // We've reached the end of the string
        }
        
        // Create a 2D array to store character and its type
        String[][] characterInfo = new String[length][2];
        
        // Analyze each character
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            String charType = identifyCharacter(currentChar);
            
            characterInfo[i][0] = String.valueOf(currentChar);
            characterInfo[i][1] = charType;
        }
        
        return characterInfo;
    }
    
    // Method to display 2D array in a nice tabular format
    public static void displayTable(String[][] data) {
        System.out.println("| Character  |      Type      |");
        System.out.println();
        
        for (int i = 0; i < data.length; i++) {
            String character = data[i][0];
            String type = data[i][1];
            
            // Format the output nicely
            System.out.printf("| %-10s | %-14s |\n", character, type);
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter a string to analyze: ");
        String userInput = scanner.nextLine();
        
        // Analyze the string
        String[][] results = analyzeCharacters(userInput);
        
        // Display the results in tabular format
        System.out.println("\n Character Analysis ");
        displayTable(results);
        
        scanner.close();
    }
}

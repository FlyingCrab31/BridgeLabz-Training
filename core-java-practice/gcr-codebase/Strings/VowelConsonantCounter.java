import java.util.Scanner;

public class VowelConsonantCounter {
    
    // Check if character is vowel, consonant, or neither
    public static String checkCharacterType(char ch) {
        // Convert to lowercase if uppercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // Convert using ASCII
        }
        
        // Check if it's a letter
        if ((ch >= 'a' && ch <= 'z') == false) {
            return "Not a Letter";
        }
        
        // Check for vowels
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return "Vowel";
        }
        
        return "Consonant";
    }
    
    // Count vowels and consonants
    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        
        int length = 0;
        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        } catch (Exception e) {
            // Got length
        }
        
        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            String type = checkCharacterType(currentChar);
            
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        
        return new int[]{vowelCount, consonantCount};
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        int[] counts = countVowelsAndConsonants(input);
        
        System.out.println("\nResults:");
        System.out.println("Number of Vowels: " + counts[0]);
        System.out.println("Number of Consonants: " + counts[1]);
        
        scanner.close();
    }
}

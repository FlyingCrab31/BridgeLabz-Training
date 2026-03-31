import java.util.Scanner;

public class ToggleCaseOfCharacter {
    private static String toggleCase(String str, char ch) {
        StringBuilder result = new StringBuilder();
        // Iterate through each character in the string
        for (char currentChar : str.toCharArray()) {
            // Check if the current character matches the specified character (case-insensitive)
            if (Character.toLowerCase(currentChar) == Character.toLowerCase(ch)) {
                // Toggle the case of the character
                if (Character.isUpperCase(currentChar)) {
                    result.append(Character.toLowerCase(currentChar));
                } else {
                    result.append(Character.toUpperCase(currentChar));
                }
            } else {
                // If it doesn't match, keep the character as is
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    // Main method to read input and print the modified string
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        char characterToToggle = sc.nextLine().charAt(0);
        System.out.println(toggleCase(inputString, characterToToggle));
        sc.close();
    }
}
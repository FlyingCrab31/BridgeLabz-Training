import java.util.Scanner;

public class RemoveSpecificChar {
    private static String removeCharacter(String str, char ch) {
        StringBuilder result = new StringBuilder();
        // Iterate through each character in the string
        for (char currentChar : str.toCharArray()) {
            // Append to result if currentChar is not the character to be removed
            if (currentChar != ch) {
                result.append(currentChar);
            }
        }
        return result.toString();
    }

    // Main method to read input and print the modified string
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        char charToRemove = sc.nextLine().charAt(0);
        System.out.println(removeCharacter(inputString, charToRemove));
        sc.close();
    }
}
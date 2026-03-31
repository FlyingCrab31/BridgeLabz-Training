import java.util.Scanner;
public class ReplaceWord{
    private static String replaceWord(String str, String target, String replacement) {
        // Split the string into words based on spaces
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        // Iterate through each word in the array
        for (String word : words) {
            // If the word matches the target, append the replacement
            if (word.equals(target)) {
                result.append(replacement);
            } else {
                // Otherwise, append the original word
                result.append(word);
            }
            result.append(" "); // Add a space after each word
        }

        // Remove the trailing space and return the modified string
        return result.toString().trim();
    }

    // Main method to read input and print the modified string
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String targetWord = sc.nextLine();
        String replacementWord = sc.nextLine();
        System.out.println(replaceWord(inputString, targetWord, replacementWord));
        sc.close();
    }
}
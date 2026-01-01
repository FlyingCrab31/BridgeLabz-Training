import java.util.Scanner;

public class ParagraphAnalyzer {

    // Helper to treat null / empty / only-spaces as empty
    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();   // handles only-spaces case too
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Input paragraph
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        if (isBlank(paragraph)) {                 // edge case handling
            System.out.println("Paragraph is empty or contains only spaces.");
            return;
        }

        // Normalize leading/trailing spaces
        paragraph = paragraph.trim();

        // 2. Count words (split on one-or-more spaces)
        String[] words = paragraph.split("\\s+"); // splits by any whitespace
        int wordCount = words.length;
        System.out.println("Word count: " + wordCount);

        // 3. Find longest word
        String longestWord = "";
        for (String w : words) {
            if (w.length() > longestWord.length()) {
                longestWord = w;
            }
        }
        System.out.println("Longest word: " + longestWord);

        // 4. Replace all occurrences of a specific word (case-insensitive)
        System.out.print("Enter the word to replace: ");
        String target = sc.nextLine();
        System.out.print("Enter the new word: ");
        String replacement = sc.nextLine();

        if (!isBlank(target)) {
            // (?i) makes the pattern case-insensitive for replaceAll
            String regex = "(?i)\\b" + java.util.regex.Pattern.quote(target) + "\\b";
            String replacedParagraph = paragraph.replaceAll(regex, replacement);
            System.out.println("Paragraph after replacement:");
            System.out.println(replacedParagraph);
        } else {
            System.out.println("No valid target word provided for replacement.");
        }

        sc.close();
    }
}

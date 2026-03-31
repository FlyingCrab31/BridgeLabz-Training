import java.util.Scanner;

public class Anagram{
    private static boolean areAnagrams(String str1, String str2) {
        // If lengths differ, they cannot be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] charCount = new int[256]; // Assuming ASCII character set

        // Count characters in str1
        for (char ch : str1.toCharArray()) {
            charCount[ch]++;
        }

        // Decrease count for characters in str2
        for (char ch : str2.toCharArray()) {
            charCount[ch]--;
            // If count goes negative, str2 has an extra character not in str1
            if (charCount[ch] < 0) {
                return false;
            }
        }

        return true; // All counts are zero, they are anagrams
    }

    // Main method to read input and print whether the strings are anagrams
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstString = sc.nextLine();
        String secondString = sc.nextLine();
        System.out.println(areAnagrams(firstString, secondString));
        sc.close();
    }
    
}
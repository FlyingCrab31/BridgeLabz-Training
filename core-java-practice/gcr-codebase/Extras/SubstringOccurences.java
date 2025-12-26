import java.util.Scanner;

public class SubstringOccurences {
    private static int countSubstringOccurrences(String str, String substr) {
        int count = 0;
        int index = 0;

        // Loop to find all occurrences of substr in str
        //str.indexOf(substr, index) returns the index of the first occurrence of substr in str starting from index
        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length(); // Move index forward to avoid counting the same occurrence
        }

        return count;
    }

    // Main method to read input and print the count of substring occurrences
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        String substring = sc.nextLine();
        System.out.println(countSubstringOccurrences(inputString, substring));
        sc.close();
    }
}
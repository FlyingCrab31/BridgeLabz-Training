import java.util.Scanner;

class StringComparer {

    // Method to compare two strings using charAt()
    public static boolean compareByCharAt(String s1, String s2) {
        // If lengths differ, strings are not equal
        if (s1.length() != s2.length()) {
            return false;
        }

        // Compare character by character
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true; // All characters matched
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter first string: ");
        String first = sc.next();

        System.out.print("Enter second string: ");
        String second = sc.next();

        // User-defined comparison
        boolean resultCharAt = compareByCharAt(first, second);

        // Built-in comparison
        boolean resultEquals = first.equals(second);

        // Display results
        System.out.println("Result using charAt comparison: " + resultCharAt);
        System.out.println("Result using equals() method  : " + resultEquals);

        // Check if both results are same
        if (resultCharAt == resultEquals) {
            System.out.println("Both methods give the SAME result.");
        } else {
            System.out.println("Methods give DIFFERENT results.");
        }

        sc.close();
    }
}

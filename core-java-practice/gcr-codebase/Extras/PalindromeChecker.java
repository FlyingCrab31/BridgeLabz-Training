import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = readInput(sc);

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }
    }

    static String readInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    static boolean isPalindrome(String s) {
        s = s.replaceAll("\\s+", "").toLowerCase(); // ignore spaces, case
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

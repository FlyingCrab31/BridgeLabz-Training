import java.util.Scanner;

class PalindromeCheck {

    public static boolean isPalindromeIterative(String text) {
        int start = 0, end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static boolean isPalindromeUsingArrays(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseUsingCharAt(text);
        if (original.length != reversed.length) return false;
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static char[] reverseUsingCharAt(String text) {
        char[] rev = new char[text.length()];
        int j = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            rev[j++] = text.charAt(i);
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Logic 1 (iterative): " + isPalindromeIterative(text));
        System.out.println("Logic 2 (recursive): " +
                isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Logic 3 (arrays): " + isPalindromeUsingArrays(text));

        sc.close();
    }
}

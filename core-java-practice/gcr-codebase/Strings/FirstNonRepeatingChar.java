import java.util.Scanner;

class FirstNonRepeatingChar {

    public static char firstNonRepeating(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] == 1) {
                return c;
            }
        }
        return '\0';
        // '\0' indicates no non-repeating character found;...
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        char result = firstNonRepeating(text);
        if (result == '\0') {
            System.out.println("No non_Repeating character.");
        } else {
            System.out.println("First non_Repeating character: " + result);
        }
        sc.close();
    }
}

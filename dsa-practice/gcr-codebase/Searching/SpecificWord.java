
import java.util.Scanner;

public class SpecificWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of sentences
        int n = Integer.parseInt(sc.nextLine());

        // Read the specific word to search
        String word = sc.nextLine().trim();

        String[] sentences = new String[n];
        for (int i = 0; i < n; i++) {
            sentences[i] = sc.nextLine();
        }

        String result = "Not Found";
        for (int i = 0; i < n; i++) {
            if (sentences[i].toLowerCase().contains(word.toLowerCase())) {
                result = sentences[i];
                break; // first sentence containing the word
            }
        }

        System.out.println(result);

        sc.close();
    }
}

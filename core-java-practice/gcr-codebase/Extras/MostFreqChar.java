import java.util.HashMap;
import java.util.Scanner;
public class MostFreqChar {
    private static char findMostFrequentChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        // Iterate through each character in the string
        for (char ch : str.toCharArray()) {
            // Update the count of the character in the map
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            //getOrDefault(ch, 0) returns the current count of ch in the map, or 0 if ch is not present.
        }

        char mostFrequentChar = '\0';
        // '\0' is the null character, used here as a placeholder for initialization.
        int maxCount = 0;
        // Find the character with the maximum count
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentChar = entry.getKey();
            }
        }
        return mostFrequentChar;
    }

    // Main method to read input and print the most frequent character
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(findMostFrequentChar(inputString));
        sc.close();
    }
}
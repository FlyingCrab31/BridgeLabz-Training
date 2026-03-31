import java.util.Scanner;

class FrequencyWithUnique {

    public static char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] temp = new char[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = c;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static String[][] frequencyUsingUnique(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char[] uniques = uniqueCharacters(text);
        String[][] result = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            char c = uniques[i];
            result[i][0] = Character.toString(c);
            result[i][1] = Integer.toString(freq[c]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] freq = frequencyUsingUnique(text);
        System.out.println("Char  Freq");
        for (String[] row : freq) {
            System.out.println(row[0] + "  -> " + row[1]);
        }
        sc.close();
    }
}

import java.util.Scanner;

class CharFrequencyArray {

    public static String[][] charFrequencies(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                count++;
            }
        }

        String[][] result = new String[count][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[idx][0] = Character.toString((char) i);
                result[idx][1] = Integer.toString(freq[i]);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] freq = charFrequencies(text);
        System.out.println("Char  Freq");
        for (String[] row : freq) {
            System.out.println(row[0] + "  -> " + row[1]);
        }
        sc.close();
    }
}

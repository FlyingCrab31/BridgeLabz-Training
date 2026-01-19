
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {

    public static void main(String[] args) {
        String filePath = "input.txt";      // your file path
        String targetWord = "is";       // word to search
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // optional lower-case and trim punctuation if needed
                String[] words = line.split("\\s+"); // split by whitespace

                for (String word : words) {
                    if (word.equals(targetWord)) {   // or equalsIgnoreCase(...)
                        count++;
                    }
                }
            }

            System.out.println("The word \"" + targetWord + "\" appears " + count + " times.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

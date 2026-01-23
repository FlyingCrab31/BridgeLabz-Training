
import java.io.*;
import java.util.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(File file) throws IOException {
        Map<String, Integer> freq = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", " ");
                String[] words = line.split("\\s+");

                for (String w : words) {
                    if (w.isEmpty()) {
                        continue;
                    }
                    freq.put(w, freq.getOrDefault(w, 0) + 1);
                }
            }
        }

        return freq;
    }

    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";
        File temp = File.createTempFile("text", ".txt");
        try (FileWriter fw = new FileWriter(temp)) {
            fw.write(text);
        }

        Map<String, Integer> result = countWords(temp);
        System.out.println(result); // {hello=2, world=1, java=1}
    }
}

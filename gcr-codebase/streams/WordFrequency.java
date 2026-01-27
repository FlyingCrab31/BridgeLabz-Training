/*Write a Java program that counts the number of words in a given text file and displays the top 5 most frequently occurring words. */
import java.io.*;
import java.util.*;

public class WordFrequency {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/C:\\Users\\HP\\Documents\\GitHub\\BridgeLabz-Training\\collections-practice\\gcr-codebase\\streams\\source.txt"));
        Map<String, Integer> map = new HashMap<>();
        String line;

        while ((line = br.readLine()) != null) {
            for (String word : line.toLowerCase().split("\\W+")) {
                if (!word.isEmpty()) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }
        br.close();

        map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(5)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}

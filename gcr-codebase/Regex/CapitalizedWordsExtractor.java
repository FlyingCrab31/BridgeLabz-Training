
import java.util.*;
import java.util.regex.*;

public class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> result = extractCapitalizedWords(text);
        for (String word : result) {
            System.out.println(word);
        }
    }
}

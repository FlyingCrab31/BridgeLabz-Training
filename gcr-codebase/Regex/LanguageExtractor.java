
import java.util.*;
import java.util.regex.*;

public class LanguageExtractor {

    public static List<String> extractLanguages(String text) {
        List<String> langs = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            langs.add(matcher.group());
        }
        return langs;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> result = extractLanguages(text);
        for (String lang : result) {
            System.out.println(lang);
        }
    }
}


import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {

    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeats = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            repeats.add(matcher.group(1));
        }
        return repeats;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Set<String> result = findRepeatingWords(text);
        for (String w : result) {
            System.out.println(w);
        }
    }
}

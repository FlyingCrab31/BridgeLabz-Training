
import java.util.*;
import java.util.regex.*;

public class LinkExtractor {

    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\bhttps?://\\S+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> links = extractLinks(text);
        for (String link : links) {
            System.out.println(link);
        }
    }
}

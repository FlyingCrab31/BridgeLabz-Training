
import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {

    public static List<String> extractCurrency(String text) {
        List<String> values = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\$?\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> result = extractCurrency(text);
        for (String v : result) {
            System.out.println(v);
        }
    }
}

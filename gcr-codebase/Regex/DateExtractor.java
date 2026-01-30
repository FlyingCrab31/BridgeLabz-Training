
import java.util.*;
import java.util.regex.*;

public class DateExtractor {

    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }

    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        List<String> result = extractDates(text);
        for (String date : result) {
            System.out.println(date);
        }
    }
}

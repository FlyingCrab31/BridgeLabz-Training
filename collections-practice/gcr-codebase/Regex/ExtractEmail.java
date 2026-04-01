
import java.util.*;
import java.util.regex.*;

public class ExtractEmail {

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        List<String> emails = extractEmails(text);

        for (String email : emails) {
            System.out.println(email);
        }
    }
}

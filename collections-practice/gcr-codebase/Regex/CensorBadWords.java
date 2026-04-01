
import java.util.regex.*;

public class CensorBadWords {

    public static String censor(String text, String[] badWords) {
        StringBuilder patternBuilder = new StringBuilder();
        for (int i = 0; i < badWords.length; i++) {
            if (i > 0) {
                patternBuilder.append("|");
            }
            patternBuilder.append("\\b").append(Pattern.quote(badWords[i])).append("\\b");
        }

        Pattern pattern = Pattern.compile(patternBuilder.toString(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("****");
    }

    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String censored = censor(text, badWords);
        System.out.println(censored);
    }
}

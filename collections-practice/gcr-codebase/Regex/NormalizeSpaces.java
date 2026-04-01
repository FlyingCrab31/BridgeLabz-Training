
public class NormalizeSpaces {

    public static String normalize(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        String input = "This   is  an   example   with   multiple   spaces.";
        String output = normalize(input);
        System.out.println(output);
    }
}

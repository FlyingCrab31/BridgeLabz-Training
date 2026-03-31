public class TextFormatter {

    public static String autoFormat(String paragraph) {
        if (paragraph == null || paragraph.isBlank()) {
            return "";
        }

        // Trim leading/trailing spaces
        String result = paragraph.trim();

        // Replace multiple spaces/tabs/newlines with a single space
        result = result.replaceAll("\\s+", " ");

        // Ensure exactly one space after punctuation (., ?, !)
        // remove spaces before punctuation
        result = result.replaceAll("\\s*([.!?])\\s*", "$1 ");  // one space after punctuation

        //  Trim again in case a space was added at the end
        result = result.trim();

        //  Capitalize first letter of the whole paragraph
        StringBuilder sb = new StringBuilder(result.toLowerCase());
        if (sb.length() > 0 && Character.isLetter(sb.charAt(0))) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        // Capitalize first letter after '.', '?', '!'
        for (int i = 0; i < sb.length() - 2; i++) {
            char ch = sb.charAt(i);
            if (ch == '.' || ch == '?' || ch == '!') {
                // find next letter after any spaces
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == ' ') {
                    j++;
                }
                if (j < sb.length() && Character.isLetter(sb.charAt(j))) {
                    sb.setCharAt(j, Character.toUpperCase(sb.charAt(j)));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "   this   is   a   test.   how   are  you?i am fine!   ";
        String output = autoFormat(input);
        System.out.println(output);
        // Output: "This is a test. How are you? I am fine!"
    }
}

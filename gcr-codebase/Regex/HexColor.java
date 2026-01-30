
import java.util.regex.Pattern;

public class HexColor {

    public static final Pattern PATTERN = Pattern.compile("^#[0-9A-Fa-f]{6}$");

    public static boolean isValid(String str) {
        return str != null && PATTERN.matcher(str).matches();
    }

    public static void main(String[] args) {
        String str = "#FFA500";
        String s2 = "#123";
        System.out.println("result : " + isValid(str));
        System.out.println("Result : " + isValid(s2));
    }

}

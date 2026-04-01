
import java.util.regex.Pattern;

public class ValidPlate {

    public static final Pattern PATTERN = Pattern.compile("^[A-z]{2}[0-9]{4}$");

    public static boolean isValid(String str) {
        return str != null && PATTERN.matcher(str).matches();
    }

    public static void main(String[] args) {
        String str = "AB1234";
        System.out.println("result : " + isValid(str));
    }

}

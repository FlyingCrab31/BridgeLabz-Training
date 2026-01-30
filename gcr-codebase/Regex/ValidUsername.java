
import java.util.regex.Pattern;

public class ValidUsername {

    private static final Pattern PATTERN = Pattern
            .compile("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");

    public static boolean isValid(String username) {
        return username != null && PATTERN.matcher(username).matches();
    }

    public static void main(String[] args) {
        // Test cases
        String[] testUsernames = {
            "user_1", // valid
            "1user", // invalid (starts with digit)
            "us", // invalid (too short)
            "this_is_a_very_long_username", // invalid (too long)
            "validUser123", // valid
            "invalid-user!", // invalid (contains invalid characters)
            "User_Name" // valid
        };

        for (String username : testUsernames) {
            System.out.println("Username: " + username + " is valid: " + isValid(username));
        }
    }
}

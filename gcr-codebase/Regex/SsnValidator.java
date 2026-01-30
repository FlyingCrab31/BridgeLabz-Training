
public class SsnValidator {

    public static boolean isValidSsn(String ssn) {
        return ssn != null && ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }

    public static void main(String[] args) {
        String valid = "123-45-6789";
        String invalid = "123456789";

        System.out.println(valid + " -> " + isValidSsn(valid));     // true
        System.out.println(invalid + " -> " + isValidSsn(invalid)); // false
    }
}

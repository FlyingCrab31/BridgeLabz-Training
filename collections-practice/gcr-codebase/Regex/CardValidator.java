
public class CardValidator {

    // Visa: starts with 4, 16 digits
    // MasterCard: starts with 5, 16 digits
    private static final String CARD_REGEX = "^(4\\d{15}|5\\d{15})$";

    public static boolean isValidCard(String cardNumber) {
        if (cardNumber == null) {
            return false;
        }
        return cardNumber.matches(CARD_REGEX);
    }

    public static void main(String[] args) {
        String[] tests = {
            "4123456789012345", // Visa
            "5123456789012345", // MasterCard
            "6123456789012345", // Invalid (starts with 6)
            "412345678901234", // Invalid (15 digits)
        };

        for (String card : tests) {
            System.out.println(card + " -> " + isValidCard(card));
        }
    }
}

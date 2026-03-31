
public class ReverseString {

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String original = "Hello, World!";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }

}

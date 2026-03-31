import java.util.Scanner;

public class Palindrome{
    private static boolean Palindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        String org = sb.toString();
        String rev =  sb.reverse().toString();
        if(org.equals(rev)) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(Palindrome(input));
    }
}
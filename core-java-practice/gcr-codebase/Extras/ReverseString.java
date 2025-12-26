import java.util.Scanner;

public class ReverseString{
    

    private static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(reverseString(input));
    }
}
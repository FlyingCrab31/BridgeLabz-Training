import java.util.Scanner;

public class RemoveDuplicates{
    private static String removeDuplicates(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            //indexOF is used to check if the character is already present in the StringBuilder.
            //valueOf() converts the character to a String.
            if (sb.indexOf(String.valueOf(ch)) == -1){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(removeDuplicates(input));
        sc.close();
    }
}   
import java.util.Scanner;
public class DictionaryWord{
    public static void main(String[] args) {
        // Using lexographical order to compare two words and word which comes first in dictionary and which comes later.
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();
        //comapreTo() method compares two strings lexicographically.
        if(word1.compareTo(word2) < 0){
            System.out.println(word1);
            System.out.println(word2);
        } else {
            System.out.println(word2);
            System.out.println(word1);
        }
    }
}
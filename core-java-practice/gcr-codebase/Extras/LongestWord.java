import java.util.Scanner;

public class LongestWord{
    private static String findLongestWord(String s){
        //s.split(" ") splits the string into words based on spaces.
        String[] words = s.split(" ");
        String longestWord = "";
        //Iterate through each word in the array.
        for (String word : words){
            if (word.length() > longestWord.length()){
                longestWord = word;
            }
        }
        return longestWord;
    }
    //Main method to read input and print the longest word.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(findLongestWord(input));
        sc.close();
    }
}
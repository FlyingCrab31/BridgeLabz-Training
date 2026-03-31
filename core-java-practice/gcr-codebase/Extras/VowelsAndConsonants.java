import java.util.Scanner;

public class VowelsAndConsonants{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = input.length();
        int countVowels = 0;
        int countConsonants = 0;
        for (int i = 0; i < n; i++){
            char ch = input.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                countVowels++;
            } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                countConsonants++;
            }
      
        }
        System.out.println("Number of vowels: " + countVowels);
        System.out.println("Number of consonants: " + countConsonants);
        sc.close();
    }
}
import java.util.*;

public class LexicalTwist{

    private static boolean isVowel(char ch){
        return "AEIOUaeiou".indexOf(ch) != -1;

    
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word : ");
        String first = sc.nextLine();


        if(first.trim().contains(" ")){
            System.out.println(first+" is an invalid word");
            return;

        }


        System.out.println("Enter second word : ");
        String second = sc.nextLine();
        if(second.trim().contains(" ")){
            System.out.println(second+" is an invalid word");
            return;

        }


        String reverseFirst=new StringBuilder(first).reverse().toString();
       

       if(reverseFirst.equalsIgnoreCase(second)){
        String result = reverseFirst.toLowerCase();
        StringBuilder transformed = new StringBuilder();

        for(char ch:result.toCharArray()){
            if(isVowel(ch)){
                transformed.append('@');
            }
            else{
                transformed.append((ch));
        }
       }

       System.out.println(transformed.toString());

    }

    else{

        String combined = (first+second).toUpperCase();

        int vowels = 0,consonants = 0;

        for(char ch:combined.toCharArray()){
            if(Character.isLetter(ch)){
                if(isVowel(ch)){
                    vowels++;
                }
                else{
                    consonants++;
                }
            }

    }

    if(vowels>consonants){
        printFirstTwoUnique(combined,true);
    }
    else if(consonants>vowels){
        printFirstTwoUnique(combined,false);
    }
    else {
        System.out.println("Vowels and Consonants are equal");
    }
    }
    }


    private static void printFirstTwoUnique(String word,boolean vowels){
        StringBuilder result = new StringBuilder();
        for(char ch:word.toCharArray()){
            if(Character.isLetter(ch)){
                if (isVowel(ch) == vowels &&
                        result.indexOf(String.valueOf(ch)) == -1) {

                    result.append(ch);

                    if (result.length() == 2)
                        break;
                }
            }
        }

        System.out.println(result.toString());
    }
}
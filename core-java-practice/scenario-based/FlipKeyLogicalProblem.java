

/*Input must:
NOT be null
Have at least 6 characters
Contain only alphabets (no spaces, digits, or special characters)
Steps:
Convert input to lowercase
Remove characters whose ASCII value is even
Reverse remaining characters
In reversed string:
Convert even index (0-based) characters to uppercase
If anything fails → Invalid Input */
import java.util.*;


public class FlipKeyLogicalProblem{

    public static String CleanseAndInvert(String input){

        // Can not be null and contain at least 6 characters long

        if(input == null || input.length() < 6 ){
            return "";

        }

        // Validation : only alphbets allowed 
        for(int i = 0; i < input.length(); i++){
            if(!Character.isLetter(input.charAt(i))){
                return "";

            }

        }
        //Conver to lowercase
        input = input.toLowerCase();

        //Remove characters with even ASCII values 
        StringBuilder filtered = new StringBuilder();
        for(int  i = 0; i < input.length(); i++){
            int ascii = input.charAt(i);
            if(ascii % 2 != 0){
                filtered.append(input.charAt(i));
            }
        }

        filtered.reverse();

        //Convert even index characters to uppercase 
        for(int i=0 ; i< filtered.length() ; i++){
            if(i % 2 == 0){
                filtered.setCharAt(i , Character.toUpperCase(filtered.charAt(i)));
            }
        }
        return filtered.toString();

    }
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter a word : ");
        String input = sc.nextLine();

        String result = CleanseAndInvert(input);
        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }






    }
    
}
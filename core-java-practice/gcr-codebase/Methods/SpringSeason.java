import java.util.Scanner;
public class SpringSeason{

    // spring season is from 20th March to 20th June...
    private static boolean isSpringSeason(int month, int day){
        if((month == 3 && day >= 20) || (month == 6 && day <= 20) || (month > 3 && month < 6)){
            return true;
        } else{
            return false;
        }

    }
    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int day = sc.nextInt();
        boolean result = isSpringSeason(month, day);
        if(result){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
    }
} 
import java.util.Scanner;
public class CheckNumber{

    // method to check if number is positive, negative or zero

    private static int checkNumber(int number){
        if(number > 0){
            return 1; // Positive
        } else if(number < 0){
            return -1; // Negative
        } else{
            return 0; // Zero
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = checkNumber(number);
        switch (result) {
            case 1 -> System.out.println("Positive 1 ");
            case -1 -> System.out.println("Negative -1");
            default -> System.out.println("Zero 0");
        }
    }
}
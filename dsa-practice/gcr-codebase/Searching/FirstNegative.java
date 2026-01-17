//import java.util.Scanner;

public class FirstNegative {

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        int[] arr = {1, 4, 8, 9, -1, 3, 2};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                System.out.println(i);
                break;
            }
        }
    }
}

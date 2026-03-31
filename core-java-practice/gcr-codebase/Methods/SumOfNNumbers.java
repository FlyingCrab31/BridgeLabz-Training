import java.util.Scanner;
public class SumOfNNumbers{

    // Method to calculate sum of first N natural numbers

    private static int sumOfNNumbers(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
        }
        // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumOfNNumbers(n));
    }
}
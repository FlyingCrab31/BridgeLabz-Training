import java.util.Scanner;

public class MaxNoOfHandshakes {
    static int maxHandshakes(int n){
        int handshakes = (n * (n - 1)) / 2;
        return handshakes;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(maxHandshakes(n));
    }
}
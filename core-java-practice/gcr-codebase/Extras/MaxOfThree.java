import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = readInt(sc, "Enter first number: ");
        int b = readInt(sc, "Enter second number: ");
        int c = readInt(sc, "Enter third number: ");

        int max = maxOfThree(a, b, c);
        System.out.println("Maximum is: " + max);
    }

    static int readInt(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    static int maxOfThree(int a, int b, int c) { // typical if-else based max 
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}

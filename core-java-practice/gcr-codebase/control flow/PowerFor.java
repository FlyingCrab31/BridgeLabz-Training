import java.util.Scanner;

class PowerFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int power = sc.nextInt();    // assume non‑negative

        int result = 1;

        for (int i = 1; i <= power; i++) {
            result = result * number;
        }

        System.out.println("Result = " + result);

        sc.close();
    }
}

import java.util.Scanner;

class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 1) {
            int sumWhile = 0;
            int i = 1;
            while (i <= n) {
                sumWhile += i;
                i++;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using while = " + sumWhile);
            System.out.println("Sum using formula = " + sumFormula);
        } else {
            System.out.println("Not a natural number");
        }

        sc.close();
    }
}

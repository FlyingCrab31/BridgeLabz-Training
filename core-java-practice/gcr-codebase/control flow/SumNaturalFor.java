import java.util.Scanner;

class SumNaturalFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 1) {
            int sumFor = 0;
            for (int i = 1; i <= n; i++) {
                sumFor += i;
            }

            int sumFormula = n * (n + 1) / 2;

            System.out.println("Sum using for = " + sumFor);
            System.out.println("Sum using formula = " + sumFormula);
        } else {
            System.out.println("Not a natural number");
        }

        sc.close();
    }
}

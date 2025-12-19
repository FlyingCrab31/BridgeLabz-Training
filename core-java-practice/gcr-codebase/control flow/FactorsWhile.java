import java.util.Scanner;

class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();   // assume positive

        int counter = 1;
        while (counter < number) {
            if (number % counter == 0) {
                System.out.println(counter);
            }
            counter++;
        }

        sc.close();
    }
}

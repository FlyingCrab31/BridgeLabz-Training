import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int low = 1;
        int high = 100;

        System.out.println("Think of a number between " + low + " and " + high + ".");
        System.out.println("I will try to guess it randomly!");
        System.out.println("Enter 'h' if my guess is too high, 'l' if too low, 'c' if correct.");

        OUTER:
        while (true) {
            int guess = low + rand.nextInt(high - low + 1);
            System.out.println("Is your number " + guess + "? (h/l/c): ");
            char feedback = sc.next().charAt(0);
            switch (feedback) {
                case 'c' -> {
                    System.out.println("Yay! Guessed correctly.");
                    break OUTER;
                }
                case 'h' -> high = guess - 1;
                case 'l' -> low = guess + 1;
                default -> System.out.println("Invalid input, please enter h/l/c.");
            }
            if (low > high) {
                System.out.println("Inconsistent feedback, no numbers left in range.");
                break;
            }
        }
    }
}

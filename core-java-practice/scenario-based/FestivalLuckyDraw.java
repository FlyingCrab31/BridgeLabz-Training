import java.util.Scanner;

public class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfVisitors;

        System.out.print("Enter total number of visitors: ");
        numberOfVisitors = sc.nextInt();

        int currentVisitor = 1;

        while (currentVisitor <= numberOfVisitors) {
            System.out.print("\nVisitor " + currentVisitor + " - Enter your number: ");
            //sc.hasNextInt() checks if the next input is an integer

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // consume invalid token
                continue;       // skip counting this visitor, ask again
            }

            int num = sc.nextInt();

            if (num % 3 == 0 && num % 5 == 0) {
                System.out.println("Congratulations! You win a gift!");
            } else {
                System.out.println("Sorry, no gift this time.");
            }

            currentVisitor++;
        }

        System.out.println("\nLucky draw over. Thank you for participating!");
        sc.close();
    }
}

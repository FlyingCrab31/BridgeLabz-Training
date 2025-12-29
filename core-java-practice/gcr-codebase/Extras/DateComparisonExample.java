import java.time.LocalDate;
import java.util.Scanner;

public class DateComparisonExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format: yyyy-MM-dd
        System.out.print("Enter first date  (yyyy-MM-dd): ");
        LocalDate d1 = LocalDate.parse(sc.nextLine());

        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate d2 = LocalDate.parse(sc.nextLine());

        if (d1.isBefore(d2)) {                         // true if d1 < d2 
            System.out.println("First date is before second date.");
        } else if (d1.isAfter(d2)) {                  // true if d1 > d2
            System.out.println("First date is after second date.");
        } else if (d1.isEqual(d2)) {                  // true if same calendar date
            System.out.println("Both dates are the same.");
        }
    }
}

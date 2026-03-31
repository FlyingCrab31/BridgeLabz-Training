import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmeticExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format: yyyy-MM-dd
        System.out.print("Enter date (yyyy-MM-dd): ");
        String input = sc.nextLine();

        LocalDate date = LocalDate.parse(input); // parses ISO format yyyy-MM-dd 

        // Step 1: add 7 days, 1 month, 2 years
        LocalDate added = date
                .plusDays(7)    // add 7 days 
                .plusMonths(1)  // add 1 month 
                .plusYears(2);  // add 2 years 

        // Step 2: subtract 3 weeks
        LocalDate result = added.minusWeeks(3); // subtract 3 weeks

        System.out.println("Original date : " + date);
        System.out.println("After +7d, +1m, +2y: " + added);
        System.out.println("Final result (then -3 weeks): " + result);
    }
}

import java.util.Scanner;
public class LibraryReminderApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int FINE_PER_DAY = 5;
        final int TOTAL_BOOKS = 5;

        for (int i = 1; i <= TOTAL_BOOKS; i++) {
            System.out.println("Enter due date for book " + i + " (in days): ");
            int dueDate = sc.nextInt();

            System.out.println("Enter return date for book " + i + " (in days): ");
            int returnDate = sc.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * FINE_PER_DAY;
                System.out.println("Book " + i + " is returned late by " + lateDays + " days. Fine: ₹" + fine);
            } else {
                System.out.println("Book " + i + " is returned on time. No fine.");
            }
        }
    }
}
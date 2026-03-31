import java.util.Scanner;
public class TicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continueBooking = null;

        do {
            System.out.println("Enter movie type (1: Action, 2: Comedy, 3: Drama): ");
            int movieType = sc.nextInt();

            System.out.println("Enter seat type (1: Gold, 2: Silver): ");
            int seatType = sc.nextInt();

            double ticketPrice = 0.0;

            // Determine base ticket price based on movie type
            switch (movieType) {
                case 1 -> // Action
                    ticketPrice = 15.0;
                case 2 -> // Comedy
                    ticketPrice = 12.0;
                case 3 -> // Drama
                    ticketPrice = 10.0;
                default -> {
                    System.out.println("Invalid movie type selected.");
                    continue; // Skip to next iteration
                }
            }

            // Adjust price based on seat type
            switch (seatType) {
                case 1 -> // Gold
                    ticketPrice += 5.0;
                case 2 -> // Silver
                    ticketPrice += 2.0;
                default -> {
                    System.out.println("Invalid seat type selected.");
                    continue; // Skip to next iteration
                }
            }

            System.out.println("Do you want snacks? (yes/no): ");
            String wantsSnacks = sc.next();

            if (wantsSnacks.equalsIgnoreCase("yes")) {
                ticketPrice += 7.0; // Flat rate for snacks
            }

            System.out.printf("Total ticket price: $%.2f%n", ticketPrice);

            System.out.println("Do you want to book another ticket? (yes/no): ");
            continueBooking = sc.next();

        }
        while (continueBooking.equalsIgnoreCase("yes"));{
            // Loop continues for next customer
        }

        }

        
}
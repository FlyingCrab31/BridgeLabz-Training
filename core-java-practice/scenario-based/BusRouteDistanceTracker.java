import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalDistance = 0.0;     // total distance travelled
        int stopNumber = 1;             // to show current stop

        System.out.print("Enter distance between two stops (in km): ");
        double distancePerStop = scanner.nextDouble();
        scanner.nextLine(); // consume leftover newline

        String choice = "no";           // default: not getting off

        // run until passenger confirms to get off
        while (choice.equalsIgnoreCase("no")) {
            System.out.println("\nBus reached stop " + stopNumber);
            totalDistance += distancePerStop;
            System.out.println("Total distance travelled so far: " + totalDistance + " km");

            System.out.print("Do you want to get off here? (yes/no): ");
            choice = scanner.nextLine().trim();

            // validate input
            while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                System.out.print("Invalid input. Please type 'yes' or 'no': ");
                choice = scanner.nextLine().trim();
            }

            stopNumber++;
        }

        System.out.println("\nYou got off the bus.");
        System.out.println("Final distance travelled: " + totalDistance + " km");

        scanner.close();
    }
}

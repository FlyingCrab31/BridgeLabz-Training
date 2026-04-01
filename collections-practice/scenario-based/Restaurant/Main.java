package Restaurant;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();

        LocalDateTime start = LocalDateTime.of(2026, Month.JANUARY, 28, 19, 0);
        LocalDateTime end   = LocalDateTime.of(2026, Month.JANUARY, 28, 21, 0);

        // first reservation OK
        system.reserveTable(1, "Alice", start, end);

        // second reservation on the same table and overlapping time -> exception
        try {
            system.reserveTable(1, "Bob", start.plusMinutes(30), end);
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Available tables: " +
                system.showAvailableTables(start, end));
    }
}


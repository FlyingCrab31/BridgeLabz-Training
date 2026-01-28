package Restaurant;

import java.time.LocalDateTime;
import java.util.*;

public class RestaurantReservationSystem {

    // tableNumber -> Table
    private final Map<Integer, Table> tables = new HashMap<>();

    // all reservations
    private final List<Reservation> reservations = new ArrayList<>();

    public RestaurantReservationSystem() {
        // sample data
        addTable(new Table(1, 2));
        addTable(new Table(2, 4));
        addTable(new Table(3, 6));
    }

    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    // ----------------- core methods -----------------

    public Reservation reserveTable(int tableNumber,
                                    String customerName,
                                    LocalDateTime startTime,
                                    LocalDateTime endTime) {

        if (!tables.containsKey(tableNumber)) {
            throw new IllegalArgumentException("Table " + tableNumber + " does not exist");
        }

        // prevent double booking
        if (isTableReserved(tableNumber, startTime, endTime)) {
            throw new TableAlreadyReservedException(
                    "Table " + tableNumber + " is already reserved for the given time slot");
        }

        Reservation reservation =
                new Reservation(tableNumber, customerName, startTime, endTime);
        reservations.add(reservation);
        return reservation;
    }

    public void cancelReservation(int tableNumber,
                                  String customerName,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime) {

        Iterator<Reservation> it = reservations.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getTableNumber() == tableNumber
                    && r.getCustomerName().equals(customerName)
                    && r.getStartTime().equals(startTime)
                    && r.getEndTime().equals(endTime)) {
                it.remove();
                return;
            }
        }
        // optionally throw if not found
        // throw new IllegalArgumentException("Reservation not found");
    }

    public List<Table> showAvailableTables(LocalDateTime startTime,
                                           LocalDateTime endTime) {

        List<Table> available = new ArrayList<>();
        for (Table table : tables.values()) {
            if (!isTableReserved(table.getTableNumber(), startTime, endTime)) {
                available.add(table);
            }
        }
        return available;
    }

    // ----------------- helper -----------------

    private boolean isTableReserved(int tableNumber,
                                    LocalDateTime startTime,
                                    LocalDateTime endTime) {

        for (Reservation r : reservations) {
            if (r.getTableNumber() != tableNumber) {
                continue;
            }
            // time overlap check:
            // [startTime, endTime) overlaps [r.start, r.end)
            boolean overlaps =
                    !startTime.isAfter(r.getEndTime()) &&
                            !endTime.isBefore(r.getStartTime());

            if (overlaps) {
                return true;
            }
        }
        return false;
    }
}


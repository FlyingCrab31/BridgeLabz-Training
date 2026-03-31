import java.time.LocalDate;
import java.util.*;

// Custom exception
class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}

enum RoomType {
    STANDARD,
    DELUXE
}

class Room {
    private final int number;
    private final RoomType type;
    private final double basePricePerNight;

    public Room(int number, RoomType type, double basePricePerNight) {
        this.number = number;
        this.type = type;
        this.basePricePerNight = basePricePerNight;
    }

    public int getNumber() { return number; }
    public RoomType getType() { return type; }
    public double getBasePricePerNight() { return basePricePerNight; }

    @Override
    public String toString() {
        return "Room{" + number + ", " + type + ", base=" + basePricePerNight + "}";
    }
}

// Inheritance: deluxe vs standard
class StandardRoom extends Room {
    public StandardRoom(int number, double basePricePerNight) {
        super(number, RoomType.STANDARD, basePricePerNight);
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(int number, double basePricePerNight) {
        super(number, RoomType.DELUXE, basePricePerNight);
    }
}

class Guest {
    private final int id;
    private final String name;

    public Guest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Guest{" + id + ", " + name + "}";
    }
}

enum ReservationStatus {
    BOOKED,
    CHECKED_IN,
    CHECKED_OUT,
    CANCELLED
}

class Reservation {
    private final int id;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private ReservationStatus status = ReservationStatus.BOOKED;
    private double totalAmount;

    public Reservation(int id, Guest guest, Room room,
                       LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getId() { return id; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public ReservationStatus getStatus() { return status; }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }

    public double getTotalAmount() { return totalAmount; }

    public void checkIn() {
        if (status != ReservationStatus.BOOKED)
            throw new IllegalStateException("Can check-in only from BOOKED state");
        status = ReservationStatus.CHECKED_IN;
    }

    public void checkOut() {
        if (status != ReservationStatus.CHECKED_IN)
            throw new IllegalStateException("Can check-out only from CHECKED_IN state");
        status = ReservationStatus.CHECKED_OUT;
    }

    public void cancel() {
        if (status == ReservationStatus.CHECKED_OUT)
            throw new IllegalStateException("Cannot cancel after check-out");
        status = ReservationStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Reservation{" + id + ", room=" + room.getNumber() +
               ", guest=" + guest.getName() +
               ", " + checkInDate + " to " + checkOutDate +
               ", status=" + status + ", total=" + totalAmount + "}";
    }
}

// Strategy interface
interface PricingStrategy {
    double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut);
}

// No seasonal change
class RegularPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        long nights = checkIn.until(checkOut).getDays();
        return nights * room.getBasePricePerNight();
    }
}

// Seasonal pricing: e.g. peak season multiplier
class SeasonalPricingStrategy implements PricingStrategy {
    private final double peakMultiplier;
    private final Set<Integer> peakMonths; // e.g. 5,6 for May/Jun

    public SeasonalPricingStrategy(double peakMultiplier, Set<Integer> peakMonths) {
        this.peakMultiplier = peakMultiplier;
        this.peakMonths = peakMonths;
    }

    @Override
    public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut) {
        long nights = checkIn.until(checkOut).getDays();
        double base = nights * room.getBasePricePerNight();
        if (isPeakSeason(checkIn, checkOut)) {
            return base * peakMultiplier;
        }
        return base;
    }

    private boolean isPeakSeason(LocalDate in, LocalDate out) {
        LocalDate d = in;
        while (!d.isAfter(out.minusDays(1))) {
            if (peakMonths.contains(d.getMonthValue())) {
                return true;
            }
            d = d.plusDays(1);
        }
        return false;
    }
}

class HotelService {

    private final Map<Integer, Room> rooms = new HashMap<>();
    private final Map<Integer, Guest> guests = new HashMap<>();
    private final Map<Integer, Reservation> reservations = new HashMap<>();
    private int nextReservationId = 1;

    // Room management
    public void addRoom(Room room) {
        rooms.put(room.getNumber(), room);
    }

    public Collection<Room> listRooms() {
        return rooms.values();
    }

    public void registerGuest(Guest guest) {
        guests.put(guest.getId(), guest);
    }

    public Guest getGuest(int id) {
        Guest g = guests.get(id);
        if (g == null) throw new IllegalArgumentException("Guest not found");
        return g;
    }

    // Check room availability for given dates
    public boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        for (Reservation r : reservations.values()) {
            if (r.getRoom().getNumber() == room.getNumber()
                && r.getStatus() != ReservationStatus.CANCELLED) {
                boolean overlaps =
                        !checkOut.isBefore(r.getCheckInDate()) &&
                        !checkIn.isAfter(r.getCheckOutDate().minusDays(1));
                if (overlaps) return false;
            }
        }
        return true;
    }

    // Reservation booking (with strategy + exception)
    public Reservation bookRoom(int guestId, int roomNumber,
                                LocalDate checkIn, LocalDate checkOut,
                                PricingStrategy pricingStrategy)
            throws RoomNotAvailableException {
        Guest guest = getGuest(guestId);
        Room room = rooms.get(roomNumber);
        if (room == null) throw new IllegalArgumentException("Room not found");

        if (!isRoomAvailable(room, checkIn, checkOut)) {
            throw new RoomNotAvailableException(
                    "Room " + roomNumber + " not available for selected dates");
        }

        Reservation reservation = new Reservation(
                nextReservationId++, guest, room, checkIn, checkOut);
        double price = pricingStrategy.calculatePrice(room, checkIn, checkOut);
        reservation.setTotalAmount(price);

        reservations.put(reservation.getId(), reservation);
        return reservation;
    }

    public Reservation getReservation(int reservationId) {
        Reservation r = reservations.get(reservationId);
        if (r == null) throw new IllegalArgumentException("Reservation not found");
        return r;
    }

    // Check-in / check-out
    public void checkIn(int reservationId) {
        Reservation r = getReservation(reservationId);
        r.checkIn();
    }

    public void checkOut(int reservationId) {
        Reservation r = getReservation(reservationId);
        r.checkOut();
    }

    // Cancel reservation
    public void cancelReservation(int reservationId) {
        Reservation r = getReservation(reservationId);
        r.cancel();
    }

    // Invoice generation
    public String generateInvoice(int reservationId) {
        Reservation r = getReservation(reservationId);
        StringBuilder sb = new StringBuilder();
        sb.append("=== Invoice ===\n");
        sb.append("Reservation ID: ").append(r.getId()).append("\n");
        sb.append("Guest: ").append(r.getGuest().getName()).append("\n");
        sb.append("Room: ").append(r.getRoom().getNumber())
          .append(" (").append(r.getRoom().getType()).append(")\n");
        sb.append("Stay: ").append(r.getCheckInDate())
          .append(" to ").append(r.getCheckOutDate()).append("\n");
        sb.append("Status: ").append(r.getStatus()).append("\n");
        sb.append("Total amount: ").append(r.getTotalAmount()).append("\n");
        sb.append("================\n");
        return sb.toString();
    }
}

public class HotelManagement {
    public static void main(String[] args) {
        HotelService service = new HotelService();

        // Room management
        service.addRoom(new StandardRoom(101, 2000));
        service.addRoom(new DeluxeRoom(201, 3500));

        // Guests
        Guest g1 = new Guest(1, "Rishabh");
        service.registerGuest(g1);

        LocalDate in = LocalDate.now().plusDays(1);
        LocalDate out = in.plusDays(3);

        // Pricing: seasonal (e.g. May, Jun as peak with 1.5x)
        PricingStrategy seasonal = new SeasonalPricingStrategy(
                1.5, new HashSet<>(Arrays.asList(5, 6)));

        try {
            Reservation r = service.bookRoom(
                    g1.getId(), 201, in, out, seasonal);
            System.out.println("Booked: " + r);

            service.checkIn(r.getId());
            System.out.println("After check-in: " + service.getReservation(r.getId()));

            service.checkOut(r.getId());
            System.out.println("After check-out: " + service.getReservation(r.getId()));

            String invoice = service.generateInvoice(r.getId());
            System.out.println(invoice);
        } catch (RoomNotAvailableException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}

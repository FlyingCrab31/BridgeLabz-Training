package Restaurant;

public class TableAlreadyReservedException extends RuntimeException {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}


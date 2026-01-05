import java.util.ArrayList;
import java.util.List;
// Interface for reservation behavior
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract base class
abstract class LibraryItem implements Reservable {

    final private String itemId;
    final private String title;
    final private String author;

    // Encapsulated borrower info
    private String borrowerName;
    private boolean reserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.reserved = false;
    }

    // Abstract method: each item defines its own loan duration
    public abstract int getLoanDuration(); // in days

    // Concrete common method
    public String getItemDetails() {
        return "ID: " + itemId +
               ", Title: " + title +
               ", Author: " + author;
    }

    // Encapsulation of borrower data
    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        if (borrowerName == null || borrowerName.isBlank()) {
            throw new IllegalArgumentException("Borrower name cannot be empty");
        }
        this.borrowerName = borrowerName;
    }

    // Interface implementation 
    @Override
    public void reserveItem(String borrowerName) {
        if (reserved) {
            System.out.println("Item already reserved: " + title);
            return;
        }
        setBorrowerName(borrowerName); // use setter for validation
        this.reserved = true;
        System.out.println("Reserved '" + title + "' for " + borrowerName);
    }

    @Override
    public boolean checkAvailability() {
        return !reserved;
    }
}
class Book extends LibraryItem {

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // Books can be loaned for 14 days
        return 14;
    }
}

class Magazine extends LibraryItem {

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // Magazines can be loaned for 7 days
        return 7;
    }
}

class DVD extends LibraryItem {

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        // DVDs can be loaned for 3 days
        return 3;
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "Effective Java", "Joshua Bloch"));
        items.add(new Magazine("M201", "National Geographic", "Various"));
        items.add(new DVD("D301", "Inception", "Christopher Nolan"));

        // Polymorphic handling of all items
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan duration: " + item.getLoanDuration() + " days");
            System.out.println("Available: " + item.checkAvailability());
            System.out.println("----");
        }

        // Reservation example via interface methods
        LibraryItem firstItem = items.get(0);
        firstItem.reserveItem("Alice");
        System.out.println("Available after reservation: " + firstItem.checkAvailability());
        System.out.println("Borrower: " + firstItem.getBorrowerName());
    }
}


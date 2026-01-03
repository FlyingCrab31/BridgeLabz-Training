import java.util.Scanner;
class Book {
    private String title;
    private String author;
    private boolean checkedOut; // false = available, true = checked out

    public Book(String title, String author, boolean checkedOut) {
        this.title = title;
        this.author = author;
        this.checkedOut = checkedOut;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public void display() {
        String status = checkedOut ? "Checked out" : "Available";
        System.out.println("Title: " + title + ", Author: " + author + ", Status: " + status);
    }
}

public class LibrarySystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store book data in an array
        Book[] books = {
            new Book("Java Programming", "Herbert Schildt", false),
            new Book("Clean Code", "Robert C. Martin", false),
            new Book("Head First Java", "Kathy Sierra", true),
            new Book("Design Patterns", "GoF", false)
        };

        while (true) {
            System.out.println("\n1. Display all books");
            System.out.println("2. Search by title");
            System.out.println("3. Checkout a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayBooks(books);
                    break;
                case 2:
                    System.out.print("Enter partial title to search: ");
                    String query = sc.nextLine();
                    searchByTitle(books, query);
                    break;
                case 3:
                    System.out.print("Enter exact title to checkout: ");
                    String checkoutTitle = sc.nextLine();
                    updateStatus(books, checkoutTitle, true);
                    break;
                case 4:
                    System.out.print("Enter exact title to return: ");
                    String returnTitle = sc.nextLine();
                    updateStatus(books, returnTitle, false);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Display all books
    public static void displayBooks(Book[] books) {
        for (Book b : books) {
            b.display();
        }
    }

    // Search by partial title (case-insensitive, using String operations)[web:1]
    public static void searchByTitle(Book[] books, String partial) {
        String query = partial.toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(query)) {
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with title containing: " + partial);
        }
    }

    // Update book status: checked out / available
    public static void updateStatus(Book[] books, String title, boolean checkout) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                if (checkout) {
                    if (b.isCheckedOut()) {
                        System.out.println("Book is already checked out.");
                    } else {
                        b.setCheckedOut(true);
                        System.out.println("Book checked out successfully.");
                    }
                } else {
                    if (!b.isCheckedOut()) {
                        System.out.println("Book is already available.");
                    } else {
                        b.setCheckedOut(false);
                        System.out.println("Book returned successfully.");
                    }
                }
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" not found.");
    }
}

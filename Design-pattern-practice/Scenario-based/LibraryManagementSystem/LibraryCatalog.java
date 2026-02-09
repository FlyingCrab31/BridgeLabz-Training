package LibraryManagementSystem;

import java.util.*;

public class LibraryCatalog {

    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private LibraryCatalog() {}

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book.getTitle());
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available yet.");
            return;
        }
        System.out.println("\nAvailable Books:");
        books.forEach(b -> System.out.println("\n- " + b));
    }

    private void notifyObservers(String bookTitle) {
        for (Observer o : observers) {
            o.update("New book available: " + bookTitle);
        }
    }
}
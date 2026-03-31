import java.util.ArrayList;
import java.util.List;

class Book {

    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}


class SmartShelf {

    // internal reading list kept sorted by title
    private final List<Book> readingList = new ArrayList<>();

    // online/real-time insertion sort behavior
    public void addBook(Book newBook) {
        // find correct position using insertion sort logic
        int i = readingList.size() - 1;

        // shift books with title > newBook.title to the right
        while (i >= 0 &&
               readingList.get(i).getTitle().compareToIgnoreCase(newBook.getTitle()) > 0) {
            i--;
        }

        // insert just after the last smaller/equal title
        // equal titles keep original order
        readingList.add(i + 1, newBook);
    }

    public List<Book> getReadingList() {
        return readingList;
    }

    public void printReadingList() {
        System.out.println("Current SmartShelf reading list (sorted by title):");
        for (Book b : readingList) {
            System.out.println(" - " + b);
        }
    }
}


public class BookManagement {
    public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf();

        // users add books one by one (list stays mostly sorted)
        shelf.addBook(new Book("Clean Code", "Robert C. Martin"));
        shelf.addBook(new Book("Algorithms", "Robert Sedgewick"));
        shelf.addBook(new Book("Design Patterns", "GoF"));
        shelf.addBook(new Book("Clean Architecture", "Robert C. Martin"));
        shelf.addBook(new Book("Algorithm Design Manual", "Steven S. Skiena"));

        shelf.printReadingList();
    }
}

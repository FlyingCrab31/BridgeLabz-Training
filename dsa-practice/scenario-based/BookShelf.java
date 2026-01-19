
import java.util.*;

class Book {

    private String title;
    private String author;
    private String isbn;
    private String genre;

    // constructor, getters
    public Book(String title, String author, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return title + " by " + author + " [" + isbn + "]";
    }
}

class BookShelf {

    private Map<String, LinkedList<Book>> catalog = new HashMap<>();
    // optional: to avoid duplicates
    private Map<String, HashSet<Book>> genreSets = new HashMap<>();

    // get or create list for genre
    private LinkedList<Book> getList(String genre) {
        return catalog.computeIfAbsent(genre, g -> new LinkedList<>());
    }

    private HashSet<Book> getSet(String genre) {
        return genreSets.computeIfAbsent(genre, g -> new HashSet<>());
    }

    // insert book (return/adding new)
    public void addBook(Book book) {
        String genre = book.getGenre();
        LinkedList<Book> list = getList(genre);

        // without duplication control:
        // list.addLast(book);
        // with HashSet-based duplication control
        HashSet<Book> set = getSet(genre);
        if (!set.contains(book)) {
            list.addLast(book);          // efficient tail insert
            set.add(book);
        } else {
            System.out.println("Duplicate book ignored: " + book);
        }
    }

    // delete book when borrowed (remove from shelf)
    public boolean borrowBook(String genre, String isbn) {
        LinkedList<Book> list = catalog.get(genre);
        if (list == null || list.isEmpty()) {
            return false;
        }

        Iterator<Book> it = list.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getIsbn().equals(isbn)) {
                it.remove();             // LinkedList remove via iterator
                HashSet<Book> set = genreSets.get(genre);
                if (set != null) {
                    set.remove(b);
                }
                return true;
            }
        }
        return false;
    }

    // when returned, simply call addBook(book)
    public void returnBook(Book book) {
        addBook(book);
    }

    // print genre-wise catalog
    public void printCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty");
            return;
        }
        for (Map.Entry<String, LinkedList<Book>> e : catalog.entrySet()) {
            String genre = e.getKey();
            LinkedList<Book> books = e.getValue();
            System.out.println("Genre: " + genre);
            for (Book b : books) {
                System.out.println("  - " + b);
            }
        }
    }

    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();

        Book b1 = new Book("Effective Java", "Joshua Bloch", "ISBN-111", "Programming");
        Book b2 = new Book("Clean Code", "Robert C. Martin", "ISBN-222", "Programming");
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", "ISBN-333", "Fantasy");

        shelf.addBook(b1);
        shelf.addBook(b2);
        shelf.addBook(b3);
        shelf.addBook(b1);  // duplicate, ignored if HashSet is enabled

        shelf.printCatalog();

        System.out.println("Borrowing ISBN-222...");
        shelf.borrowBook("Programming", "ISBN-222");
        shelf.printCatalog();

        System.out.println("Returning ISBN-222...");
        shelf.returnBook(b2);
        shelf.printCatalog();
    }
}

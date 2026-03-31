package BookShelf;
import java.util.*;

public class BookShelf{

private final Map<String, LinkedList<Book>> catalog = new HashMap<>();
// optional: to avoid duplicates
private final Map<String, HashSet<Book>> genreSets = new HashMap<>();

// get or create a list for genre
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
}

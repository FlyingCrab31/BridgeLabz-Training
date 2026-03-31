// Base class
class Book {
    // Access modifiers as required
    public String ISBN;      // public
    protected String title;  // protected
    private String author;   // private

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter for author (public)
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author (public)
    public String getAuthor() {
        return author;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN   : " + ISBN);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("---------------------------");
    }
}

// Subclass to demonstrate access modifiers
class EBook extends Book {
    double fileSizeMB;

    EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    // Can access public ISBN and protected title directly
    public void displayEBookDetails() {
        System.out.println("E-Book ISBN  : " + ISBN);    // public
        System.out.println("E-Book Title : " + title);   // protected
        System.out.println("Author       : " + getAuthor()); // via getter
        System.out.println("File Size    : " + fileSizeMB + " MB");
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Book b1 = new Book("978-1234567890", "Core Java", "Rohan Sharma");
        b1.displayBookDetails();

        EBook eb1 = new EBook("978-0987654321", "Java for Beginners", "Kiran Verma", 5.2);
        eb1.displayEBookDetails();

        // Update author using setter
        eb1.setAuthor("Kiran V.");
        eb1.displayEBookDetails();
    }
}

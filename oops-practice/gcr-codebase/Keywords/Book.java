class Book{

    public static final String libraryName = "ABC Library";
    private String title;
    private String author;
    private final String isbn;

    static void displayLibraryName(){
        System.out.println(libraryName);
    }

    Book(String title, String author, String isbn ){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    // Method to display book details
    void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
    }
    public static void main(String[] args) {

        // Access static variable and method
        Book.displayLibraryName();

        // Create objects using constructor with this
        Object obj1 = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        Object obj2 = "Not a book";

        // 4. instanceof: check before displaying details
        if (obj1 instanceof Book) {
            Book b1 = (Book) obj1;
            System.out.println("\nBook 1 details:");
            b1.displayDetails();
            }

        if (obj2 instanceof Book) {
            Book b2 = (Book) obj2;
            System.out.println("\nBook 2 details:");
            b2.displayDetails();
        } else {
            System.out.println("\nobj2 is not an instance of Book.");
        }
    }


}
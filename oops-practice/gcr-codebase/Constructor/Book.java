class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;    // this.title refers to instance variable
        this.author = author;  // author is constructor parameter
        this.price = price;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    // Test the constructors
    public static void main(String[] args) {
        // Using default constructor
        Book defaultBook = new Book();
        defaultBook.displayDetails();

        System.out.println("--------------------");

        // Using parameterized constructor
        Book paramBook = new Book("2States", "Chetan Bhagat", 500.0);
        paramBook.displayDetails();
    }
}

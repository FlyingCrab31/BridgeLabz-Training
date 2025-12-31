class Book {
    // Attributes
    String title;
    String author;
    double price;
    
    // Constructor to initialize the Book object
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // Method to display book details
    public void displayDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }
}

class Main {
    public static void main(String[] args) {
        // Create first book object
        Book book1 = new Book("2States", "Chetan Bhagat", 500.0);
        book1.displayDetails();
        
        // Create second book object
        Book book2 = new Book("Wings Of Fire", "Abdul kalam.A.P.J", 500.0);
        book2.displayDetails();
    }
}

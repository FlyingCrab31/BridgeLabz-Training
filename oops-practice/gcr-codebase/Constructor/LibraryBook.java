class Books {
    
    // Attributes
    String title;
    String author;
    double price;
    boolean availability;   // true = available, false = borrowed

    // Parameterized constructor
    Books(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Method to borrow a book
    void borrowBook() {
        if (availability) {
            availability = false; // now book is borrowed
            System.out.println("You have successfully borrowed: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is not available.");
        }
    }

    // Display details
    void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : " + price);
        System.out.println("Available: " + availability);
        System.out.println("------------------------");
    }

    // Test in main
    public static void main(String[] args) {
        Books b1 = new Books("Wings Of Fire", "A.P.J. Abdul Kalam", 500.0, true);

        b1.displayDetails();
        b1.borrowBook();   // first time - should succeed
        b1.borrowBook();   // second time - should show not available
    }
}

package BookShelf;

class Main{
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


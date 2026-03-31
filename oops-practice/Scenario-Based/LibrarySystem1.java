
import java.util.*;
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}
class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }
}

public class LibrarySystem1{
    static List<Book> bookList = new ArrayList<>();

    static String[] bookTitles ={
            "Java Programming",
            "DSA",
            "OS",
            "CN",
            "DBMS"
    };

    static String[] bookAuthors ={
           "James Gosling",
        "Mark Allen Weiss",
        "Abraham Silberschatz",
        "Andrew S. Tanenbaum",
        "Raghu Ramakrishnan"
    };

    static boolean[] isBookAvailable ={
            true, true, true, true, true
    };
    static void loadBooksIntoList() {

        for (int i = 0; i < bookTitles.length; i++) {
            bookList.add(new Book(
                    bookTitles[i],
                    bookAuthors[i],
                    isBookAvailable[i]
            ));
        }
    }



    // Method to display all books
    static void displayBooks(){
        System.out.println("\n--- Library Books ---");
        for (int i = 0; i < bookTitles.length; i++) {
            System.out.println(
                    (i + 1) + ". " + bookTitles[i] +
                    "  | Author : " + bookAuthors[i] +
                    " |   Status : " + (isBookAvailable[i] ? "Available" : "Checked Out")
            );

        }

    }

    // Method to search book by partial title
    static void searchBook(String searchText){
        boolean found = false;
        System.out.println("\nSearch Results:");
        for (int i = 0; i < bookTitles.length; i++){

            if (bookTitles[i].toLowerCase().contains(searchText.toLowerCase())) {
                System.out.println(

                        (i + 1) + ". " + bookTitles[i] +
                        "| Status: " + (isBookAvailable[i] ? "Available" : "Checked Out")
                );


                found = true;
            }
        }
        if (!found){
            System.out.println("No matching books found");
        }
    }

    // Method to checkout a book
    static void checkoutBook(int bookNumber) throws BookNotAvailableException{
        if (bookNumber < 1 || bookNumber > bookTitles.length){
            System.out.println("Invalid book number.");

            return;
        }
        Book book = bookList.get(bookNumber - 1);

        // if (isBookAvailable[bookNumber - 1]){
        //     isBookAvailable[bookNumber - 1] = false;
        //     System.out.println("Book checked out successfully.");
        // } else{
        //     System.out.println("Sorry, this book is already checked out.");
        // }
        if (!book.isAvailable) {
            throw new BookNotAvailableException("Book is already checked out.");
        }

        book.isAvailable = false;
        System.out.println("Book checked out successfully");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        loadBooksIntoList();
        displayBooks();

        System.out.print("\nEnter part of book title to search : ");
        String searchText = input.nextLine();
        searchBook(searchText);

        System.out.print("\nEnter book number to checkout : ");
        int bookNumber = input.nextInt();
        

        try {
            checkoutBook(bookNumber);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        displayBooks();

        input.close();
    }
}
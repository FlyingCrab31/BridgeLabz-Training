package LibraryManagementSystem;

import java.util.Scanner;
public class LibraryApp {
	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    	
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        preloadBooks(catalog);

        System.out.println("Welcome to Smart University Library");
        System.out.print("Enter your role (student / faculty / librarian): ");
        String role = sc.nextLine();

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        User user = UserFactory.createUser(role, name);
        user.showRole();


        if (!role.equalsIgnoreCase("librarian")) {
            catalog.addObserver(user);
        }

        boolean running = true;

        while (running) {
        	
            if (role.equalsIgnoreCase("librarian")) {
                librarianMenu(catalog);
            } else {
                userMenu(catalog);
            }

            System.out.print("\nContinue? (yes/no): ");
            running = sc.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("\nSession ended. Have a great day!");
    }


    private static void librarianMenu(LibraryCatalog catalog) {

        System.out.println("\n1. Add Book");
        System.out.println("2. View Books");
        System.out.print("Choose option: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                addBookFlow(catalog);
                break;
            case 2:
                catalog.showAllBooks();
                break;
            default:
                System.out.println("Invalid option");
        }
    }


    private static void userMenu(LibraryCatalog catalog) {

        System.out.println("All the Available Books Library");
        catalog.showAllBooks();
        
    }


    private static void addBookFlow(LibraryCatalog catalog) {

        System.out.print("Book title (mandatory): ");
        String title = sc.nextLine();

        Book.BookBuilder builder = new Book.BookBuilder(title);

        System.out.print("Author (optional): ");
        String author = sc.nextLine();
        if (!author.isEmpty()) builder.author(author);

        System.out.print("Edition (optional): ");
        String edition = sc.nextLine();
        if (!edition.isEmpty()) builder.edition(edition);

        System.out.print("Genre (optional): ");
        String genre = sc.nextLine();
        if (!genre.isEmpty()) builder.genre(genre);

        Book book = builder.build();
        catalog.addBook(book);

        System.out.println("Book added successfully.");
    }

	private static void preloadBooks(LibraryCatalog catalog) {

	    catalog.addBook(new Book.BookBuilder("Design Patterns")
	            .author("Gang of Four")
	            .edition("2nd")
	            .genre("Software Engineering")
	            .build());

	    catalog.addBook(new Book.BookBuilder("Clean Code")
	            .author("Robert C. Martin")
	            .genre("Programming")
	            .build());

	    catalog.addBook(new Book.BookBuilder("Introduction to Algorithms")
	            .author("Cormen et al.")
	            .edition("3rd")
	            .genre("Computer Science")
	            .build());

	    catalog.addBook(new Book.BookBuilder("Effective Java")
	            .author("Joshua Bloch")
	            .edition("3rd")
	            .genre("Java")
	            .build());
	}
}
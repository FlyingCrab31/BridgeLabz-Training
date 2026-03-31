/*5. Library Book Statistics
Given a list of books with their genres and number of pages, use
Collectors.summarizingInt()
to find total pages, average pages, and maximum pages per genre. */
import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String genre;
    private int pages;



    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;



    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public int getPages(){
        return pages;
    }
}

public class LibraryBookStatistics{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        System.out.print("Enter number of books : ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for book : " + (i + 1));

            System.out.print("Title : ") ;
            String title = sc.nextLine();

            System.out.print("Genre : ");
            String genre = sc.nextLine();

            System.out.print("Number of Pages : ");
            int pages = sc.nextInt();
            sc.nextLine(); 

            books.add(new Book(title, genre, pages));
        }

        // Group by genre and summarize pages
        Map<String, IntSummaryStatistics> statsByGenre =
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));

        
        System.out.println("\nLibrary Book Statistics (Per Genre):");
        statsByGenre.forEach((genre, stats) -> {
            System.out.println("\nGenre : " + genre);
            System.out.println("Total Pages : " + stats.getSum());
            System.out.println("Average Pages : " + stats.getAverage());
            System.out.println("Maximum Pages : " + stats.getMax());
        });

        
    }
}


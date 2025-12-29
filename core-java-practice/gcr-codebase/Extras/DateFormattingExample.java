import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormattingExample {
    public static void main(String[] args) {

        // current date
        LocalDate today = LocalDate.now(); // gets current system date 

        // formatters with required patterns
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");      // 29/12/2025 
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");      // 2025-12-29 
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy"); // Mon, Dec 29, 2025 

        // format and print
        System.out.println("Format 1 (dd/MM/yyyy): " + today.format(f1)); 
        System.out.println("Format 2 (yyyy-MM-dd): " + today.format(f2));
        System.out.println("Format 3 (EEE, MMM dd, yyyy): " + today.format(f3));
    }
}

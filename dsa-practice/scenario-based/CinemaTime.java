
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class InvalidTimeFormatException extends Exception {

    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

class CinemaTimeManager {

    private List<String> movieTitles = new ArrayList<>();
    private List<String> movieTimes = new ArrayList<>();

    // HH:mm, 00–23 and 00–59
    private boolean isValidTime(String time) {
        String regex = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";
        return time != null && time.matches(regex);
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        movieTimes.add(time);
    }

    // keyword search using contains()
    public void searchMovie(String keyword) {
        boolean found = false;
        for (int i = 0; i < movieTitles.size(); i++) {
            String title = movieTitles.get(i);
            if (title.toLowerCase().contains(keyword.toLowerCase())) {
                String time = movieTimes.get(i);
                String formatted = String.format("%s - %s", title, time);
                System.out.println("[" + i + "] " + formatted);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movies found for keyword: " + keyword);
        }
    }

    public void displayAllMovies() {
        if (movieTitles.isEmpty()) {
            System.out.println("No movies scheduled.");
            return;
        }
        System.out.println("All Movies:");
        for (int i = 0; i < movieTitles.size(); i++) {
            String formatted = movieTitles.get(i) + " - " + movieTimes.get(i);
            System.out.println("[" + i + "] " + formatted);
        }
    }

    // Example of handling invalid index with IndexOutOfBoundsException
    public void printMovieByIndex(int index) {
        try {
            String title = movieTitles.get(index); // can throw IndexOutOfBoundsException
            String time = movieTimes.get(index);
            System.out.println("Movie at index " + index + ": " + title + " - " + time);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index + ". Please enter a valid movie index.");
        }
    }

    // Convert to array for printable report
    public String[] generateReportArray() {
        String[] report = new String[movieTitles.size()];
        for (int i = 0; i < movieTitles.size(); i++) {
            report[i] = String.format("%s - %s", movieTitles.get(i), movieTimes.get(i));
        }
        return report;
    }
}

public class CinemaTime {

    public static void main(String[] args) {
        CinemaTimeManager manager = new CinemaTimeManager();
        try {
            manager.addMovie("Inception", "10:30");
            manager.addMovie("Interstellar", "13:45");
            manager.addMovie("Avatar", "21:15");
            // manager.addMovie("Bad Time", "25:99"); // would throw InvalidTimeFormatException
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        manager.displayAllMovies();

        System.out.println("\nSearch 'in':");
        manager.searchMovie("in");

        System.out.println("\nPrint by index:");
        manager.printMovieByIndex(1);
        manager.printMovieByIndex(10); // triggers IndexOutOfBoundsException handling

        System.out.println("\nReport array:");
        String[] report = manager.generateReportArray();
        System.out.println(Arrays.toString(report));
    }
}

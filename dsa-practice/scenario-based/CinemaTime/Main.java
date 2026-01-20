package CinemaTime;

import java.util.Arrays;

public class Main {

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

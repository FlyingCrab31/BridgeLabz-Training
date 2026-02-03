
import java.util.Comparator;
import java.util.List;

class Movie {

    private final String title;
    private final double rating;
    private final int releaseYear;

    // constructor, getters
    public Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - " + rating;
    }
}

public class TrendingMovies {

    public static List<Movie> findTop5Trending(List<Movie> movies) {
        return movies.stream()
                // filter by rating and year
                .filter(m -> m.getRating() >= 8.0 && m.getReleaseYear() >= 2020)
                // sort: highest rating first, then latest year first
                .sorted(
                        Comparator.comparingDouble(Movie::getRating).reversed()
                                .thenComparing(Movie::getReleaseYear, Comparator.reverseOrder())
                )
                // take top 5
                .limit(5)
                .toList(); // or .collect(Collectors.toList()) for Java 8
    }

    public static void main(String[] args) {
        List<Movie> movies = List.of(
                new Movie("Movie A", 8.5, 2021),
                new Movie("Movie B", 9.0, 2020),
                new Movie("Movie C", 7.9, 2023), // will be filtered out (rating < 8.0)
                new Movie("Movie D", 8.7, 2024),
                new Movie("Movie E", 8.2, 2022),
                new Movie("Movie F", 9.1, 2024),
                new Movie("Movie G", 8.8, 2023)
        );

        List<Movie> top5 = findTop5Trending(movies);
        top5.forEach(System.out::println);
    }
}

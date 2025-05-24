package streams;

import java.util.Comparator;
import java.util.List;

public class GettingUniqueElements {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        movies.stream()
                .map(Movie::getLikes)
                .distinct()
                .forEach(System.out::println);
    }
}

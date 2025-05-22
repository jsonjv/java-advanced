package streams;

import java.util.Comparator;
import java.util.List;

public class SortingStreams {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("b", 10),
                new Movie("a", 20),
                new Movie("c", 30)
        );

        // sorted - two overload methods
        // one by implementing Comparable on Movie class and override compareTo method
        movies.stream()
                .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
                .forEach(m -> System.out.println(m.getTitle()));

        movies.stream()
//                .sorted(Comparator.comparing(m -> m.getTitle()))
                .sorted(Comparator.comparing(Movie::getTitle).reversed())
                .forEach(m -> System.out.println(m.getTitle()));
    }
}

package streams;

import java.util.List;
import java.util.function.Predicate;

public class FilteringStreams {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        // intermediate operations - map, filter - returns a new Stream/pipe that can be chained
        // terminal operations - forEach - produce end result, cannot be chained
        Predicate<Movie> isPopular = m -> m.getLikes() > 10;

        movies.stream()
                .filter(isPopular)
                .forEach(m -> System.out.println(m.getTitle()));
    }
}

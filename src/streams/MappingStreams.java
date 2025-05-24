package streams;

import java.util.List;
import java.util.stream.Stream;

public class MappingStreams {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(title -> System.out.println(title));

        var stream = Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream.flatMap(list -> list.stream())
                .forEach(n -> System.out.println(n));
    }
}

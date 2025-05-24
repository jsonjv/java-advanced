package streams;

import java.util.List;
import java.util.stream.Collectors;

public class PartitioningElements {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 20,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(","))
                ));

        System.out.println(result);
    }
}

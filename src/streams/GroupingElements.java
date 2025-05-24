package streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingElements {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.THRILLER),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        var result = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
//                        Collectors.toList()
//                        Collectors.counting()
//                        Collectors.joining() // only works on streams of Strings
                        Collectors.mapping(Movie::getTitle, Collectors.joining(","))
                ));

        System.out.println(result);
    }
}

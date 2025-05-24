package streams;

import java.util.List;

public class SlicingStreams {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        // limit(n)
        // skip(n) - useful for pagination
        movies.stream()
                .skip(2)
                .forEach(m -> System.out.println(m.getTitle()));

        // 1000 movies
        // 10 movies per page
        // view 3rd page
        // skip(20) = skip( (page-1) * pageSize )
        // limit(10) = limit(pageSize)

        // filter - iterates the entire data source that match criteria
        // takeWhile(predicate) - stops the moment the predicate returns false
        movies.stream()
                .takeWhile(m -> m.getLikes() < 30)
                .forEach(m -> System.out.println(m.getTitle()));

        // dropWhile(predicate) -  opposite of takeWhile
        movies.stream()
                .dropWhile(m -> m.getLikes() < 30)
                .forEach(m -> System.out.println(m.getTitle()));
    }
}

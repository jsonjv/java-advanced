package streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        // imperative programming - how
        // statements "how" something should be done
        int count = 0;
        for (var movie : movies)
            if (movie.getLikes() > 10)
                count++;

        // streams - to process a collection of data in a declarative way

        // declarative (functional) programming - what
        // express logics in terms of "what" needs to be done
        var count2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();

        System.out.println(count);
        System.out.println(count2);

        // intermediate operations - map, filter - returns a new Stream/pipe that can be chained
        // terminal operations - forEach - produce end result, cannot be chained
        Predicate<Movie> isPopular = m -> m.getLikes() > 10;

        movies.stream()
                .filter(isPopular)
                .forEach(m -> System.out.println(m.getTitle()));

        // slicing streams
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

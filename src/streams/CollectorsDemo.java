package streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        var list = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toList());

        System.out.println(list);

        var set = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toSet());

        System.out.println(set);

        // key (title), value (likes)
        var hashMap1 = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        System.out.println(hashMap1);

        // key (title), value (obj)
        var hashMap2 = movies.stream()
                .filter(m -> m.getLikes() > 10)
//                .collect(Collectors.toMap(Movie::getTitle, m -> m));
                .collect(Collectors.toMap(Movie::getTitle, Function.identity())); // same as m -> m

        System.out.println(hashMap2);

        var sum = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));

        System.out.println(sum);

        var summarize = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(summarize);

        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
}

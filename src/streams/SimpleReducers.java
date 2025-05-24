package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SimpleReducers {
    public static void show() {
        List<Movie> movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 20, Genre.ACTION),
                new Movie("c", 30, Genre.ACTION)
        );

        // reducers - reduces stream of objects to single object
        //
        // terminal operation
        // count()
        // anyMatch(predicate)
        // allMatch(predicate)
        // noneMatch(predicate)
        // findFirst()
        // findAny()
        // max(comparator)
        // min(comparator)

        var hasLikesMoreThan20 = movies.stream()
                .anyMatch(m -> m.getLikes() > 20);

        System.out.println(hasLikesMoreThan20);

        var isAllLikesMoreThan20 = movies.stream()
                .allMatch(m -> m.getLikes() > 20);

        System.out.println(isAllLikesMoreThan20);

        var result = movies.stream()
                .findFirst()
                .get();

        System.out.println(result.getTitle());

        var res = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get();

        System.out.println(res);

        // accumulator - to accumulate the values
        // map - [10, 20, 30]
        // reduce - 10+20 = 30 = [30, 30]
        // reduce - 30+30 = 60 = [60]

        // Optional - represents an object that may or may not have a value
        // stream could be empty

        Optional<Integer> sum = movies.stream()
                .map(Movie::getLikes)
//                .reduce((a, b) -> a + b);
                .reduce(Integer::sum);

//        sum.get(); // if no value this will throw an exception
        System.out.println(sum.orElse(0)); // supply a default value

        // identity - like an initial value we can supply, no need to work with Optional object
        Integer sum2 = movies.stream()
                .map(Movie::getLikes)
                .reduce(0, Integer::sum);

        System.out.println(sum2);
    }
}

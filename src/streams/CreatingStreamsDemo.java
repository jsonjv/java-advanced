package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

// creating streams
// - from collections
// - from arrays
// - from an arbitrary number of objects
// generate infinite/finite streams

public class CreatingStreamsDemo {
    public static void show() {
        Collection<Integer> x;
//        x.stream();

        var list = new ArrayList<>();
//        list.stream();

        int[] numbers = { 1, 2, 3 };
        Arrays.stream(numbers)
                .forEach(n -> System.out.println(n));

        Stream.of(1,2,3,4,5);

        var stream = Stream.generate(() -> Math.random());
        stream.limit(3).forEach(n -> System.out.println(n));

        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> System.out.println(n));
    }
}

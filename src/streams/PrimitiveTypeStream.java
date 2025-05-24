package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimitiveTypeStream {
    public static void show() {
        // rangeClosed - endInclusive
        // returns 1-5
        IntStream.rangeClosed(1, 5)
                .forEach(System.out::println);

        // range - endExclusive
        // returns 1-4
        IntStream.range(1, 5)
                .forEach(System.out::println);
    }
}

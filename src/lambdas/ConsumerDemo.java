package lambdas;

import java.util.List;
import java.util.function.Consumer;

// https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
// consumer - consumes a value
// void consume(obj)
// takes single arg, return no result

public class ConsumerDemo {
    public static void show() {
        List<Integer> intList = List.of(1,2,3);

        // imperative programming (for, if/else, switch/case)
        // instruction on how something should be done
        for (var item : intList)
            System.out.println(item);

        // declarative programming
        // instruction on what's need to be done
        // forEach expects Consumer of Integer
        intList.forEach(item -> System.out.println(item));

        List<String> strList = List.of("a", "b", "c");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());

        // chaining consumers
        strList.forEach(print.andThen(printUpperCase).andThen(print));
    }
}

package lambdas;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

// https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
// function - can map a value to a different value
// obj map(obj)
// operation that takes an arg and returns a value

public class FunctionDemo {
    public static void show() {
        Function<String, Integer> map = str -> str.length();
        var length = map.apply("sky");
        System.out.println(length);

        // "key:value"
        // first: "key=value"
        // second: "{key=value}"

        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";

        // declarative programming
        var result = replaceColon
                .andThen(addBraces)
                .apply("key:value");

        result = addBraces
                .compose(replaceColon)
                .apply("key:value");

        System.out.println(result);

        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/function/BinaryOperator.html
        // a, b -> a + b -> square
        BinaryOperator<Integer> add = (a, b) -> a + b;
        Function<Integer, Integer> squareFunc = a -> a * a;

        var sumResult = add.andThen(squareFunc).apply(1, 2);
        System.out.println(sumResult);

        // https://docs.oracle.com/javase/8/docs/api/java/util/function/UnaryOperator.html
        UnaryOperator<Integer> square = n -> n * n;
        UnaryOperator<Integer> increment = n -> n + 1;

        var unaryResult = increment.andThen(square).apply(1);
        System.out.println(unaryResult);
    }
}

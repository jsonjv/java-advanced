package lambdas;

import java.util.function.Predicate;

// https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
// predicate -
// bool test(condition)
// operation that takes an object and checks if object satisfy some criteria

public class PredicateDemo {
    public static void show() {
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        var result = isLongerThan5.test("sky");

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        // && || !
        Predicate<String> hasLeftAndRightBraces = hasLeftBrace.and(hasRightBrace);
        System.out.println(hasLeftAndRightBraces.test("{key:value}"));

        System.out.println(hasLeftBrace.or(hasRightBrace).test("{}"));
        System.out.println(hasLeftBrace.negate().test("{}"));
    }
}

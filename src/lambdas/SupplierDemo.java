package lambdas;

import java.util.function.Supplier;

// https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
// supplier - supplies a value, opposite of consumer interface
// obj supply()
// takes no input and returns a value

public class SupplierDemo {
    public static void show() {
        // lazy evaluation
        // lambda expression not executed
        Supplier<Double> getRandom = () -> Math.random();
        // until explicitly called it
        var random = getRandom.get();
        System.out.println(random);
    }
}

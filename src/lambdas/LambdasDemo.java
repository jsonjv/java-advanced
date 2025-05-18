package lambdas;

public class LambdasDemo {
    public static String prefix = "-";

    public LambdasDemo(String message) {
    }

    public static void print1(String message) {}
    public void print2(String message) {}

    public static void show() {
        greet(new ConsolePrinter());

        // anonymous inner class
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // lambda expression
        greet((String message) -> {
            System.out.println(message);
        });

        greet(message -> System.out.println(prefix + message));

        Printer printer = message -> System.out.println(message);
        greet(printer);

        // method reference
        // Class/Object::method
        greet(System.out::println);

        greet(message -> print1(message));
        greet(LambdasDemo::print1);

//        var demo = new LambdasDemo();
//        greet(message -> demo.print2(message));
//        greet(demo::print2);

        // constructor reference
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }
}

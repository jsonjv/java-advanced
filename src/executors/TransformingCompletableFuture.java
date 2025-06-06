package executors;

import java.util.concurrent.CompletableFuture;

public class TransformingCompletableFuture {
    private static int toFahrenheit(int celsius) {
        return (int) (celsius * 1.8) + 32;
    }

    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> 20);
        // thenApply - returns a new CompletableFuture
//        future.thenApplyAsync()

        future
                .thenApply(TransformingCompletableFuture::toFahrenheit)
                .thenAccept(System.out::println);
    }
}

package executors;

import java.util.concurrent.CompletableFuture;

public class WaitForFirstTask {
    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        var second = CompletableFuture.supplyAsync(() -> 20);

        // returns a new CompletableFuture that will complete as soon one of the CompletableFutures completes
        CompletableFuture.anyOf(first, second)
                .thenAccept(System.out::println);
    }
}

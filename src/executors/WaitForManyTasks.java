package executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class WaitForManyTasks {
    public static void show() {
        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);

        // returns a new CompletableFuture that will complete when all the CompletableFuture complete
        var all = CompletableFuture.allOf(first, second, third);

        all.thenRun(() -> {
            // .get won't block the thread since the result will be ready when this code block executes
            try {
                var firstResult = first.get();
                System.out.println(firstResult);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

            System.out.println("All tasks completed successfully!");
        });
    }
}

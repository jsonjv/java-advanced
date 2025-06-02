package executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class CompletableFuturesDemo {
    public static void show() {
        // common pool - well over the number of available threads
//        ForkJoinPool.commonPool();

        Runnable task = () -> System.out.println("a");

        // optional executor - will default run tasks on a common pool
        var future = CompletableFuture.runAsync(task);

        // if task returns a value, use supplyAsync
        var future2 = CompletableFuture.supplyAsync(() -> 1);

//        try {
//            var result = future2.get();
//            System.out.println(result);
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }

        // runnable executed on the main thread
        future2.thenRun(() -> System.out.println("Done"));

        // async - runnable executed on the thread pool
        future2.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Done");
        });

        future2.thenAccept((result) -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });
    }
}

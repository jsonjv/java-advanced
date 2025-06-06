package executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class HandlingTimeouts {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;
        });

        // return a new CompletableFuture that will complete after 1 second
        try {
            var result = future
//                    .orTimeout(1, TimeUnit.SECONDS)
                    // recover with a default value
                    .completeOnTimeout(1, 1, TimeUnit.SECONDS)
                    .get();

            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

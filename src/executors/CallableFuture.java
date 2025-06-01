package executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

// https://docs.oracle.com/javase/8/docs//api/java/util/concurrent/Callable.html
public class CallableFuture {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            // java.util.concurrent.Future<Integer>
            // get future result of an operation
            var future = executor.submit(() -> {
                LongTask.simulate();
                return 1;
            });

            System.out.println("Do more work");
            try {
                var result = future.get(); // synchronous - thread-blocking method
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        } finally {
            executor.shutdown();
        }
    }
}

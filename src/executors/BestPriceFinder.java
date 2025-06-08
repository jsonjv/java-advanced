package executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class BestPriceFinder {
    public static void show() {
        var start = LocalTime.now();

        var service = new FlightService();

//        service.getQuote("site1")
//                .thenAccept(System.out::println);

        var futures = service.getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .toList();

        CompletableFuture
                .allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + "ms.");
                });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

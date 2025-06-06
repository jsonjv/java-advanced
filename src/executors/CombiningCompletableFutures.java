package executors;

import java.util.concurrent.CompletableFuture;

public class CombiningCompletableFutures {
    public static void show() {
        // Ability 2 tasks async and combine the result
        // 20 USD
        // 0.9

//        var firstTask = CompletableFuture.supplyAsync(() -> 20);
        var firstTask = CompletableFuture
                .supplyAsync(() -> "20USD")
                .thenApply(str -> {
                    var price = str.replace("USD", "");
                    return Integer.parseInt(price);
                });

        var secondTask = CompletableFuture.supplyAsync(() -> 0.9);

        firstTask
                .thenCombine(secondTask, (price, exchangeRate) -> price * exchangeRate)
                .thenAccept(System.out::println);
    }
}

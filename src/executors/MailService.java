package executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
    // synchronous - thread-blocking method
    public void send() {
        LongTask.simulate();
        System.out.println("Mail was sent.");
    }

    public CompletableFuture<Void> sendAsync() {
        return CompletableFuture.runAsync(this::send);
    }
}

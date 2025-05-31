package concurrency;

import java.util.ArrayList;
import java.util.List;

public class RaceCondition {
    public static void show() {
       // race condition - multiple threads racing or competing to modify a shared resource

        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("total bytes " + status.getTotalBytes());

        // strategies for thread safety
        // confinement - restrict each thread to have its own data
        // immutability - threads can only read immutable objects

        // synchronization
        // - prevent multiple threads from accessing the same object concurrently using locks
        // - forces the code to run sequentially which against idea of concurrency
        // - implementation is challenging and error-prone
        // - deadlock - two threads waits for each other indefinitely
        // - bad and should avoid as much as possible

        // atomic objects - achieve thread safety without using locks
        // partitioning - partition data into segments that can be accessed concurrently

    }
}

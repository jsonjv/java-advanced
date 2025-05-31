package concurrency;

import java.util.ArrayList;
import java.util.List;

// atomic objects - achieve thread safety without using locks
// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/atomic/package-summary.html
public class AtomicObjects {
    public static void show() {
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
    }
}
